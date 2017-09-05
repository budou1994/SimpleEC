package com.budou.ec_logiic.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.budou.ec_core.delegates.EcDelegate;
import com.budou.ec_core.ui.banner.BannerHolderCreator;
import com.budou.ec_core.ui.banner.BannerScrollTag;
import com.budou.ec_core.util.storage.EcPreference;
import com.budou.ec_logiic.R;

import java.util.ArrayList;

/**
 * package：com.budou.ec_logiic.launcher
 * author : 布兜小爱
 * e-mail : budou1994@qq.com
 * time   : 2017年09月06日 00:02
 * desc   ：首次进入APP或者更新时轮播页面
 */

public class LauncherScrollDelegate extends EcDelegate implements OnItemClickListener {

    private ConvenientBanner<Integer> convenientBanner = null;
    private final static ArrayList<Integer> INTEGERS = new ArrayList<>();


    @Override
    public Object setLayout() {
        convenientBanner = new ConvenientBanner<>(getContext());
        return convenientBanner;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initBanner();
    }

    private void initBanner() {
        INTEGERS.add(R.mipmap.launcher_01);
        INTEGERS.add(R.mipmap.launcher_02);
        INTEGERS.add(R.mipmap.launcher_03);
        INTEGERS.add(R.mipmap.launcher_04);
        INTEGERS.add(R.mipmap.launcher_05);
        convenientBanner.setPages(new BannerHolderCreator(), INTEGERS)
                .setPageIndicator(new int[]{R.drawable.banner_dot_normal, R.drawable.banner_dot_focus})
                .setOnItemClickListener(this)
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setCanLoop(false);


    }

    @Override
    public void onItemClick(int position) {
        if (position == INTEGERS.size() - 1) {
            EcPreference.setAppFlag(BannerScrollTag.HAS_FIRST_LAUNCHER_APP.name(), true);
            //登录逻辑
        }
    }
}
