package com.example.zb.testdemo.FirstPage.RecyclerView;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zb.testdemo.R;

public class GameActivity extends AppCompatActivity {

    public static final  String GAME_NAME = "game_name";
    public static  final String  GAME_IMAGE_ID= "game_image_id";
    public static final String GAME_EVALUATION = "game_evaluation";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        Intent intent = getIntent();
        String gameName = intent.getStringExtra(GAME_NAME);
        int gameImageID  = intent.getIntExtra(GAME_IMAGE_ID,0);
        String gameEvaluation = intent.getStringExtra(GAME_EVALUATION);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toobar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.activity_game_collapsing_toolbar);
        ImageView gameImageView = (ImageView)findViewById(R.id.game_image_view);
        TextView gameContentTextView = (TextView)findViewById(R.id.game_content_view);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar !=null){
             actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle(gameName);
        Glide.with(this).load(gameImageID).into(gameImageView);
        String gameContent = generateGameContent("测试内容    :"+gameName);
        gameContentTextView.setText(gameContent);







    }

    private String generateGameContent(String s) {
        StringBuilder stringBuilder = new StringBuilder("");
        for(int i = 0;i <=50 ;i++)
            stringBuilder.append(s);
        return stringBuilder.toString();

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
