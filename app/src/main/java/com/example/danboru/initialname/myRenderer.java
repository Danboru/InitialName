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

    private Triangle mTriangle1,mTriangle2,mTriangle3,mTriangle4,mTriangle5,mTriangle6
            ,mTriangle7,mTriangle8,mTriangle9,mTriangle10,mTriangle11,mTriangle12;

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

        float triangleCoords1[] = {//selesai

                0.4f, 0.7f, 0.0f,
                0.0f, 0.4f, 0.0f,
                0.4f, 0.0f, 0.0f
        };

        float triangleCoords2[] = {//selesai

                0.4f, 0.7f, 0.0f,
                0.0f, 0.7f, 0.0f,
                0.0f, 0.4f, 0.0f
        };

        float triangleCoords3[] = {//selesai

                0.0f, 0.7f, 0.0f,
                -0.4f, 0.4f, 0.0f,
                0.0f, 0.4f, 0.0f
        };

        float triangleCoords4[] = {//selesai

                0.0f, 0.4f, 0.0f,
                0.0f, 0.0f, 0.0f,
                0.4f, 0.0f, 0.0f
        };

        float triangleCoords5[] = {//selesai

                0.0f, 0.4f, 0.0f,
                -0.4f, 0.4f, 0.0f,
                0.0f, 0.0f, 0.0f
        };

        float triangleCoords6[] = {//selesai

                -0.4f, 0.4f, 0.0f,
                -0.4f, 0.0f, 0.0f,
                0.0f, 0.0f, 0.0f
        };

        float triangleCoords7[] = {//selesai

                0.4f, 0.0f, 0.0f,
                0.0f, -0.4f, 0.0f,
                0.4f, -0.7f, 0.0f
        };

        float triangleCoords8[] = {//selesai

                0.4f, 0.0f, 0.0f,
                0.0f, 0.0f, 0.0f,
                0.0f, -0.4f, 0.0f
        };

        float triangleCoords9[] = {//selesai

                0.0f, 0.0f, 0.0f,
                -0.4f, 0.0f, 0.0f,
                -0.4f, -0.4f, 0.0f
        };

        float triangleCoords10[] = {//selesai

                0.0f, 0.0f, 0.0f,
                -0.4f, -0.4f, 0.0f,
                0.0f, -0.4f, 0.0f
        };

        float triangleCoords11[] = {//selesai

                0.0f, -0.4f, 0.0f,
                0.0f, -0.7f, 0.0f,
                0.4f, -0.7f, 0.0f
        };

        float triangleCoords12[] = {

                0.0f, -0.4f, 0.0f,
                -0.4f, -0.4f, 0.0f,
                0.0f, -0.7f, 0.0f
        };


        //===================================

        GLES20.glClearColor(1.000f, 1.000f, 1.000f, 1.0f);

        mTriangle1 = new Triangle(triangleCoords1);
        mTriangle2 = new Triangle(triangleCoords2);
        mTriangle3 = new Triangle(triangleCoords3);
        mTriangle4 = new Triangle(triangleCoords4);
        mTriangle5 = new Triangle(triangleCoords5);
        mTriangle6 = new Triangle(triangleCoords6);
        mTriangle7 = new Triangle(triangleCoords7);
        mTriangle8 = new Triangle(triangleCoords8);
        mTriangle9 = new Triangle(triangleCoords9);
        mTriangle10 = new Triangle(triangleCoords10);
        mTriangle11 = new Triangle(triangleCoords11);
        mTriangle12 = new Triangle(triangleCoords12);


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
        mTriangle1.draw(mMVPMatrix, color);
        mTriangle2.draw(mMVPMatrix, color2);
        mTriangle3.draw(mMVPMatrix, color);
        mTriangle4.draw(mMVPMatrix, color2);
        mTriangle5.draw(mMVPMatrix, color);
        mTriangle6.draw(mMVPMatrix, color2);
        mTriangle7.draw(mMVPMatrix, color);
        mTriangle8.draw(mMVPMatrix, color2);
        mTriangle9.draw(mMVPMatrix, color);
        mTriangle10.draw(mMVPMatrix, color2);
        mTriangle11.draw(mMVPMatrix, color);
        mTriangle12.draw(mMVPMatrix, color2);


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
