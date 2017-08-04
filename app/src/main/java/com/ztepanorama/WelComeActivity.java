package com.ztepanorama;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Slingge on 2017/7/20 0020.
 */

public class WelComeActivity extends BaseActivity {


    private ViewPager viewPager;
    private List<Fragment> list;
    private ViewPagerAdapter adapter;

    private WelComeFragment1 fragment1;
    private WelComeFragment2 fragment2;
    private WelComeFragment3 fragment3;

    private boolean flag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        init();
    }


    private void init() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        list = new ArrayList<>();
        fragment1 = new WelComeFragment1();
        fragment2 = new WelComeFragment2();
        fragment3 = new WelComeFragment3();
        list.add(fragment1);
        list.add(fragment2);
        list.add(fragment3);
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        //拖的时候才进入下一页
                        flag = false;
                        break;
                    case ViewPager.SCROLL_STATE_SETTLING:
                        flag = true;
                        break;
                    case ViewPager.SCROLL_STATE_IDLE:
                        /**
                         * 判断是不是最后一页，同时是不是拖的状态
                         */
                        if (viewPager.getCurrentItem() == adapter.getCount() - 1 && !flag) {
                            SharedPreferencesUtil.putSharePre(WelComeActivity.this, "isFirst", true);
                            startActivity(new Intent(WelComeActivity.this, MainActivity.class));
                            finish();
                        }
                        flag = true;
                        break;
                }
            }
        });
    }


    public class ViewPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragmentList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fragmentManager, List<Fragment> arrayList) {
            super(fragmentManager);
            this.fragmentList = arrayList;
        }

        @Override
        public Fragment getItem(int arg0) {
            return fragmentList.get(arg0);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }
}
