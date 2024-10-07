package kotlinx.coroutines.flow;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* compiled from: Transform.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class FlowKt__TransformKt$runningReduce$1$1<T> implements FlowCollector {
    final /* synthetic */ Ref.ObjectRef<Object> $accumulator;
    final /* synthetic */ Function3<T, T, Continuation<? super T>, Object> $operation;
    final /* synthetic */ FlowCollector<T> $this_unsafeFlow;

    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__TransformKt$runningReduce$1$1(Ref.ObjectRef<Object> objectRef, Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> function3, FlowCollector<? super T> flowCollector) {
        this.$accumulator = objectRef;
        this.$operation = function3;
        this.$this_unsafeFlow = flowCollector;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(T r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1$emit$1
            if (r0 == 0) goto L14
            r0 = r10
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1$emit$1
            r0.<init>(r8, r10)
        L19:
            r10 = r0
            java.lang.Object r0 = r10.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r10.label
            switch(r2) {
                case 0: goto L3f;
                case 1: goto L31;
                case 2: goto L2d;
                default: goto L25;
            }
        L25:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L2d:
            kotlin.ResultKt.throwOnFailure(r0)
            goto L7f
        L31:
            java.lang.Object r9 = r10.L$1
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r2 = r10.L$0
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1 r2 = (kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1) r2
            kotlin.ResultKt.throwOnFailure(r0)
            r3 = r2
            r2 = r0
            goto L64
        L3f:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r8
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r3 = r2.$accumulator
            T r4 = r3.element
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL
            if (r4 != r5) goto L4c
            goto L68
        L4c:
            kotlin.jvm.functions.Function3<T, T, kotlin.coroutines.Continuation<? super T>, java.lang.Object> r4 = r2.$operation
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r5 = r2.$accumulator
            T r5 = r5.element
            r10.L$0 = r2
            r10.L$1 = r3
            r6 = 1
            r10.label = r6
            java.lang.Object r9 = r4.invoke(r5, r9, r10)
            if (r9 != r1) goto L60
            return r1
        L60:
            r7 = r2
            r2 = r9
            r9 = r3
            r3 = r7
        L64:
            r7 = r3
            r3 = r9
            r9 = r2
            r2 = r7
        L68:
            r3.element = r9
            kotlinx.coroutines.flow.FlowCollector<T> r9 = r2.$this_unsafeFlow
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r3 = r2.$accumulator
            T r3 = r3.element
            r4 = 0
            r10.L$0 = r4
            r10.L$1 = r4
            r4 = 2
            r10.label = r4
            java.lang.Object r9 = r9.emit(r3, r10)
            if (r9 != r1) goto L7f
            return r1
        L7f:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
