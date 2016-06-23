package com.example.danboru.initialname;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created by Danboru on 18/06/2016.
 */
public class myOpenGLSurfaceView extends GLSurfaceView {

    private final myRenderer renderernya;

    public myOpenGLSurfaceView(Context context){
        super(context);

        setEGLContextClientVersion(2);

        renderernya = new myRenderer();
        setRenderer(renderernya);

    }

}
