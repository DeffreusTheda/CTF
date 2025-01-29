package io.flutter.embedding.engine.renderer;

import android.graphics.SurfaceTexture;

/* loaded from: classes.dex */
public class SurfaceTextureWrapper {
    private boolean attached;
    private boolean newFrameAvailable;
    private Runnable onFrameConsumed;
    private boolean released;
    private SurfaceTexture surfaceTexture;

    public SurfaceTextureWrapper(SurfaceTexture surfaceTexture) {
        this(surfaceTexture, null);
    }

    public void attachToGLContext(int i2) {
        synchronized (this) {
            try {
                if (this.released) {
                    return;
                }
                if (this.attached) {
                    this.surfaceTexture.detachFromGLContext();
                }
                this.surfaceTexture.attachToGLContext(i2);
                this.attached = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void detachFromGLContext() {
        synchronized (this) {
            try {
                if (this.attached && !this.released) {
                    this.surfaceTexture.detachFromGLContext();
                    this.attached = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void getTransformMatrix(float[] fArr) {
        this.surfaceTexture.getTransformMatrix(fArr);
    }

    public void markDirty() {
        synchronized (this) {
            this.newFrameAvailable = true;
        }
    }

    public void release() {
        synchronized (this) {
            try {
                if (!this.released) {
                    this.surfaceTexture.release();
                    this.released = true;
                    this.attached = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean shouldUpdate() {
        boolean z2;
        synchronized (this) {
            z2 = this.newFrameAvailable;
        }
        return z2;
    }

    public SurfaceTexture surfaceTexture() {
        return this.surfaceTexture;
    }

    public void updateTexImage() {
        synchronized (this) {
            try {
                this.newFrameAvailable = false;
                if (!this.released) {
                    this.surfaceTexture.updateTexImage();
                    Runnable runnable = this.onFrameConsumed;
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public SurfaceTextureWrapper(SurfaceTexture surfaceTexture, Runnable runnable) {
        this.newFrameAvailable = false;
        this.surfaceTexture = surfaceTexture;
        this.released = false;
        this.onFrameConsumed = runnable;
    }
}
