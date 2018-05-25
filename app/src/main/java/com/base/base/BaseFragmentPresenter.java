package com.base.base;

import android.support.v4.app.Fragment;

import com.base.app.App;


/**
 * Created by zsq
 * on 2017/12/11 0011.
 */

public class BaseFragmentPresenter<T> {

    private T IView;
    private App app;

    public BaseFragmentPresenter(T IView) {
        this.IView = IView;
        this.app = (App) ((Fragment) IView).getActivity().getApplication();
    }

    public T getIView() {
        return IView;
    }

    public App getApp() {
        return app;
    }

}
