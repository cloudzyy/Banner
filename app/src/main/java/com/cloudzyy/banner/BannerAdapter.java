package com.cloudzyy.banner;

/**
 * Created by cloud on 2018/5/4.
 */

import android.content.Context;
import android.view.View;

import com.cloudzyy.banner.view.BannerBaseAdapter;

public class BannerAdapter extends BannerBaseAdapter<BannerBean> {

    public BannerAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.item_banner;
    }

    @Override
    protected void convert(View convertView, BannerBean data) {
        setImage(R.id.pageimg, data.imageRes);
    }
}
