package alipay.com.base;

import android.app.Application;
import android.content.Context;
import android.content.Intent;


import java.util.LinkedList;

import alipay.com.commonlib.di.module.AppModule;
import alipay.com.commonlib.di.module.ClientModule;


/**
 * 本项目由
 * mvp
 * +dagger2
 * +retrofit
 * +rxjava
 * +butterknife组成
 */
public abstract class BaseApplication extends Application {
    static private BaseApplication mApplication;
    public LinkedList<BaseCommonActivity> mActivityList;
    private ClientModule mClientModule;
    private AppModule mAppModule;
    protected final String TAG = this.getClass().getSimpleName();


    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        this.mAppModule = new AppModule(this);//提供application
    }


    /**
     * 提供基础url给retrofit
     *
     * @return
     */
    protected abstract String getBaseUrl();

    public ClientModule getClientModule() {
        return mClientModule;
    }

    public AppModule getAppModule() {
        return mAppModule;
    }

    /**
     * 返回上下文
     *
     * @return
     */
    public static Context getContext() {
        return mApplication;
    }

    /**
     * 返回一个存储所有存在的activity的列表
     *
     * @return
     */
    public LinkedList<BaseCommonActivity> getActivityList() {
        if (mActivityList == null) {
            mActivityList = new LinkedList<>();
        }
        return mActivityList;
    }
    /**
     * 退出所有activity
     */
    public static void killAll() {
        Intent intent = new Intent(BaseCommonActivity.ACTION_RECEIVER_ACTIVITY);
        intent.putExtra("type", "killAll");
        getContext().sendBroadcast(intent);
    }
}
