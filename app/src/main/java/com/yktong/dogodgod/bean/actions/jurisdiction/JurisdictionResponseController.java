package com.yktong.dogodgod.bean.actions.jurisdiction;

import com.yktong.dogodgod.bean.actions.ResponseBaseController;

/**
 * Created by Eileen on 2017/9/30.
 */

public interface JurisdictionResponseController extends ResponseBaseController<JurisdictionResponseContext> {
    void notAdmin(String msg);
}
