package com.yktong.dogodgod.fragment;

import android.view.View;

import com.yktong.dogodgod.R;
import com.yktong.dogodgod.base.BaseDataBindingFragment;
import com.yktong.dogodgod.bean.view_bean.ManageFragmentViewBean;
import com.yktong.dogodgod.databinding.FragmentManageBinding;

/**
 * Created by vampire on 2017/9/29.
 */

public class ManageFragment extends BaseDataBindingFragment<FragmentManageBinding> {
    ManageFragmentViewBean manageFragmentViewBean;

    @Override
    protected void doBindData(FragmentManageBinding binding) {
        if (manageFragmentViewBean == null) {
            manageFragmentViewBean = new ManageFragmentViewBean();
            manageFragmentViewBean.setCallCountTeamToDay(0 + "");
            manageFragmentViewBean.setChatCountTeamToDay(0 + "");
            manageFragmentViewBean.setFansCountTeamToDay(0 + "");
            manageFragmentViewBean.setPerformanceCountTeamToDay(0 + "");
            manageFragmentViewBean.setVisitationCountTeamToDay(0 + "");
        }
        binding.setBean(manageFragmentViewBean);
        binding.setControl(this);
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_manage;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    //点击微信管理事件
    public void goWeChatManage(View view) {

    }   //点击电话管理事件

    public void goCallManage(View view) {

    }   //点击轨迹管理事件

    public void goLBSManage(View view) {

    }   //点击业绩管理事件

    public void goPerformanceManage(View view) {

    }   //点击素材管理事件

    public void goMatterManage(View view) {

    }   //点击数据管理事件

    public void goDataManage(View view) {

    }
}
