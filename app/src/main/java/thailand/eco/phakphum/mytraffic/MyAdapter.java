package thailand.eco.phakphum.mytraffic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Phakphum on 03-Jul-16.
 */
public class MyAdapter extends BaseAdapter{

    //Explicit ประกาศตัวแปร
    private Context context;
    private int[] iconInts;
    private String[] nameStrings, detailStrings;

    // Alt + Insert
    // สร้าง Context
    public MyAdapter(Context context,
                     int[] iconInts,
                     String[] nameStrings,
                     String[] detailStrings) {
        this.context = context;
        this.iconInts = iconInts;
        this.nameStrings = nameStrings;
        this.detailStrings = detailStrings;
    }

    @Override
    public int getCount() {
        return iconInts.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        // Open Service
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.my_listview, viewGroup, false);

        // Bind Widget
        ImageView iconImageView = (ImageView) view1.findViewById(R.id.imageView);
        TextView nameTextView = (TextView) view1.findViewById(R.id.textView2);
        TextView detailTextView = (TextView) view1.findViewById(R.id.textView3);

        //Show View
        iconImageView.setImageResource(iconInts[i]);
        nameTextView.setText(nameStrings[i]);
        detailTextView.setText(detailStrings[i]);


        return view1;
    }
} // Main Class
