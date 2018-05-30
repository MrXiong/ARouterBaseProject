package com.base.dtaroutor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.base.commonlib.service.HomeExportService;

@Route(path = "/test/main")
public class MainActivity extends AppCompatActivity {

    private TextView hello_tv;

    @Autowired(name = "/home/HomeService")
    public HomeExportService baseService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ARouter.getInstance().inject(this);
        hello_tv = findViewById(R.id.hello_tv);
        hello_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 2. 跳转并携带参数
                ARouter.getInstance().build("/chat/test")
                        .withLong("key1", 666L)
                        .withString("key3", "888")
                        .navigation();
                Toast.makeText(MainActivity.this,baseService.sayHello("张绍强"),Toast.LENGTH_LONG).show();
            }
        });
    }
}
