package mycollege.asmobisoft.com.restaurentapp.Adaptor;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import mycollege.asmobisoft.com.restaurentapp.R;

/**
 * Created by gaurav on 30/8/17.
 */

public class LastOrderListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] web;
    private final int[] imageId;
    public LastOrderListAdapter(Activity context, String[] web, int[] imageId) {
        super(context, R.layout.last_order_row, web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;

    }



    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.last_order_row, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.orderlist);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.orderimgCode);
        txtTitle.setText(web[position]);

        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}
