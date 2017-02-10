package com.example.eleteam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    private Handler handler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//
//            String obj = (String) msg.obj;
//
//            if (msg.what == 0) {
//                Gson gson = new Gson();
//                FeaturedPriceData featuredPriceData = gson.fromJson(obj, FeaturedPriceData.class);
//                tv_json.setText(obj);
//
//            }
//
//
//        }
//    };
//    private TextView tv_json;

    //图片
    private int mImages[] = {R.mipmap.tab_home, R.mipmap.tab_topic, R.mipmap.main_index_cart_normal, R.mipmap.main_index_my_normal};


    // 标题
    private String mFragmentTags[] = {
            "月光茶人",
            "优惠",
            "购物车",
            "我的"
    };
    private TextView title;
    private NewsFragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        tv_json = (TextView) findViewById(R.id.tv_json);
//
//        initData();

        title = (TextView) findViewById(R.id.title);
        mTabHost = (NewsFragmentTabHost) findViewById(R.id.tabhost);

        mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        mTabHost.getTabWidget().setDividerDrawable(null);

        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Log.d(getLocalClassName(), tabId);
                title.setText(tabId);
            }
        });

        Bundle bundle = null;

        for (int i = 0; i < mImages.length; i++) {


            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mFragmentTags[i]).setIndicator(getImageView(i, mFragmentTags[i]));

            bundle = new Bundle();
            mTabHost.addTab(tabSpec, FragmentTab.class, bundle);

            mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.color.pedo_actionbar_bkg);

        }


    }


    private View getImageView(int index, String str) {

        View view = getLayoutInflater().inflate(R.layout.view_tab_indicator, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.tab_iv_image);
        TextView label = (TextView) view.findViewById(R.id.tab_label);
        label.setText(str);
        imageView.setImageResource(mImages[index]);


        return view;
    }


//    private void initData() {
//
//        //创建okHttpClient对象
//        OkHttpClient mOkHttpClient = new OkHttpClient();
////创建一个Request
//        final Request request = new Request.Builder()
//                .url("http://eleteamapi.ygcr8.com/v1/product/list-featured-price")
//                .build();
////new call
//        Call call = mOkHttpClient.newCall(request);
////请求加入调度
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Request request, IOException e) {
//            }
//
//            @Override
//            public void onResponse(final Response response) throws IOException {
//                String htmlStr = response.body().string();
//
//                handler.obtainMessage(0, htmlStr).sendToTarget();
//
//            }
//        });
//
//
//    }

}
