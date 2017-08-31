package com.budou.ec_logiic.icons;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

/**
 * package：com.budou.ec_logiic.icons
 * author : 布兜小爱
 * e-mail : budou1994@qq.com
 * time   : 2017年08月31日 23:22
 * desc   ：
 */

public class FontEcModule implements IconFontDescriptor {

    @Override
    public String ttfFileName() {
        return "iconfont.ttf";
    }

    @Override
    public Icon[] characters() {
        return EcIcons.values();
    }
}
