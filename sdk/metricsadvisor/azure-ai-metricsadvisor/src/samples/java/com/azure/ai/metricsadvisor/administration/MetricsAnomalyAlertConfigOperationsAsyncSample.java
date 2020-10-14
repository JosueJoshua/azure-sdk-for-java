// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.ai.metricsadvisor.administration;

import com.azure.ai.metricsadvisor.models.AnomalyAlertConfiguration;
import com.azure.ai.metricsadvisor.models.MetricAnomalyAlertConditions;
import com.azure.ai.metricsadvisor.models.MetricAnomalyAlertConfiguration;
import com.azure.ai.metricsadvisor.models.MetricAnomalyAlertConfigurationsOperator;
import com.azure.ai.metricsadvisor.models.MetricAnomalyAlertScope;
import com.azure.ai.metricsadvisor.models.MetricsAdvisorKeyCredential;
import com.azure.ai.metricsadvisor.models.AnomalySeverity;
import com.azure.ai.metricsadvisor.models.SeverityCondition;
import reactor.core.publisher.Mono;

import java.util.Arrays;

/**
 * Async sample demonstrates how to create, get, update, delete and list anomaly alert configurations.
 */
public class MetricsAnomalyAlertConfigOperationsAsyncSample {
    public static void main(String[] args) {
        final MetricsAdvisorAdministrationAsyncClient advisorAdministrationAsyncClient =
            new MetricsAdvisorAdministrationClientBuilder()
                .endpoint("https://{endpoint}.cognitiveservices.azure.com/")
                .credential(new MetricsAdvisorKeyCredential("subscription_key", "api_key"))
                .buildAsyncClient();

        // Create Anomaly alert config
        System.out.printf("Creating Anomaly alert config%n");
        String detectionConfigurationId1 = "9ol48er30-6e6e-4391-b78f-b00dfee1e6f5";
        String detectionConfigurationId2 = "3e58er30-6e6e-4391-b78f-b00dfee1e6f5";
        String hookId1 = "5f48er30-6e6e-4391-b78f-b00dfee1e6f5";
        String hookId2 = "8i48er30-6e6e-4391-b78f-b00dfee1e6f5";

        final Mono<AnomalyAlertConfiguration> createdAnomalyAlertConfigMono =
            advisorAdministrationAsyncClient.createAnomalyAlertConfiguration(
            new AnomalyAlertConfiguration("My Alert config name")
                .setDescription("alert config description")
                .setMetricAlertConfigurations(Arrays.asList(
                    new MetricAnomalyAlertConfiguration(detectionConfigurationId1,
                        MetricAnomalyAlertScope.forWholeSeries()),
                    new MetricAnomalyAlertConfiguration(detectionConfigurationId2,
                        MetricAnomalyAlertScope.forWholeSeries())
                        .setAlertConditions(new MetricAnomalyAlertConditions()
                            .setSeverityCondition(new SeverityCondition().setMaxAlertSeverity(AnomalySeverity.HIGH)))))
                .setCrossMetricsOperator(MetricAnomalyAlertConfigurationsOperator.AND)
                .setIdOfHooksToAlert(Arrays.asList(hookId1, hookId2)));

        createdAnomalyAlertConfigMono
            .doOnSubscribe(__ ->
                System.out.printf("Creating Anomaly alert config%n"))
            .doOnSuccess(anomalyAlertConfig ->
                System.out.printf("Created Anomaly alert config: %s%n", anomalyAlertConfig.getId()));

        // Retrieve the anomaly alert config that just created.
        Mono<AnomalyAlertConfiguration> fetchAnomalyAlertConfig =
            createdAnomalyAlertConfigMono.flatMap(createdConfig -> {
                return advisorAdministrationAsyncClient.getAnomalyAlertConfiguration(createdConfig.getId())
                    .doOnSubscribe(__ ->
                        System.out.printf("Fetching Anomaly alert config: %s%n", createdConfig.getId()))
                    .doOnSuccess(config ->
                        System.out.printf("Fetched Anomaly alert config%n"))
                    .doOnNext(anomalyAlertConfig -> {
                        System.out.printf("Anomaly alert config Id : %s%n", anomalyAlertConfig.getId());
                        System.out.printf("Anomaly alert config name : %s%n", anomalyAlertConfig.getName());
                        System.out.printf("Anomaly alert config description : %s%n", anomalyAlertConfig.getDescription());
                        System.out.println("Anomaly alert configuration hook ids:");
                        anomalyAlertConfig.getIdOfHooksToAlert().forEach(System.out::println);
                        System.out.printf("Anomaly alert configuration cross metrics operator: %s%n",
                            anomalyAlertConfig.getCrossMetricsOperator().toString());
                        System.out.println("Metric level alert configurations for this anomaly alert config:");
                        anomalyAlertConfig.getMetricAlertConfigurations().
                            forEach(metricAnomalyAlertConfiguration -> {
                                System.out.printf("Alert detection configuration Id: %s%n",
                                    metricAnomalyAlertConfiguration.getDetectionConfigurationId());
                                System.out.printf("Alert configuration negation value",
                                    metricAnomalyAlertConfiguration.isNegationOperationEnabled());
                                System.out.printf("Alert configuration scope type",
                                    metricAnomalyAlertConfiguration.getAlertScope().getScopeType().toString());
                            });
                    });
            });

        // Update the anomaly alert config.
        Mono<AnomalyAlertConfiguration> updatedAlertConfigMono = fetchAnomalyAlertConfig
            .flatMap(anomalyAlertConfig -> {
                return advisorAdministrationAsyncClient.updateAnomalyAlertConfiguration(
                    anomalyAlertConfig
                        .removeHookToAlert(hookId2)
                        .setDescription("updated to remove hookId2"))
                    .doOnSubscribe(__ ->
                        System.out.printf("Updating anomaly alert config: %s%n", anomalyAlertConfig.getId()))
                    .doOnSuccess(config -> {
                        System.out.printf("Updated anomaly alert config%n");
                        System.out.println("Updated anomaly alert config hook Id list:");
                        anomalyAlertConfig.getIdOfHooksToAlert().forEach(System.out::println);
                    });
            });

        // Delete the anomaly alert config.
        Mono<Void> deletedAnomalyAlertConfigMono = updatedAlertConfigMono.flatMap(anomalyAlertConfig -> {
            return advisorAdministrationAsyncClient.deleteAnomalyAlertConfiguration(anomalyAlertConfig.getId())
                .doOnSubscribe(__ ->
                    System.out.printf("Deleting anomaly alert config: %s%n", anomalyAlertConfig.getId()))
                .doOnSuccess(config ->
                    System.out.printf("Deleted anomaly alert config%n"));
        });

        /*
          This will block until all the above CRUD on operation on email hook is completed.
          This is strongly discouraged for use in production as it eliminates the benefits
          of asynchronous IO. It is used here to ensure the sample runs to completion.
         */
        deletedAnomalyAlertConfigMono.block();

        // List Anomaly alert configs.
        System.out.printf("Listing Anomaly alert configs for a detection configurations%n");
        advisorAdministrationAsyncClient.listAnomalyAlertConfigurations(detectionConfigurationId1)
            .doOnNext(anomalyAlertConfigurationItem -> {
                System.out.printf("Anomaly alert config Id : %s%n", anomalyAlertConfigurationItem.getId());
                System.out.printf("Anomaly alert config name : %s%n", anomalyAlertConfigurationItem.getName());
                System.out.printf("Anomaly alert config description : %s%n", anomalyAlertConfigurationItem.getDescription());
                System.out.println("Anomaly alert configuration hook ids:");
                anomalyAlertConfigurationItem.getIdOfHooksToAlert().forEach(System.out::println);
                System.out.printf("Anomaly alert configuration cross metrics operator: %s%n",
                    anomalyAlertConfigurationItem.getCrossMetricsOperator().toString());
            });
    }
}
