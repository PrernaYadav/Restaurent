package mycollege.asmobisoft.com.restaurentapp.staggeredgridlayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import mycollege.asmobisoft.com.restaurentapp.Navigationnn.MenuFragment;
import mycollege.asmobisoft.com.restaurentapp.R;

/**
 * Created by Suleiman on 26-07-2015.
 */
public class GridAdapter extends RecyclerView.Adapter<GridAdapter.MasonryView> {

    private Context context;
    int[] imgList;
    String[] nameList;
    String[] count;

    public GridAdapter(Context context, int[]imgList, String[]nameList,String[]count) {
        this.context = context;
        this.imgList=imgList;
        this.nameList=nameList;
        this.count=count;
    }

    public GridAdapter(MenuFragment menuFragment) {
    }

    @Override
    public MasonryView onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, null);
        MasonryView holder=new MasonryView(layoutView);
        return holder;
    }

    @Override
    public void onBindViewHolder(MasonryView holder, int position) {
        holder.imageView.setImageResource(imgList[position]);
        holder.textView1.setText(count[position]);
        holder.textView.setText(nameList[position]);



    }

    @Override
    public int getItemCount() {
        return nameList.length;
    }

    class MasonryView extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView textView1;

        public MasonryView(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.img);
            textView1 = (TextView) itemView.findViewById(R.id.tv_count);

            textView = (TextView) itemView.findViewById(R.id.tv_name);


        }
    }
}
