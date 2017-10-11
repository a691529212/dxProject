package com.yktong.dogodgod.bean.data_bean.matter_beans;

import com.yktong.dogodgod.bean.view_bean.MatterViewBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eileen on 2017/7/19.
 */

public class MatterPageBean {

    private List<MatterContentBean> library_Image;
    private PageInfo pagination;

    public List<MatterContentBean> getLibrary_Image() {
        return library_Image;
    }

    public void setLibrary_Image(List<MatterContentBean> library_Image) {
        this.library_Image = library_Image;
    }

    public PageInfo getPagination() {
        return pagination;
    }

    public void setPagination(PageInfo pagination) {
        this.pagination = pagination;
    }

    public List<MatterViewBean> toMatterBeanList() {
        if (!(library_Image != null && library_Image.size() > 0)) return null;
        List<MatterViewBean> matterViewBeanList = new ArrayList<>();
        for (int i = 0; i < library_Image.size(); i++) {
            matterViewBeanList.add(library_Image.get(i).convertToMatter(i));
        }

        return matterViewBeanList;
    }
}
