package alipay.com.base;

/**
 * Created by V.Wenju.Tian
 * on 2016/11/29.
 */

public abstract class BaseActivity<p extends BasePresenter> extends BaseCommonActivity{

    public final String TAG = getClass().getSimpleName();

    @Override
    protected void initCView() {
        initView();
    }

    protected abstract void initView();

    @Override
    protected void initCData() {
        initData();
    }

    protected abstract void initData();


    @Override
    protected abstract int getContentViewId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
