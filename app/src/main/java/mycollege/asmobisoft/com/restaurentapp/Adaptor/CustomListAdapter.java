package mycollege.asmobisoft.com.restaurentapp.Adaptor;

/**
 * Created by gaurav on 24/8/17.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import mycollege.asmobisoft.com.restaurentapp.R;

public class CustomListAdapter extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] web;
    private final String[] code;
    private final Integer[] imageId;
    public CustomListAdapter(Activity context, String[] web, String[] code, Integer[] imageId) {
        super(context, R.layout.list_row, web);
        this.context = context;
        this.web = web;
        this.code = code;
        this.imageId = imageId;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_row, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.list_row);
        TextView txtTitle1 = (TextView) rowView.findViewById(R.id.txtDescription);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imgCode);
        txtTitle.setText(web[position]);
        txtTitle1.setText(code[position]);

        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}