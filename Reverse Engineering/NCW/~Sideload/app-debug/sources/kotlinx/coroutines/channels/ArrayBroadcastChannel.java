package kotlinx.coroutines.channels;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.ConcurrentKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

/* compiled from: ArrayBroadcastChannel.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000L2\b\u0012\u0004\u0012\u00028\u00000M:\u0001JB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0017¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\t\u001a\u00020\r2\u000e\u0010\u0007\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fH\u0016¢\u0006\u0004\b\t\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\nJ\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00028\u00002\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0014¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0016¢\u0006\u0004\b\"\u0010#J4\u0010'\u001a\u00020\r2\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010$2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010$H\u0082\u0010¢\u0006\u0004\b'\u0010(R\u001c\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020,8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0018\u00102\u001a\u000600j\u0002`18\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00104\u001a\u0004\b5\u00106R$\u0010;\u001a\u00020\u00132\u0006\u00107\u001a\u00020\u00138B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b8\u0010\u0015\"\u0004\b9\u0010:R\u0014\u0010<\u001a\u00020\b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0014\u0010>\u001a\u00020\b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b>\u0010=R$\u0010A\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u00028B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b?\u00106\"\u0004\b@\u0010\u0005R6\u0010D\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000$0Bj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000$`C8\u0002X\u0082\u0004¢\u0006\f\n\u0004\bD\u0010E\u0012\u0004\bF\u0010\u0011R$\u0010I\u001a\u00020\u00132\u0006\u00107\u001a\u00020\u00138B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bG\u0010\u0015\"\u0004\bH\u0010:¨\u0006K"}, d2 = {"Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "E", "", "capacity", "<init>", "(I)V", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "(Ljava/util/concurrent/CancellationException;)V", "cancelInternal", "checkSubOffers", "()V", "close", "", "computeMinHead", "()J", "index", "elementAt", "(J)Ljava/lang/Object;", "element", "", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;", "addSub", "removeSub", "updateHead", "(Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;)V", "", "buffer", "[Ljava/lang/Object;", "", "getBufferDebugString", "()Ljava/lang/String;", "bufferDebugString", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "bufferLock", "Ljava/util/concurrent/locks/ReentrantLock;", "I", "getCapacity", "()I", "value", "getHead", "setHead", "(J)V", "head", "isBufferAlwaysFull", "()Z", "isBufferFull", "getSize", "setSize", "size", "", "Lkotlinx/coroutines/internal/SubscribersList;", "subscribers", "Ljava/util/List;", "getSubscribers$annotations", "getTail", "setTail", "tail", "Subscriber", "kotlinx-coroutines-core", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/BroadcastChannel;"}, k = 1, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ArrayBroadcastChannel<E> extends AbstractSendChannel<E> implements BroadcastChannel<E> {
    private volatile /* synthetic */ long _head;
    private volatile /* synthetic */ int _size;
    private volatile /* synthetic */ long _tail;
    private final Object[] buffer;
    private final ReentrantLock bufferLock;
    private final int capacity;
    private final List<Subscriber<E>> subscribers;

    private static /* synthetic */ void getSubscribers$annotations() {
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public ArrayBroadcastChannel(int capacity) {
        super(null);
        this.capacity = capacity;
        if (!(capacity >= 1)) {
            throw new IllegalArgumentException(("ArrayBroadcastChannel capacity must be at least 1, but " + capacity + " was specified").toString());
        }
        this.bufferLock = new ReentrantLock();
        this.buffer = new Object[capacity];
        this._head = 0L;
        this._tail = 0L;
        this._size = 0;
        this.subscribers = ConcurrentKt.subscriberList();
    }

    /* renamed from: getHead, reason: from getter */
    private final long get_head() {
        return this._head;
    }

    private final void setHead(long value) {
        this._head = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getTail, reason: from getter */
    public final long get_tail() {
        return this._tail;
    }

    private final void setTail(long value) {
        this._tail = value;
    }

    /* renamed from: getSize, reason: from getter */
    private final int get_size() {
        return this._size;
    }

    private final void setSize(int value) {
        this._size = value;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected boolean isBufferAlwaysFull() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected boolean isBufferFull() {
        return get_size() >= this.capacity;
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public ReceiveChannel<E> openSubscription() {
        Subscriber it = new Subscriber(this);
        updateHead$default(this, it, null, 2, null);
        return it;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel, kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable cause) {
        if (!super.close(cause)) {
            return false;
        }
        checkSubOffers();
        return true;
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public void cancel(CancellationException cause) {
        cancel(cause);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // kotlinx.coroutines.channels.BroadcastChannel
    /* renamed from: cancelInternal, reason: merged with bridge method [inline-methods] */
    public final boolean cancel(Throwable cause) {
        boolean close = close(cause);
        for (Subscriber sub : this.subscribers) {
            sub.cancel(cause);
        }
        return close;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected Object offerInternal(E element) {
        ReentrantLock $this$withLock$iv = this.bufferLock;
        ReentrantLock reentrantLock = $this$withLock$iv;
        reentrantLock.lock();
        try {
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            int size = get_size();
            if (size >= this.capacity) {
                return AbstractChannelKt.OFFER_FAILED;
            }
            long tail = get_tail();
            this.buffer[(int) (tail % this.capacity)] = element;
            setSize(size + 1);
            setTail(1 + tail);
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            checkSubOffers();
            return AbstractChannelKt.OFFER_SUCCESS;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected Object offerSelectInternal(E element, SelectInstance<?> select) {
        ReentrantLock $this$withLock$iv = this.bufferLock;
        ReentrantLock reentrantLock = $this$withLock$iv;
        reentrantLock.lock();
        try {
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            int size = get_size();
            if (size >= this.capacity) {
                return AbstractChannelKt.OFFER_FAILED;
            }
            if (!select.trySelect()) {
                return SelectKt.getALREADY_SELECTED();
            }
            long tail = get_tail();
            this.buffer[(int) (tail % this.capacity)] = element;
            setSize(size + 1);
            setTail(1 + tail);
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            checkSubOffers();
            return AbstractChannelKt.OFFER_SUCCESS;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void checkSubOffers() {
        boolean updated = false;
        boolean hasSubs = false;
        for (Subscriber sub : this.subscribers) {
            hasSubs = true;
            if (sub.checkOffer()) {
                updated = true;
            }
        }
        if (updated || !hasSubs) {
            updateHead$default(this, null, null, 3, null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b0, code lost:
    
        if (kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED() == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b6, code lost:
    
        if (r4 != kotlinx.coroutines.CancellableContinuationImplKt.RESUME_TOKEN) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b8, code lost:
    
        r21 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00bd, code lost:
    
        if (r21 == false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c5, code lost:
    
        throw new java.lang.AssertionError();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00bb, code lost:
    
        r21 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00c6, code lost:
    
        r23.buffer[(int) (r10 % r23.capacity)] = r21.getElement();
        setSize(r0 + 1);
        setTail(r10 + 1);
        r0 = kotlin.Unit.INSTANCE;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void updateHead(kotlinx.coroutines.channels.ArrayBroadcastChannel.Subscriber<E> r24, kotlinx.coroutines.channels.ArrayBroadcastChannel.Subscriber<E> r25) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ArrayBroadcastChannel.updateHead(kotlinx.coroutines.channels.ArrayBroadcastChannel$Subscriber, kotlinx.coroutines.channels.ArrayBroadcastChannel$Subscriber):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void updateHead$default(ArrayBroadcastChannel arrayBroadcastChannel, Subscriber subscriber, Subscriber subscriber2, int i, Object obj) {
        if ((i & 1) != 0) {
            subscriber = null;
        }
        if ((i & 2) != 0) {
            subscriber2 = null;
        }
        arrayBroadcastChannel.updateHead(subscriber, subscriber2);
    }

    private final long computeMinHead() {
        long minHead = Long.MAX_VALUE;
        for (Subscriber sub : this.subscribers) {
            minHead = RangesKt.coerceAtMost(minHead, sub.get_subHead());
        }
        return minHead;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final E elementAt(long index) {
        return (E) this.buffer[(int) (index % this.capacity)];
    }

    /* compiled from: ArrayBroadcastChannel.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010'2\b\u0012\u0004\u0012\u00028\u00010(B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\bJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0011\u0010\u0010J\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\bR\u0014\u0010\u0018\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\bR\u0014\u0010\u0019\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\bR\u0014\u0010\u001a\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\bR$\u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u00060\"j\u0002`#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;", "E", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "broadcastChannel", "<init>", "(Lkotlinx/coroutines/channels/ArrayBroadcastChannel;)V", "", "checkOffer", "()Z", "", "cause", "close", "(Ljava/lang/Throwable;)Z", "needsToCheckOfferWithoutLock", "", "peekUnderLock", "()Ljava/lang/Object;", "pollInternal", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "pollSelectInternal", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "isBufferAlwaysEmpty", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "", "value", "getSubHead", "()J", "setSubHead", "(J)V", "subHead", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "subLock", "Ljava/util/concurrent/locks/ReentrantLock;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/channels/AbstractChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;"}, k = 1, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private static final class Subscriber<E> extends AbstractChannel<E> implements ReceiveChannel<E> {
        private volatile /* synthetic */ long _subHead;
        private final ArrayBroadcastChannel<E> broadcastChannel;
        private final ReentrantLock subLock;

        public Subscriber(ArrayBroadcastChannel<E> arrayBroadcastChannel) {
            super(null);
            this.broadcastChannel = arrayBroadcastChannel;
            this.subLock = new ReentrantLock();
            this._subHead = 0L;
        }

        /* renamed from: getSubHead, reason: from getter */
        public final long get_subHead() {
            return this._subHead;
        }

        public final void setSubHead(long value) {
            this._subHead = value;
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        protected boolean isBufferAlwaysEmpty() {
            return false;
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        protected boolean isBufferEmpty() {
            return get_subHead() >= this.broadcastChannel.get_tail();
        }

        @Override // kotlinx.coroutines.channels.AbstractSendChannel
        protected boolean isBufferAlwaysFull() {
            throw new IllegalStateException("Should not be used".toString());
        }

        @Override // kotlinx.coroutines.channels.AbstractSendChannel
        protected boolean isBufferFull() {
            throw new IllegalStateException("Should not be used".toString());
        }

        @Override // kotlinx.coroutines.channels.AbstractSendChannel, kotlinx.coroutines.channels.SendChannel
        public boolean close(Throwable cause) {
            boolean wasClosed = super.close(cause);
            if (wasClosed) {
                ArrayBroadcastChannel.updateHead$default(this.broadcastChannel, null, this, 1, null);
                ReentrantLock $this$withLock$iv = this.subLock;
                ReentrantLock reentrantLock = $this$withLock$iv;
                reentrantLock.lock();
                try {
                    setSubHead(this.broadcastChannel.get_tail());
                    Unit unit = Unit.INSTANCE;
                } finally {
                    reentrantLock.unlock();
                }
            }
            return wasClosed;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final boolean checkOffer() {
            boolean z = false;
            Closed closed = null;
            while (needsToCheckOfferWithoutLock() && this.subLock.tryLock()) {
                try {
                    Object peekUnderLock = peekUnderLock();
                    if (peekUnderLock != AbstractChannelKt.POLL_FAILED) {
                        if (peekUnderLock instanceof Closed) {
                            closed = (Closed) peekUnderLock;
                        } else {
                            ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
                            if (takeFirstReceiveOrPeekClosed != 0 && !(takeFirstReceiveOrPeekClosed instanceof Closed)) {
                                Symbol tryResumeReceive = takeFirstReceiveOrPeekClosed.tryResumeReceive(peekUnderLock, null);
                                if (tryResumeReceive != null) {
                                    if (DebugKt.getASSERTIONS_ENABLED()) {
                                        if (!(tryResumeReceive == CancellableContinuationImplKt.RESUME_TOKEN)) {
                                            throw new AssertionError();
                                        }
                                    }
                                    setSubHead(1 + get_subHead());
                                    z = true;
                                    this.subLock.unlock();
                                    takeFirstReceiveOrPeekClosed.completeResumeReceive(peekUnderLock);
                                }
                            }
                        }
                        break;
                    }
                } finally {
                    this.subLock.unlock();
                }
            }
            if (closed != null) {
                close(closed.closeCause);
            }
            return z;
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        protected Object pollInternal() {
            boolean updated = false;
            ReentrantLock $this$withLock$iv = this.subLock;
            ReentrantLock reentrantLock = $this$withLock$iv;
            reentrantLock.lock();
            try {
                Object result = peekUnderLock();
                if (!(result instanceof Closed) && result != AbstractChannelKt.POLL_FAILED) {
                    long subHead = get_subHead();
                    setSubHead(1 + subHead);
                    updated = true;
                }
                reentrantLock.unlock();
                Closed it = result instanceof Closed ? (Closed) result : null;
                if (it != null) {
                    close(it.closeCause);
                }
                if (checkOffer()) {
                    updated = true;
                }
                if (updated) {
                    ArrayBroadcastChannel.updateHead$default(this.broadcastChannel, null, null, 3, null);
                }
                return result;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        protected Object pollSelectInternal(SelectInstance<?> select) {
            boolean updated = false;
            ReentrantLock $this$withLock$iv = this.subLock;
            ReentrantLock reentrantLock = $this$withLock$iv;
            reentrantLock.lock();
            try {
                Object result = peekUnderLock();
                if (!(result instanceof Closed) && result != AbstractChannelKt.POLL_FAILED) {
                    if (!select.trySelect()) {
                        result = SelectKt.getALREADY_SELECTED();
                    } else {
                        long subHead = get_subHead();
                        setSubHead(1 + subHead);
                        updated = true;
                    }
                }
                reentrantLock.unlock();
                Object result2 = result;
                Closed it = result2 instanceof Closed ? (Closed) result2 : null;
                if (it != null) {
                    close(it.closeCause);
                }
                if (checkOffer()) {
                    updated = true;
                }
                if (updated) {
                    ArrayBroadcastChannel.updateHead$default(this.broadcastChannel, null, null, 3, null);
                }
                return result2;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        private final boolean needsToCheckOfferWithoutLock() {
            if (getClosedForReceive() != null) {
                return false;
            }
            return (isBufferEmpty() && this.broadcastChannel.getClosedForReceive() == null) ? false : true;
        }

        private final Object peekUnderLock() {
            long subHead = get_subHead();
            Closed closedBroadcast = this.broadcastChannel.getClosedForReceive();
            long tail = this.broadcastChannel.get_tail();
            if (subHead < tail) {
                Object result = this.broadcastChannel.elementAt(subHead);
                Closed closedSub = getClosedForReceive();
                return closedSub != null ? closedSub : result;
            }
            if (closedBroadcast != null) {
                return closedBroadcast;
            }
            Closed<?> closedForReceive = getClosedForReceive();
            return closedForReceive == null ? AbstractChannelKt.POLL_FAILED : closedForReceive;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected String getBufferDebugString() {
        return "(buffer:capacity=" + this.buffer.length + ",size=" + get_size() + ')';
    }
}
