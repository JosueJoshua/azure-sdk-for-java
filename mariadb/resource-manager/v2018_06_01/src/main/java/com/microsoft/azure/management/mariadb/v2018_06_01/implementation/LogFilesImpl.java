/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 *
 */

package com.microsoft.azure.management.mariadb.v2018_06_01.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.mariadb.v2018_06_01.LogFiles;
import rx.Observable;
import rx.functions.Func1;
import java.util.List;
import com.microsoft.azure.management.mariadb.v2018_06_01.LogFile;

class LogFilesImpl extends WrapperImpl<LogFilesInner> implements LogFiles {
    private final MariaDBManager manager;

    LogFilesImpl(MariaDBManager manager) {
        super(manager.inner().logFiles());
        this.manager = manager;
    }

    public MariaDBManager manager() {
        return this.manager;
    }

    private LogFileImpl wrapModel(LogFileInner inner) {
        return  new LogFileImpl(inner, manager());
    }

    @Override
    public Observable<LogFile> listByServerAsync(String resourceGroupName, String serverName) {
        LogFilesInner client = this.inner();
        return client.listByServerAsync(resourceGroupName, serverName)
        .flatMap(new Func1<List<LogFileInner>, Observable<LogFileInner>>() {
            @Override
            public Observable<LogFileInner> call(List<LogFileInner> innerList) {
                return Observable.from(innerList);
            }
        })
        .map(new Func1<LogFileInner, LogFile>() {
            @Override
            public LogFile call(LogFileInner inner) {
                return wrapModel(inner);
            }
        });
    }

}
