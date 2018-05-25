package alipay.com.base;

/**
 * @description :
 * @autHor :  V.Wenju.Tian
 * @date : 2016/12/14 10:57
 */

public abstract class BaseFragmentModule<E> {

    private E e;

    public BaseFragmentModule(E e) {
        this.e = e;
    }

    public E providerView(E e) {
        return e;
    }
}
