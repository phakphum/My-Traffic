package thailand.eco.phakphum.mytraffic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    //Explicit
    TextView nameTextView , detailTextView; // การประกาศตัวแปรอย่างย่อจะเป็น Private ิัอมัติ
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Bind Widget
        nameTextView = (TextView) findViewById(R.id.textView4);
        detailTextView = (TextView) findViewById(R.id.textView5);
        imageView = (ImageView) findViewById(R.id.imageView2);

        //Get Value From Intent การรับค่าจาก Intent มาตรวจสอย ในที่นี้รับมาจาก MainActivity ดังนี้
        /*      intent.putExtra("Name", nameStrings[position]);
                intent.putExtra("Icon", iconInts[position]);
                intent.putExtra("Index", position);             */
        String strName = getIntent().getStringExtra("Name"); //getString เมื่อค่านั้นเป็น String
        int intIcon = getIntent().getIntExtra("Icon", R.drawable.traffic_01);
        int intIndex = getIntent().getIntExtra("Index", 0);

        //การใช้ Check Logcat
        Log.d("Traffic", "strName ==> " + strName);
        Log.d("Traffic", "intIcon ==> " + intIcon);
        Log.d("Traffic", "intIndex ==> " + intIndex);

        //Show View
        nameTextView.setText(strName);
        imageView.setImageResource(intIcon);

        String[] detailStrings = getResources().getStringArray(R.array.long_data);
        detailTextView.setText(detailStrings[intIndex]);


    }   // Main Method

    public void clickBack(View view) {
        finish();
    }

}   //  Main Class
