package com.budou.ec_core.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;

import com.budou.ec_core.R;
import com.budou.ec_core.delegates.EcDelegate;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * package：com.budou.ec_core.activities
 * author : 布兜小爱
 * e-mail : budou1994@qq.com
 * time   : 2017年09月02日 19:48
 * desc   ：
 */

public abstract class ProxyActivity extends SupportActivity {

    public abstract EcDelegate setRootDelegate();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContainer(savedInstanceState);
    }

    private void initContainer(Bundle savedInstanceState) {
        ContentFrameLayout container = new ContentFrameLayout(this);
        container.setId(R.id.delegate_container);
        setContentView(container);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.delegate_container,setRootDelegate());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
        System.runFinalization();
    }
}
