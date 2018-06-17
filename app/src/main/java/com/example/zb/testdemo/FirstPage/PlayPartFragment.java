package com.example.zb.testdemo.FirstPage;


        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.support.v4.widget.SwipeRefreshLayout;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.support.v7.widget.Toolbar;
        import android.view.LayoutInflater;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.Toast;

        import com.bigkoo.convenientbanner.ConvenientBanner;
        import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
        import com.bigkoo.convenientbanner.listener.OnItemClickListener;
        import com.example.zb.testdemo.FirstPage.RecyclerView.GameAdapter;
        import com.example.zb.testdemo.FirstPage.RecyclerView.Games;
        import com.example.zb.testdemo.R;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayPartFragment extends Fragment {
    private int[] mImages  = {R.drawable.ic_1,R.drawable.ic_2,R.drawable.ic_3,R.drawable.ic_4};//轮播图图源
    private ArrayList mImageList = new ArrayList<Integer>(){{add(mImages[0]);add(mImages[1]);add(mImages[2]);add(mImages[3]);}};
    private ConvenientBanner mCb;//轮播图
    private SwipeRefreshLayout swipeRefresh;//下拉刷新



    /*------------------------------------------测试数据---------------------------------------------*/
    private Games[] games = {new Games(R.drawable.test_1,"测试一",5),new Games(R.drawable.test_2,"测试二",4),new Games(R.drawable.test_3,"测试三",3),
            new Games(R.drawable.test_4,"测试四",1),new Games(R.drawable.test_5,"测试五",2),new Games(R.drawable.test_6,"测试六",1),
            new Games(R.drawable.ic_1,"测试七",2),new Games(R.drawable.ic_2,"测试8",3),new Games(R.drawable.ic_3,"测试9",3),
            new Games(R.drawable.ic_4,"测试ten",5),
    };
    private List<Games> test= new ArrayList<>();
    private GameAdapter adapter;
       /*------------------------------------------测试数据---------------------------------------------*/


    public PlayPartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play_part,container,false);
        mCb = (ConvenientBanner) view.findViewById(R.id.TurningPage);//初始化轮播图
        initDatas();//轮播图图片数据
        initListener();//轮播图点击事件
        setHasOptionsMenu(true);//确保Menu被加载


        initGames();
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.first_page_recyclerView);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new GameAdapter(test);
        recyclerView.setAdapter(adapter);
        /*_________________________________下拉刷新__________________________________________*/
        swipeRefresh = (SwipeRefreshLayout)view.findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshGames();
            }
        });
        /*_____________________________________点击事件模块________________________________________________*/



        // Inflate the layout for this fragment
        return view;
    }

    private void refreshGames() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initGames();
                        adapter.notifyDataSetChanged();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    private  void initGames(){
        test.clear();
        for(int i= 0 ;i<= 30;i++)
        {
            Random random = new Random();
            int index = random.nextInt(games.length);
            test.add(games[index]);
        }
    }

    private void initDatas() {

        mCb.setPages(new CBViewHolderCreator<ImageViewHolder>() {
            @Override
            public ImageViewHolder createHolder() {
                return new ImageViewHolder();
            }
        },mImageList)
                .setPageIndicator(new int[] {R.drawable.ponit_normal,R.drawable.point_select}) //设置两个点作为指示器
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL); //设置指示器的方向水平居中
//        mCb.setCanLoop(true);

    }
    @Override
    public void onResume() {
        super.onResume();

        mCb.startTurning(2000);      //设置开始轮播以及轮播时间
    }
    @Override
    public void onPause() {
        if(mCb!=null){
            mCb.stopTurning();   //停止轮播
        }
        super.onPause();
    }

    private void initListener() {

        mCb.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getActivity(),"点击了条目"+position,Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();//不清空就会变成添加进来而不是替换
        inflater.inflate(R.menu.toolbar, menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.location:
                break;
            default:
        }
        return  true;
    }


}
