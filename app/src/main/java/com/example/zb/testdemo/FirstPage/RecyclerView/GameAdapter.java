package com.example.zb.testdemo.FirstPage.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zb.testdemo.R;

import java.util.List;

/**
 * Created by zb on 2017/10/27.
 *
 *FirstPage的RecyclerView
 */

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {

    private Context context;
    private List<Games> mGameList;

    private  StringBuilder stringBuilder= new StringBuilder("");
    private int Count;


    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView GameImage;
        TextView GameName;
        TextView GameEvaluation;

        public ViewHolder(View view){

            super(view);
            cardView = (CardView) view;
            GameImage = (ImageView) view.findViewById(R.id.GameImage);
            GameName = (TextView) view.findViewById(R.id.GameName);
            GameEvaluation = (TextView) view.findViewById(R.id.Game_Evaluation);
        }

    }


    public GameAdapter(List<Games> gameList){
        mGameList =gameList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        if(context == null)
            context=parent.getContext();


        View view= LayoutInflater.from(context).inflate(R.layout.game_item,parent,false);

        final  ViewHolder holder=new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Games game = mGameList.get(position);
                Intent intent = new Intent(context,GameActivity.class);
                intent.putExtra(GameActivity.GAME_NAME,game.getName());
                intent.putExtra(GameActivity.GAME_IMAGE_ID,game.getGameImageId());
                context.startActivity(intent);
            }
        });







        return holder;

    }

    @Override
    public  void onBindViewHolder(ViewHolder holder,int position)
    {

        Games game= mGameList.get(position);
        holder.GameName.setText("名字    :"+game.getName());
        Count = game.getEvaluation();
       for(int i=1;i<=Count;i++)
           stringBuilder.append("★");
        holder.GameEvaluation.setText("推荐指数:"+stringBuilder);
        stringBuilder.delete(0,stringBuilder.length());
        Glide.with(context).load(game.getGameImageId()).into(holder.GameImage);

    }
    @Override
    public int getItemCount(){
        return mGameList.size();
    }

}
