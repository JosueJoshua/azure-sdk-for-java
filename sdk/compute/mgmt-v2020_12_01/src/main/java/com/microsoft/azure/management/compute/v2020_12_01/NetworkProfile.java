/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.compute.v2020_12_01;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Specifies the network interfaces of the virtual machine.
 */
public class NetworkProfile {
    /**
     * Specifies the list of resource Ids for the network interfaces associated
     * with the virtual machine.
     */
    @JsonProperty(value = "networkInterfaces")
    private List<NetworkInterfaceReference> networkInterfaces;

    /**
     * Get specifies the list of resource Ids for the network interfaces associated with the virtual machine.
     *
     * @return the networkInterfaces value
     */
    public List<NetworkInterfaceReference> networkInterfaces() {
        return this.networkInterfaces;
    }

    /**
     * Set specifies the list of resource Ids for the network interfaces associated with the virtual machine.
     *
     * @param networkInterfaces the networkInterfaces value to set
     * @return the NetworkProfile object itself.
     */
    public NetworkProfile withNetworkInterfaces(List<NetworkInterfaceReference> networkInterfaces) {
        this.networkInterfaces = networkInterfaces;
        return this;
    }

}
