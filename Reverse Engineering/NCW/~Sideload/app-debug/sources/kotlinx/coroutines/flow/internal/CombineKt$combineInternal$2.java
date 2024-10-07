package kotlinx.coroutines.flow.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: Combine.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "R", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {57, 79, 82}, m = "invokeSuspend", n = {"latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
/* loaded from: classes.dex */
final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<T[]> $arrayFactory;
    final /* synthetic */ Flow<T>[] $flows;
    final /* synthetic */ FlowCollector<R> $this_combineInternal;
    final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> $transform;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CombineKt$combineInternal$2(Flow<? extends T>[] flowArr, Function0<T[]> function0, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> function3, FlowCollector<? super R> flowCollector, Continuation<? super CombineKt$combineInternal$2> continuation) {
        super(2, continuation);
        this.$flows = flowArr;
        this.$arrayFactory = function0;
        this.$transform = function3;
        this.$this_combineInternal = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.$flows, this.$arrayFactory, this.$transform, this.$this_combineInternal, continuation);
        combineKt$combineInternal$2.L$0 = obj;
        return combineKt$combineInternal$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CombineKt$combineInternal$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00f8 A[LOOP:0: B:15:0x00f8->B:35:?, LOOP_START, PHI: r6 r9
      0x00f8: PHI (r6v11 'remainingAbsentValues' int) = (r6v10 'remainingAbsentValues' int), (r6v12 'remainingAbsentValues' int) binds: [B:12:0x00f2, B:35:?] A[DONT_GENERATE, DONT_INLINE]
      0x00f8: PHI (r9v8 'element' kotlin.collections.IndexedValue) = (r9v7 'element' kotlin.collections.IndexedValue), (r9v20 'element' kotlin.collections.IndexedValue) binds: [B:12:0x00f2, B:35:?] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00ea A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0144 -> B:7:0x00d0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x016a -> B:7:0x00d0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x016d -> B:7:0x00d0). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r23) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* compiled from: Combine.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "R", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Flow<T>[] $flows;
        final /* synthetic */ int $i;
        final /* synthetic */ AtomicInteger $nonClosed;
        final /* synthetic */ Channel<IndexedValue<Object>> $resultChannel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Flow<? extends T>[] flowArr, int i, AtomicInteger atomicInteger, Channel<IndexedValue<Object>> channel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$flows = flowArr;
            this.$i = i;
            this.$nonClosed = atomicInteger;
            this.$resultChannel = channel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$flows, this.$i, this.$nonClosed, this.$resultChannel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x005c  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r9.label
                r2 = 1
                r3 = 0
                switch(r1) {
                    case 0: goto L1a;
                    case 1: goto L13;
                    default: goto Lb;
                }
            Lb:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L13:
                r0 = r9
                kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L18
                goto L3d
            L18:
                r1 = move-exception
                goto L54
            L1a:
                kotlin.ResultKt.throwOnFailure(r10)
                r1 = r9
                kotlinx.coroutines.flow.Flow<T>[] r4 = r1.$flows     // Catch: java.lang.Throwable -> L50
                int r5 = r1.$i     // Catch: java.lang.Throwable -> L50
                r4 = r4[r5]     // Catch: java.lang.Throwable -> L50
                kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1 r5 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1     // Catch: java.lang.Throwable -> L50
                kotlinx.coroutines.channels.Channel<kotlin.collections.IndexedValue<java.lang.Object>> r6 = r1.$resultChannel     // Catch: java.lang.Throwable -> L50
                int r7 = r1.$i     // Catch: java.lang.Throwable -> L50
                r5.<init>(r6, r7)     // Catch: java.lang.Throwable -> L50
                kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5     // Catch: java.lang.Throwable -> L50
                r6 = r1
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch: java.lang.Throwable -> L50
                r1.label = r2     // Catch: java.lang.Throwable -> L50
                java.lang.Object r4 = r4.collect(r5, r6)     // Catch: java.lang.Throwable -> L50
                if (r4 != r0) goto L3c
                return r0
            L3c:
                r0 = r1
            L3d:
                java.util.concurrent.atomic.AtomicInteger r1 = r0.$nonClosed
                int r1 = r1.decrementAndGet()
                if (r1 != 0) goto L4c
                kotlinx.coroutines.channels.Channel<kotlin.collections.IndexedValue<java.lang.Object>> r1 = r0.$resultChannel
                kotlinx.coroutines.channels.SendChannel r1 = (kotlinx.coroutines.channels.SendChannel) r1
                kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r1, r3, r2, r3)
            L4c:
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
            L50:
                r0 = move-exception
                r8 = r1
                r1 = r0
                r0 = r8
            L54:
                java.util.concurrent.atomic.AtomicInteger r4 = r0.$nonClosed
                int r4 = r4.decrementAndGet()
                if (r4 != 0) goto L63
                kotlinx.coroutines.channels.Channel<kotlin.collections.IndexedValue<java.lang.Object>> r4 = r0.$resultChannel
                kotlinx.coroutines.channels.SendChannel r4 = (kotlinx.coroutines.channels.SendChannel) r4
                kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r4, r3, r2, r3)
            L63:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* compiled from: Combine.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "R", "T", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00051<T> implements FlowCollector {
            final /* synthetic */ int $i;
            final /* synthetic */ Channel<IndexedValue<Object>> $resultChannel;

            C00051(Channel<IndexedValue<Object>> channel, int i) {
                this.$resultChannel = channel;
                this.$i = i;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0055 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(T r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1
                    if (r0 == 0) goto L14
                    r0 = r8
                    kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L14
                    int r8 = r0.label
                    int r8 = r8 - r2
                    r0.label = r8
                    goto L19
                L14:
                    kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1
                    r0.<init>(r6, r8)
                L19:
                    r8 = r0
                    java.lang.Object r0 = r8.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r8.label
                    switch(r2) {
                        case 0: goto L35;
                        case 1: goto L31;
                        case 2: goto L2d;
                        default: goto L25;
                    }
                L25:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L2d:
                    kotlin.ResultKt.throwOnFailure(r0)
                    goto L56
                L31:
                    kotlin.ResultKt.throwOnFailure(r0)
                    goto L4c
                L35:
                    kotlin.ResultKt.throwOnFailure(r0)
                    r2 = r6
                    kotlinx.coroutines.channels.Channel<kotlin.collections.IndexedValue<java.lang.Object>> r3 = r2.$resultChannel
                    kotlin.collections.IndexedValue r4 = new kotlin.collections.IndexedValue
                    int r5 = r2.$i
                    r4.<init>(r5, r7)
                    r5 = 1
                    r8.label = r5
                    java.lang.Object r7 = r3.send(r4, r8)
                    if (r7 != r1) goto L4c
                    return r1
                L4c:
                    r7 = 2
                    r8.label = r7
                    java.lang.Object r7 = kotlinx.coroutines.YieldKt.yield(r8)
                    if (r7 != r1) goto L56
                    return r1
                L56:
                    kotlin.Unit r7 = kotlin.Unit.INSTANCE
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.AnonymousClass1.C00051.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }
    }
}
