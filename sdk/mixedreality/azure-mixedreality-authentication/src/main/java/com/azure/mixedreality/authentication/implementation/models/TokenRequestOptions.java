// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.mixedreality.authentication.implementation.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Parameter group. */
@Fluent
public final class TokenRequestOptions {
    /*
     * The client request correlation vector, which should be set to a new
     * value for each request. Useful when debugging with Microsoft.
     */
    @JsonProperty(value = "clientRequestId")
    private String clientRequestId;

    /**
     * Get the clientRequestId property: The client request correlation vector, which should be set to a new value for
     * each request. Useful when debugging with Microsoft.
     *
     * @return the clientRequestId value.
     */
    public String getClientRequestId() {
        return this.clientRequestId;
    }

    /**
     * Set the clientRequestId property: The client request correlation vector, which should be set to a new value for
     * each request. Useful when debugging with Microsoft.
     *
     * @param clientRequestId the clientRequestId value to set.
     * @return the TokenRequestOptions object itself.
     */
    public TokenRequestOptions setClientRequestId(String clientRequestId) {
        this.clientRequestId = clientRequestId;
        return this;
    }
}
