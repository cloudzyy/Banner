package com.cloudzyy.banner;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cloudzyy.banner.view.BannerBaseAdapter;
import com.cloudzyy.banner.view.BannerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BannerView mBanner;
    private BannerAdapter mAdapter;
    private List<BannerBean> datas = new ArrayList<>();
    private Button start;
    private Button stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        initData();
    }

    private void initListener() {
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mBanner!=null){

                    mBanner.startAutoScroll();
                }

            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mBanner!=null){

                    mBanner.stopAutoScroll();
                }

            }
        });

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mBanner != null) {
            mBanner.destruction();
        }

    }

    private void initView() {
        mBanner = findViewById(R.id.bannerView);
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);

        mBanner.setAdapter(mAdapter = new BannerAdapter(this));

        mAdapter.setOnPageTouchListener(new BannerBaseAdapter.OnPageTouchListener<BannerBean>() {
            @Override
            public void onPageClick(int position, BannerBean bannerBean) {
                // 页面点击
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageDown() {
                // 按下，可以停止轮播
                //   Toast.makeText(BannerActivity.this, "按下", Toast.LENGTH_SHORT).show();
                mBanner.stopAutoScroll();
            }

            @Override
            public void onPageUp() {
                // 抬起开始轮播
                //  Toast.makeText(BannerActivity.this, "抬起", Toast.LENGTH_SHORT).show();
                mBanner.startAutoScroll();
            }
        });
    }

    private void initData() {
        datas.clear();
        datas.add(new BannerBean(R.mipmap.img1, "第一页"));
        datas.add(new BannerBean(R.mipmap.img2, "第二页"));
        datas.add(new BannerBean(R.mipmap.img3, "第三页"));
        datas.add(new BannerBean(R.mipmap.img4, "第四页"));
        datas.add(new BannerBean(R.mipmap.img5, "第五页"));


        // 数据更新之后需要设置
        mAdapter.setData(datas);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mBanner != null) {
            mBanner.stopAutoScroll();
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        if (mBanner != null) {
            mBanner.startAutoScroll();
        }
    }

}
