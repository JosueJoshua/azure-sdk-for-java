/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.appservice.v2020_09_01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Rules that can be defined for auto-heal.
 */
public class AutoHealRules {
    /**
     * Conditions that describe when to execute the auto-heal actions.
     */
    @JsonProperty(value = "triggers")
    private AutoHealTriggers triggers;

    /**
     * Actions to be executed when a rule is triggered.
     */
    @JsonProperty(value = "actions")
    private AutoHealActions actions;

    /**
     * Get conditions that describe when to execute the auto-heal actions.
     *
     * @return the triggers value
     */
    public AutoHealTriggers triggers() {
        return this.triggers;
    }

    /**
     * Set conditions that describe when to execute the auto-heal actions.
     *
     * @param triggers the triggers value to set
     * @return the AutoHealRules object itself.
     */
    public AutoHealRules withTriggers(AutoHealTriggers triggers) {
        this.triggers = triggers;
        return this;
    }

    /**
     * Get actions to be executed when a rule is triggered.
     *
     * @return the actions value
     */
    public AutoHealActions actions() {
        return this.actions;
    }

    /**
     * Set actions to be executed when a rule is triggered.
     *
     * @param actions the actions value to set
     * @return the AutoHealRules object itself.
     */
    public AutoHealRules withActions(AutoHealActions actions) {
        this.actions = actions;
        return this;
    }

}
