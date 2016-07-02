package thailand.eco.phakphum.mytraffic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(),R.raw.horse);
                mediaPlayer.start();

                //Web View
                // Intent ทำหน้าที่ Link จาก Activity 1 ไป Activity 2
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://youtu.be/7_z2Xgy4aPE"));
                startActivity(intent);


            }   // onClick
        });


    }   //Main Method
}   //Main Class หรือ คลาสหลัก
