package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LifecycleRegistry.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 42\u00020\u0001:\u000245B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001cH\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u001cH\u0002J\u0010\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020(H\u0003J\u0010\u0010)\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u0010\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\"2\u0006\u0010\n\u001a\u00020\u000bH\u0017J\u0010\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u00020\u000bH\u0002J\b\u00100\u001a\u00020\"H\u0002J\u0010\u00101\u001a\u00020\"2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u00102\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001cH\u0016J\b\u00103\u001a\u00020\"H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u001fj\b\u0012\u0004\u0012\u00020\u000b` X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Landroidx/lifecycle/LifecycleRegistry;", "Landroidx/lifecycle/Lifecycle;", "provider", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;)V", "enforceMainThread", "", "(Landroidx/lifecycle/LifecycleOwner;Z)V", "addingObserverCounter", "", "state", "Landroidx/lifecycle/Lifecycle$State;", "currentState", "getCurrentState", "()Landroidx/lifecycle/Lifecycle$State;", "setCurrentState", "(Landroidx/lifecycle/Lifecycle$State;)V", "handlingEvent", "isSynced", "()Z", "lifecycleOwner", "Ljava/lang/ref/WeakReference;", "newEventOccurred", "observerCount", "getObserverCount", "()I", "observerMap", "Landroidx/arch/core/internal/FastSafeIterableMap;", "Landroidx/lifecycle/LifecycleObserver;", "Landroidx/lifecycle/LifecycleRegistry$ObserverWithState;", "parentStates", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addObserver", "", "observer", "backwardPass", "calculateTargetState", "enforceMainThreadIfNeeded", "methodName", "", "forwardPass", "handleLifecycleEvent", NotificationCompat.CATEGORY_EVENT, "Landroidx/lifecycle/Lifecycle$Event;", "markState", "moveToState", "next", "popParentState", "pushParentState", "removeObserver", "sync", "Companion", "ObserverWithState", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public class LifecycleRegistry extends Lifecycle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int addingObserverCounter;
    private final boolean enforceMainThread;
    private boolean handlingEvent;
    private final WeakReference<LifecycleOwner> lifecycleOwner;
    private boolean newEventOccurred;
    private FastSafeIterableMap<LifecycleObserver, ObserverWithState> observerMap;
    private ArrayList<Lifecycle.State> parentStates;
    private Lifecycle.State state;

    public /* synthetic */ LifecycleRegistry(LifecycleOwner lifecycleOwner, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(lifecycleOwner, z);
    }

    @JvmStatic
    public static final LifecycleRegistry createUnsafe(LifecycleOwner lifecycleOwner) {
        return INSTANCE.createUnsafe(lifecycleOwner);
    }

    private LifecycleRegistry(LifecycleOwner provider, boolean enforceMainThread) {
        this.enforceMainThread = enforceMainThread;
        this.observerMap = new FastSafeIterableMap<>();
        this.state = Lifecycle.State.INITIALIZED;
        this.parentStates = new ArrayList<>();
        this.lifecycleOwner = new WeakReference<>(provider);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LifecycleRegistry(LifecycleOwner provider) {
        this(provider, true);
        Intrinsics.checkNotNullParameter(provider, "provider");
    }

    @Deprecated(message = "Override [currentState].")
    public void markState(Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        enforceMainThreadIfNeeded("markState");
        setCurrentState(state);
    }

    @Override // androidx.lifecycle.Lifecycle
    /* renamed from: getCurrentState, reason: from getter */
    public Lifecycle.State getState() {
        return this.state;
    }

    public void setCurrentState(Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        enforceMainThreadIfNeeded("setCurrentState");
        moveToState(state);
    }

    public void handleLifecycleEvent(Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        enforceMainThreadIfNeeded("handleLifecycleEvent");
        moveToState(event.getTargetState());
    }

    private final void moveToState(Lifecycle.State next) {
        Lifecycle.State state = this.state;
        if (state == next) {
            return;
        }
        if (!((state == Lifecycle.State.INITIALIZED && next == Lifecycle.State.DESTROYED) ? false : true)) {
            throw new IllegalStateException(("no event down from " + this.state + " in component " + this.lifecycleOwner.get()).toString());
        }
        this.state = next;
        if (this.handlingEvent || this.addingObserverCounter != 0) {
            this.newEventOccurred = true;
            return;
        }
        this.handlingEvent = true;
        sync();
        this.handlingEvent = false;
        if (this.state == Lifecycle.State.DESTROYED) {
            this.observerMap = new FastSafeIterableMap<>();
        }
    }

    private final boolean isSynced() {
        if (this.observerMap.size() == 0) {
            return true;
        }
        Map.Entry<LifecycleObserver, ObserverWithState> eldest = this.observerMap.eldest();
        Intrinsics.checkNotNull(eldest);
        Lifecycle.State eldestObserverState = eldest.getValue().getState();
        Map.Entry<LifecycleObserver, ObserverWithState> newest = this.observerMap.newest();
        Intrinsics.checkNotNull(newest);
        Lifecycle.State newestObserverState = newest.getValue().getState();
        return eldestObserverState == newestObserverState && this.state == newestObserverState;
    }

    private final Lifecycle.State calculateTargetState(LifecycleObserver observer) {
        ObserverWithState value;
        Map.Entry map = this.observerMap.ceil(observer);
        Lifecycle.State parentState = null;
        Lifecycle.State siblingState = (map == null || (value = map.getValue()) == null) ? null : value.getState();
        if (!this.parentStates.isEmpty()) {
            parentState = this.parentStates.get(r1.size() - 1);
        }
        Companion companion = INSTANCE;
        return companion.min$lifecycle_runtime_release(companion.min$lifecycle_runtime_release(this.state, siblingState), parentState);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void addObserver(LifecycleObserver observer) {
        LifecycleOwner lifecycleOwner;
        Intrinsics.checkNotNullParameter(observer, "observer");
        enforceMainThreadIfNeeded("addObserver");
        Lifecycle.State initialState = this.state == Lifecycle.State.DESTROYED ? Lifecycle.State.DESTROYED : Lifecycle.State.INITIALIZED;
        ObserverWithState statefulObserver = new ObserverWithState(observer, initialState);
        ObserverWithState previous = this.observerMap.putIfAbsent(observer, statefulObserver);
        if (previous != null || (lifecycleOwner = this.lifecycleOwner.get()) == null) {
            return;
        }
        boolean isReentrance = this.addingObserverCounter != 0 || this.handlingEvent;
        Lifecycle.State targetState = calculateTargetState(observer);
        this.addingObserverCounter++;
        while (statefulObserver.getState().compareTo(targetState) < 0 && this.observerMap.contains(observer)) {
            pushParentState(statefulObserver.getState());
            Lifecycle.Event event = Lifecycle.Event.INSTANCE.upFrom(statefulObserver.getState());
            if (event == null) {
                throw new IllegalStateException("no event up from " + statefulObserver.getState());
            }
            statefulObserver.dispatchEvent(lifecycleOwner, event);
            popParentState();
            targetState = calculateTargetState(observer);
        }
        if (!isReentrance) {
            sync();
        }
        this.addingObserverCounter--;
    }

    private final void popParentState() {
        this.parentStates.remove(r0.size() - 1);
    }

    private final void pushParentState(Lifecycle.State state) {
        this.parentStates.add(state);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void removeObserver(LifecycleObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        enforceMainThreadIfNeeded("removeObserver");
        this.observerMap.remove(observer);
    }

    public int getObserverCount() {
        enforceMainThreadIfNeeded("getObserverCount");
        return this.observerMap.size();
    }

    private final void forwardPass(LifecycleOwner lifecycleOwner) {
        Iterator iteratorWithAdditions = this.observerMap.iteratorWithAdditions();
        Intrinsics.checkNotNullExpressionValue(iteratorWithAdditions, "observerMap.iteratorWithAdditions()");
        Iterator ascendingIterator = iteratorWithAdditions;
        while (ascendingIterator.hasNext() && !this.newEventOccurred) {
            Map.Entry next = ascendingIterator.next();
            LifecycleObserver key = (LifecycleObserver) next.getKey();
            ObserverWithState observer = (ObserverWithState) next.getValue();
            while (observer.getState().compareTo(this.state) < 0 && !this.newEventOccurred && this.observerMap.contains(key)) {
                pushParentState(observer.getState());
                Lifecycle.Event event = Lifecycle.Event.INSTANCE.upFrom(observer.getState());
                if (event == null) {
                    throw new IllegalStateException("no event up from " + observer.getState());
                }
                observer.dispatchEvent(lifecycleOwner, event);
                popParentState();
            }
        }
    }

    private final void backwardPass(LifecycleOwner lifecycleOwner) {
        Iterator descendingIterator = this.observerMap.descendingIterator();
        Intrinsics.checkNotNullExpressionValue(descendingIterator, "observerMap.descendingIterator()");
        while (descendingIterator.hasNext() && !this.newEventOccurred) {
            Map.Entry<LifecycleObserver, ObserverWithState> next = descendingIterator.next();
            Intrinsics.checkNotNullExpressionValue(next, "next()");
            LifecycleObserver key = next.getKey();
            ObserverWithState observer = next.getValue();
            while (observer.getState().compareTo(this.state) > 0 && !this.newEventOccurred && this.observerMap.contains(key)) {
                Lifecycle.Event event = Lifecycle.Event.INSTANCE.downFrom(observer.getState());
                if (event == null) {
                    throw new IllegalStateException("no event down from " + observer.getState());
                }
                pushParentState(event.getTargetState());
                observer.dispatchEvent(lifecycleOwner, event);
                popParentState();
            }
        }
    }

    private final void sync() {
        LifecycleOwner lifecycleOwner = this.lifecycleOwner.get();
        if (lifecycleOwner == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
        while (!isSynced()) {
            this.newEventOccurred = false;
            Lifecycle.State state = this.state;
            Map.Entry<LifecycleObserver, ObserverWithState> eldest = this.observerMap.eldest();
            Intrinsics.checkNotNull(eldest);
            if (state.compareTo(eldest.getValue().getState()) < 0) {
                backwardPass(lifecycleOwner);
            }
            Map.Entry newest = this.observerMap.newest();
            if (!this.newEventOccurred && newest != null && this.state.compareTo(newest.getValue().getState()) > 0) {
                forwardPass(lifecycleOwner);
            }
        }
        this.newEventOccurred = false;
    }

    private final void enforceMainThreadIfNeeded(String methodName) {
        if (this.enforceMainThread && !ArchTaskExecutor.getInstance().isMainThread()) {
            throw new IllegalStateException(("Method " + methodName + " must be called on the main thread").toString());
        }
    }

    /* compiled from: LifecycleRegistry.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Landroidx/lifecycle/LifecycleRegistry$ObserverWithState;", "", "observer", "Landroidx/lifecycle/LifecycleObserver;", "initialState", "Landroidx/lifecycle/Lifecycle$State;", "(Landroidx/lifecycle/LifecycleObserver;Landroidx/lifecycle/Lifecycle$State;)V", "lifecycleObserver", "Landroidx/lifecycle/LifecycleEventObserver;", "getLifecycleObserver", "()Landroidx/lifecycle/LifecycleEventObserver;", "setLifecycleObserver", "(Landroidx/lifecycle/LifecycleEventObserver;)V", "state", "getState", "()Landroidx/lifecycle/Lifecycle$State;", "setState", "(Landroidx/lifecycle/Lifecycle$State;)V", "dispatchEvent", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", NotificationCompat.CATEGORY_EVENT, "Landroidx/lifecycle/Lifecycle$Event;", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class ObserverWithState {
        private LifecycleEventObserver lifecycleObserver;
        private Lifecycle.State state;

        public ObserverWithState(LifecycleObserver observer, Lifecycle.State initialState) {
            Intrinsics.checkNotNullParameter(initialState, "initialState");
            Intrinsics.checkNotNull(observer);
            this.lifecycleObserver = Lifecycling.lifecycleEventObserver(observer);
            this.state = initialState;
        }

        public final Lifecycle.State getState() {
            return this.state;
        }

        public final void setState(Lifecycle.State state) {
            Intrinsics.checkNotNullParameter(state, "<set-?>");
            this.state = state;
        }

        public final LifecycleEventObserver getLifecycleObserver() {
            return this.lifecycleObserver;
        }

        public final void setLifecycleObserver(LifecycleEventObserver lifecycleEventObserver) {
            Intrinsics.checkNotNullParameter(lifecycleEventObserver, "<set-?>");
            this.lifecycleObserver = lifecycleEventObserver;
        }

        public final void dispatchEvent(LifecycleOwner owner, Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter(event, "event");
            Lifecycle.State newState = event.getTargetState();
            this.state = LifecycleRegistry.INSTANCE.min$lifecycle_runtime_release(this.state, newState);
            LifecycleEventObserver lifecycleEventObserver = this.lifecycleObserver;
            Intrinsics.checkNotNull(owner);
            lifecycleEventObserver.onStateChanged(owner, event);
            this.state = newState;
        }
    }

    /* compiled from: LifecycleRegistry.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001f\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0002\b\u000b¨\u0006\f"}, d2 = {"Landroidx/lifecycle/LifecycleRegistry$Companion;", "", "()V", "createUnsafe", "Landroidx/lifecycle/LifecycleRegistry;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "min", "Landroidx/lifecycle/Lifecycle$State;", "state1", "state2", "min$lifecycle_runtime_release", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final LifecycleRegistry createUnsafe(LifecycleOwner owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            return new LifecycleRegistry(owner, false, null);
        }

        @JvmStatic
        public final Lifecycle.State min$lifecycle_runtime_release(Lifecycle.State state1, Lifecycle.State state2) {
            Intrinsics.checkNotNullParameter(state1, "state1");
            return (state2 == null || state2.compareTo(state1) >= 0) ? state1 : state2;
        }
    }
}
