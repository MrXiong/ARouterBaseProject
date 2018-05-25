package com.base.base;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.base.app.App;

/**
 * Created by Administrator on 2017/12/8 0008.
 */

public class BasePresenter<T> {

    private T IView;
    private App app;

    public BasePresenter(T IView) {
        this.IView = IView;
        try {
            this.app = (App) ((Activity) IView).getApplication();
        } catch (ClassCastException ignored) {
            this.app = (App) (((Fragment) IView).getActivity()).getApplication();
        }
    }

    public T getIView() {
        return IView;
    }

    public App getApp() {
        return app;
    }

}
