package kotlinx.coroutines.flow;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* compiled from: SharingStarted.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlinx/coroutines/flow/SharingCommand;", "count", ""}, k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", i = {1, 2, 3}, l = {178, 180, 182, 183, 185}, m = "invokeSuspend", n = {"$this$transformLatest", "$this$transformLatest", "$this$transformLatest"}, s = {"L$0", "L$0", "L$0"})
/* loaded from: classes.dex */
final class StartedWhileSubscribed$command$1 extends SuspendLambda implements Function3<FlowCollector<? super SharingCommand>, Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StartedWhileSubscribed this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StartedWhileSubscribed$command$1(StartedWhileSubscribed startedWhileSubscribed, Continuation<? super StartedWhileSubscribed$command$1> continuation) {
        super(3, continuation);
        this.this$0 = startedWhileSubscribed;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super SharingCommand> flowCollector, Integer num, Continuation<? super Unit> continuation) {
        return invoke(flowCollector, num.intValue(), continuation);
    }

    public final Object invoke(FlowCollector<? super SharingCommand> flowCollector, int i, Continuation<? super Unit> continuation) {
        StartedWhileSubscribed$command$1 startedWhileSubscribed$command$1 = new StartedWhileSubscribed$command$1(this.this$0, continuation);
        startedWhileSubscribed$command$1.L$0 = flowCollector;
        startedWhileSubscribed$command$1.I$0 = i;
        return startedWhileSubscribed$command$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x009c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0077  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            switch(r1) {
                case 0: goto L38;
                case 1: goto L33;
                case 2: goto L2a;
                case 3: goto L21;
                case 4: goto L17;
                case 5: goto L11;
                default: goto L9;
            }
        L9:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L11:
            r0 = r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto Lb1
        L17:
            r1 = r7
            java.lang.Object r2 = r1.L$0
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L9d
        L21:
            r1 = r7
            java.lang.Object r2 = r1.L$0
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L88
        L2a:
            r1 = r7
            java.lang.Object r2 = r1.L$0
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L6b
        L33:
            r0 = r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L55
        L38:
            kotlin.ResultKt.throwOnFailure(r8)
            r1 = r7
            java.lang.Object r2 = r1.L$0
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            int r3 = r1.I$0
            if (r3 <= 0) goto L56
            kotlinx.coroutines.flow.SharingCommand r3 = kotlinx.coroutines.flow.SharingCommand.START
            r4 = r1
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r5 = 1
            r1.label = r5
            java.lang.Object r2 = r2.emit(r3, r4)
            if (r2 != r0) goto L54
            return r0
        L54:
            r0 = r1
        L55:
            goto Lb2
        L56:
            kotlinx.coroutines.flow.StartedWhileSubscribed r3 = r1.this$0
            long r3 = kotlinx.coroutines.flow.StartedWhileSubscribed.access$getStopTimeout$p(r3)
            r5 = r1
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r1.L$0 = r2
            r6 = 2
            r1.label = r6
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r3, r5)
            if (r3 != r0) goto L6b
            return r0
        L6b:
            kotlinx.coroutines.flow.StartedWhileSubscribed r3 = r1.this$0
            long r3 = kotlinx.coroutines.flow.StartedWhileSubscribed.access$getReplayExpiration$p(r3)
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L9e
            kotlinx.coroutines.flow.SharingCommand r3 = kotlinx.coroutines.flow.SharingCommand.STOP
            r4 = r1
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r1.L$0 = r2
            r5 = 3
            r1.label = r5
            java.lang.Object r3 = r2.emit(r3, r4)
            if (r3 != r0) goto L88
            return r0
        L88:
            kotlinx.coroutines.flow.StartedWhileSubscribed r3 = r1.this$0
            long r3 = kotlinx.coroutines.flow.StartedWhileSubscribed.access$getReplayExpiration$p(r3)
            r5 = r1
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r1.L$0 = r2
            r6 = 4
            r1.label = r6
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r3, r5)
            if (r3 != r0) goto L9d
            return r0
        L9d:
        L9e:
            kotlinx.coroutines.flow.SharingCommand r3 = kotlinx.coroutines.flow.SharingCommand.STOP_AND_RESET_REPLAY_CACHE
            r4 = r1
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r5 = 0
            r1.L$0 = r5
            r5 = 5
            r1.label = r5
            java.lang.Object r2 = r2.emit(r3, r4)
            if (r2 != r0) goto Lb0
            return r0
        Lb0:
            r0 = r1
        Lb1:
        Lb2:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StartedWhileSubscribed$command$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
