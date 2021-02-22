// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

module com.azure.core.amqp {
    requires transitive com.azure.core;

    requires transitive com.microsoft.azure.qpid.protonj.extensions;
    requires transitive org.reactivestreams;
    requires transitive org.apache.qpid.proton.j;

    exports com.azure.core.amqp;
    exports com.azure.core.amqp.models;
    exports com.azure.core.amqp.exception;
}
