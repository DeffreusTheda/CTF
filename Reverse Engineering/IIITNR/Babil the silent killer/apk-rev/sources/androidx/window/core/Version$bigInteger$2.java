package androidx.window.core;

import j0.a;
import java.math.BigInteger;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
final class Version$bigInteger$2 extends j implements a<BigInteger> {
    final /* synthetic */ Version this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Version$bigInteger$2(Version version) {
        super(0);
        this.this$0 = version;
    }

    @Override // j0.a
    public final BigInteger invoke() {
        return BigInteger.valueOf(this.this$0.getMajor()).shiftLeft(32).or(BigInteger.valueOf(this.this$0.getMinor())).shiftLeft(32).or(BigInteger.valueOf(this.this$0.getPatch()));
    }
}
