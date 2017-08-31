package com.budou.simpleec.ec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.budou.ec_core.app.EC;
import com.budou.ec_logiic.icons.FontEcModule;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.joanzapata.iconify.fonts.IoniconsModule;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(EC.getApplicationsContext(),"context传入成功",Toast.LENGTH_SHORT).show();
    }
}
