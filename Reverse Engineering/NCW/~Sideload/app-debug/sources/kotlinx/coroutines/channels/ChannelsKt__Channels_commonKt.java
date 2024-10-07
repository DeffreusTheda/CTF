package kotlinx.coroutines.channels;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.selects.SelectClause1;

/* compiled from: Channels.common.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u001a\u001a\u0010\u0002\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0001\u001aC\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\t0\n2\u001d\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u0004\u0012\u0004\u0012\u0002H\b0\f¢\u0006\u0002\b\rH\u0087\b¢\u0006\u0002\u0010\u000e\u001aP\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\t0\u00042\u001d\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u0004\u0012\u0004\u0012\u0002H\b0\f¢\u0006\u0002\b\rH\u0086\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000f\u001a5\u0010\u0010\u001a\u00020\u0003\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\n2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00030\fH\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a5\u0010\u0010\u001a\u00020\u0003\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00030\fH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a$\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\t0\u0015\"\b\b\u0000\u0010\t*\u00020\u0016*\b\u0012\u0004\u0012\u0002H\t0\u0004H\u0007\u001a'\u0010\u0017\u001a\u0004\u0018\u0001H\t\"\b\b\u0000\u0010\t*\u00020\u0016*\b\u0012\u0004\u0012\u0002H\t0\u0004H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a'\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\t0\u001a\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"DEFAULT_CLOSE_MESSAGE", "", "cancelConsumed", "", "Lkotlinx/coroutines/channels/ReceiveChannel;", "cause", "", "consume", "R", "E", "Lkotlinx/coroutines/channels/BroadcastChannel;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "consumeEach", "action", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onReceiveOrNull", "Lkotlinx/coroutines/selects/SelectClause1;", "", "receiveOrNull", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toList", "", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE, xs = "kotlinx/coroutines/channels/ChannelsKt")
/* loaded from: classes.dex */
final /* synthetic */ class ChannelsKt__Channels_commonKt {
    public static final <E, R> R consume(BroadcastChannel<E> broadcastChannel, Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        ReceiveChannel channel = broadcastChannel.openSubscription();
        try {
            return function1.invoke(channel);
        } finally {
            InlineMarker.finallyStart(1);
            ReceiveChannel.DefaultImpls.cancel$default(channel, (CancellationException) null, 1, (Object) null);
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'receiveCatching'", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    public static final <E> Object receiveOrNull(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        return receiveChannel.receiveOrNull(continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'onReceiveCatching'")
    public static final <E> SelectClause1<E> onReceiveOrNull(ReceiveChannel<? extends E> receiveChannel) {
        return receiveChannel.getOnReceiveOrNull();
    }

    public static final <E, R> R consume(ReceiveChannel<? extends E> receiveChannel, Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        try {
            R invoke = function1.invoke(receiveChannel);
            InlineMarker.finallyStart(1);
            ChannelsKt.cancelConsumed(receiveChannel, null);
            InlineMarker.finallyEnd(1);
            return invoke;
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0081 A[Catch: all -> 0x00a0, TryCatch #0 {all -> 0x00a0, blocks: (B:16:0x0079, B:18:0x0081, B:24:0x0090), top: B:15:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0090 A[Catch: all -> 0x00a0, TRY_LEAVE, TryCatch #0 {all -> 0x00a0, blocks: (B:16:0x0079, B:18:0x0081, B:24:0x0090), top: B:15:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0070 -> B:15:0x0079). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <E> java.lang.Object consumeEach(kotlinx.coroutines.channels.ReceiveChannel<? extends E> r10, kotlin.jvm.functions.Function1<? super E, kotlin.Unit> r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            Method dump skipped, instructions count: 192
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.consumeEach(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final <E> Object consumeEach$$forInline(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Unit> function1, Continuation<? super Unit> continuation) {
        try {
            ChannelIterator<? extends E> it = receiveChannel.iterator();
            while (true) {
                InlineMarker.mark(3);
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(null);
                InlineMarker.mark(1);
                if (!((Boolean) hasNext).booleanValue()) {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, null);
                    InlineMarker.finallyEnd(1);
                    return Unit.INSTANCE;
                }
                Object e = it.next();
                function1.invoke(e);
            }
        } finally {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0096 A[Catch: all -> 0x00b8, TryCatch #3 {all -> 0x00b8, blocks: (B:16:0x008e, B:18:0x0096, B:24:0x00aa), top: B:15:0x008e }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0081 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00aa A[Catch: all -> 0x00b8, TRY_LEAVE, TryCatch #3 {all -> 0x00b8, blocks: (B:16:0x008e, B:18:0x0096, B:24:0x00aa), top: B:15:0x008e }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0082 -> B:15:0x008e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <E> java.lang.Object toList(kotlinx.coroutines.channels.ReceiveChannel<? extends E> r14, kotlin.coroutines.Continuation<? super java.util.List<? extends E>> r15) {
        /*
            Method dump skipped, instructions count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.toList(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0080 A[Catch: all -> 0x009e, TryCatch #2 {all -> 0x009e, blocks: (B:16:0x0078, B:18:0x0080, B:24:0x008e), top: B:15:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008e A[Catch: all -> 0x009e, TRY_LEAVE, TryCatch #2 {all -> 0x009e, blocks: (B:16:0x0078, B:18:0x0080, B:24:0x008e), top: B:15:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0070 -> B:15:0x0078). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <E> java.lang.Object consumeEach(kotlinx.coroutines.channels.BroadcastChannel<E> r10, kotlin.jvm.functions.Function1<? super E, kotlin.Unit> r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            Method dump skipped, instructions count: 186
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.consumeEach(kotlinx.coroutines.channels.BroadcastChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final <E> Object consumeEach$$forInline(BroadcastChannel<E> broadcastChannel, Function1<? super E, Unit> function1, Continuation<? super Unit> continuation) {
        ReceiveChannel channel$iv = broadcastChannel.openSubscription();
        try {
            ChannelIterator<E> it = channel$iv.iterator();
            while (true) {
                InlineMarker.mark(3);
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(null);
                InlineMarker.mark(1);
                if (!((Boolean) hasNext).booleanValue()) {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ReceiveChannel.DefaultImpls.cancel$default(channel$iv, (CancellationException) null, 1, (Object) null);
                    InlineMarker.finallyEnd(1);
                    return Unit.INSTANCE;
                }
                Object element = it.next();
                function1.invoke(element);
            }
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            ReceiveChannel.DefaultImpls.cancel$default(channel$iv, (CancellationException) null, 1, (Object) null);
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    public static final void cancelConsumed(ReceiveChannel<?> receiveChannel, Throwable cause) {
        if (cause != null) {
            r0 = cause instanceof CancellationException ? (CancellationException) cause : null;
            if (r0 == null) {
                r0 = ExceptionsKt.CancellationException("Channel was consumed, consumer had failed", cause);
            }
        }
        receiveChannel.cancel(r0);
    }
}
