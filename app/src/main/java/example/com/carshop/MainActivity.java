package example.com.carshop;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import example.com.carshop.adapt.MainAdapt;
import example.com.carshop.ui.fragment.Home_frag;
import example.com.carshop.ui.fragment.My_frag;
import example.com.carshop.ui.fragment.Store_frag;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayout shouye,shangcheng,wode;
    private ImageView iv1,iv2,iv3;
    private TextView tv1,tv2,tv3;
    private ViewPager vpContent;
    private MainAdapt mainAdapt;
    private List<Fragment> fragmentList;
    private Fragment homefrag,storefrag;
    private My_frag mefrag;

    private TextView setting;
    public  String name,name1;
    private  int currentIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initTab();

        Intent intent = getIntent();
        name = intent.getStringExtra("Who");
        Log.i("",  name +"  正在线上!");
        Bundle bundle = new Bundle();
        bundle.putString("data",name);
        mefrag.setArguments(bundle);

    }


    private void initTab() {

        fragmentList = new ArrayList<>();
        homefrag =new Home_frag();
        storefrag = new Store_frag();
        mefrag = new My_frag();
        fragmentList.add(homefrag);
        fragmentList.add(storefrag);
        fragmentList.add(mefrag);

        mainAdapt = new MainAdapt(getSupportFragmentManager(),fragmentList);
        vpContent.setAdapter(mainAdapt);
        vpContent.setCurrentItem(currentIndex);
        currentIndex = 0;
        initFragSta();
        vpContent.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                  currentIndex = position;
                  initFragSta();
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    private void initView() {

        shouye = findViewById(R.id.shouye);
        shangcheng = findViewById(R.id.shangcheng);
        wode = findViewById(R.id.wode);
        iv1 = findViewById(R.id.iv1);
        iv2 = findViewById(R.id.iv2);
        iv3 = findViewById(R.id.iv3);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        vpContent = findViewById(R.id.vpContent);

        shouye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = 0;
                initFragSta();
            }
        });
        shangcheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = 1;
                initFragSta();
            }
        });
        wode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = 2;
                initFragSta();
            }
        });
    }

    private void initFragSta() {
        tv1.setTextColor(getResources().getColor(R.color.black));
        tv2.setTextColor(getResources().getColor(R.color.green));
        tv3.setTextColor(getResources().getColor(R.color.yellow));

        iv1.setImageResource(R.mipmap.main);
        iv2.setImageResource(R.mipmap.store);
        iv3.setImageResource(R.mipmap.me);

        if(currentIndex == 0)  //首页
        {
            tv1.setTextColor(getResources().getColor(R.color.red));
            //iv1.setImageResource(R.mipmap.car0);
        }else if(currentIndex == 1)//商城
        {
            tv2.setTextColor(getResources().getColor(R.color.gray));
            //iv2.setImageResource(R.mipmap.car1);
        }else//我的
        {
            tv3.setTextColor(getResources().getColor(R.color.colorAccent));
            //iv3.setImageResource(R.mipmap.car2);
        }

        vpContent.setCurrentItem(currentIndex);
    }


}
