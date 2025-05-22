package kotlinx.coroutines.future;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.function.BiFunction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: Future.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0018\u0012\u0006\u0012\u0004\u0018\u0001H\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0015\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J!\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00018\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/future/ContinuationHandler;", "T", "Ljava/util/function/BiFunction;", "", "", "cont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/Continuation;)V", "apply", "result", "exception", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
final class ContinuationHandler<T> implements BiFunction<T, Throwable, Unit> {
    public volatile Continuation<? super T> cont;

    public ContinuationHandler(Continuation<? super T> continuation) {
        this.cont = continuation;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.BiFunction
    public /* bridge */ /* synthetic */ Unit apply(Object obj, Throwable th) {
        apply2((ContinuationHandler<T>) obj, th);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
    
        r2 = r2.getCause();
     */
    /* renamed from: apply, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void apply2(T r2, java.lang.Throwable r3) {
        /*
            r1 = this;
            kotlin.coroutines.Continuation<? super T> r0 = r1.cont
            if (r0 != 0) goto L5
            return
        L5:
            if (r3 != 0) goto L11
            kotlin.Result$Companion r3 = kotlin.Result.INSTANCE
            java.lang.Object r2 = kotlin.Result.m5528constructorimpl(r2)
            r0.resumeWith(r2)
            goto L34
        L11:
            boolean r2 = kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0.m$1(r3)
            if (r2 == 0) goto L1c
            java.util.concurrent.CompletionException r2 = kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0.m6864m(r3)
            goto L1d
        L1c:
            r2 = 0
        L1d:
            if (r2 == 0) goto L27
            java.lang.Throwable r2 = kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0.m(r2)
            if (r2 != 0) goto L26
            goto L27
        L26:
            r3 = r2
        L27:
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE
            java.lang.Object r2 = kotlin.ResultKt.createFailure(r3)
            java.lang.Object r2 = kotlin.Result.m5528constructorimpl(r2)
            r0.resumeWith(r2)
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.future.ContinuationHandler.apply2(java.lang.Object, java.lang.Throwable):void");
    }
}
