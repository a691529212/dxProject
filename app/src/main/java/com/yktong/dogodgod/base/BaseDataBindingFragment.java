package com.yktong.dogodgod.base;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public abstract class BaseDataBindingFragment<F extends ViewDataBinding> extends Fragment {
    private static final String TAG = "Vampire_BaseFragment";

    protected Context mContext;
    //Fragment 当前状态是否可见
    protected boolean isVisible;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    public void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        F binding = DataBindingUtil.inflate(inflater, setLayout(), container, false);
        doBindData(binding);
        return binding.getRoot();
    }

    protected abstract void doBindData(F binding);

    protected abstract
    int setLayout();

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }


    protected abstract void initView();

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();

    protected <T extends View> T bindView(int id) {

        return (T) getView().findViewById(id);
    }

    protected <T extends View> T bindView(View view, int id) {
        return (T) view.findViewById(id);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
