/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.netapp.v2020_09_01;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for ActiveDirectoryStatus.
 */
public final class ActiveDirectoryStatus extends ExpandableStringEnum<ActiveDirectoryStatus> {
    /** Static value Created for ActiveDirectoryStatus. */
    public static final ActiveDirectoryStatus CREATED = fromString("Created");

    /** Static value InUse for ActiveDirectoryStatus. */
    public static final ActiveDirectoryStatus IN_USE = fromString("InUse");

    /** Static value Deleted for ActiveDirectoryStatus. */
    public static final ActiveDirectoryStatus DELETED = fromString("Deleted");

    /** Static value Error for ActiveDirectoryStatus. */
    public static final ActiveDirectoryStatus ERROR = fromString("Error");

    /** Static value Updating for ActiveDirectoryStatus. */
    public static final ActiveDirectoryStatus UPDATING = fromString("Updating");

    /**
     * Creates or finds a ActiveDirectoryStatus from its string representation.
     * @param name a name to look for
     * @return the corresponding ActiveDirectoryStatus
     */
    @JsonCreator
    public static ActiveDirectoryStatus fromString(String name) {
        return fromString(name, ActiveDirectoryStatus.class);
    }

    /**
     * @return known ActiveDirectoryStatus values
     */
    public static Collection<ActiveDirectoryStatus> values() {
        return values(ActiveDirectoryStatus.class);
    }
}
