package com.base.commonlib.base.mvp_no_dagger;

import android.support.v4.app.Fragment;


/**
 * Created by zsq
 * on 2017/12/11 0011.
 */

public class BaseFragmentPresenter<T, APP extends BaseApplication> {

    private T IView;
    private APP app;

    public BaseFragmentPresenter(T IView) {
        this.IView = IView;
        this.app = (APP) ((Fragment) IView).getActivity().getApplication();
    }

    public T getIView() {
        return IView;
    }

    public APP getApp() {
        return app;
    }

}
