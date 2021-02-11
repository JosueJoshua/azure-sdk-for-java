/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.compute.v2020_10_01_preview;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes scaling information of a sku.
 */
public class VirtualMachineScaleSetSkuCapacity {
    /**
     * The minimum capacity.
     */
    @JsonProperty(value = "minimum", access = JsonProperty.Access.WRITE_ONLY)
    private Long minimum;

    /**
     * The maximum capacity that can be set.
     */
    @JsonProperty(value = "maximum", access = JsonProperty.Access.WRITE_ONLY)
    private Long maximum;

    /**
     * The default capacity.
     */
    @JsonProperty(value = "defaultCapacity", access = JsonProperty.Access.WRITE_ONLY)
    private Long defaultCapacity;

    /**
     * The scale type applicable to the sku. Possible values include:
     * 'Automatic', 'None'.
     */
    @JsonProperty(value = "scaleType", access = JsonProperty.Access.WRITE_ONLY)
    private VirtualMachineScaleSetSkuScaleType scaleType;

    /**
     * Get the minimum capacity.
     *
     * @return the minimum value
     */
    public Long minimum() {
        return this.minimum;
    }

    /**
     * Get the maximum capacity that can be set.
     *
     * @return the maximum value
     */
    public Long maximum() {
        return this.maximum;
    }

    /**
     * Get the default capacity.
     *
     * @return the defaultCapacity value
     */
    public Long defaultCapacity() {
        return this.defaultCapacity;
    }

    /**
     * Get the scale type applicable to the sku. Possible values include: 'Automatic', 'None'.
     *
     * @return the scaleType value
     */
    public VirtualMachineScaleSetSkuScaleType scaleType() {
        return this.scaleType;
    }

}
