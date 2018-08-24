package com.base;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.base.commonlib.service.HomeExportService;

/**
 * Created by zsq51 on 2018/5/30.
 */

@Route(path = "/home/HomeService",name = "测试服务")
public class HomeService implements HomeExportService {
    private String name;
    @Override
    public String sayHello(String s) {
        return "HomeService say hello to" + s;
    }

    @Override
    public void init(Context context) {
       initData();
    }

    private void initData() {
        name="yc";
    }
}
