package mycollege.asmobisoft.com.restaurentapp.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import mycollege.asmobisoft.com.restaurentapp.R;


/**
 * Created by root on 28/7/17.
 */

public class MyCartAdapter extends BaseAdapter {
    Context context;
    String name[];
    int image[];
    LayoutInflater inflter;

    public MyCartAdapter(Context applicationContext, String[] countryList, int[] flags) {
        this.context = context;
        this.name = countryList;
        this.image = flags;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_mycart_row, null);
        TextView country = (TextView)view.findViewById(R.id.label);
        ImageView icon = (ImageView) view.findViewById(R.id.logo);
        country.setText(name[i]);
        icon.setImageResource(image[i]);
        return view;
    }


}