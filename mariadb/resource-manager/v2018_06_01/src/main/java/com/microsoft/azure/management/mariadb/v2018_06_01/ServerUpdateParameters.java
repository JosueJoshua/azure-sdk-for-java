/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.mariadb.v2018_06_01;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;

/**
 * Parameters allowed to update for a server.
 */
@JsonFlatten
public class ServerUpdateParameters {
    /**
     * The SKU (pricing tier) of the server.
     */
    @JsonProperty(value = "sku")
    private Sku sku;

    /**
     * Storage profile of a server.
     */
    @JsonProperty(value = "properties.storageProfile")
    private StorageProfile storageProfile;

    /**
     * The password of the administrator login.
     */
    @JsonProperty(value = "properties.administratorLoginPassword")
    private String administratorLoginPassword;

    /**
     * The version of a server. Possible values include: '5.6', '5.7'.
     */
    @JsonProperty(value = "properties.version")
    private ServerVersion version;

    /**
     * Enable ssl enforcement or not when connect to server. Possible values
     * include: 'Enabled', 'Disabled'.
     */
    @JsonProperty(value = "properties.sslEnforcement")
    private SslEnforcementEnum sslEnforcement;

    /**
     * The replication role of the server.
     */
    @JsonProperty(value = "properties.replicationRole")
    private String replicationRole;

    /**
     * Application-specific metadata in the form of key-value pairs.
     */
    @JsonProperty(value = "tags")
    private Map<String, String> tags;

    /**
     * Get the SKU (pricing tier) of the server.
     *
     * @return the sku value
     */
    public Sku sku() {
        return this.sku;
    }

    /**
     * Set the SKU (pricing tier) of the server.
     *
     * @param sku the sku value to set
     * @return the ServerUpdateParameters object itself.
     */
    public ServerUpdateParameters withSku(Sku sku) {
        this.sku = sku;
        return this;
    }

    /**
     * Get storage profile of a server.
     *
     * @return the storageProfile value
     */
    public StorageProfile storageProfile() {
        return this.storageProfile;
    }

    /**
     * Set storage profile of a server.
     *
     * @param storageProfile the storageProfile value to set
     * @return the ServerUpdateParameters object itself.
     */
    public ServerUpdateParameters withStorageProfile(StorageProfile storageProfile) {
        this.storageProfile = storageProfile;
        return this;
    }

    /**
     * Get the password of the administrator login.
     *
     * @return the administratorLoginPassword value
     */
    public String administratorLoginPassword() {
        return this.administratorLoginPassword;
    }

    /**
     * Set the password of the administrator login.
     *
     * @param administratorLoginPassword the administratorLoginPassword value to set
     * @return the ServerUpdateParameters object itself.
     */
    public ServerUpdateParameters withAdministratorLoginPassword(String administratorLoginPassword) {
        this.administratorLoginPassword = administratorLoginPassword;
        return this;
    }

    /**
     * Get the version of a server. Possible values include: '5.6', '5.7'.
     *
     * @return the version value
     */
    public ServerVersion version() {
        return this.version;
    }

    /**
     * Set the version of a server. Possible values include: '5.6', '5.7'.
     *
     * @param version the version value to set
     * @return the ServerUpdateParameters object itself.
     */
    public ServerUpdateParameters withVersion(ServerVersion version) {
        this.version = version;
        return this;
    }

    /**
     * Get enable ssl enforcement or not when connect to server. Possible values include: 'Enabled', 'Disabled'.
     *
     * @return the sslEnforcement value
     */
    public SslEnforcementEnum sslEnforcement() {
        return this.sslEnforcement;
    }

    /**
     * Set enable ssl enforcement or not when connect to server. Possible values include: 'Enabled', 'Disabled'.
     *
     * @param sslEnforcement the sslEnforcement value to set
     * @return the ServerUpdateParameters object itself.
     */
    public ServerUpdateParameters withSslEnforcement(SslEnforcementEnum sslEnforcement) {
        this.sslEnforcement = sslEnforcement;
        return this;
    }

    /**
     * Get the replication role of the server.
     *
     * @return the replicationRole value
     */
    public String replicationRole() {
        return this.replicationRole;
    }

    /**
     * Set the replication role of the server.
     *
     * @param replicationRole the replicationRole value to set
     * @return the ServerUpdateParameters object itself.
     */
    public ServerUpdateParameters withReplicationRole(String replicationRole) {
        this.replicationRole = replicationRole;
        return this;
    }

    /**
     * Get application-specific metadata in the form of key-value pairs.
     *
     * @return the tags value
     */
    public Map<String, String> tags() {
        return this.tags;
    }

    /**
     * Set application-specific metadata in the form of key-value pairs.
     *
     * @param tags the tags value to set
     * @return the ServerUpdateParameters object itself.
     */
    public ServerUpdateParameters withTags(Map<String, String> tags) {
        this.tags = tags;
        return this;
    }

}
