package androidx.lifecycle;

import androidx.arch.core.util.Function;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: Transformations.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001aB\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u001c\u0010\u0005\u001a\u0018\u0012\t\u0012\u0007H\u0002¢\u0006\u0002\b\u0007\u0012\t\u0012\u0007H\u0004¢\u0006\u0002\b\u00070\u0006H\u0007\u001a8\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\tH\u0007\u001aJ\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012$\u0010\u0005\u001a \u0012\t\u0012\u0007H\u0002¢\u0006\u0002\b\u0007\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\u0001¢\u0006\u0002\b\u00070\u0006H\u0007\u001a>\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00010\tH\u0007¨\u0006\f"}, d2 = {"distinctUntilChanged", "Landroidx/lifecycle/LiveData;", "X", "map", "Y", "transform", "Lkotlin/Function1;", "Lkotlin/jvm/JvmSuppressWildcards;", "mapFunction", "Landroidx/arch/core/util/Function;", "switchMap", "switchMapFunction", "lifecycle-livedata_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class Transformations {
    public static final <X, Y> LiveData<Y> map(LiveData<X> liveData, final Function1<X, Y> transform) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        final MediatorLiveData result = new MediatorLiveData();
        result.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new Function1<X, Unit>() { // from class: androidx.lifecycle.Transformations$map$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2((Transformations$map$1<X>) obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(X x) {
                result.setValue(transform.invoke(x));
            }
        }));
        return result;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use kotlin functions, instead of outdated arch core Functions")
    public static final /* synthetic */ LiveData map(LiveData $this$map, final Function mapFunction) {
        Intrinsics.checkNotNullParameter($this$map, "<this>");
        Intrinsics.checkNotNullParameter(mapFunction, "mapFunction");
        final MediatorLiveData result = new MediatorLiveData();
        result.addSource($this$map, new Transformations$sam$androidx_lifecycle_Observer$0(new Function1<X, Unit>() { // from class: androidx.lifecycle.Transformations$map$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2((Transformations$map$2<X>) obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(X x) {
                result.setValue(mapFunction.apply(x));
            }
        }));
        return result;
    }

    public static final <X, Y> LiveData<Y> switchMap(LiveData<X> liveData, final Function1<X, LiveData<Y>> transform) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        final MediatorLiveData result = new MediatorLiveData();
        result.addSource(liveData, new Observer<X>() { // from class: androidx.lifecycle.Transformations$switchMap$1
            private LiveData<Y> liveData;

            public final LiveData<Y> getLiveData() {
                return this.liveData;
            }

            public final void setLiveData(LiveData<Y> liveData2) {
                this.liveData = liveData2;
            }

            @Override // androidx.lifecycle.Observer
            public void onChanged(X value) {
                LiveData newLiveData = (LiveData) transform.invoke(value);
                LiveData liveData2 = this.liveData;
                if (liveData2 == newLiveData) {
                    return;
                }
                if (liveData2 != null) {
                    MediatorLiveData<Y> mediatorLiveData = result;
                    Intrinsics.checkNotNull(liveData2);
                    mediatorLiveData.removeSource(liveData2);
                }
                this.liveData = newLiveData;
                if (newLiveData != null) {
                    MediatorLiveData<Y> mediatorLiveData2 = result;
                    Intrinsics.checkNotNull(newLiveData);
                    final MediatorLiveData<Y> mediatorLiveData3 = result;
                    mediatorLiveData2.addSource(newLiveData, new Transformations$sam$androidx_lifecycle_Observer$0(new Function1<Y, Unit>() { // from class: androidx.lifecycle.Transformations$switchMap$1$onChanged$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                            invoke2((Transformations$switchMap$1$onChanged$1<Y>) obj);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Y y) {
                            mediatorLiveData3.setValue(y);
                        }
                    }));
                }
            }
        });
        return result;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use kotlin functions, instead of outdated arch core Functions")
    public static final /* synthetic */ LiveData switchMap(LiveData $this$switchMap, final Function switchMapFunction) {
        Intrinsics.checkNotNullParameter($this$switchMap, "<this>");
        Intrinsics.checkNotNullParameter(switchMapFunction, "switchMapFunction");
        final MediatorLiveData result = new MediatorLiveData();
        result.addSource($this$switchMap, new Observer<X>() { // from class: androidx.lifecycle.Transformations$switchMap$2
            private LiveData<Y> liveData;

            public final LiveData<Y> getLiveData() {
                return this.liveData;
            }

            public final void setLiveData(LiveData<Y> liveData) {
                this.liveData = liveData;
            }

            @Override // androidx.lifecycle.Observer
            public void onChanged(X value) {
                LiveData newLiveData = (LiveData) switchMapFunction.apply(value);
                LiveData liveData = this.liveData;
                if (liveData == newLiveData) {
                    return;
                }
                if (liveData != null) {
                    MediatorLiveData<Y> mediatorLiveData = result;
                    Intrinsics.checkNotNull(liveData);
                    mediatorLiveData.removeSource(liveData);
                }
                this.liveData = newLiveData;
                if (newLiveData != null) {
                    MediatorLiveData<Y> mediatorLiveData2 = result;
                    Intrinsics.checkNotNull(newLiveData);
                    final MediatorLiveData<Y> mediatorLiveData3 = result;
                    mediatorLiveData2.addSource(newLiveData, new Transformations$sam$androidx_lifecycle_Observer$0(new Function1<Y, Unit>() { // from class: androidx.lifecycle.Transformations$switchMap$2$onChanged$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                            invoke2((Transformations$switchMap$2$onChanged$1<Y>) obj);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Y y) {
                            mediatorLiveData3.setValue(y);
                        }
                    }));
                }
            }
        });
        return result;
    }

    public static final <X> LiveData<X> distinctUntilChanged(LiveData<X> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        final MediatorLiveData outputLiveData = new MediatorLiveData();
        final Ref.BooleanRef firstTime = new Ref.BooleanRef();
        firstTime.element = true;
        if (liveData.isInitialized()) {
            outputLiveData.setValue(liveData.getValue());
            firstTime.element = false;
        }
        outputLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new Function1<X, Unit>() { // from class: androidx.lifecycle.Transformations$distinctUntilChanged$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2((Transformations$distinctUntilChanged$1<X>) obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(X x) {
                Object previousValue = outputLiveData.getValue();
                if (firstTime.element || ((previousValue == null && x != null) || (previousValue != null && !Intrinsics.areEqual(previousValue, x)))) {
                    firstTime.element = false;
                    outputLiveData.setValue(x);
                }
            }
        }));
        return outputLiveData;
    }
}
