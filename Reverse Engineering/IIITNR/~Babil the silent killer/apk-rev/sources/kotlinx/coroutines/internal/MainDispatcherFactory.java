package kotlinx.coroutines.internal;

import java.util.List;
import q0.t1;

/* loaded from: classes.dex */
public interface MainDispatcherFactory {
    t1 createDispatcher(List<? extends MainDispatcherFactory> list);

    int getLoadPriority();

    String hintOnError();
}
