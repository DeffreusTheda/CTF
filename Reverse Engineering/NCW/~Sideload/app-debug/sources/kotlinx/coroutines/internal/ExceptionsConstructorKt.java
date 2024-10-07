package kotlinx.coroutines.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;

/* compiled from: ExceptionsConstructor.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a2\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0002`\u0007\"\b\b\u0000\u0010\b*\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0002\u001a*\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u00072\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rH\u0002\u001a1\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0002`\u00072\u0014\b\u0004\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0082\b\u001a!\u0010\u0010\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u00062\u0006\u0010\u0011\u001a\u0002H\bH\u0000¢\u0006\u0002\u0010\u0012\u001a\u001b\u0010\u0013\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\n2\b\b\u0002\u0010\u0014\u001a\u00020\u0003H\u0082\u0010\u001a\u0018\u0010\u0015\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000*(\b\u0002\u0010\u0017\"\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¨\u0006\u0018"}, d2 = {"ctorCache", "Lkotlinx/coroutines/internal/CtorCache;", "throwableFields", "", "createConstructor", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/Ctor;", "E", "clz", "Ljava/lang/Class;", "createSafeConstructor", "constructor", "Ljava/lang/reflect/Constructor;", "safeCtor", "block", "tryCopyException", "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "fieldsCount", "accumulator", "fieldsCountOrDefault", "defaultValue", "Ctor", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ExceptionsConstructorKt {
    private static final CtorCache ctorCache;
    private static final int throwableFields = fieldsCountOrDefault(Throwable.class, -1);

    static {
        ClassValueCtorCache classValueCtorCache;
        try {
            classValueCtorCache = FastServiceLoaderKt.getANDROID_DETECTED() ? WeakMapCtorCache.INSTANCE : ClassValueCtorCache.INSTANCE;
        } catch (Throwable th) {
            classValueCtorCache = WeakMapCtorCache.INSTANCE;
        }
        ctorCache = classValueCtorCache;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E extends Throwable> E tryCopyException(E e) {
        Object m163constructorimpl;
        if (e instanceof CopyableThrowable) {
            try {
                Result.Companion companion = Result.INSTANCE;
                m163constructorimpl = Result.m163constructorimpl(((CopyableThrowable) e).createCopy());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                m163constructorimpl = Result.m163constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m169isFailureimpl(m163constructorimpl)) {
                m163constructorimpl = null;
            }
            return (E) m163constructorimpl;
        }
        return (E) ctorCache.get(e.getClass()).invoke(e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E extends Throwable> Function1<Throwable, Throwable> createConstructor(Class<E> cls) {
        Function1 nullResult = new Function1() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$nullResult$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Throwable it) {
                return null;
            }
        };
        if (throwableFields != fieldsCountOrDefault(cls, 0)) {
            return nullResult;
        }
        Object[] $this$sortedByDescending$iv = cls.getConstructors();
        List<Constructor> constructors = ArraysKt.sortedWith($this$sortedByDescending$iv, new Comparator() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Constructor it = (Constructor) t2;
                Constructor it2 = (Constructor) t;
                return ComparisonsKt.compareValues(Integer.valueOf(it.getParameterTypes().length), Integer.valueOf(it2.getParameterTypes().length));
            }
        });
        for (Constructor constructor : constructors) {
            Function1 result = createSafeConstructor(constructor);
            if (result != null) {
                return result;
            }
        }
        return nullResult;
    }

    private static final Function1<Throwable, Throwable> createSafeConstructor(final Constructor<?> constructor) {
        Class[] p = constructor.getParameterTypes();
        switch (p.length) {
            case 0:
                return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createSafeConstructor$$inlined$safeCtor$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Throwable invoke(Throwable e) {
                        Object m163constructorimpl;
                        Object newInstance;
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            newInstance = constructor.newInstance(new Object[0]);
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.INSTANCE;
                            m163constructorimpl = Result.m163constructorimpl(ResultKt.createFailure(th));
                        }
                        if (newInstance == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                        }
                        Throwable it = (Throwable) newInstance;
                        it.initCause(e);
                        m163constructorimpl = Result.m163constructorimpl(it);
                        if (Result.m169isFailureimpl(m163constructorimpl)) {
                            m163constructorimpl = null;
                        }
                        return (Throwable) m163constructorimpl;
                    }
                };
            case 1:
                Class cls = p[0];
                if (!Intrinsics.areEqual(cls, Throwable.class)) {
                    if (Intrinsics.areEqual(cls, String.class)) {
                        return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createSafeConstructor$$inlined$safeCtor$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Throwable invoke(Throwable e) {
                                Object m163constructorimpl;
                                Object newInstance;
                                try {
                                    Result.Companion companion = Result.INSTANCE;
                                    newInstance = constructor.newInstance(e.getMessage());
                                } catch (Throwable th) {
                                    Result.Companion companion2 = Result.INSTANCE;
                                    m163constructorimpl = Result.m163constructorimpl(ResultKt.createFailure(th));
                                }
                                if (newInstance == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                                }
                                Throwable it = (Throwable) newInstance;
                                it.initCause(e);
                                m163constructorimpl = Result.m163constructorimpl(it);
                                if (Result.m169isFailureimpl(m163constructorimpl)) {
                                    m163constructorimpl = null;
                                }
                                return (Throwable) m163constructorimpl;
                            }
                        };
                    }
                    return null;
                }
                return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createSafeConstructor$$inlined$safeCtor$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Throwable invoke(Throwable e) {
                        Object m163constructorimpl;
                        Object newInstance;
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            newInstance = constructor.newInstance(e);
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.INSTANCE;
                            m163constructorimpl = Result.m163constructorimpl(ResultKt.createFailure(th));
                        }
                        if (newInstance == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                        }
                        m163constructorimpl = Result.m163constructorimpl((Throwable) newInstance);
                        if (Result.m169isFailureimpl(m163constructorimpl)) {
                            m163constructorimpl = null;
                        }
                        return (Throwable) m163constructorimpl;
                    }
                };
            case 2:
                if (Intrinsics.areEqual(p[0], String.class) && Intrinsics.areEqual(p[1], Throwable.class)) {
                    return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createSafeConstructor$$inlined$safeCtor$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Throwable invoke(Throwable e) {
                            Object m163constructorimpl;
                            Object newInstance;
                            try {
                                Result.Companion companion = Result.INSTANCE;
                                newInstance = constructor.newInstance(e.getMessage(), e);
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.INSTANCE;
                                m163constructorimpl = Result.m163constructorimpl(ResultKt.createFailure(th));
                            }
                            if (newInstance == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                            }
                            m163constructorimpl = Result.m163constructorimpl((Throwable) newInstance);
                            if (Result.m169isFailureimpl(m163constructorimpl)) {
                                m163constructorimpl = null;
                            }
                            return (Throwable) m163constructorimpl;
                        }
                    };
                }
                return null;
            default:
                return null;
        }
    }

    private static final Function1<Throwable, Throwable> safeCtor(final Function1<? super Throwable, ? extends Throwable> function1) {
        return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$safeCtor$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Throwable invoke(Throwable e) {
                Object m163constructorimpl;
                Function1<Throwable, Throwable> function12 = function1;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    m163constructorimpl = Result.m163constructorimpl(function12.invoke(e));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m163constructorimpl = Result.m163constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m169isFailureimpl(m163constructorimpl)) {
                    m163constructorimpl = null;
                }
                return (Throwable) m163constructorimpl;
            }
        };
    }

    private static final int fieldsCountOrDefault(Class<?> cls, int defaultValue) {
        Object m163constructorimpl;
        JvmClassMappingKt.getKotlinClass(cls);
        try {
            Result.Companion companion = Result.INSTANCE;
            m163constructorimpl = Result.m163constructorimpl(Integer.valueOf(fieldsCount$default(cls, 0, 1, null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m163constructorimpl = Result.m163constructorimpl(ResultKt.createFailure(th));
        }
        Integer valueOf = Integer.valueOf(defaultValue);
        if (Result.m169isFailureimpl(m163constructorimpl)) {
            m163constructorimpl = valueOf;
        }
        return ((Number) m163constructorimpl).intValue();
    }

    private static final int fieldsCount(Class<?> cls, int accumulator) {
        Class<?> cls2 = cls;
        int totalFields = accumulator;
        do {
            int count$iv = 0;
            int length = cls2.getDeclaredFields().length;
            for (int i = 0; i < length; i++) {
                if (!Modifier.isStatic(r2[i].getModifiers())) {
                    count$iv++;
                }
            }
            int fieldsCount = count$iv;
            totalFields += fieldsCount;
            cls2 = cls2.getSuperclass();
        } while (cls2 != null);
        return totalFields;
    }

    static /* synthetic */ int fieldsCount$default(Class cls, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return fieldsCount(cls, i);
    }
}
