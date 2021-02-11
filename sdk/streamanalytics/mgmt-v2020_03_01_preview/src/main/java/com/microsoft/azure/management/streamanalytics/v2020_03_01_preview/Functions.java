/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.streamanalytics.v2020_03_01_preview;

import com.microsoft.azure.arm.collection.SupportsCreating;
import rx.Completable;
import rx.Observable;
import com.microsoft.azure.management.streamanalytics.v2020_03_01_preview.implementation.FunctionsInner;
import com.microsoft.azure.arm.model.HasInner;

/**
 * Type representing Functions.
 */
public interface Functions extends SupportsCreating<Function.DefinitionStages.Blank>, HasInner<FunctionsInner> {
    /**
     * Tests if the information provided for a function is valid. This can range from testing the connection to the underlying web service behind the function or making sure the function code provided is syntactically correct.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param jobName The name of the streaming job.
     * @param functionName The name of the function.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<ResourceTestStatus> testAsync(String resourceGroupName, String jobName, String functionName);

    /**
     * Retrieves the default definition of a function based on the parameters specified.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param jobName The name of the streaming job.
     * @param functionName The name of the function.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<Function> retrieveDefaultDefinitionAsync(String resourceGroupName, String jobName, String functionName);

    /**
     * Gets details about the specified function.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param jobName The name of the streaming job.
     * @param functionName The name of the function.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<Function> getAsync(String resourceGroupName, String jobName, String functionName);

    /**
     * Lists all of the functions under the specified streaming job.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param jobName The name of the streaming job.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<Function> listByStreamingJobAsync(final String resourceGroupName, final String jobName);

    /**
     * Deletes a function from the streaming job.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param jobName The name of the streaming job.
     * @param functionName The name of the function.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Completable deleteAsync(String resourceGroupName, String jobName, String functionName);

}
