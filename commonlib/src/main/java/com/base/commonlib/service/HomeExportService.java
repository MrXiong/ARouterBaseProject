package com.base.commonlib.service;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * Created by zsq51
 * on 2018/5/30.
 *
 * 接口为各个组件间通讯的代理接口，继承了 @IProvider
 * 各个组件要暴露方法时可以继承在commonlib 里创建的接口并实现方法
 *
 *
 */

public interface HomeExportService extends IProvider {
    String sayHello(String s);
}
