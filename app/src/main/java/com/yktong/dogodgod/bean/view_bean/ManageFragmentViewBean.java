package com.yktong.dogodgod.bean.view_bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.yktong.dogodgod.BR;

/**
 * Created by Eileen on 2017/10/11.
 */

public class ManageFragmentViewBean extends BaseObservable {
    private
    @Bindable
    String chatCountTeamToDay;
    private
    @Bindable
    String callCountTeamToDay;
    private
    @Bindable
    String fansCountTeamToDay;
    private
    @Bindable
    String performanceCountTeamToDay;
    private
    @Bindable
    String visitationCountTeamToDay;

    public String getChatCountTeamToDay() {
        return chatCountTeamToDay;
    }

    public void setChatCountTeamToDay(String chatCountTeamToDay) {
        this.chatCountTeamToDay = chatCountTeamToDay;
        notifyPropertyChanged(BR.chatCountTeamToDay);
    }

    public String getCallCountTeamToDay() {
        return callCountTeamToDay;
    }

    public void setCallCountTeamToDay(String callCountTeamToDay) {
        this.callCountTeamToDay = callCountTeamToDay;
        notifyPropertyChanged(BR.callCountTeamToDay);
    }

    public String getFansCountTeamToDay() {
        return fansCountTeamToDay;
    }

    public void setFansCountTeamToDay(String fansCountTeamToDay) {
        this.fansCountTeamToDay = fansCountTeamToDay;
        notifyPropertyChanged(BR.fansCountTeamToDay);
    }

    public String getPerformanceCountTeamToDay() {
        return performanceCountTeamToDay;
    }

    public void setPerformanceCountTeamToDay(String performanceCountTeamToDay) {
        this.performanceCountTeamToDay = performanceCountTeamToDay;
        notifyPropertyChanged(BR.performanceCountTeamToDay);
    }

    public String getVisitationCountTeamToDay() {
        return visitationCountTeamToDay;
    }

    public void setVisitationCountTeamToDay(String visitationCountTeamToDay) {
        this.visitationCountTeamToDay = visitationCountTeamToDay;
        notifyPropertyChanged(BR.visitationCountTeamToDay);
    }
}
