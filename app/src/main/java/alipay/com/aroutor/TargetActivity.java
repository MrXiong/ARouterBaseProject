package alipay.com.aroutor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/test/target")
public class TargetActivity extends AppCompatActivity {

    @Autowired
    public String key3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);
        ARouter.getInstance().inject(this);
        Toast.makeText(this, key3, Toast.LENGTH_LONG).show();
    }
}
