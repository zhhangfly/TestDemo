package com.example.zb.testdemo.SecondPage;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zb.testdemo.FirstPage.RecyclerView.GameActivity;
import com.example.zb.testdemo.R;
import com.example.zb.testdemo.SecondPage.SecondRecyclerView.Chat;
import com.example.zb.testdemo.SecondPage.SecondRecyclerView.ChatAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LivePartFragment extends Fragment {


    /*____________________________顶部四个资源按钮______________________________________________*/
    private LinearLayout hospital;
    private LinearLayout job;
    private LinearLayout heal;
    private LinearLayout communication;


    private List<Chat> chatList = new ArrayList<>();

    private List<Msg> msgList = new ArrayList<>();
    private final int userIdOne =2;
    private final int userIdTwo =3;

    StringBuilder lastContent = new StringBuilder("我是你的第一个好友~~~");
    StringBuilder lastContentOne = new StringBuilder("我是你的第二个好友~~~");


    public LivePartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("乐生");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_live_part, container, false);
        chatList.clear();
        initChats();
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.secondpager_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        ChatAdapter adapter = new ChatAdapter(chatList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new ChatAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(View view , int position){
                Intent intent = new Intent(getContext(),ChatActivity.class);
                Bundle bundle = new Bundle();
                if(chatList.get(position).getChatName().equals("JLL")){
                    Toast.makeText(getContext(),chatList.get(position).getChatName(),Toast.LENGTH_SHORT).show();
                    initMsglist1();
                    intent.putExtra("userId",userIdOne);
                    intent.putExtra("name",chatList.get(position).getChatName());
                    bundle.putSerializable("first", (Serializable) msgList);
                    intent.putExtras(bundle);
                    startActivityForResult(intent,userIdOne);

                }
                else if(chatList.get(position).getChatName().equals("ZB"))
                {
                    Toast.makeText(getContext(),chatList.get(position).getChatName(),Toast.LENGTH_SHORT).show();
                    initMsgList2();
                    intent.putExtra("userId",userIdTwo);
                    intent.putExtra("name",chatList.get(position).getChatName());
                    bundle.putSerializable("second", (Serializable) msgList);
                    intent.putExtras(bundle);
                    startActivityForResult(intent,userIdTwo);

                }
            }
        });



        return view;
    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        switch (resultCode){
            case userIdOne:
                msgList = (List<Msg>)intent.getSerializableExtra("backMsgList");
                int i = msgList.size();
                String s = msgList.get(i - 1).getContent();
                lastContent.delete(0,lastContent.length());
                lastContent.append(s);
                break;
            case userIdTwo:
                msgList = (List<Msg>)intent.getSerializableExtra("backMsgList");
                int j = msgList.size();
                String t = msgList.get(j - 1).getContent();
                lastContentOne.delete(0,lastContentOne.length());
                lastContentOne.append(t);
                break;
            default:
                break;



        }



    }
    @Override
    public  void onResume(){
        super.onResume();
        onStop();
    }

    private void initChats() {

            Chat chat = new Chat(R.drawable.ic_1,"JLL",lastContent.toString());
            chatList.add(chat);
            Chat chat1 = new Chat(R.drawable.ic_2,"ZB",lastContentOne.toString());
            chatList.add(chat1);
    }
    private void initMsglist1(){
        Msg msg1 = new Msg("Hello JLL.", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("Hello. Who is that?", Msg.TYPE_SENT);
        msgList.add(msg2);
        Msg msg3 = new Msg("Your father. Nice talking to you. ", Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }
    private void initMsgList2(){
        Msg msg1 = new Msg("Hello zb.", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("Hello. Who is that?", Msg.TYPE_SENT);
        msgList.add(msg2);
        Msg msg3 = new Msg("Your daughter. Nice talking to you. ", Msg.TYPE_RECEIVED);
        msgList.add(msg3);

    }

}
