package thailand.eco.phakphum.mytraffic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    //Explicit การประกาศตัวแปร ต้องทำการประกาศทุกครั้งเพื่อจองหน่วยความจำเครื่อง
    // มีรูปแบบ = [Access] [DataType] [Name]
    // [Access] = Public(ใช้นอกคลาสได้) , Private (ใช้ในคลาส)
    // Completement Key= Shift+Ctrl+Enter
    private ListView trafficListView;
    private Button aboutMeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget คือการผูกความสัมพันธ์ ระหว่าง ตัวแปร กับ Widget ใน Android
        // จะมีก่ารทำ Cast to เสมอ Alt+Enter
        trafficListView = (ListView) findViewById(R.id.listView);
        aboutMeButton = (Button) findViewById(R.id.button);

        //Controller for Button
        //Ctrl+Space Bar = ขอคำแนะนำ หลัง new
        aboutMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Sound Effect
                // ส้ราง Class ย่อย
                // กด Ctrl ค้างไว้ใน () เพื่อตรวจสอบ parameter ที่ต้องใส่
                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.horse);
                mediaPlayer.start();

                //Web View
                // Intent ทำหน้าที่ Link จาก Activity 1 ไป Activity 2 (ในที่นี้คือ web view จึงใช้ ACTION_VIEW
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://youtu.be/7_z2Xgy4aPE"));
                startActivity(intent);


            }   // onClick
        });

        //Create ListView
        //1. การทำ Setter array Simple ** ง่ายสุด ธรรมชาติ
        final int[] iconInts = new int[20];
        iconInts[0] = R.drawable.traffic_01;
        iconInts[1] = R.drawable.traffic_02;
        iconInts[2] = R.drawable.traffic_03;
        iconInts[3] = R.drawable.traffic_04;
        iconInts[4] = R.drawable.traffic_05;
        iconInts[5] = R.drawable.traffic_06;
        iconInts[6] = R.drawable.traffic_07;
        iconInts[7] = R.drawable.traffic_08;
        iconInts[8] = R.drawable.traffic_09;
        iconInts[9] = R.drawable.traffic_10;
        iconInts[10] = R.drawable.traffic_11;
        iconInts[11] = R.drawable.traffic_12;
        iconInts[12] = R.drawable.traffic_13;
        iconInts[13] = R.drawable.traffic_14;
        iconInts[14] = R.drawable.traffic_15;
        iconInts[15] = R.drawable.traffic_16;
        iconInts[16] = R.drawable.traffic_17;
        iconInts[17] = R.drawable.traffic_18;
        iconInts[18] = R.drawable.traffic_19;
        iconInts[19] = R.drawable.traffic_20;

        //2. Call Value From xml **รูปแบบการทำงานร่วมกับ ทีม Copy Editor
        final String[] nameStrings = getResources().getStringArray(R.array.name);

        //3. Call Value From Java ** ต้องทำการสร้าง Data ในไฟล์ Class.java ก่อน
        // แล้วสร้าง Object **
        MyData myData = new MyData();   // ** Create object or instance
        String[] detailStrings = myData.getDetailStrings();

        //Inheriate to MyAdapter
        MyAdapter myAdapter = new MyAdapter(this, iconInts, nameStrings, detailStrings);
        trafficListView.setAdapter(myAdapter);

        //Intent to Detail(DetailActivity) When Click
        trafficListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //การ Intent จาก MainActivity ไป DetailActivity
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("Name", nameStrings[position]);
                intent.putExtra("Icon", iconInts[position]);
                intent.putExtra("Index", position);
                startActivity(intent);  //เปิดหน้าใหม่ DetailActivity ตามที่ Intent มา

            }// onItemClick
        });

    }   //Main Method

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}   //Main Class หรือ คลาสหลัก
