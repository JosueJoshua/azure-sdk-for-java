/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.synapse.v2020_12_01.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureServiceFuture;
import com.microsoft.azure.ListOperationCallback;
import com.microsoft.azure.management.synapse.v2020_12_01.ErrorResponseException;
import com.microsoft.azure.Page;
import com.microsoft.azure.PagedList;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in PrivateLinkResources.
 */
public class PrivateLinkResourcesInner {
    /** The Retrofit service to perform REST calls. */
    private PrivateLinkResourcesService service;
    /** The service client containing this operation class. */
    private SynapseManagementClientImpl client;

    /**
     * Initializes an instance of PrivateLinkResourcesInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public PrivateLinkResourcesInner(Retrofit retrofit, SynapseManagementClientImpl client) {
        this.service = retrofit.create(PrivateLinkResourcesService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for PrivateLinkResources to be
     * used by Retrofit to perform actually REST calls.
     */
    interface PrivateLinkResourcesService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.synapse.v2020_12_01.PrivateLinkResources list" })
        @GET("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Synapse/workspaces/{workspaceName}/privateLinkResources")
        Observable<Response<ResponseBody>> list(@Path("subscriptionId") String subscriptionId, @Path("resourceGroupName") String resourceGroupName, @Path("workspaceName") String workspaceName, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.synapse.v2020_12_01.PrivateLinkResources get" })
        @GET("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Synapse/workspaces/{workspaceName}/privateLinkResources/{privateLinkResourceName}")
        Observable<Response<ResponseBody>> get(@Path("subscriptionId") String subscriptionId, @Path("resourceGroupName") String resourceGroupName, @Path("workspaceName") String workspaceName, @Path("privateLinkResourceName") String privateLinkResourceName, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.synapse.v2020_12_01.PrivateLinkResources listNext" })
        @GET
        Observable<Response<ResponseBody>> listNext(@Url String nextUrl, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Private Link Resources.
     * Get all private link resources for a workspaces.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;PrivateLinkResourceInner&gt; object if successful.
     */
    public PagedList<PrivateLinkResourceInner> list(final String resourceGroupName, final String workspaceName) {
        ServiceResponse<Page<PrivateLinkResourceInner>> response = listSinglePageAsync(resourceGroupName, workspaceName).toBlocking().single();
        return new PagedList<PrivateLinkResourceInner>(response.body()) {
            @Override
            public Page<PrivateLinkResourceInner> nextPage(String nextPageLink) {
                return listNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * Private Link Resources.
     * Get all private link resources for a workspaces.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<PrivateLinkResourceInner>> listAsync(final String resourceGroupName, final String workspaceName, final ListOperationCallback<PrivateLinkResourceInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listSinglePageAsync(resourceGroupName, workspaceName),
            new Func1<String, Observable<ServiceResponse<Page<PrivateLinkResourceInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<PrivateLinkResourceInner>>> call(String nextPageLink) {
                    return listNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Private Link Resources.
     * Get all private link resources for a workspaces.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;PrivateLinkResourceInner&gt; object
     */
    public Observable<Page<PrivateLinkResourceInner>> listAsync(final String resourceGroupName, final String workspaceName) {
        return listWithServiceResponseAsync(resourceGroupName, workspaceName)
            .map(new Func1<ServiceResponse<Page<PrivateLinkResourceInner>>, Page<PrivateLinkResourceInner>>() {
                @Override
                public Page<PrivateLinkResourceInner> call(ServiceResponse<Page<PrivateLinkResourceInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * Private Link Resources.
     * Get all private link resources for a workspaces.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;PrivateLinkResourceInner&gt; object
     */
    public Observable<ServiceResponse<Page<PrivateLinkResourceInner>>> listWithServiceResponseAsync(final String resourceGroupName, final String workspaceName) {
        return listSinglePageAsync(resourceGroupName, workspaceName)
            .concatMap(new Func1<ServiceResponse<Page<PrivateLinkResourceInner>>, Observable<ServiceResponse<Page<PrivateLinkResourceInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<PrivateLinkResourceInner>>> call(ServiceResponse<Page<PrivateLinkResourceInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Private Link Resources.
     * Get all private link resources for a workspaces.
     *
    ServiceResponse<PageImpl<PrivateLinkResourceInner>> * @param resourceGroupName The name of the resource group. The name is case insensitive.
    ServiceResponse<PageImpl<PrivateLinkResourceInner>> * @param workspaceName The name of the workspace
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;PrivateLinkResourceInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<PrivateLinkResourceInner>>> listSinglePageAsync(final String resourceGroupName, final String workspaceName) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (workspaceName == null) {
            throw new IllegalArgumentException("Parameter workspaceName is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.list(this.client.subscriptionId(), resourceGroupName, workspaceName, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<PrivateLinkResourceInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<PrivateLinkResourceInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<PrivateLinkResourceInner>> result = listDelegate(response);
                        return Observable.just(new ServiceResponse<Page<PrivateLinkResourceInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<PrivateLinkResourceInner>> listDelegate(Response<ResponseBody> response) throws ErrorResponseException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<PrivateLinkResourceInner>, ErrorResponseException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<PrivateLinkResourceInner>>() { }.getType())
                .registerError(ErrorResponseException.class)
                .build(response);
    }

    /**
     * Get Private Link Resource.
     * Get private link resource in workspace.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace
     * @param privateLinkResourceName The name of the private link resource
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PrivateLinkResourceInner object if successful.
     */
    public PrivateLinkResourceInner get(String resourceGroupName, String workspaceName, String privateLinkResourceName) {
        return getWithServiceResponseAsync(resourceGroupName, workspaceName, privateLinkResourceName).toBlocking().single().body();
    }

    /**
     * Get Private Link Resource.
     * Get private link resource in workspace.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace
     * @param privateLinkResourceName The name of the private link resource
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<PrivateLinkResourceInner> getAsync(String resourceGroupName, String workspaceName, String privateLinkResourceName, final ServiceCallback<PrivateLinkResourceInner> serviceCallback) {
        return ServiceFuture.fromResponse(getWithServiceResponseAsync(resourceGroupName, workspaceName, privateLinkResourceName), serviceCallback);
    }

    /**
     * Get Private Link Resource.
     * Get private link resource in workspace.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace
     * @param privateLinkResourceName The name of the private link resource
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PrivateLinkResourceInner object
     */
    public Observable<PrivateLinkResourceInner> getAsync(String resourceGroupName, String workspaceName, String privateLinkResourceName) {
        return getWithServiceResponseAsync(resourceGroupName, workspaceName, privateLinkResourceName).map(new Func1<ServiceResponse<PrivateLinkResourceInner>, PrivateLinkResourceInner>() {
            @Override
            public PrivateLinkResourceInner call(ServiceResponse<PrivateLinkResourceInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Get Private Link Resource.
     * Get private link resource in workspace.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace
     * @param privateLinkResourceName The name of the private link resource
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PrivateLinkResourceInner object
     */
    public Observable<ServiceResponse<PrivateLinkResourceInner>> getWithServiceResponseAsync(String resourceGroupName, String workspaceName, String privateLinkResourceName) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (workspaceName == null) {
            throw new IllegalArgumentException("Parameter workspaceName is required and cannot be null.");
        }
        if (privateLinkResourceName == null) {
            throw new IllegalArgumentException("Parameter privateLinkResourceName is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.get(this.client.subscriptionId(), resourceGroupName, workspaceName, privateLinkResourceName, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<PrivateLinkResourceInner>>>() {
                @Override
                public Observable<ServiceResponse<PrivateLinkResourceInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PrivateLinkResourceInner> clientResponse = getDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PrivateLinkResourceInner> getDelegate(Response<ResponseBody> response) throws ErrorResponseException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PrivateLinkResourceInner, ErrorResponseException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PrivateLinkResourceInner>() { }.getType())
                .registerError(ErrorResponseException.class)
                .build(response);
    }

    /**
     * Private Link Resources.
     * Get all private link resources for a workspaces.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;PrivateLinkResourceInner&gt; object if successful.
     */
    public PagedList<PrivateLinkResourceInner> listNext(final String nextPageLink) {
        ServiceResponse<Page<PrivateLinkResourceInner>> response = listNextSinglePageAsync(nextPageLink).toBlocking().single();
        return new PagedList<PrivateLinkResourceInner>(response.body()) {
            @Override
            public Page<PrivateLinkResourceInner> nextPage(String nextPageLink) {
                return listNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * Private Link Resources.
     * Get all private link resources for a workspaces.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceFuture the ServiceFuture object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<PrivateLinkResourceInner>> listNextAsync(final String nextPageLink, final ServiceFuture<List<PrivateLinkResourceInner>> serviceFuture, final ListOperationCallback<PrivateLinkResourceInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listNextSinglePageAsync(nextPageLink),
            new Func1<String, Observable<ServiceResponse<Page<PrivateLinkResourceInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<PrivateLinkResourceInner>>> call(String nextPageLink) {
                    return listNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Private Link Resources.
     * Get all private link resources for a workspaces.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;PrivateLinkResourceInner&gt; object
     */
    public Observable<Page<PrivateLinkResourceInner>> listNextAsync(final String nextPageLink) {
        return listNextWithServiceResponseAsync(nextPageLink)
            .map(new Func1<ServiceResponse<Page<PrivateLinkResourceInner>>, Page<PrivateLinkResourceInner>>() {
                @Override
                public Page<PrivateLinkResourceInner> call(ServiceResponse<Page<PrivateLinkResourceInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * Private Link Resources.
     * Get all private link resources for a workspaces.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;PrivateLinkResourceInner&gt; object
     */
    public Observable<ServiceResponse<Page<PrivateLinkResourceInner>>> listNextWithServiceResponseAsync(final String nextPageLink) {
        return listNextSinglePageAsync(nextPageLink)
            .concatMap(new Func1<ServiceResponse<Page<PrivateLinkResourceInner>>, Observable<ServiceResponse<Page<PrivateLinkResourceInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<PrivateLinkResourceInner>>> call(ServiceResponse<Page<PrivateLinkResourceInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Private Link Resources.
     * Get all private link resources for a workspaces.
     *
    ServiceResponse<PageImpl<PrivateLinkResourceInner>> * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;PrivateLinkResourceInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<PrivateLinkResourceInner>>> listNextSinglePageAsync(final String nextPageLink) {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        String nextUrl = String.format("%s", nextPageLink);
        return service.listNext(nextUrl, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<PrivateLinkResourceInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<PrivateLinkResourceInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<PrivateLinkResourceInner>> result = listNextDelegate(response);
                        return Observable.just(new ServiceResponse<Page<PrivateLinkResourceInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<PrivateLinkResourceInner>> listNextDelegate(Response<ResponseBody> response) throws ErrorResponseException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<PrivateLinkResourceInner>, ErrorResponseException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<PrivateLinkResourceInner>>() { }.getType())
                .registerError(ErrorResponseException.class)
                .build(response);
    }

}
