package example.com.carshop.ui.fragment;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import example.com.carshop.ui.activity.DetailActivity;
import example.com.carshop.util.DBOpenHelper;

public class Store_frag extends Fragment implements View.OnClickListener {

    private LinearLayout layout ;
    SQLiteOpenHelper helper;
    private ImageView iv1,iv2,iv3,iv4,iv5,iv6;
    private TextView tv1,tv2,tv3,tv4,tv5,tv6;
    private Bitmap bitmap;
    byte[] buff = new byte[125*250];

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_store,container,false);
        layout = view.findViewById(R.id.search);

        iv1 = view.findViewById(R.id.show_iv1);
        iv1.setOnClickListener(this);
        iv2 = view.findViewById(R.id.show_iv2);
        iv2.setOnClickListener(this);
        iv3 = view.findViewById(R.id.show_iv3);
        iv3.setOnClickListener(this);
        iv4 = view.findViewById(R.id.show_iv4);
        iv4.setOnClickListener(this);
        iv5 = view.findViewById(R.id.show_iv5);
        iv5.setOnClickListener(this);
        iv6 = view.findViewById(R.id.show_iv6);
        iv6.setOnClickListener(this);

        tv1 = view.findViewById(R.id.show_tv1);
        tv2 = view.findViewById(R.id.show_tv2);
        tv3 = view.findViewById(R.id.show_tv3);
        tv4 = view.findViewById(R.id.show_tv4);
        tv5 = view.findViewById(R.id.show_tv5);
        tv6 = view.findViewById(R.id.show_tv6);

        helper = new DBOpenHelper(getActivity());
        SQLiteDatabase db = helper.getReadableDatabase();

        return view;
    }

    public void setImage(){
        helper = new DBOpenHelper(getActivity());
        SQLiteDatabase db = helper.getReadableDatabase();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.show_iv1:
                bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.car5);
               // buff = new byte[bitmap];
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("data1","lp");
                //intent.putExtra("image",bitmap);
                Log.d("","跳啊跳");
                startActivity(intent);
                Log.d("","跳啊跳");
                break;
            case R.id.show_iv2:
                Intent intent1 = new Intent(getActivity(), DetailActivity.class);
                intent1.putExtra("data1","lp1");
                startActivity(intent1);
                break;
            case R.id.show_iv3:
                Intent intent2 = new Intent(getActivity(), DetailActivity.class);
                intent2.putExtra("data1","lp2");
                startActivity(intent2);

                break;
            case R.id.show_iv4:
                Intent intent3 = new Intent(getActivity(), DetailActivity.class);
                intent3.putExtra("data1","lp3");
                startActivity(intent3);

                break;
            case R.id.show_iv5:
                Intent intent4 = new Intent(getActivity(), DetailActivity.class);
                intent4.putExtra("data1","lp4");
                startActivity(intent4);

                break;
            case R.id.show_iv6:
                Intent intent5 = new Intent(getActivity(), DetailActivity.class);
                intent5.putExtra("data1","lp5");
                startActivity(intent5);

                break;
        }

    }


}
