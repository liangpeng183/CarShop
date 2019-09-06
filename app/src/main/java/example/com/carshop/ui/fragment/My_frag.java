package example.com.carshop.ui.fragment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import example.com.carshop.R;
import example.com.carshop.MyCarKu;
import example.com.carshop.ui.activity.PersonActivity;

public class My_frag extends Fragment implements View.OnClickListener {


    private TextView textView,tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10;
    private ImageView ivPerson;
    private LinearLayout layout1,layout2,layout3;
    private TextView guanzhu,fensi,dongtai;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_me,container,false);
        layout1 = view.findViewById(R.id.layout1);
        layout2 = view.findViewById(R.id.layout2);
        layout3 = view.findViewById(R.id.layout3);
        layout1.setOnClickListener(this);
        layout2.setOnClickListener(this);
        layout3.setOnClickListener(this);

        guanzhu = view.findViewById(R.id.guanzhu);
        fensi = view.findViewById(R.id.fensi);
        dongtai = view.findViewById(R.id.dongtai);
        textView  = view.findViewById(R.id.who);

        tv5 = view.findViewById(R.id.tv_collect);
        tv5.setClickable(true);
        tv5.setOnClickListener(this);
        Log.i("","我的界面");
        ivPerson = view.findViewById(R.id.iv_goPerson);
        ivPerson.setOnClickListener(this);
        //
        tv1 = view.findViewById(R.id.tv_money);
        tv2 = view.findViewById(R.id.tv_user);
        tv3 = view.findViewById(R.id.tv_addr);
        tv4 = view.findViewById(R.id.tv_moreCar);
        //tv5 = view.findViewById(R.id.tv_collect);
        tv6 = view.findViewById(R.id.tv_find);
        tv7 = view.findViewById(R.id.tv_kefu);
        tv8 = view.findViewById(R.id.tv_fankui);
        tv9 = view.findViewById(R.id.tv_juan);
        tv10 = view.findViewById(R.id.tv_about);

        Drawable d1 = getResources().getDrawable(R.mipmap.money);
        d1.setBounds(0,0,60,60);
        tv1.setCompoundDrawables(d1,null,null,null);

        Drawable d2 = getResources().getDrawable(R.mipmap.person);
        d2.setBounds(0,0,60,60);
        tv2.setCompoundDrawables(d2,null,null,null);

        Drawable d3 = getResources().getDrawable(R.mipmap.dizhi);
        d3.setBounds(0,0,60,60);
        tv3.setCompoundDrawables(d3,null,null,null);

        Drawable d4 = getResources().getDrawable(R.mipmap.gj1);
        d4.setBounds(0,0,60,60);
        tv4.setCompoundDrawables(d4,null,null,null);

        Drawable d5 = getResources().getDrawable(R.mipmap.gj2);
        d5.setBounds(0,0,60,60);
        tv5.setCompoundDrawables(d5,null,null,null);

        Drawable d6 = getResources().getDrawable(R.mipmap.gj3);
        d6.setBounds(0,0,60,60);
        tv6.setCompoundDrawables(d6,null,null,null);

        Drawable d7 = getResources().getDrawable(R.mipmap.kefu);
        d7.setBounds(0,0,60,60);
        tv7.setCompoundDrawables(d7,null,null,null);

        Drawable d8 = getResources().getDrawable(R.mipmap.fankui);
        d8.setBounds(0,0,60,60);
        tv8.setCompoundDrawables(d8,null,null,null);

        Drawable d9 = getResources().getDrawable(R.mipmap.juan);
        d9.setBounds(0,0,60,60);
        tv9.setCompoundDrawables(d9,null,null,null);

        Drawable d10 = getResources().getDrawable(R.mipmap.about);
        d10.setBounds(0,0,60,60);
        tv10.setCompoundDrawables(d10,null,null,null);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
         if (getArguments() != null){
             textView.setText("懂车帝--"+getArguments().getString("data"));
             Log.d("方法--：","接收数据成功！");
         }else{
             Log.d("方法--：","接收数据不成功！");
         }
    }

    //
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout1:
                int num = Integer.valueOf(guanzhu.getText().toString())+1;
                guanzhu.setText(String.valueOf(num));
                break;
                case R.id.layout2:

                break;
                case R.id.layout3:

                break;
            case R.id.tv_collect:
                Intent intent = new Intent(getActivity(), MyCarKu.class);//获得当前活动
                startActivity(intent);
                break;
            case R.id.iv_goPerson:
                Intent intentPerson = new Intent(getActivity(), PersonActivity.class);
                startActivity(intentPerson);
                break;

        }

    }


}
