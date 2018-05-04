package com.cloudzyy.banner;

import android.support.annotation.IntegerRes;

import java.io.Serializable;

/**
 * Created by cloud on 2018/5/4.
 */

public class BannerBean implements Serializable {
    public String imageUrl;
    public String title;
    public @IntegerRes
    int imageRes;

    public BannerBean(int imageRes, String title) {
        this.imageRes = imageRes;
        this.title = title;
    }
}