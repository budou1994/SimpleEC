package com.budou.ec_core.delegates.bottom;

/**
 * package：com.budou.ec_core.delegates.bottom
 * author : 布兜小爱
 * e-mail : budou1994@qq.com
 * time   : 2017年09月08日 23:20
 * desc   ：
 */

public final class BottomTabBean {

    private final CharSequence TITLE;
    private final CharSequence ICON;

    public BottomTabBean(CharSequence TITLE, CharSequence ICON) {
        this.TITLE = TITLE;
        this.ICON = ICON;
    }

    public CharSequence getTITLE() {
        return TITLE;
    }

    public CharSequence getICON() {
        return ICON;
    }
}
