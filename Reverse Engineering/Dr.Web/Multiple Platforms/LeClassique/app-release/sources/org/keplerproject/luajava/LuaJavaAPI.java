package org.keplerproject.luajava;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* loaded from: classes.dex */
public final class LuaJavaAPI {
    private LuaJavaAPI() {
    }

    public static int objectIndex(int i, Object obj, String str) throws LuaException {
        Class<?> cls;
        Method method;
        Object invoke;
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            int top = existingState.getTop() - 1;
            Object[] objArr = new Object[top];
            if (obj instanceof Class) {
                cls = (Class) obj;
            } else {
                cls = obj.getClass();
            }
            Method[] methods = cls.getMethods();
            int i2 = 0;
            loop0: while (true) {
                if (i2 >= methods.length) {
                    method = null;
                    break;
                }
                if (methods[i2].getName().equals(str)) {
                    Class<?>[] parameterTypes = methods[i2].getParameterTypes();
                    if (parameterTypes.length == top) {
                        for (int i3 = 0; i3 < parameterTypes.length; i3++) {
                            try {
                                objArr[i3] = compareTypes(existingState, parameterTypes[i3], i3 + 2);
                            } catch (Exception unused) {
                            }
                        }
                        method = methods[i2];
                        break loop0;
                    }
                }
                i2++;
            }
            if (method == null) {
                throw new LuaException("Invalid method call. No such method.");
            }
            try {
                if (Modifier.isPublic(method.getModifiers())) {
                    method.setAccessible(true);
                }
                if (obj instanceof Class) {
                    invoke = method.invoke(null, objArr);
                } else {
                    invoke = method.invoke(obj, objArr);
                }
                if (invoke == null) {
                    return 0;
                }
                existingState.pushObjectValue(invoke);
                return 1;
            } catch (Exception e) {
                throw new LuaException(e);
            }
        }
    }

    public static int classIndex(int i, Class cls, String str) throws LuaException {
        synchronized (LuaStateFactory.getExistingState(i)) {
            if (checkField(i, cls, str) != 0) {
                return 1;
            }
            return checkMethod(i, cls, str) != 0 ? 2 : 0;
        }
    }

    public static int javaNewInstance(int i, String str) throws LuaException {
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            try {
                try {
                    existingState.pushJavaObject(getObjInstance(existingState, Class.forName(str)));
                } catch (ClassNotFoundException e) {
                    throw new LuaException(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return 1;
    }

    public static int javaNew(int i, Class cls) throws LuaException {
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            existingState.pushJavaObject(getObjInstance(existingState, cls));
        }
        return 1;
    }

    public static int javaLoadLib(int i, String str, String str2) throws LuaException {
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            try {
                try {
                    try {
                        Object invoke = Class.forName(str).getMethod(str2, LuaState.class).invoke(null, existingState);
                        if (invoke == null || !(invoke instanceof Integer)) {
                            return 0;
                        }
                        return ((Integer) invoke).intValue();
                    } catch (Exception e) {
                        throw new LuaException("Error on calling method. Library could not be loaded. " + e.getMessage());
                    }
                } catch (ClassNotFoundException e2) {
                    throw new LuaException(e2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static Object getObjInstance(LuaState luaState, Class cls) throws LuaException {
        Constructor<?> constructor;
        Object newInstance;
        synchronized (luaState) {
            int top = luaState.getTop() - 1;
            Object[] objArr = new Object[top];
            Constructor<?>[] constructors = cls.getConstructors();
            int i = 0;
            loop0: while (true) {
                if (i >= constructors.length) {
                    constructor = null;
                    break;
                }
                Class<?>[] parameterTypes = constructors[i].getParameterTypes();
                if (parameterTypes.length == top) {
                    for (int i2 = 0; i2 < parameterTypes.length; i2++) {
                        try {
                            objArr[i2] = compareTypes(luaState, parameterTypes[i2], i2 + 2);
                        } catch (Exception unused) {
                        }
                    }
                    constructor = constructors[i];
                    break loop0;
                }
                i++;
            }
            if (constructor == null) {
                throw new LuaException("Invalid method call. No such method.");
            }
            try {
                newInstance = constructor.newInstance(objArr);
                if (newInstance == null) {
                    throw new LuaException("Couldn't instantiate java Object");
                }
            } catch (Exception e) {
                throw new LuaException(e);
            }
        }
        return newInstance;
    }

    public static int checkField(int i, Object obj, String str) throws LuaException {
        Class<?> cls;
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            if (obj instanceof Class) {
                cls = (Class) obj;
            } else {
                cls = obj.getClass();
            }
            try {
                Field field = cls.getField(str);
                if (field == null) {
                    return 0;
                }
                try {
                    Object obj2 = field.get(obj);
                    if (obj == null) {
                        return 0;
                    }
                    existingState.pushObjectValue(obj2);
                    return 1;
                } catch (Exception unused) {
                    return 0;
                }
            } catch (Exception unused2) {
                return 0;
            }
        }
    }

    public static int checkMethod(int i, Object obj, String str) {
        Class<?> cls;
        synchronized (LuaStateFactory.getExistingState(i)) {
            if (obj instanceof Class) {
                cls = (Class) obj;
            } else {
                cls = obj.getClass();
            }
            for (Method method : cls.getMethods()) {
                if (method.getName().equals(str)) {
                    return 1;
                }
            }
            return 0;
        }
    }

    public static int createProxyObject(int i, String str) throws LuaException {
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            try {
                if (!existingState.isTable(2)) {
                    throw new LuaException("Parameter is not a table. Can't create proxy.");
                }
                existingState.pushJavaObject(existingState.getLuaObject(2).createProxy(str));
            } catch (Exception e) {
                throw new LuaException(e);
            }
        }
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x007e, code lost:
    
        if (r6 == null) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.Object compareTypes(org.keplerproject.luajava.LuaState r5, java.lang.Class r6, int r7) throws org.keplerproject.luajava.LuaException {
        /*
            boolean r0 = r5.isBoolean(r7)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L28
            boolean r0 = r6.isPrimitive()
            if (r0 == 0) goto L13
            java.lang.Class r0 = java.lang.Boolean.TYPE
            if (r6 == r0) goto L1c
            goto L1d
        L13:
            java.lang.Class<java.lang.Boolean> r0 = java.lang.Boolean.class
            boolean r6 = r6.isAssignableFrom(r0)
            if (r6 != 0) goto L1c
            goto L1d
        L1c:
            r1 = r2
        L1d:
            java.lang.Boolean r6 = new java.lang.Boolean
            boolean r5 = r5.toBoolean(r7)
            r6.<init>(r5)
            goto Lb4
        L28:
            int r0 = r5.type(r7)
            r3 = 4
            r4 = 0
            if (r0 != r3) goto L42
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            boolean r6 = r6.isAssignableFrom(r0)
            if (r6 != 0) goto L3b
        L38:
            r6 = r4
            goto Lb4
        L3b:
            java.lang.String r6 = r5.toString(r7)
        L3f:
            r1 = r2
            goto Lb4
        L42:
            boolean r0 = r5.isFunction(r7)
            if (r0 == 0) goto L56
            java.lang.Class<org.keplerproject.luajava.LuaObject> r0 = org.keplerproject.luajava.LuaObject.class
            boolean r6 = r6.isAssignableFrom(r0)
            if (r6 != 0) goto L51
            goto L38
        L51:
            org.keplerproject.luajava.LuaObject r6 = r5.getLuaObject(r7)
            goto L3f
        L56:
            boolean r0 = r5.isTable(r7)
            if (r0 == 0) goto L6a
            java.lang.Class<org.keplerproject.luajava.LuaObject> r0 = org.keplerproject.luajava.LuaObject.class
            boolean r6 = r6.isAssignableFrom(r0)
            if (r6 != 0) goto L65
            goto L38
        L65:
            org.keplerproject.luajava.LuaObject r6 = r5.getLuaObject(r7)
            goto L3f
        L6a:
            int r0 = r5.type(r7)
            r3 = 3
            if (r0 != r3) goto L81
            java.lang.Double r0 = new java.lang.Double
            double r3 = r5.toNumber(r7)
            r0.<init>(r3)
            java.lang.Number r6 = org.keplerproject.luajava.LuaState.convertLuaNumber(r0, r6)
            if (r6 != 0) goto L3f
            goto Lb4
        L81:
            boolean r0 = r5.isUserdata(r7)
            if (r0 == 0) goto Lac
            boolean r0 = r5.isObject(r7)
            if (r0 == 0) goto L9e
            java.lang.Object r5 = r5.getObjectFromUserdata(r7)
            java.lang.Class r7 = r5.getClass()
            boolean r1 = r6.isAssignableFrom(r7)
            if (r1 != 0) goto L9c
            goto L38
        L9c:
            r6 = r5
            goto Lb4
        L9e:
            java.lang.Class<org.keplerproject.luajava.LuaObject> r0 = org.keplerproject.luajava.LuaObject.class
            boolean r6 = r6.isAssignableFrom(r0)
            if (r6 != 0) goto La7
            goto L38
        La7:
            org.keplerproject.luajava.LuaObject r6 = r5.getLuaObject(r7)
            goto L3f
        Lac:
            boolean r5 = r5.isNil(r7)
            if (r5 == 0) goto Lbf
            r1 = r2
            goto L38
        Lb4:
            if (r1 == 0) goto Lb7
            return r6
        Lb7:
            org.keplerproject.luajava.LuaException r5 = new org.keplerproject.luajava.LuaException
            java.lang.String r6 = "Invalid Parameter."
            r5.<init>(r6)
            throw r5
        Lbf:
            org.keplerproject.luajava.LuaException r5 = new org.keplerproject.luajava.LuaException
            java.lang.String r6 = "Invalid Parameters."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.keplerproject.luajava.LuaJavaAPI.compareTypes(org.keplerproject.luajava.LuaState, java.lang.Class, int):java.lang.Object");
    }
}
