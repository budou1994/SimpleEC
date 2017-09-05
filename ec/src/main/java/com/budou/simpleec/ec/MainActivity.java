package com.budou.simpleec.ec;

import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.budou.ec_core.activities.ProxyActivity;
import com.budou.ec_core.app.EC;
import com.budou.ec_core.delegates.EcDelegate;
import com.budou.ec_logiic.icons.FontEcModule;
import com.budou.ec_logiic.launcher.LauncherDelegate;
import com.budou.ec_logiic.launcher.LauncherScrollDelegate;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.joanzapata.iconify.fonts.IoniconsModule;

public class MainActivity extends ProxyActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar bar=getSupportActionBar();
        assert bar != null;
        bar.hide();
    }

    @Override
    public EcDelegate setRootDelegate() {
        return new LauncherDelegate();
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        Toast.makeText(EC.getApplicationsContext(),"context传入成功",Toast.LENGTH_SHORT).show();
//    }
}
