package mycollege.asmobisoft.com.restaurentapp.Adaptor;

import android.app.Activity;
import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mycollege.asmobisoft.com.restaurentapp.R;
import mycollege.asmobisoft.com.restaurentapp.activity.ListRowModel;

public class CustomFavoriteAdapter extends ArrayAdapter<ListRowModel> {
    Context context;
    private  SparseBooleanArray selectedListItemsIds;
    List multipleSelectionList;

    public CustomFavoriteAdapter(Context context, int resourceId, List items) {
        super(context, resourceId, items);
        this.context = context;
        selectedListItemsIds = new SparseBooleanArray();
        this.multipleSelectionList = items;
    }
    /*private view holder class*/
    private class ViewHolder {
        ImageView imgCountryFlag;
        TextView txtCountryName;
        TextView txtCountryCode;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        ListRowModel rowItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.favroite_list_row, null);
            holder = new ViewHolder();
            holder.txtCountryCode = (TextView) convertView.findViewById(R.id.favdes);
            holder.txtCountryName = (TextView) convertView.findViewById(R.id.favlabel);
            holder.imgCountryFlag = (ImageView) convertView.findViewById(R.id.favlogo);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.txtCountryCode.setText(rowItem.getCountryCode());
        holder.txtCountryName.setText(rowItem.getCountryName());
        holder.imgCountryFlag.setImageResource(rowItem.getImageId());

        return convertView;
    }

    @Override
    public void remove(ListRowModel object) {
        multipleSelectionList.remove(object);
        notifyDataSetChanged();
    }

    public void toggleSelection(int position) {
        selectView(position, !selectedListItemsIds.get(position));
    }

    public void removeSelection() {
        selectedListItemsIds = new SparseBooleanArray();
        notifyDataSetChanged();
    }

    public void selectView(int position, boolean value) {
        if (value)
            selectedListItemsIds.put(position, value);
        else
            selectedListItemsIds.delete(position);
        notifyDataSetChanged();
    }

    public int getSelectedCount() {
        return selectedListItemsIds.size();
    }

    public SparseBooleanArray getSelectedIds() {
        return selectedListItemsIds;
    }

}