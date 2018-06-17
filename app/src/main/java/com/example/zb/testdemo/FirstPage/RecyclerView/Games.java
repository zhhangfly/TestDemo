package com.example.zb.testdemo.FirstPage.RecyclerView;

import android.widget.ImageView;

/**
 * Created by zb on 2017/10/26.
 */

public class Games {
    private int GameImageId;//活动资源id
    private String name;//活动名称
    private int evaluation;//活动评价

    public Games(int gameImageId, String name, int evaluation) {
        GameImageId = gameImageId;
        this.name = name;
        this.evaluation = evaluation;
    }

    public int getGameImageId() {
        return GameImageId;
    }

    public String getName() {
        return name;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setGameImageId(int gameImageId) {
        GameImageId = gameImageId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }
}
