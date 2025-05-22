package androidx.compose.foundation.text;

import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;

/* compiled from: KeyMapping.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u001f\u0010\u0004\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0000ø\u0001\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"defaultKeyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "getDefaultKeyMapping", "()Landroidx/compose/foundation/text/KeyMapping;", "commonKeyMapping", "shortcutModifier", "Lkotlin/Function1;", "Landroidx/compose/ui/input/key/KeyEvent;", "", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class KeyMappingKt {
    private static final KeyMapping defaultKeyMapping;

    public static final KeyMapping commonKeyMapping(final Function1<? super KeyEvent, Boolean> shortcutModifier) {
        Intrinsics.checkNotNullParameter(shortcutModifier, "shortcutModifier");
        return new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$commonKeyMapping$1
            @Override // androidx.compose.foundation.text.KeyMapping
            /* renamed from: map-ZmokQxo */
            public KeyCommand mo807mapZmokQxo(android.view.KeyEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (shortcutModifier.invoke(KeyEvent.m3693boximpl(event)).booleanValue() && KeyEvent_androidKt.m3716isShiftPressedZmokQxo(event)) {
                    if (Key.m3402equalsimpl0(KeyEvent_androidKt.m3710getKeyZmokQxo(event), MappedKeys.INSTANCE.m842getZEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    return null;
                }
                if (shortcutModifier.invoke(KeyEvent.m3693boximpl(event)).booleanValue()) {
                    long m3710getKeyZmokQxo = KeyEvent_androidKt.m3710getKeyZmokQxo(event);
                    if (Key.m3402equalsimpl0(m3710getKeyZmokQxo, MappedKeys.INSTANCE.m822getCEK5gGoQ()) || Key.m3402equalsimpl0(m3710getKeyZmokQxo, MappedKeys.INSTANCE.m832getInsertEK5gGoQ())) {
                        return KeyCommand.COPY;
                    }
                    if (Key.m3402equalsimpl0(m3710getKeyZmokQxo, MappedKeys.INSTANCE.m839getVEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    if (Key.m3402equalsimpl0(m3710getKeyZmokQxo, MappedKeys.INSTANCE.m840getXEK5gGoQ())) {
                        return KeyCommand.CUT;
                    }
                    if (Key.m3402equalsimpl0(m3710getKeyZmokQxo, MappedKeys.INSTANCE.m819getAEK5gGoQ())) {
                        return KeyCommand.SELECT_ALL;
                    }
                    if (Key.m3402equalsimpl0(m3710getKeyZmokQxo, MappedKeys.INSTANCE.m841getYEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    if (Key.m3402equalsimpl0(m3710getKeyZmokQxo, MappedKeys.INSTANCE.m842getZEK5gGoQ())) {
                        return KeyCommand.UNDO;
                    }
                    return null;
                }
                if (KeyEvent_androidKt.m3714isCtrlPressedZmokQxo(event)) {
                    return null;
                }
                if (KeyEvent_androidKt.m3716isShiftPressedZmokQxo(event)) {
                    long m3710getKeyZmokQxo2 = KeyEvent_androidKt.m3710getKeyZmokQxo(event);
                    if (Key.m3402equalsimpl0(m3710getKeyZmokQxo2, MappedKeys.INSTANCE.m827getDirectionLeftEK5gGoQ())) {
                        return KeyCommand.SELECT_LEFT_CHAR;
                    }
                    if (Key.m3402equalsimpl0(m3710getKeyZmokQxo2, MappedKeys.INSTANCE.m828getDirectionRightEK5gGoQ())) {
                        return KeyCommand.SELECT_RIGHT_CHAR;
                    }
                    if (Key.m3402equalsimpl0(m3710getKeyZmokQxo2, MappedKeys.INSTANCE.m829getDirectionUpEK5gGoQ())) {
                        return KeyCommand.SELECT_UP;
                    }
                    if (Key.m3402equalsimpl0(m3710getKeyZmokQxo2, MappedKeys.INSTANCE.m826getDirectionDownEK5gGoQ())) {
                        return KeyCommand.SELECT_DOWN;
                    }
                    if (Key.m3402equalsimpl0(m3710getKeyZmokQxo2, MappedKeys.INSTANCE.m836getPageUpEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_UP;
                    }
                    if (Key.m3402equalsimpl0(m3710getKeyZmokQxo2, MappedKeys.INSTANCE.m835getPageDownEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_DOWN;
                    }
                    if (Key.m3402equalsimpl0(m3710getKeyZmokQxo2, MappedKeys.INSTANCE.m834getMoveHomeEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_START;
                    }
                    if (Key.m3402equalsimpl0(m3710getKeyZmokQxo2, MappedKeys.INSTANCE.m833getMoveEndEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_END;
                    }
                    if (Key.m3402equalsimpl0(m3710getKeyZmokQxo2, MappedKeys.INSTANCE.m832getInsertEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    return null;
                }
                long m3710getKeyZmokQxo3 = KeyEvent_androidKt.m3710getKeyZmokQxo(event);
                if (Key.m3402equalsimpl0(m3710getKeyZmokQxo3, MappedKeys.INSTANCE.m827getDirectionLeftEK5gGoQ())) {
                    return KeyCommand.LEFT_CHAR;
                }
                if (Key.m3402equalsimpl0(m3710getKeyZmokQxo3, MappedKeys.INSTANCE.m828getDirectionRightEK5gGoQ())) {
                    return KeyCommand.RIGHT_CHAR;
                }
                if (Key.m3402equalsimpl0(m3710getKeyZmokQxo3, MappedKeys.INSTANCE.m829getDirectionUpEK5gGoQ())) {
                    return KeyCommand.UP;
                }
                if (Key.m3402equalsimpl0(m3710getKeyZmokQxo3, MappedKeys.INSTANCE.m826getDirectionDownEK5gGoQ())) {
                    return KeyCommand.DOWN;
                }
                if (Key.m3402equalsimpl0(m3710getKeyZmokQxo3, MappedKeys.INSTANCE.m836getPageUpEK5gGoQ())) {
                    return KeyCommand.PAGE_UP;
                }
                if (Key.m3402equalsimpl0(m3710getKeyZmokQxo3, MappedKeys.INSTANCE.m835getPageDownEK5gGoQ())) {
                    return KeyCommand.PAGE_DOWN;
                }
                if (Key.m3402equalsimpl0(m3710getKeyZmokQxo3, MappedKeys.INSTANCE.m834getMoveHomeEK5gGoQ())) {
                    return KeyCommand.LINE_START;
                }
                if (Key.m3402equalsimpl0(m3710getKeyZmokQxo3, MappedKeys.INSTANCE.m833getMoveEndEK5gGoQ())) {
                    return KeyCommand.LINE_END;
                }
                if (Key.m3402equalsimpl0(m3710getKeyZmokQxo3, MappedKeys.INSTANCE.m830getEnterEK5gGoQ())) {
                    return KeyCommand.NEW_LINE;
                }
                if (Key.m3402equalsimpl0(m3710getKeyZmokQxo3, MappedKeys.INSTANCE.m821getBackspaceEK5gGoQ())) {
                    return KeyCommand.DELETE_PREV_CHAR;
                }
                if (Key.m3402equalsimpl0(m3710getKeyZmokQxo3, MappedKeys.INSTANCE.m825getDeleteEK5gGoQ())) {
                    return KeyCommand.DELETE_NEXT_CHAR;
                }
                if (Key.m3402equalsimpl0(m3710getKeyZmokQxo3, MappedKeys.INSTANCE.m837getPasteEK5gGoQ())) {
                    return KeyCommand.PASTE;
                }
                if (Key.m3402equalsimpl0(m3710getKeyZmokQxo3, MappedKeys.INSTANCE.m824getCutEK5gGoQ())) {
                    return KeyCommand.CUT;
                }
                if (Key.m3402equalsimpl0(m3710getKeyZmokQxo3, MappedKeys.INSTANCE.m823getCopyEK5gGoQ())) {
                    return KeyCommand.COPY;
                }
                if (Key.m3402equalsimpl0(m3710getKeyZmokQxo3, MappedKeys.INSTANCE.m838getTabEK5gGoQ())) {
                    return KeyCommand.TAB;
                }
                return null;
            }
        };
    }

    public static final KeyMapping getDefaultKeyMapping() {
        return defaultKeyMapping;
    }

    static {
        final KeyMapping commonKeyMapping = commonKeyMapping(new PropertyReference1Impl() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Boolean.valueOf(KeyEvent_androidKt.m3714isCtrlPressedZmokQxo(((KeyEvent) obj).m3699unboximpl()));
            }
        });
        defaultKeyMapping = new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$2$1
            @Override // androidx.compose.foundation.text.KeyMapping
            /* renamed from: map-ZmokQxo */
            public KeyCommand mo807mapZmokQxo(android.view.KeyEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                KeyCommand keyCommand = null;
                if (KeyEvent_androidKt.m3716isShiftPressedZmokQxo(event) && KeyEvent_androidKt.m3714isCtrlPressedZmokQxo(event)) {
                    long m3710getKeyZmokQxo = KeyEvent_androidKt.m3710getKeyZmokQxo(event);
                    if (Key.m3402equalsimpl0(m3710getKeyZmokQxo, MappedKeys.INSTANCE.m827getDirectionLeftEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LEFT_WORD;
                    } else if (Key.m3402equalsimpl0(m3710getKeyZmokQxo, MappedKeys.INSTANCE.m828getDirectionRightEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_RIGHT_WORD;
                    } else if (Key.m3402equalsimpl0(m3710getKeyZmokQxo, MappedKeys.INSTANCE.m829getDirectionUpEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_PREV_PARAGRAPH;
                    } else if (Key.m3402equalsimpl0(m3710getKeyZmokQxo, MappedKeys.INSTANCE.m826getDirectionDownEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_NEXT_PARAGRAPH;
                    }
                } else if (KeyEvent_androidKt.m3714isCtrlPressedZmokQxo(event)) {
                    long m3710getKeyZmokQxo2 = KeyEvent_androidKt.m3710getKeyZmokQxo(event);
                    if (Key.m3402equalsimpl0(m3710getKeyZmokQxo2, MappedKeys.INSTANCE.m827getDirectionLeftEK5gGoQ())) {
                        keyCommand = KeyCommand.LEFT_WORD;
                    } else if (Key.m3402equalsimpl0(m3710getKeyZmokQxo2, MappedKeys.INSTANCE.m828getDirectionRightEK5gGoQ())) {
                        keyCommand = KeyCommand.RIGHT_WORD;
                    } else if (Key.m3402equalsimpl0(m3710getKeyZmokQxo2, MappedKeys.INSTANCE.m829getDirectionUpEK5gGoQ())) {
                        keyCommand = KeyCommand.PREV_PARAGRAPH;
                    } else if (Key.m3402equalsimpl0(m3710getKeyZmokQxo2, MappedKeys.INSTANCE.m826getDirectionDownEK5gGoQ())) {
                        keyCommand = KeyCommand.NEXT_PARAGRAPH;
                    } else if (Key.m3402equalsimpl0(m3710getKeyZmokQxo2, MappedKeys.INSTANCE.m831getHEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_PREV_CHAR;
                    } else if (Key.m3402equalsimpl0(m3710getKeyZmokQxo2, MappedKeys.INSTANCE.m825getDeleteEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_NEXT_WORD;
                    } else if (Key.m3402equalsimpl0(m3710getKeyZmokQxo2, MappedKeys.INSTANCE.m821getBackspaceEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_PREV_WORD;
                    } else if (Key.m3402equalsimpl0(m3710getKeyZmokQxo2, MappedKeys.INSTANCE.m820getBackslashEK5gGoQ())) {
                        keyCommand = KeyCommand.DESELECT;
                    }
                } else if (KeyEvent_androidKt.m3716isShiftPressedZmokQxo(event)) {
                    long m3710getKeyZmokQxo3 = KeyEvent_androidKt.m3710getKeyZmokQxo(event);
                    if (Key.m3402equalsimpl0(m3710getKeyZmokQxo3, MappedKeys.INSTANCE.m834getMoveHomeEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LINE_LEFT;
                    } else if (Key.m3402equalsimpl0(m3710getKeyZmokQxo3, MappedKeys.INSTANCE.m833getMoveEndEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LINE_RIGHT;
                    }
                } else if (KeyEvent_androidKt.m3713isAltPressedZmokQxo(event)) {
                    long m3710getKeyZmokQxo4 = KeyEvent_androidKt.m3710getKeyZmokQxo(event);
                    if (Key.m3402equalsimpl0(m3710getKeyZmokQxo4, MappedKeys.INSTANCE.m821getBackspaceEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_FROM_LINE_START;
                    } else if (Key.m3402equalsimpl0(m3710getKeyZmokQxo4, MappedKeys.INSTANCE.m825getDeleteEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_TO_LINE_END;
                    }
                }
                return keyCommand == null ? KeyMapping.this.mo807mapZmokQxo(event) : keyCommand;
            }
        };
    }
}
