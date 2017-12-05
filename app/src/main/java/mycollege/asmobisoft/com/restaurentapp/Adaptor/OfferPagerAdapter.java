package mycollege.asmobisoft.com.restaurentapp.Adaptor;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import mycollege.asmobisoft.com.restaurentapp.R;

/**
 * Created by gaurav on 25/8/17.
 */


public class OfferPagerAdapter extends PagerAdapter {
    Context context;
    int images[];
    String price[];
    String product[];
    LayoutInflater layoutInflater;
    String name[];
    String string[];
    String string1[];
    TextView textView;

    public OfferPagerAdapter(Context context, String string[], String string1[], int images[]) {
        this.context = context;
        this.images = images;
        this.string = string;
        this.string1 = string1;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = layoutInflater.inflate(R.layout.pager_offer_item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.offerimg);


        TextView textView = (TextView) itemView.findViewById(R.id.tv_offer);
        TextView textView1 = (TextView) itemView.findViewById(R.id.tv_offer1);


        textView.setText(string[position]);
        textView1.setText(string1[position]);
        imageView.setImageResource(images[position]);


        container.addView(itemView);

        //listening to image click
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "you clicked image " + (position + 1), Toast.LENGTH_LONG).show();
            }
        });

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}