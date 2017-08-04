package com.ztepanorama;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Slingge on 2017/7/20 0020.
 */

public class StartUpActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);
        toTask();
    }


    private void toTask() {
        int count = SharedPreferencesUtil.getSharePreInt(StartUpActivity.this, "count");
        Toast.makeText(this, count + "", Toast.LENGTH_SHORT).show();
        if (count == 20) {
            finish();
            System.exit(0);
        }
        count++;
        SharedPreferencesUtil.putSharePre(this, "count", count);

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                boolean isFirst = SharedPreferencesUtil.getSharePreBoolean(StartUpActivity.this, "isFirst");
                if (!isFirst) {
                    startActivity(new Intent(StartUpActivity.this, WelComeActivity.class));
                } else {
                    startActivity(new Intent(StartUpActivity.this, MainActivity.class));
                }
                finish();
            }
        };
        timer.schedule(task, 2000);//第一次执行前的毫秒延迟时间。在随后的执行之间毫秒内的时间
    }


}
