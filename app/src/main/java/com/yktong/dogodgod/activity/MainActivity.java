package com.yktong.dogodgod.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.yktong.dogodgod.R;
import com.yktong.dogodgod.base.BaseActivity;
import com.yktong.dogodgod.fragment.ClientFragment;
import com.yktong.dogodgod.fragment.MainFragment;
import com.yktong.dogodgod.fragment.ManageFragment;
import com.yktong.dogodgod.fragment.MarketFragment;
import com.yktong.dogodgod.fragment.UserFragment;

public class MainActivity extends BaseActivity {

    private FragmentManager fragmentManager;

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        Log.d("MainActivity", "onCreate");
//        FrameLayout frameLayout = bindView(R.id.activity_main_frame_layout);
        RadioGroup radioGroup = (RadioGroup) bindView(R.id.main_radio_group);

        radioGroup.check(R.id.main_btn);
        fragmentManager = getSupportFragmentManager();
        changeView(new MainFragment());
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.main_btn:
                        changeView(new MainFragment());
                        break;
                    case R.id.client_btn:
                        changeView(new ClientFragment());
                        break;
                    case R.id.market_btn:
                        changeView(new MarketFragment());
                        break;
                    case R.id.manage_btn:
                        changeView(new ManageFragment());
                        break;
                    case R.id.user_btn:
                        changeView(new UserFragment());
                        break;
                }
            }
        });
    }

    private void changeView(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activity_main_frame_layout,fragment).commit();
    }

    @Override
    protected void initData() {

    }
}
