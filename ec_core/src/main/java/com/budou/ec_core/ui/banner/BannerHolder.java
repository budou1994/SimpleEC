package com.budou.ec_core.ui.banner;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;

import com.bigkoo.convenientbanner.holder.Holder;

/**
 * package：com.budou.ec_core.ui.banner
 * author : 布兜小爱
 * e-mail : budou1994@qq.com
 * time   : 2017年09月06日 00:09
 * desc   ：
 */

public class BannerHolder implements Holder<Integer> {

    private AppCompatImageView imageView = null;

    @Override
    public View createView(Context context) {
        imageView = new AppCompatImageView(context);
        return imageView;
    }

    @Override
    public void UpdateUI(Context context, int position, Integer data) {
        imageView.setBackgroundResource(data);
    }
}
