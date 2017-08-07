package com.ztepanorama;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

/**
 * Created by Slingge on 2017/8/7 0007.
 */

public class VideoActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        init();
    }


    private void init() {
        TextView tv_jump = (TextView) findViewById(R.id.tv_jump);
        tv_jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VideoActivity.this, MainActivity.class));
                finish();
            }
        });

        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        String uri = "android.resource://" + getPackageName() + "/" + R.raw.video;
        videoView.setVideoURI(Uri.parse((uri)));
        videoView.requestFocus();  //获取焦点
        //监听播完了重播
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                startActivity(new Intent(VideoActivity.this, MainActivity.class));
                finish();
            }
        });
        videoView.start();

    }

}
