package io.flutter.view;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.accessibility.AccessibilityRecord;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class AccessibilityViewEmbedder {
    private static final String TAG = "AccessibilityBridge";
    private int nextFlutterId;
    private final View rootAccessibilityView;
    private final m reflectionAccessors = new m();
    private final SparseArray<n> flutterIdToOrigin = new SparseArray<>();
    private final Map<n, Integer> originToFlutterId = new HashMap();
    private final Map<View, Rect> embeddedViewToDisplayBounds = new HashMap();

    public AccessibilityViewEmbedder(View view, int i2) {
        this.rootAccessibilityView = view;
        this.nextFlutterId = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0097 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void addChildrenToFlutterNode(android.view.accessibility.AccessibilityNodeInfo r10, android.view.View r11, android.view.accessibility.AccessibilityNodeInfo r12) {
        /*
            r9 = this;
            r0 = 1
            r1 = 0
            r2 = 0
        L3:
            int r3 = r10.getChildCount()
            if (r2 >= r3) goto L9a
            io.flutter.view.m r3 = r9.reflectionAccessors
            java.lang.reflect.Method r4 = r3.f857f
            r5 = 0
            java.lang.reflect.Field r6 = r3.f856e
            java.lang.reflect.Method r3 = r3.f855d
            if (r3 != 0) goto L19
            if (r6 == 0) goto L64
            if (r4 != 0) goto L19
            goto L64
        L19:
            java.lang.String r7 = "AccessibilityBridge"
            if (r3 == 0) goto L3d
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.reflect.InvocationTargetException -> L2d java.lang.IllegalAccessException -> L2f
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch: java.lang.reflect.InvocationTargetException -> L2d java.lang.IllegalAccessException -> L2f
            r6[r1] = r4     // Catch: java.lang.reflect.InvocationTargetException -> L2d java.lang.IllegalAccessException -> L2f
            java.lang.Object r3 = r3.invoke(r10, r6)     // Catch: java.lang.reflect.InvocationTargetException -> L2d java.lang.IllegalAccessException -> L2f
            java.lang.Long r3 = (java.lang.Long) r3     // Catch: java.lang.reflect.InvocationTargetException -> L2d java.lang.IllegalAccessException -> L2f
        L2b:
            r5 = r3
            goto L64
        L2d:
            r3 = move-exception
            goto L31
        L2f:
            r3 = move-exception
            goto L37
        L31:
            java.lang.String r4 = "The getChildId method threw an exception when invoked."
            android.util.Log.w(r7, r4, r3)
            goto L64
        L37:
            java.lang.String r4 = "Failed to access getChildId method."
            android.util.Log.w(r7, r4, r3)
            goto L64
        L3d:
            java.lang.Object r3 = r6.get(r10)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L53 java.lang.reflect.InvocationTargetException -> L55 java.lang.IllegalAccessException -> L57
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L53 java.lang.reflect.InvocationTargetException -> L55 java.lang.IllegalAccessException -> L57
            java.lang.Object[] r8 = new java.lang.Object[r0]     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L53 java.lang.reflect.InvocationTargetException -> L55 java.lang.IllegalAccessException -> L57
            r8[r1] = r6     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L53 java.lang.reflect.InvocationTargetException -> L55 java.lang.IllegalAccessException -> L57
            java.lang.Object r3 = r4.invoke(r3, r8)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L53 java.lang.reflect.InvocationTargetException -> L55 java.lang.IllegalAccessException -> L57
            java.lang.Long r3 = (java.lang.Long) r3     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L53 java.lang.reflect.InvocationTargetException -> L55 java.lang.IllegalAccessException -> L57
            r3.getClass()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L53 java.lang.reflect.InvocationTargetException -> L55 java.lang.IllegalAccessException -> L57
            goto L2b
        L53:
            r3 = move-exception
            goto L59
        L55:
            r3 = move-exception
            goto L59
        L57:
            r3 = move-exception
            goto L5f
        L59:
            java.lang.String r4 = "The longArrayGetIndex method threw an exception when invoked."
            android.util.Log.w(r7, r4, r3)
            goto L64
        L5f:
            java.lang.String r4 = "Failed to access longArrayGetIndex method or the childNodeId field."
            android.util.Log.w(r7, r4, r3)
        L64:
            if (r5 != 0) goto L67
            goto L97
        L67:
            long r3 = r5.longValue()
            r5 = 32
            long r3 = r3 >> r5
            int r4 = (int) r3
            io.flutter.view.n r3 = new io.flutter.view.n
            r3.<init>(r11, r4)
            java.util.Map<io.flutter.view.n, java.lang.Integer> r5 = r9.originToFlutterId
            boolean r5 = r5.containsKey(r3)
            if (r5 == 0) goto L89
            java.util.Map<io.flutter.view.n, java.lang.Integer> r4 = r9.originToFlutterId
            java.lang.Object r3 = r4.get(r3)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            goto L92
        L89:
            int r3 = r9.nextFlutterId
            int r5 = r3 + 1
            r9.nextFlutterId = r5
            r9.cacheVirtualIdMappings(r11, r4, r3)
        L92:
            android.view.View r4 = r9.rootAccessibilityView
            r12.addChild(r4, r3)
        L97:
            int r2 = r2 + r0
            goto L3
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.AccessibilityViewEmbedder.addChildrenToFlutterNode(android.view.accessibility.AccessibilityNodeInfo, android.view.View, android.view.accessibility.AccessibilityNodeInfo):void");
    }

    private void cacheVirtualIdMappings(View view, int i2, int i3) {
        n nVar = new n(view, i2);
        this.originToFlutterId.put(nVar, Integer.valueOf(i3));
        this.flutterIdToOrigin.put(i3, nVar);
    }

    private AccessibilityNodeInfo convertToFlutterNode(AccessibilityNodeInfo accessibilityNodeInfo, int i2, View view) {
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(this.rootAccessibilityView, i2);
        obtain.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
        obtain.setSource(this.rootAccessibilityView, i2);
        obtain.setClassName(accessibilityNodeInfo.getClassName());
        Rect rect = this.embeddedViewToDisplayBounds.get(view);
        copyAccessibilityFields(accessibilityNodeInfo, obtain);
        setFlutterNodesTranslateBounds(accessibilityNodeInfo, rect, obtain);
        addChildrenToFlutterNode(accessibilityNodeInfo, view, obtain);
        setFlutterNodeParent(accessibilityNodeInfo, view, obtain);
        return obtain;
    }

    private void copyAccessibilityFields(AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityNodeInfo accessibilityNodeInfo2) {
        List availableExtraData;
        CharSequence hintText;
        boolean isShowingHintText;
        int drawingOrder;
        boolean isImportantForAccessibility;
        boolean isContextClickable;
        accessibilityNodeInfo2.setAccessibilityFocused(accessibilityNodeInfo.isAccessibilityFocused());
        accessibilityNodeInfo2.setCheckable(accessibilityNodeInfo.isCheckable());
        accessibilityNodeInfo2.setChecked(accessibilityNodeInfo.isChecked());
        accessibilityNodeInfo2.setContentDescription(accessibilityNodeInfo.getContentDescription());
        accessibilityNodeInfo2.setEnabled(accessibilityNodeInfo.isEnabled());
        accessibilityNodeInfo2.setClickable(accessibilityNodeInfo.isClickable());
        accessibilityNodeInfo2.setFocusable(accessibilityNodeInfo.isFocusable());
        accessibilityNodeInfo2.setFocused(accessibilityNodeInfo.isFocused());
        accessibilityNodeInfo2.setLongClickable(accessibilityNodeInfo.isLongClickable());
        accessibilityNodeInfo2.setMovementGranularities(accessibilityNodeInfo.getMovementGranularities());
        accessibilityNodeInfo2.setPassword(accessibilityNodeInfo.isPassword());
        accessibilityNodeInfo2.setScrollable(accessibilityNodeInfo.isScrollable());
        accessibilityNodeInfo2.setSelected(accessibilityNodeInfo.isSelected());
        accessibilityNodeInfo2.setText(accessibilityNodeInfo.getText());
        accessibilityNodeInfo2.setVisibleToUser(accessibilityNodeInfo.isVisibleToUser());
        accessibilityNodeInfo2.setEditable(accessibilityNodeInfo.isEditable());
        accessibilityNodeInfo2.setCanOpenPopup(accessibilityNodeInfo.canOpenPopup());
        accessibilityNodeInfo2.setCollectionInfo(accessibilityNodeInfo.getCollectionInfo());
        accessibilityNodeInfo2.setCollectionItemInfo(accessibilityNodeInfo.getCollectionItemInfo());
        accessibilityNodeInfo2.setContentInvalid(accessibilityNodeInfo.isContentInvalid());
        accessibilityNodeInfo2.setDismissable(accessibilityNodeInfo.isDismissable());
        accessibilityNodeInfo2.setInputType(accessibilityNodeInfo.getInputType());
        accessibilityNodeInfo2.setLiveRegion(accessibilityNodeInfo.getLiveRegion());
        accessibilityNodeInfo2.setMultiLine(accessibilityNodeInfo.isMultiLine());
        accessibilityNodeInfo2.setRangeInfo(accessibilityNodeInfo.getRangeInfo());
        accessibilityNodeInfo2.setError(accessibilityNodeInfo.getError());
        accessibilityNodeInfo2.setMaxTextLength(accessibilityNodeInfo.getMaxTextLength());
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            isContextClickable = accessibilityNodeInfo.isContextClickable();
            accessibilityNodeInfo2.setContextClickable(isContextClickable);
        }
        if (i2 >= 24) {
            drawingOrder = accessibilityNodeInfo.getDrawingOrder();
            accessibilityNodeInfo2.setDrawingOrder(drawingOrder);
            isImportantForAccessibility = accessibilityNodeInfo.isImportantForAccessibility();
            accessibilityNodeInfo2.setImportantForAccessibility(isImportantForAccessibility);
        }
        if (i2 >= 26) {
            availableExtraData = accessibilityNodeInfo.getAvailableExtraData();
            accessibilityNodeInfo2.setAvailableExtraData(availableExtraData);
            hintText = accessibilityNodeInfo.getHintText();
            accessibilityNodeInfo2.setHintText(hintText);
            isShowingHintText = accessibilityNodeInfo.isShowingHintText();
            accessibilityNodeInfo2.setShowingHintText(isShowingHintText);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0076 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setFlutterNodeParent(android.view.accessibility.AccessibilityNodeInfo r6, android.view.View r7, android.view.accessibility.AccessibilityNodeInfo r8) {
        /*
            r5 = this;
            io.flutter.view.m r0 = r5.reflectionAccessors
            java.lang.reflect.Method r0 = r0.f853b
            r1 = 0
            java.lang.String r2 = "AccessibilityBridge"
            if (r0 == 0) goto L22
            java.lang.Object r0 = r0.invoke(r6, r1)     // Catch: java.lang.reflect.InvocationTargetException -> L13 java.lang.IllegalAccessException -> L15
            java.lang.Long r0 = (java.lang.Long) r0     // Catch: java.lang.reflect.InvocationTargetException -> L13 java.lang.IllegalAccessException -> L15
            r0.getClass()     // Catch: java.lang.reflect.InvocationTargetException -> L13 java.lang.IllegalAccessException -> L15
            goto L74
        L13:
            r0 = move-exception
            goto L17
        L15:
            r0 = move-exception
            goto L1d
        L17:
            java.lang.String r3 = "The getParentNodeId method threw an exception when invoked."
            android.util.Log.w(r2, r3, r0)
            goto L22
        L1d:
            java.lang.String r3 = "Failed to access getParentNodeId method."
            android.util.Log.w(r2, r3, r0)
        L22:
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 26
            if (r0 >= r3) goto L2e
            java.lang.String r6 = "Unexpected Android version. Unable to find the parent ID."
            android.util.Log.w(r2, r6)
            goto L73
        L2e:
            android.view.accessibility.AccessibilityNodeInfo r6 = android.view.accessibility.AccessibilityNodeInfo.obtain(r6)
            android.os.Parcel r0 = android.os.Parcel.obtain()
            r2 = 0
            r0.setDataPosition(r2)
            r6.writeToParcel(r0, r2)
            r0.setDataPosition(r2)
            long r3 = r0.readLong()
            boolean r6 = io.flutter.view.m.b(r3, r2)
            if (r6 == 0) goto L4d
            r0.readInt()
        L4d:
            r6 = 1
            boolean r6 = io.flutter.view.m.b(r3, r6)
            if (r6 == 0) goto L57
            r0.readLong()
        L57:
            r6 = 2
            boolean r6 = io.flutter.view.m.b(r3, r6)
            if (r6 == 0) goto L61
            r0.readInt()
        L61:
            r6 = 3
            boolean r6 = io.flutter.view.m.b(r3, r6)
            if (r6 == 0) goto L70
            long r1 = r0.readLong()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
        L70:
            r0.recycle()
        L73:
            r0 = r1
        L74:
            if (r0 != 0) goto L77
            return
        L77:
            long r0 = r0.longValue()
            r6 = 32
            long r0 = r0 >> r6
            int r6 = (int) r0
            java.util.Map<io.flutter.view.n, java.lang.Integer> r0 = r5.originToFlutterId
            io.flutter.view.n r1 = new io.flutter.view.n
            r1.<init>(r7, r6)
            java.lang.Object r6 = r0.get(r1)
            java.lang.Integer r6 = (java.lang.Integer) r6
            if (r6 == 0) goto L97
            android.view.View r7 = r5.rootAccessibilityView
            int r6 = r6.intValue()
            r8.setParent(r7, r6)
        L97:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.AccessibilityViewEmbedder.setFlutterNodeParent(android.view.accessibility.AccessibilityNodeInfo, android.view.View, android.view.accessibility.AccessibilityNodeInfo):void");
    }

    private void setFlutterNodesTranslateBounds(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect, AccessibilityNodeInfo accessibilityNodeInfo2) {
        Rect rect2 = new Rect();
        accessibilityNodeInfo.getBoundsInParent(rect2);
        accessibilityNodeInfo2.setBoundsInParent(rect2);
        Rect rect3 = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect3);
        rect3.offset(rect.left, rect.top);
        accessibilityNodeInfo2.setBoundsInScreen(rect3);
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i2) {
        AccessibilityNodeInfo createAccessibilityNodeInfo;
        n nVar = this.flutterIdToOrigin.get(i2);
        if (nVar == null) {
            return null;
        }
        Map<View, Rect> map = this.embeddedViewToDisplayBounds;
        View view = nVar.f858a;
        if (!map.containsKey(view) || view.getAccessibilityNodeProvider() == null || (createAccessibilityNodeInfo = view.getAccessibilityNodeProvider().createAccessibilityNodeInfo(nVar.f859b)) == null) {
            return null;
        }
        return convertToFlutterNode(createAccessibilityNodeInfo, i2, view);
    }

    public Integer getRecordFlutterId(View view, AccessibilityRecord accessibilityRecord) {
        Long a2 = m.a(this.reflectionAccessors, accessibilityRecord);
        if (a2 == null) {
            return null;
        }
        return this.originToFlutterId.get(new n(view, (int) (a2.longValue() >> 32)));
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0028 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.accessibility.AccessibilityNodeInfo getRootNode(android.view.View r6, int r7, android.graphics.Rect r8) {
        /*
            r5 = this;
            android.view.accessibility.AccessibilityNodeInfo r0 = r6.createAccessibilityNodeInfo()
            io.flutter.view.m r1 = r5.reflectionAccessors
            java.lang.String r2 = "AccessibilityBridge"
            java.lang.reflect.Method r1 = r1.f852a
            r3 = 0
            if (r1 != 0) goto Lf
        Ld:
            r1 = r3
            goto L26
        Lf:
            java.lang.Object r1 = r1.invoke(r0, r3)     // Catch: java.lang.reflect.InvocationTargetException -> L16 java.lang.IllegalAccessException -> L18
            java.lang.Long r1 = (java.lang.Long) r1     // Catch: java.lang.reflect.InvocationTargetException -> L16 java.lang.IllegalAccessException -> L18
            goto L26
        L16:
            r1 = move-exception
            goto L1a
        L18:
            r1 = move-exception
            goto L20
        L1a:
            java.lang.String r4 = "The getSourceNodeId method threw an exception when invoked."
            android.util.Log.w(r2, r4, r1)
            goto Ld
        L20:
            java.lang.String r4 = "Failed to access getSourceNodeId method."
            android.util.Log.w(r2, r4, r1)
            goto Ld
        L26:
            if (r1 != 0) goto L29
            return r3
        L29:
            java.util.Map<android.view.View, android.graphics.Rect> r2 = r5.embeddedViewToDisplayBounds
            r2.put(r6, r8)
            long r1 = r1.longValue()
            r8 = 32
            long r1 = r1 >> r8
            int r8 = (int) r1
            r5.cacheVirtualIdMappings(r6, r8, r7)
            android.view.accessibility.AccessibilityNodeInfo r6 = r5.convertToFlutterNode(r0, r7, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.AccessibilityViewEmbedder.getRootNode(android.view.View, int, android.graphics.Rect):android.view.accessibility.AccessibilityNodeInfo");
    }

    public boolean onAccessibilityHoverEvent(int i2, MotionEvent motionEvent) {
        n nVar = this.flutterIdToOrigin.get(i2);
        if (nVar == null) {
            return false;
        }
        Map<View, Rect> map = this.embeddedViewToDisplayBounds;
        View view = nVar.f858a;
        Rect rect = map.get(view);
        int pointerCount = motionEvent.getPointerCount();
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        for (int i3 = 0; i3 < motionEvent.getPointerCount(); i3++) {
            MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
            pointerPropertiesArr[i3] = pointerProperties;
            motionEvent.getPointerProperties(i3, pointerProperties);
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            motionEvent.getPointerCoords(i3, pointerCoords);
            MotionEvent.PointerCoords pointerCoords2 = new MotionEvent.PointerCoords(pointerCoords);
            pointerCoordsArr[i3] = pointerCoords2;
            pointerCoords2.x -= rect.left;
            pointerCoords2.y -= rect.top;
        }
        return view.dispatchGenericMotionEvent(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getAction(), motionEvent.getPointerCount(), pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags()));
    }

    public boolean performAction(int i2, int i3, Bundle bundle) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        n nVar = this.flutterIdToOrigin.get(i2);
        if (nVar == null || (accessibilityNodeProvider = nVar.f858a.getAccessibilityNodeProvider()) == null) {
            return false;
        }
        return accessibilityNodeProvider.performAction(nVar.f859b, i3, bundle);
    }

    public View platformViewOfNode(int i2) {
        n nVar = this.flutterIdToOrigin.get(i2);
        if (nVar == null) {
            return null;
        }
        return nVar.f858a;
    }

    public boolean requestSendAccessibilityEvent(View view, View view2, AccessibilityEvent accessibilityEvent) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(accessibilityEvent);
        Long a2 = m.a(this.reflectionAccessors, accessibilityEvent);
        if (a2 == null) {
            return false;
        }
        int longValue = (int) (a2.longValue() >> 32);
        Integer num = this.originToFlutterId.get(new n(view, longValue));
        if (num == null) {
            int i2 = this.nextFlutterId;
            this.nextFlutterId = i2 + 1;
            Integer valueOf = Integer.valueOf(i2);
            cacheVirtualIdMappings(view, longValue, i2);
            num = valueOf;
        }
        obtain.setSource(this.rootAccessibilityView, num.intValue());
        obtain.setClassName(accessibilityEvent.getClassName());
        obtain.setPackageName(accessibilityEvent.getPackageName());
        for (int i3 = 0; i3 < obtain.getRecordCount(); i3++) {
            AccessibilityRecord record = obtain.getRecord(i3);
            Long a3 = m.a(this.reflectionAccessors, record);
            if (a3 == null) {
                return false;
            }
            n nVar = new n(view, (int) (a3.longValue() >> 32));
            if (!this.originToFlutterId.containsKey(nVar)) {
                return false;
            }
            record.setSource(this.rootAccessibilityView, this.originToFlutterId.get(nVar).intValue());
        }
        return this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(view2, obtain);
    }
}
