package kotlinx.coroutines;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* compiled from: JobSupport.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lkotlinx/coroutines/Job;"}, k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {1, 1, 1}, l = {952, 954}, m = "invokeSuspend", n = {"$this$sequence", "this_$iv", "cur$iv"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes.dex */
final class JobSupport$children$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Job>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ JobSupport this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    JobSupport$children$1(JobSupport jobSupport, Continuation<? super JobSupport$children$1> continuation) {
        super(2, continuation);
        this.this$0 = jobSupport;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        JobSupport$children$1 jobSupport$children$1 = new JobSupport$children$1(this.this$0, continuation);
        jobSupport$children$1.L$0 = obj;
        return jobSupport$children$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super Job> sequenceScope, Continuation<? super Unit> continuation) {
        return ((JobSupport$children$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0075  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0077 -> B:7:0x0091). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x008f -> B:7:0x0091). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            switch(r1) {
                case 0: goto L2b;
                case 1: goto L26;
                case 2: goto L11;
                default: goto L9;
            }
        L9:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L11:
            r1 = r12
            r2 = 0
            r3 = 0
            r4 = 0
            java.lang.Object r5 = r1.L$2
            kotlinx.coroutines.internal.LockFreeLinkedListNode r5 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r5
            java.lang.Object r6 = r1.L$1
            kotlinx.coroutines.internal.LockFreeLinkedListHead r6 = (kotlinx.coroutines.internal.LockFreeLinkedListHead) r6
            java.lang.Object r7 = r1.L$0
            kotlin.sequences.SequenceScope r7 = (kotlin.sequences.SequenceScope) r7
            kotlin.ResultKt.throwOnFailure(r13)
            goto L90
        L26:
            r0 = r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L50
        L2b:
            kotlin.ResultKt.throwOnFailure(r13)
            r1 = r12
            java.lang.Object r2 = r1.L$0
            kotlin.sequences.SequenceScope r2 = (kotlin.sequences.SequenceScope) r2
            kotlinx.coroutines.JobSupport r3 = r1.this$0
            java.lang.Object r3 = r3.getState$kotlinx_coroutines_core()
            boolean r4 = r3 instanceof kotlinx.coroutines.ChildHandleNode
            if (r4 == 0) goto L52
            r4 = r3
            kotlinx.coroutines.ChildHandleNode r4 = (kotlinx.coroutines.ChildHandleNode) r4
            kotlinx.coroutines.ChildJob r4 = r4.childJob
            r5 = r1
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6 = 1
            r1.label = r6
            java.lang.Object r2 = r2.yield(r4, r5)
            if (r2 != r0) goto L4f
            return r0
        L4f:
            r0 = r1
        L50:
            r1 = r0
            goto L99
        L52:
            boolean r4 = r3 instanceof kotlinx.coroutines.Incomplete
            if (r4 == 0) goto L99
            r4 = r3
            kotlinx.coroutines.Incomplete r4 = (kotlinx.coroutines.Incomplete) r4
            kotlinx.coroutines.NodeList r3 = r4.getList()
            if (r3 == 0) goto L99
            r4 = 0
            kotlinx.coroutines.internal.LockFreeLinkedListHead r3 = (kotlinx.coroutines.internal.LockFreeLinkedListHead) r3
            r5 = 0
            java.lang.Object r6 = r3.getNext()
            kotlinx.coroutines.internal.LockFreeLinkedListNode r6 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r6
            r7 = r2
            r2 = r4
            r11 = r6
            r6 = r3
            r3 = r5
            r5 = r11
        L6f:
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r4 != 0) goto L96
            boolean r4 = r5 instanceof kotlinx.coroutines.ChildHandleNode
            if (r4 == 0) goto L91
            r4 = r5
            kotlinx.coroutines.ChildHandleNode r4 = (kotlinx.coroutines.ChildHandleNode) r4
            r8 = 0
            kotlinx.coroutines.ChildJob r9 = r4.childJob
            r1.L$0 = r7
            r1.L$1 = r6
            r1.L$2 = r5
            r10 = 2
            r1.label = r10
            java.lang.Object r4 = r7.yield(r9, r1)
            if (r4 != r0) goto L8f
            return r0
        L8f:
            r4 = r8
        L90:
        L91:
            kotlinx.coroutines.internal.LockFreeLinkedListNode r5 = r5.getNextNode()
            goto L6f
        L96:
        L99:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport$children$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
