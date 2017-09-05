package com.budou.ec_core.ui.banner;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;

/**
 * package：com.budou.ec_core.ui.banner
 * author : 布兜小爱
 * e-mail : budou1994@qq.com
 * time   : 2017年09月06日 00:08
 * desc   ：
 */

public class BannerHolderCreator implements CBViewHolderCreator<BannerHolder> {

    @Override
    public BannerHolder createHolder() {
        return new BannerHolder();
    }
}
