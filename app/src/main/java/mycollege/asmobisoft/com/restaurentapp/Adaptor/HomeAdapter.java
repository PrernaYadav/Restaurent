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
 * Created by gaurav on 5/9/17.
 */

public class HomeAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] web;
    private final String[] code;
    private final int[] imageId;
    public HomeAdapter(Activity context,  String[] web,String[] code,  int[] imageId) {
        super(context, R.layout.home_page_row, web);
        this.context = context;
        this.web = web;
        this.code = code;
        this.imageId = imageId;

    }

    TextView txtTitle2;
    TextView  txtTitle1;



    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.home_page_row, null, true);

         txtTitle1 = (TextView) rowView.findViewById(R.id.home_row);

        txtTitle2 = (TextView) rowView.findViewById(R.id.tv_homerow);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.homee);

        txtTitle1.setText(web[position]);
        txtTitle2.setText(code[position]);
        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}


