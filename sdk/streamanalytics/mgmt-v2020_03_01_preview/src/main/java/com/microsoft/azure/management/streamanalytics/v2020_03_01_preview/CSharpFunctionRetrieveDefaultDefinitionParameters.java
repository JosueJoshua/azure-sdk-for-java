/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.streamanalytics.v2020_03_01_preview;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.microsoft.rest.serializer.JsonFlatten;

/**
 * The parameters needed to retrieve the default function definition for a
 * CSharp function.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "bindingType", defaultImpl = CSharpFunctionRetrieveDefaultDefinitionParameters.class)
@JsonTypeName("Microsoft.StreamAnalytics/CLRUdf")
@JsonFlatten
public class CSharpFunctionRetrieveDefaultDefinitionParameters extends FunctionRetrieveDefaultDefinitionParameters {
    /**
     * The CSharp code containing a single function definition.
     */
    @JsonProperty(value = "bindingRetrievalProperties.script")
    private String script;

    /**
     * The function type. Possible values include: 'Scalar'.
     */
    @JsonProperty(value = "bindingRetrievalProperties.udfType")
    private UdfType udfType;

    /**
     * Get the CSharp code containing a single function definition.
     *
     * @return the script value
     */
    public String script() {
        return this.script;
    }

    /**
     * Set the CSharp code containing a single function definition.
     *
     * @param script the script value to set
     * @return the CSharpFunctionRetrieveDefaultDefinitionParameters object itself.
     */
    public CSharpFunctionRetrieveDefaultDefinitionParameters withScript(String script) {
        this.script = script;
        return this;
    }

    /**
     * Get the function type. Possible values include: 'Scalar'.
     *
     * @return the udfType value
     */
    public UdfType udfType() {
        return this.udfType;
    }

    /**
     * Set the function type. Possible values include: 'Scalar'.
     *
     * @param udfType the udfType value to set
     * @return the CSharpFunctionRetrieveDefaultDefinitionParameters object itself.
     */
    public CSharpFunctionRetrieveDefaultDefinitionParameters withUdfType(UdfType udfType) {
        this.udfType = udfType;
        return this;
    }

}
