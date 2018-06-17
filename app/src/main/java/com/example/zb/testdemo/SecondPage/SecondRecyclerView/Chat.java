package com.example.zb.testdemo.SecondPage.SecondRecyclerView;

import android.widget.ImageView;

/**
 * Created by zb on 2017/10/28.
 */

public class Chat {
    private int chatImageId;
    private String chatName;
    private String chatContent;

    public Chat(int chatImageId, String chatName, String chatContent) {
        this.chatImageId = chatImageId;
        this.chatName = chatName;
        this.chatContent = chatContent;
    }

    public int getChatImageId() {
        return chatImageId;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public String getChatContent() {
        return chatContent;
    }

    public void setChatImageId(int chatImageId) {
        this.chatImageId = chatImageId;
    }

    public void setChatContent(String chatContent) {
        this.chatContent = chatContent;
    }
}
