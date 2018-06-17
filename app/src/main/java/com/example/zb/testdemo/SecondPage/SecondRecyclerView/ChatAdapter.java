package com.example.zb.testdemo.SecondPage.SecondRecyclerView;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zb.testdemo.R;

import java.util.List;

/**
 * Created by zb on 2017/10/28.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> implements View.OnClickListener{

    private List<Chat> mChatList;

    //define interface
        public static interface OnItemClickListener {
            void onItemClick(View view , int position);
        }

    private OnItemClickListener mOnItemClickListener = null;
    public ChatAdapter(List<Chat> mBhatList) {
        this.mChatList = mBhatList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(this);
        return holder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Chat chat = mChatList.get(position);
        holder.textViewName.setText(chat.getChatName());
        holder.textViewContent.setText(chat.getChatContent());
        holder.imageViewHeadImage.setImageResource(chat.getChatImageId());
        holder.itemView.setTag(position);

    }
    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }

    @Override
    public int getItemCount() {
        return mChatList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewContent;
        ImageView imageViewHeadImage;
        public ViewHolder(View view) {
            super(view);
            textViewName = (TextView)view.findViewById(R.id.chat_name);
            textViewContent = (TextView)view.findViewById(R.id.chat_context);
            imageViewHeadImage = (ImageView) view.findViewById(R.id.second_pager_head_image);

        }
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}
