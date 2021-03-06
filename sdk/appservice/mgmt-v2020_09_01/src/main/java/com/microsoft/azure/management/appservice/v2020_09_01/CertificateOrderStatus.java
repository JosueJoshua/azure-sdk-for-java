/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.appservice.v2020_09_01;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for CertificateOrderStatus.
 */
public enum CertificateOrderStatus {
    /** Enum value Pendingissuance. */
    PENDINGISSUANCE("Pendingissuance"),

    /** Enum value Issued. */
    ISSUED("Issued"),

    /** Enum value Revoked. */
    REVOKED("Revoked"),

    /** Enum value Canceled. */
    CANCELED("Canceled"),

    /** Enum value Denied. */
    DENIED("Denied"),

    /** Enum value Pendingrevocation. */
    PENDINGREVOCATION("Pendingrevocation"),

    /** Enum value PendingRekey. */
    PENDING_REKEY("PendingRekey"),

    /** Enum value Unused. */
    UNUSED("Unused"),

    /** Enum value Expired. */
    EXPIRED("Expired"),

    /** Enum value NotSubmitted. */
    NOT_SUBMITTED("NotSubmitted");

    /** The actual serialized value for a CertificateOrderStatus instance. */
    private String value;

    CertificateOrderStatus(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a CertificateOrderStatus instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed CertificateOrderStatus object, or null if unable to parse.
     */
    @JsonCreator
    public static CertificateOrderStatus fromString(String value) {
        CertificateOrderStatus[] items = CertificateOrderStatus.values();
        for (CertificateOrderStatus item : items) {
            if (item.toString().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
