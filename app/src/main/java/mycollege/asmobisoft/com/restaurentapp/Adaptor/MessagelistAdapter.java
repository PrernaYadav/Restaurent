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
 * Created by jamiepatel on 22/09/2015.
 */
public class MessagelistAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] Code;
    private final String[] web;
    private final Integer[] imageId;
    public MessagelistAdapter(Activity context, String[] web, String[] code, Integer[] imageId) {
        super(context, R.layout.list_row, web);
        this.context = context;
        this.web = web;
        this.Code = code;
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
        txtTitle1.setText(Code[position]);
        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}