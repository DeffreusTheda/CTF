package org.keplerproject.luajava;

import java.lang.reflect.Proxy;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class LuaObject {
    protected LuaState L;
    protected Integer ref;

    protected LuaObject(LuaState luaState, String str) {
        synchronized (luaState) {
            this.L = luaState;
            luaState.getGlobal(str);
            registerValue(-1);
            luaState.pop(1);
        }
    }

    protected LuaObject(LuaObject luaObject, String str) throws LuaException {
        synchronized (luaObject.getLuaState()) {
            this.L = luaObject.getLuaState();
            if (!luaObject.isTable() && !luaObject.isUserdata()) {
                throw new LuaException("Object parent should be a table or userdata .");
            }
            luaObject.push();
            this.L.pushString(str);
            this.L.getTable(-2);
            this.L.remove(-2);
            registerValue(-1);
            this.L.pop(1);
        }
    }

    protected LuaObject(LuaObject luaObject, Number number) throws LuaException {
        synchronized (luaObject.getLuaState()) {
            this.L = luaObject.getLuaState();
            if (!luaObject.isTable() && !luaObject.isUserdata()) {
                throw new LuaException("Object parent should be a table or userdata .");
            }
            luaObject.push();
            this.L.pushNumber(number.doubleValue());
            this.L.getTable(-2);
            this.L.remove(-2);
            registerValue(-1);
            this.L.pop(1);
        }
    }

    protected LuaObject(LuaObject luaObject, LuaObject luaObject2) throws LuaException {
        if (luaObject.getLuaState() != luaObject2.getLuaState()) {
            throw new LuaException("LuaStates must be the same!");
        }
        synchronized (luaObject.getLuaState()) {
            if (!luaObject.isTable() && !luaObject.isUserdata()) {
                throw new LuaException("Object parent should be a table or userdata .");
            }
            this.L = luaObject.getLuaState();
            luaObject.push();
            luaObject2.push();
            this.L.getTable(-2);
            this.L.remove(-2);
            registerValue(-1);
            this.L.pop(1);
        }
    }

    protected LuaObject(LuaState luaState, int i) {
        synchronized (luaState) {
            this.L = luaState;
            registerValue(i);
        }
    }

    public LuaState getLuaState() {
        return this.L;
    }

    private void registerValue(int i) {
        synchronized (this.L) {
            this.L.pushValue(i);
            this.ref = new Integer(this.L.Lref(LuaState.LUA_REGISTRYINDEX));
        }
    }

    protected void finalize() {
        try {
            synchronized (this.L) {
                if (this.L.getCPtrPeer() != 0) {
                    this.L.LunRef(LuaState.LUA_REGISTRYINDEX, this.ref.intValue());
                }
            }
        } catch (Exception unused) {
            System.err.println("Unable to release object " + this.ref);
        }
    }

    public void push() {
        this.L.rawGetI(LuaState.LUA_REGISTRYINDEX, this.ref.intValue());
    }

    public boolean isNil() {
        boolean isNil;
        synchronized (this.L) {
            push();
            isNil = this.L.isNil(-1);
            this.L.pop(1);
        }
        return isNil;
    }

    public boolean isBoolean() {
        boolean isBoolean;
        synchronized (this.L) {
            push();
            isBoolean = this.L.isBoolean(-1);
            this.L.pop(1);
        }
        return isBoolean;
    }

    public boolean isNumber() {
        boolean isNumber;
        synchronized (this.L) {
            push();
            isNumber = this.L.isNumber(-1);
            this.L.pop(1);
        }
        return isNumber;
    }

    public boolean isString() {
        boolean isString;
        synchronized (this.L) {
            push();
            isString = this.L.isString(-1);
            this.L.pop(1);
        }
        return isString;
    }

    public boolean isFunction() {
        boolean isFunction;
        synchronized (this.L) {
            push();
            isFunction = this.L.isFunction(-1);
            this.L.pop(1);
        }
        return isFunction;
    }

    public boolean isJavaObject() {
        boolean isObject;
        synchronized (this.L) {
            push();
            isObject = this.L.isObject(-1);
            this.L.pop(1);
        }
        return isObject;
    }

    public boolean isJavaFunction() {
        boolean isJavaFunction;
        synchronized (this.L) {
            push();
            isJavaFunction = this.L.isJavaFunction(-1);
            this.L.pop(1);
        }
        return isJavaFunction;
    }

    public boolean isTable() {
        boolean isTable;
        synchronized (this.L) {
            push();
            isTable = this.L.isTable(-1);
            this.L.pop(1);
        }
        return isTable;
    }

    public boolean isUserdata() {
        boolean isUserdata;
        synchronized (this.L) {
            push();
            isUserdata = this.L.isUserdata(-1);
            this.L.pop(1);
        }
        return isUserdata;
    }

    public int type() {
        int type;
        synchronized (this.L) {
            push();
            type = this.L.type(-1);
            this.L.pop(1);
        }
        return type;
    }

    public boolean getBoolean() {
        boolean z;
        synchronized (this.L) {
            push();
            z = this.L.toBoolean(-1);
            this.L.pop(1);
        }
        return z;
    }

    public double getNumber() {
        double number;
        synchronized (this.L) {
            push();
            number = this.L.toNumber(-1);
            this.L.pop(1);
        }
        return number;
    }

    public String getString() {
        String luaState;
        synchronized (this.L) {
            push();
            luaState = this.L.toString(-1);
            this.L.pop(1);
        }
        return luaState;
    }

    public Object getObject() throws LuaException {
        Object objectFromUserdata;
        synchronized (this.L) {
            push();
            objectFromUserdata = this.L.getObjectFromUserdata(-1);
            this.L.pop(1);
        }
        return objectFromUserdata;
    }

    public LuaObject getField(String str) throws LuaException {
        return this.L.getLuaObject(this, str);
    }

    public Object[] call(Object[] objArr, int i) throws LuaException {
        int i2;
        Object[] objArr2;
        String str;
        String str2;
        synchronized (this.L) {
            if (!isFunction() && !isTable() && !isUserdata()) {
                throw new LuaException("Invalid object. Not a function, table or userdata .");
            }
            int top = this.L.getTop();
            push();
            if (objArr != null) {
                for (Object obj : objArr) {
                    this.L.pushObjectValue(obj);
                }
            } else {
                i2 = 0;
            }
            int pcall = this.L.pcall(i2, i, 0);
            if (pcall != 0) {
                if (this.L.isString(-1)) {
                    str = this.L.toString(-1);
                    this.L.pop(1);
                } else {
                    str = "";
                }
                if (pcall == 2) {
                    str2 = "Runtime error. " + str;
                } else if (pcall == 4) {
                    str2 = "Memory allocation error. " + str;
                } else if (pcall == 6) {
                    str2 = "Error while running the error handler function. " + str;
                } else {
                    str2 = "Lua Error code " + pcall + ". " + str;
                }
                throw new LuaException(str2);
            }
            if (i == -1) {
                i = this.L.getTop() - top;
            }
            if (this.L.getTop() - top < i) {
                throw new LuaException("Invalid Number of Results .");
            }
            objArr2 = new Object[i];
            while (i > 0) {
                objArr2[i - 1] = this.L.toJavaObject(-1);
                this.L.pop(1);
                i--;
            }
        }
        return objArr2;
    }

    public Object call(Object[] objArr) throws LuaException {
        return call(objArr, 1)[0];
    }

    public String toString() {
        synchronized (this.L) {
            try {
                try {
                    if (isNil()) {
                        return "nil";
                    }
                    if (isBoolean()) {
                        return String.valueOf(getBoolean());
                    }
                    if (isNumber()) {
                        return String.valueOf(getNumber());
                    }
                    if (isString()) {
                        return getString();
                    }
                    if (isFunction()) {
                        return "Lua Function";
                    }
                    if (isJavaObject()) {
                        return getObject().toString();
                    }
                    if (isUserdata()) {
                        return "Userdata";
                    }
                    if (isTable()) {
                        return "Lua Table";
                    }
                    if (isJavaFunction()) {
                        return "Java Function";
                    }
                    return null;
                } catch (LuaException unused) {
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Object createProxy(String str) throws ClassNotFoundException, LuaException {
        Object newProxyInstance;
        synchronized (this.L) {
            if (!isTable()) {
                throw new LuaException("Invalid Object. Must be Table.");
            }
            StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
            Class[] clsArr = new Class[stringTokenizer.countTokens()];
            int i = 0;
            while (stringTokenizer.hasMoreTokens()) {
                clsArr[i] = Class.forName(stringTokenizer.nextToken());
                i++;
            }
            newProxyInstance = Proxy.newProxyInstance(getClass().getClassLoader(), clsArr, new LuaInvocationHandler(this));
        }
        return newProxyInstance;
    }
}
