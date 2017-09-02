package com.budou.simpleec.ec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.budou.ec_core.delegates.EcDelegate;

/**
 * package：com.budou.simpleec.ec
 * author : 布兜小爱
 * e-mail : budou1994@qq.com
 * time   : 2017年09月02日 22:12
 * desc   ：
 */

public class ExampleDelegate extends EcDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
