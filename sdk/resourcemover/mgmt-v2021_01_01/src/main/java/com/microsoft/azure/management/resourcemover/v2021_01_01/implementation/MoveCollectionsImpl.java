/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * def
 */

package com.microsoft.azure.management.resourcemover.v2021_01_01.implementation;

import com.microsoft.azure.arm.resources.collection.implementation.GroupableResourcesCoreImpl;
import com.microsoft.azure.management.resourcemover.v2021_01_01.MoveCollections;
import com.microsoft.azure.management.resourcemover.v2021_01_01.MoveCollection;
import rx.Observable;
import rx.Completable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import com.microsoft.azure.arm.resources.ResourceUtilsCore;
import com.microsoft.azure.arm.utils.RXMapper;
import rx.functions.Func1;
import com.microsoft.azure.PagedList;
import com.microsoft.azure.Page;
import com.microsoft.azure.management.resourcemover.v2021_01_01.OperationStatus;
import com.microsoft.azure.management.resourcemover.v2021_01_01.RequiredForResourcesCollection;

class MoveCollectionsImpl extends GroupableResourcesCoreImpl<MoveCollection, MoveCollectionImpl, MoveCollectionInner, MoveCollectionsInner, ResourceMoverManager>  implements MoveCollections {
    protected MoveCollectionsImpl(ResourceMoverManager manager) {
        super(manager.inner().moveCollections(), manager);
    }

    @Override
    protected Observable<MoveCollectionInner> getInnerAsync(String resourceGroupName, String name) {
        MoveCollectionsInner client = this.inner();
        return client.getByResourceGroupAsync(resourceGroupName, name);
    }

    @Override
    protected Completable deleteInnerAsync(String resourceGroupName, String name) {
        MoveCollectionsInner client = this.inner();
        return client.deleteAsync(resourceGroupName, name).toCompletable();
    }

    @Override
    public Observable<String> deleteByIdsAsync(Collection<String> ids) {
        if (ids == null || ids.isEmpty()) {
            return Observable.empty();
        }
        Collection<Observable<String>> observables = new ArrayList<>();
        for (String id : ids) {
            final String resourceGroupName = ResourceUtilsCore.groupFromResourceId(id);
            final String name = ResourceUtilsCore.nameFromResourceId(id);
            Observable<String> o = RXMapper.map(this.inner().deleteAsync(resourceGroupName, name), id);
            observables.add(o);
        }
        return Observable.mergeDelayError(observables);
    }

    @Override
    public Observable<String> deleteByIdsAsync(String...ids) {
        return this.deleteByIdsAsync(new ArrayList<String>(Arrays.asList(ids)));
    }

    @Override
    public void deleteByIds(Collection<String> ids) {
        if (ids != null && !ids.isEmpty()) {
            this.deleteByIdsAsync(ids).toBlocking().last();
        }
    }

    @Override
    public void deleteByIds(String...ids) {
        this.deleteByIds(new ArrayList<String>(Arrays.asList(ids)));
    }

    @Override
    public PagedList<MoveCollection> listByResourceGroup(String resourceGroupName) {
        MoveCollectionsInner client = this.inner();
        return this.wrapList(client.listByResourceGroup(resourceGroupName));
    }

    @Override
    public Observable<MoveCollection> listByResourceGroupAsync(String resourceGroupName) {
        MoveCollectionsInner client = this.inner();
        return client.listByResourceGroupAsync(resourceGroupName)
        .flatMapIterable(new Func1<Page<MoveCollectionInner>, Iterable<MoveCollectionInner>>() {
            @Override
            public Iterable<MoveCollectionInner> call(Page<MoveCollectionInner> page) {
                return page.items();
            }
        })
        .map(new Func1<MoveCollectionInner, MoveCollection>() {
            @Override
            public MoveCollection call(MoveCollectionInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public PagedList<MoveCollection> list() {
        MoveCollectionsInner client = this.inner();
        return this.wrapList(client.list());
    }

    @Override
    public Observable<MoveCollection> listAsync() {
        MoveCollectionsInner client = this.inner();
        return client.listAsync()
        .flatMapIterable(new Func1<Page<MoveCollectionInner>, Iterable<MoveCollectionInner>>() {
            @Override
            public Iterable<MoveCollectionInner> call(Page<MoveCollectionInner> page) {
                return page.items();
            }
        })
        .map(new Func1<MoveCollectionInner, MoveCollection>() {
            @Override
            public MoveCollection call(MoveCollectionInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public MoveCollectionImpl define(String name) {
        return wrapModel(name);
    }

    @Override
    public Observable<OperationStatus> prepareAsync(String resourceGroupName, String moveCollectionName) {
        MoveCollectionsInner client = this.inner();
        return client.prepareAsync(resourceGroupName, moveCollectionName)
        .map(new Func1<OperationStatusInner, OperationStatus>() {
            @Override
            public OperationStatus call(OperationStatusInner inner) {
                return new OperationStatusImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<OperationStatus> initiateMoveAsync(String resourceGroupName, String moveCollectionName) {
        MoveCollectionsInner client = this.inner();
        return client.initiateMoveAsync(resourceGroupName, moveCollectionName)
        .map(new Func1<OperationStatusInner, OperationStatus>() {
            @Override
            public OperationStatus call(OperationStatusInner inner) {
                return new OperationStatusImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<OperationStatus> commitAsync(String resourceGroupName, String moveCollectionName) {
        MoveCollectionsInner client = this.inner();
        return client.commitAsync(resourceGroupName, moveCollectionName)
        .map(new Func1<OperationStatusInner, OperationStatus>() {
            @Override
            public OperationStatus call(OperationStatusInner inner) {
                return new OperationStatusImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<OperationStatus> discardAsync(String resourceGroupName, String moveCollectionName) {
        MoveCollectionsInner client = this.inner();
        return client.discardAsync(resourceGroupName, moveCollectionName)
        .map(new Func1<OperationStatusInner, OperationStatus>() {
            @Override
            public OperationStatus call(OperationStatusInner inner) {
                return new OperationStatusImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<OperationStatus> resolveDependenciesAsync(String resourceGroupName, String moveCollectionName) {
        MoveCollectionsInner client = this.inner();
        return client.resolveDependenciesAsync(resourceGroupName, moveCollectionName)
        .map(new Func1<OperationStatusInner, OperationStatus>() {
            @Override
            public OperationStatus call(OperationStatusInner inner) {
                return new OperationStatusImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<OperationStatus> bulkRemoveAsync(String resourceGroupName, String moveCollectionName) {
        MoveCollectionsInner client = this.inner();
        return client.bulkRemoveAsync(resourceGroupName, moveCollectionName)
        .map(new Func1<OperationStatusInner, OperationStatus>() {
            @Override
            public OperationStatus call(OperationStatusInner inner) {
                return new OperationStatusImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<RequiredForResourcesCollection> listRequiredForAsync(String resourceGroupName, String moveCollectionName, String sourceId) {
        MoveCollectionsInner client = this.inner();
        return client.listRequiredForAsync(resourceGroupName, moveCollectionName, sourceId)
        .map(new Func1<RequiredForResourcesCollectionInner, RequiredForResourcesCollection>() {
            @Override
            public RequiredForResourcesCollection call(RequiredForResourcesCollectionInner inner) {
                return new RequiredForResourcesCollectionImpl(inner, manager());
            }
        });
    }

    @Override
    protected MoveCollectionImpl wrapModel(MoveCollectionInner inner) {
        return  new MoveCollectionImpl(inner.name(), inner, manager());
    }

    @Override
    protected MoveCollectionImpl wrapModel(String name) {
        return new MoveCollectionImpl(name, new MoveCollectionInner(), this.manager());
    }

}
