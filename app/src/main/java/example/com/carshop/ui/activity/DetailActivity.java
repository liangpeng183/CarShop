package example.com.carshop.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import example.com.carshop.R;

public class DetailActivity extends AppCompatActivity {

    private TextView tv1;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tv1 = findViewById(R.id.detail_tv1);
        iv = findViewById(R.id.iv_car);

        Intent intent = getIntent();
        String data1 = intent.getStringExtra("data1");
        Bitmap bitmap = intent.getParcelableExtra("image");

        tv1.setText(data1);
        iv.setImageBitmap(bitmap);
    }
}
