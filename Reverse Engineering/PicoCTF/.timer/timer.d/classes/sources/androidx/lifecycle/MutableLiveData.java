package androidx.lifecycle;

/* loaded from: /home/vinnie/CTF/Reverse Engineering/PicoCTF/timer/timer.d/classes.dex */
public class MutableLiveData<T> extends LiveData<T> {
    public MutableLiveData(T value) {
        super(value);
    }

    public MutableLiveData() {
    }

    @Override // androidx.lifecycle.LiveData
    public void postValue(T value) {
        super.postValue(value);
    }

    @Override // androidx.lifecycle.LiveData
    public void setValue(T value) {
        super.setValue(value);
    }
}
