package com.budou.ec_logiic.icons;

import com.joanzapata.iconify.Icon;

/**
 * package：com.budou.ec_logiic.icons
 * author : 布兜小爱
 * e-mail : budou1994@qq.com
 * time   : 2017年08月31日 23:22
 * desc   ：
 */

public enum EcIcons implements Icon {

    icon_scan('\ue602'),
    icon_ali_pay('\ue606');

    private char character;

    EcIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_','-');
    }

    @Override
    public char character() {
        return character;
    }
}
