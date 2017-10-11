package com.yktong.dogodgod.bean.data_bean.matter_beans;

import com.google.gson.annotations.SerializedName;
import com.yktong.dogodgod.bean.view_bean.MatterViewBean;

import java.util.ArrayList;
import java.util.List;

import space.eileen.tools.XString;

/**
 * Created by Eileen on 2017/7/19.
 */

public class MatterContentBean {
    @SerializedName("clibrary")
    private MatterBean matterBean;
    @SerializedName("matterImageBeen")
    private List<MatterImageBean> matterImageBeen;

    public MatterBean getMatterBean() {
        return matterBean;
    }

    public void setMatterBean(MatterBean matterBean) {
        this.matterBean = matterBean;
    }

    public List<MatterImageBean> getMatterImageBeen() {
        return matterImageBeen;
    }

    public void setMatterImageBeen(List<MatterImageBean> matterImageBeen) {
        this.matterImageBeen = matterImageBeen;
    }

    public MatterViewBean convertToMatter(int... index) {

        MatterViewBean matterViewBean = new MatterViewBean();
        if (index != null) matterViewBean.setId(index[0] + "");
        matterViewBean.setMatter_use_count(getMatterBean().getUseTimes()+"");
        matterViewBean.setMatter_another(getMatterBean().getUserName());
        matterViewBean.setMatter_date_time(XString.toDateForLong(getMatterBean().getAddTime()));
        matterViewBean.setMatterType(matterViewBean.convertToMatterType(getMatterBean().getLibraryStortId()));
        matterViewBean.setTitle(getMatterBean().getContent());
        matterViewBean.setMatter_id(getMatterBean().getLibraryId() + "");
        if (matterViewBean.isLink(getMatterBean().getLibraryStage())) {
            if (getMatterImageBeen().size() > 0) {
                matterViewBean.setMatter_url_icon(getMatterImageBeen().get(0).getLibraryImagePrimary());
            }
            matterViewBean.setMatter_url_link(getMatterBean().getInterLinkage());
            matterViewBean.setMatter_url_title(getMatterBean().getHeadLine());

        } else {
            List<String> largeImgList = new ArrayList<>();
            List<String> middleImgList = new ArrayList<>();
            List<String> imgList = new ArrayList<>();
            for (MatterImageBean matterImageBean : getMatterImageBeen()) {
                largeImgList.add(matterImageBean.getLibraryImagePrimary());
                middleImgList.add(matterImageBean.getLibraryImageZoom());
                imgList.add(matterImageBean.getLibraryImageCompress());
            }
            matterViewBean.setImgLargeList(largeImgList);
            matterViewBean.setImgMiddleList(middleImgList);
            matterViewBean.setImgList(imgList);
        }
        return matterViewBean;
    }
}
