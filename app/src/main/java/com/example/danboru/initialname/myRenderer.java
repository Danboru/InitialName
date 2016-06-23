package com.example.danboru.initialname;

import android.opengl.GLES10;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Danboru on 18/06/2016.
 */
public class myRenderer implements GLSurfaceView.Renderer {

    private static final String TAG = "MyGLRenderer";
    private Triangle mTriangle, mT;

    private final float[] mMVPMatrix = new float[16];
    private final float[] mProjectionMatrix = new float[16];
    private final float[] mViewMatrix = new float[16];
    private final float[] mRotationMatrix = new float[16];

    private float mAngle;

    @Override
    public void onSurfaceCreated(GL10 unused, EGLConfig config) {


        //===================================

        //deklarasi object vertex :

        //Format
        //X, Y , Opacity

        //Position Vertex
        //Top
        //Bottom Left
        //Bottom Right

        float triangleCoords[] = {

                0.0f, 1.0f, 0.0f,
                0.0f, -0.3f, 0.0f,
                0.5f, -0.3f, 0.0f
        };

        float triangleCoords2[] = {

                0.0f, 0.6f, 0.0f,
                -0.5f, -0.3f, 0.0f,
                0.5f, -0.3f, 0.0f
        };


        //===================================

        GLES20.glClearColor(1.000f, 1.000f, 1.000f, 1.0f);

        mTriangle = new Triangle(triangleCoords);
        mT = new Triangle(triangleCoords2);


    }


    @Override
    public void onDrawFrame(GL10 unused) {
        float[] scratch = new float[16];

        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);


        Matrix.setLookAtM(mViewMatrix, 0, 0, 0, -3, 0f, 0f, 0f, 0f, 1.0f, 0.0f);

        Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mViewMatrix, 0);
        Matrix.multiplyMM(scratch, 0, mMVPMatrix, 0, mRotationMatrix, 0);

        Matrix.setRotateM(mRotationMatrix, 0, mAngle, 0, 0, 1.0f);


        //===================================

        //inisislisasi warna dari object
        float color[] = {0.184f, 0.310f, 0.310f, 0.0f};
        float color2[] = {1.0f, 0.0f, 0.0f, 0.0f};

        //===================================

        //deklarasi Object yang akan di draw
        mTriangle.draw(mMVPMatrix, color);
        mT.draw(mMVPMatrix, color2);

        //===================================

    }

    @Override
    public void onSurfaceChanged(GL10 unused, int width, int height) {

        GLES20.glViewport(0, 0, width, height);

        float ratio = (float) width / height;


        Matrix.frustumM(mProjectionMatrix, 0, -ratio, ratio, -1, 1, 3, 7);

    }

    public static int loadShader(int type, String shaderCode) {


        int shader = GLES20.glCreateShader(type);

        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);

        return shader;
    }

    public static void checkGlError(String glGetUniformLocation) {

    }

    class Texture2D {
        public void bind() {
        }
    }

    class Vector2 {
        private float[] array;

        public float[] getArray() {
            return array;
        }
    }
}
