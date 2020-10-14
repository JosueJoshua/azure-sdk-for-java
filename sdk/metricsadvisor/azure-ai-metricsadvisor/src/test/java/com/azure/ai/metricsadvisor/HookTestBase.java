// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.ai.metricsadvisor;

import com.azure.ai.metricsadvisor.models.EmailNotificationHook;
import com.azure.ai.metricsadvisor.models.NotificationHook;
import com.azure.ai.metricsadvisor.models.MetricsAdvisorServiceVersion;
import com.azure.ai.metricsadvisor.models.WebNotificationHook;
import com.azure.core.http.HttpClient;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.rest.PagedResponse;
import com.azure.core.test.TestMode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

public abstract class HookTestBase extends MetricsAdvisorAdministrationClientTestBase {
    @Test
    abstract void createEmailHook(HttpClient httpClient, MetricsAdvisorServiceVersion serviceVersion);

    protected static class CreateEmailHookInput {
        static final CreateEmailHookInput INSTANCE = new CreateEmailHookInput();
        String name = UUID.randomUUID().toString();
        String email1 = "simpleuser0@hotmail.com";
        String email2 = "simpleuser1@hotmail.com";
        String description = "alert_us!";
        String externalLink = "https://github.com/Azure/azure-sdk-for-java/wiki";
        EmailNotificationHook hook = new EmailNotificationHook(name)
            .addEmailToAlert(email1)
            .addEmailToAlert(email2)
            .setDescription(description)
            .setExternalLink(externalLink);
    }

    protected void assertCreateEmailHookOutput(NotificationHook hook) {
        Assertions.assertNotNull(hook);
        Assertions.assertTrue(hook instanceof EmailNotificationHook);
        EmailNotificationHook emailHook = (EmailNotificationHook) hook;
        Assertions.assertNotNull(emailHook.getId());
        Assertions.assertNotNull(emailHook.getAdmins());
        Assertions.assertNotNull(emailHook.getName());
        Assertions.assertEquals(CreateEmailHookInput.INSTANCE.description, emailHook.getDescription());
        Assertions.assertEquals(CreateEmailHookInput.INSTANCE.externalLink, emailHook.getExternalLink());
        List<String> emails = emailHook.getEmailsToAlert();
        Assertions.assertNotNull(emails);
        Assertions.assertEquals(2, emails.size());
        HashSet<String> emailSet = new HashSet<>();
        emailSet.addAll(emails);
        Assertions.assertTrue(emailSet.contains(CreateEmailHookInput.INSTANCE.email1));
        Assertions.assertTrue(emailSet.contains(CreateEmailHookInput.INSTANCE.email2));
    }

    @Test
    abstract void createWebHook(HttpClient httpClient, MetricsAdvisorServiceVersion serviceVersion);

    protected static class CreateWebHookInput {
        static final CreateWebHookInput INSTANCE = new CreateWebHookInput();
        String name = UUID.randomUUID().toString();
        String endpoint = "https://httpbin.org/post";
        String description = "alert_us!";
        String externalLink = "https://github.com/Azure/azure-sdk-for-java/wiki";
        String userName = "test";
        String password = "testpwd!@#";
        HttpHeaders httpHeaders = new HttpHeaders()
            .put("x-contoso-id", "123")
            .put("x-contoso-name", "contoso");
        WebNotificationHook hook = new WebNotificationHook(name, endpoint)
            .setDescription(description)
            .setExternalLink(externalLink)
            .setUserCredentials(userName, password)
            .setHttpHeaders(httpHeaders);
    }

    protected void assertCreateWebHookOutput(NotificationHook hook) {
        Assertions.assertNotNull(hook);
        Assertions.assertTrue(hook instanceof WebNotificationHook);
        WebNotificationHook webHook = (WebNotificationHook) hook;
        Assertions.assertNotNull(webHook.getId());
        Assertions.assertNotNull(webHook.getAdmins());
        Assertions.assertNotNull(webHook.getName());
        Assertions.assertEquals(CreateWebHookInput.INSTANCE.description, webHook.getDescription());
        Assertions.assertEquals(CreateWebHookInput.INSTANCE.externalLink, webHook.getExternalLink());
        Assertions.assertEquals(CreateWebHookInput.INSTANCE.userName, webHook.getUsername());
        Assertions.assertEquals(CreateWebHookInput.INSTANCE.password, webHook.getPassword());
        HttpHeaders httpHeaders = webHook.getHttpHeaders();
        Assertions.assertNotNull(httpHeaders);
//        TODO: BUG: Service is not returning headers.
//        Assertions.assertEquals(CreateWebHookInput.INSTANCE.httpHeaders.getSize(), httpHeaders.getSize());
//        Map<String, String> headersMap = httpHeaders.toMap();
//        for (HttpHeader httpHeader : CreateWebHookInput.INSTANCE.httpHeaders) {
//            Assertions.assertTrue(headersMap.containsKey(httpHeader.getName()));
//            Assertions.assertEquals(httpHeader.getValue(), headersMap.get(httpHeader.getName()));
//        }
    }

    @Test
    abstract void testListHook(HttpClient httpClient, MetricsAdvisorServiceVersion serviceVersion);

    protected static class ListHookInput {
        static final ListHookInput INSTANCE = new ListHookInput();
        EmailNotificationHook emailHook = new EmailNotificationHook(UUID.randomUUID().toString())
            .addEmailToAlert("simpleuser0@hotmail.com");
        WebNotificationHook webHook = new WebNotificationHook(UUID.randomUUID().toString(),
            "https://httpbin.org/post");
        int pageSize = 1;
    }

    protected void assertListHookOutput(List<NotificationHook> hooksList) {
        Assertions.assertTrue(hooksList.size() >= 2);
        if (getTestMode() == TestMode.PLAYBACK) {
            // assert random generated hook names only when hitting real service.
            return;
        }
        NotificationHook hook1 = null;
        NotificationHook hook2 = null;
        for (NotificationHook hook : hooksList) {
            if (hook1 != null && hook2 != null) {
                break;
            }
            Assertions.assertNotNull(hook.getName());
            if (hook.getName().equals(ListHookInput.INSTANCE.emailHook.getName())) {
                hook1 = hook;
            } else if (hook.getName().equals(ListHookInput.INSTANCE.webHook.getName())) {
                hook2 = hook;
            }
        }
        Assertions.assertNotNull(hook1);
        Assertions.assertNotNull(hook2);
        Assertions.assertTrue(hook1 instanceof EmailNotificationHook);
        Assertions.assertTrue(hook2 instanceof WebNotificationHook);
    }

    protected void assertPagedListHookOutput(List<PagedResponse<NotificationHook>> hookPageList) {
        Assertions.assertTrue(hookPageList.size() >= 2);
        int cnt = 0;
        for (PagedResponse<NotificationHook> hookPage : hookPageList) {
            Assertions.assertNotNull(hookPage.getValue());
            cnt++;
            boolean isLastPage = (cnt == hookPageList.size());
            if (!isLastPage) {
                Assertions.assertEquals(ListHookInput.INSTANCE.pageSize, hookPage.getValue().size());
            }
        }
    }
}
