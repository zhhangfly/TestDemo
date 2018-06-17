package com.example.zb.testdemo.SecondPage;

import android.content.Intent;

import java.io.Serializable;

/**
 * Created by zb on 2017/10/28.
 */

public class Msg implements Serializable{
    public int leftImageId;

    public  int rightImageId;

    public static final int TYPE_RECEIVED = 0;

    public static final int TYPE_SENT = 1;

    private String content;

    private int type;

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public int getLeftImageId() {
        return leftImageId;
    }

    public int getRightImageId() {
        return rightImageId;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }

    public void setLeftImageId(int leftImageId) {
        this.leftImageId = leftImageId;
    }

    public void setRightImageId(int rightImageId) {
        this.rightImageId = rightImageId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setType(int type) {
        this.type = type;
    }
}