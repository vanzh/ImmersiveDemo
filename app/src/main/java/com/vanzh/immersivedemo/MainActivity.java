package com.vanzh.immersivedemo;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.vanzh.immersive.ImmersiveUitls;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (Build.VERSION.SDK_INT >= 19) {
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        }
        //     setContentView(R.layout.activity_main);
        ImmersiveUitls.setContentView(this, R.layout.activity_main);

        TextView tvTitle = (TextView) findViewById(R.id.tv_title);
         ImmersiveUitls.immerView(this, tvTitle);
      //  tvTitle.setPadding(0, tvTitle.getPaddingTop() + ImmersiveUitls.dp2px(this, 24), 0, 0);
//        if (Build.VERSION.SDK_INT >= 21) {
//            getWindow().setStatusBarColor(Color.BLUE);
//            getWindow().setNavigationBarColor(Color.BLUE);
//        }

    }
}
