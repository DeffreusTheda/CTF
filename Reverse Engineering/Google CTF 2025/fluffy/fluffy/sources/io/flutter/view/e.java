package io.flutter.view;

/* loaded from: classes.dex */
public enum e {
    TAP(1),
    LONG_PRESS(2),
    SCROLL_LEFT(4),
    SCROLL_RIGHT(8),
    SCROLL_UP(16),
    SCROLL_DOWN(32),
    INCREASE(64),
    DECREASE(128),
    SHOW_ON_SCREEN(256),
    MOVE_CURSOR_FORWARD_BY_CHARACTER(512),
    MOVE_CURSOR_BACKWARD_BY_CHARACTER(1024),
    SET_SELECTION(2048),
    COPY(4096),
    CUT(8192),
    PASTE(16384),
    DID_GAIN_ACCESSIBILITY_FOCUS(32768),
    DID_LOSE_ACCESSIBILITY_FOCUS(65536),
    CUSTOM_ACTION(131072),
    DISMISS(262144),
    MOVE_CURSOR_FORWARD_BY_WORD(524288),
    MOVE_CURSOR_BACKWARD_BY_WORD(1048576),
    SET_TEXT(2097152),
    /* JADX INFO: Fake field, exist only in values array */
    FOCUS(4194304),
    /* JADX INFO: Fake field, exist only in values array */
    SCROLL_TO_OFFSET(8388608);


    /* renamed from: b, reason: collision with root package name */
    public final int f772b;

    e(int i2) {
        this.f772b = i2;
    }
}
