package com.budou.ec_core.util.dimen;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.budou.ec_core.app.EC;

/**
 * package：com.budou.ec_core.util.dimen
 * author : 布兜小爱
 * e-mail : budou1994@qq.com
 * time   : 2017年09月04日 00:56
 * desc   ：测量屏幕尺寸的工具类
 */

public class DimenUtil {

    public static int getScreenWidth() {
        final Resources resources = EC.getApplicationsContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight() {
        final Resources resources = EC.getApplicationsContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
