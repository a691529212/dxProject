package com.yktong.dogodgod.tool.datebase;

import java.util.ArrayList;

/**
 * Created by vampire on 2017/9/28.
 */

public interface OnQueryListener<T> {
    <T> void queryLinster(ArrayList<T> result);
}
