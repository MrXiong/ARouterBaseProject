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
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView chat_tv;
    private TextView contract_tv;
    private TextView find_tv;
    private TextView mine_tv;
    private TextView say_hello_tv;

    @Autowired(name = "/home/HomeService")
    public HomeExportService baseService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ARouter.getInstance().inject(this);
        initView();
    }

    private void initView() {
        chat_tv = findViewById(R.id.chat_tv);
        contract_tv = findViewById(R.id.contract_tv);
        find_tv = findViewById(R.id.find_tv);
        mine_tv = findViewById(R.id.mine_tv);
        say_hello_tv = findViewById(R.id.say_hello_tv);

        chat_tv.setOnClickListener(this);
        contract_tv.setOnClickListener(this);
        find_tv.setOnClickListener(this);
        mine_tv.setOnClickListener(this);
        say_hello_tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.chat_tv:
                ARouter.getInstance().build("/chat/main")
                        .withLong("key1", 666L)
                        .withString("key3", "888")
                        .navigation();
                break;
            case R.id.contract_tv:
                ARouter.getInstance().build("/home/main")
                        .navigation();
                break;
            case R.id.find_tv:
                ARouter.getInstance().build("/find/main")
                        .navigation();
                break;
            case R.id.mine_tv:
                ARouter.getInstance().build("/mine/main")
                        .navigation();
                break;
            case R.id.say_hello_tv:
                Toast.makeText(this, baseService.sayHello("易诚互动"), Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
