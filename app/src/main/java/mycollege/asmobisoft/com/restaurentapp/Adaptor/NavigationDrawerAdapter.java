package mycollege.asmobisoft.com.restaurentapp.Adaptor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import mycollege.asmobisoft.com.restaurentapp.Model.NavDrawerItem;
import mycollege.asmobisoft.com.restaurentapp.R;

/**
 * Created by Ravi Tamada on 12-gg-2015.
 */
public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.MyViewHolder> {
    List<NavDrawerItem> data = Collections.emptyList();
    ImageView ivTitleIcon;
    int position;
    private LayoutInflater inflater;
    private Context context;

    public NavigationDrawerAdapter(Context context, List<NavDrawerItem> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }


    public void delete(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.nav_drawer_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NavDrawerItem current = data.get(position);


        holder.title.setText(current.getTitle());
        holder.menu.setImageResource(current.getIcon());

        if (position == 1 || position == 2) {
            holder.count.setVisibility(View.VISIBLE);
            holder.count.setText(current.getCount());
        } else {
            holder.count.setVisibility(View.INVISIBLE);
            holder.count.setText(current.getCount());
        }


    }


    @Override
    public int getItemCount() {

        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView menu;
        ImageView icon;
        TextView txtCount;
        TextView count;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            menu = (ImageView) itemView.findViewById(R.id.menu);
            count = (TextView) itemView.findViewById(R.id.tv_count);
        }
    }
}