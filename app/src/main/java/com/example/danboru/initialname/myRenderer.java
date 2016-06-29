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
            ,mTriangle7,mTriangle8,mTriangle9,mTriangle10,mTriangle11,mTriangle12 ;

    private Triangle1 mHurufA1,mHurufA2,mHurufA3,mHurufA4,mHurufA5,mHurufA6,mHurufA7,
            mHurufA8,mHurufA9,mHurufA10;

    private Triangle2 mHurufE1,mHurufE2,mHurufE3,mHurufE4,mHurufE5,mHurufE6,mHurufE7,
            mHurufE8,mHurufE9,mHurufE10;


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

        //huruf D
        /*
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
        */
        /*
        //===================================

        //Huruf A
        float shapeA1[] = {//selesai

                0.1f, 0.5f, 0.0f,
                0.0f, 0.3f, 0.0f,
                -0.1f, 0.5f, 0.0f


        };

        float shapeA2[] = {//selesai

                0.1f, 0.5f, 0.0f,
                0.2f, 0.3f, 0.0f,
                0.0f, 0.3f, 0.0f

        };

        float shapeA3[] = {//selesai

                -0.1f, 0.5f, 0.0f,
                0.0f, 0.3f, 0.0f,
                -0.2f, 0.3f, 0.0f

        };

        float shapeA4[] = {//selesai

                0.2f, 0.3f, 0.0f,
                0.0f, 0.0f, 0.0f,
                -0.2f, 0.3f, 0.0f

        };

        float shapeA5[] = {//selesai

                0.2f, 0.3f, 0.0f,
                0.350f, 0.0f, 0.0f,
                0.0f, 0.0f, 0.0f

        };

        float shapeA6[] = {//selesai

                -0.2f, 0.3f, 0.0f,
                -0.350f, 0.0f, 0.0f,
                0.0f, 0.0f, 0.0f

        };

        float shapeA7[] = {//selesai

                0.350f, 0.0f, 0.0f,
                0.1f, -0.4f, 0.0f,
                0.0f, 0.0f, 0.0f

        };

        float shapeA8[] = {//selesai

                0.0f, 0.0f, 0.0f,
                -0.1f, -0.4f, 0.0f,
                -0.350f, 0.0f, 0.0f

        };

        float shapeA9[] = {

                0.350f, 0.0f, 0.0f,
                0.4f, -0.4f, 0.0f,
                0.1f, -0.4f, 0.0f

        };

        float shapeA10[] = {

                -0.350f, 0.0f, 0.0f,
                -0.4f, -0.4f, 0.0f,
                -0.1f, -0.4f, 0.0f

        };
        */

        //===================================

        //Huruf E

        float shapeE1[] = {

                0.1f, 0.5f, 0.0f,
                0.2f, 0.3f, 0.0f,
                0.0f, 0.3f, 0.0f

        };

        float shapeE2[] = {

                0.1f, 0.5f, 0.0f,
                0.2f, 0.3f, 0.0f,
                0.0f, 0.3f, 0.0f

        };

        float shapeE3[] = {

                0.1f, 0.5f, 0.0f,
                0.2f, 0.3f, 0.0f,
                0.0f, 0.3f, 0.0f

        };

        float shapeE4[] = {

                0.1f, 0.5f, 0.0f,
                0.2f, 0.3f, 0.0f,
                0.0f, 0.3f, 0.0f

        };

        float shapeE5[] = {

                0.1f, 0.5f, 0.0f,
                0.2f, 0.3f, 0.0f,
                0.0f, 0.3f, 0.0f

        };

        float shapeE6[] = {

                0.1f, 0.5f, 0.0f,
                0.2f, 0.3f, 0.0f,
                0.0f, 0.3f, 0.0f

        };

        float shapeE7[] = {

                0.1f, 0.5f, 0.0f,
                0.2f, 0.3f, 0.0f,
                0.0f, 0.3f, 0.0f

        };

        float shapeE8[] = {

                0.1f, 0.5f, 0.0f,
                0.2f, 0.3f, 0.0f,
                0.0f, 0.3f, 0.0f

        };


        float shapeE9[] = {

                0.1f, 0.5f, 0.0f,
                0.2f, 0.3f, 0.0f,
                0.0f, 0.3f, 0.0f

        };


        float shapeE10[] = {

                0.1f, 0.5f, 0.0f,
                0.2f, 0.3f, 0.0f,
                0.0f, 0.3f, 0.0f

        };


        //===================================

        GLES20.glClearColor(1.000f, 1.000f, 1.000f, 1.0f);


        //Huruf D
        //===================================
        /*
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
        */

        //===================================
        /*
        // Huruf A
        mHurufA1 = new Triangle1(shapeA1);
        mHurufA2 = new Triangle1(shapeA2);
        mHurufA3 = new Triangle1(shapeA3);
        mHurufA4 = new Triangle1(shapeA4);
        mHurufA5 = new Triangle1(shapeA5);
        mHurufA6 = new Triangle1(shapeA6);
        mHurufA7 = new Triangle1(shapeA7);
        mHurufA8 = new Triangle1(shapeA8);
        mHurufA9 = new Triangle1(shapeA9);
        mHurufA10 = new Triangle1(shapeA10);
        */
        //===================================
        // Huruf E


        mHurufE1 = new Triangle2(shapeE1);
        mHurufE2 = new Triangle2(shapeE2);
        mHurufE3 = new Triangle2(shapeE3);
        mHurufE4 = new Triangle2(shapeE4);
        mHurufE5 = new Triangle2(shapeE5);
        mHurufE6 = new Triangle2(shapeE6);
        mHurufE7 = new Triangle2(shapeE7);
        mHurufE8 = new Triangle2(shapeE8);
        mHurufE9 = new Triangle2(shapeE9);
        mHurufE10 = new Triangle2(shapeE10);

        //===================================
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
        float color1[] = {0.184f, 0.310f, 0.310f, 0.0f};
        float color2[] = {0.824f, 0.412f, 0.118f, 0.0f};
        float color3[] = {0.871f, 0.722f, 0.529f, 0.0f};
        float color4[] = {0.255f, 0.412f, 0.882f, 0.0f};
        float color5[] = {0.000f, 0.749f, 1.000f, 0.0f};
        float color6[] = {0.498f, 1.000f, 0.831f, 0.0f};
        float color7[] = {0.561f, 0.737f, 0.561f, 0.0f};
        float color8[] = {0.604f, 0.804f, 0.196f, 0.0f};
        float color9[] = {0.678f, 1.000f, 0.184f, 0.0f};
        float color10[] = {0.580f, 0.000f, 0.827f, 0.0f};
        float color11[] = {1.000f, 0.647f, 0.000f, 0.0f};
        float color12[] = {	0.980f, 0.502f, 0.447f, 0.0f};

        //===================================
        /*
        //Huruf D
        //deklarasi Object yang akan di draw
        mTriangle1.draw(mMVPMatrix, color1);
        mTriangle2.draw(mMVPMatrix, color2);
        mTriangle3.draw(mMVPMatrix, color3);
        mTriangle4.draw(mMVPMatrix, color4);
        mTriangle5.draw(mMVPMatrix, color5);
        mTriangle6.draw(mMVPMatrix, color6);
        mTriangle7.draw(mMVPMatrix, color7);
        mTriangle8.draw(mMVPMatrix, color8);
        mTriangle9.draw(mMVPMatrix, color9);
        mTriangle10.draw(mMVPMatrix, color10);
        mTriangle11.draw(mMVPMatrix, color11);
        mTriangle12.draw(mMVPMatrix, color12);
        */

        //===================================
        /*
        //Huruf A
        //deklarasi Object yang akan di draw
        mHurufA1.draw(mMVPMatrix, color1);
        mHurufA2.draw(mMVPMatrix, color2);
        mHurufA3.draw(mMVPMatrix, color3);
        mHurufA4.draw(mMVPMatrix, color4);
        mHurufA5.draw(mMVPMatrix, color5);
        mHurufA6.draw(mMVPMatrix, color6);
        mHurufA7.draw(mMVPMatrix, color7);
        mHurufA8.draw(mMVPMatrix, color8);
        mHurufA9.draw(mMVPMatrix, color9);
        mHurufA10.draw(mMVPMatrix, color10);
        */

        //====================================

        //Huruf E
        mHurufE1.draw(mMVPMatrix, color1);
        mHurufE2.draw(mMVPMatrix, color2);
        mHurufE3.draw(mMVPMatrix, color3);
        mHurufE4.draw(mMVPMatrix, color4);
        mHurufE5.draw(mMVPMatrix, color5);
        mHurufE6.draw(mMVPMatrix, color6);
        mHurufE7.draw(mMVPMatrix, color7);
        mHurufE8.draw(mMVPMatrix, color8);
        mHurufE9.draw(mMVPMatrix, color9);
        mHurufE10.draw(mMVPMatrix, color10);

        //====================================

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
