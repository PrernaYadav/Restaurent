package mycollege.asmobisoft.com.restaurentapp.Navigationnn;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.util.SortedList;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import mycollege.asmobisoft.com.restaurentapp.Adaptor.CustomFavoriteAdapter;
import mycollege.asmobisoft.com.restaurentapp.R;
import mycollege.asmobisoft.com.restaurentapp.activity.ListRowModel;

public class FavoriteFragment extends Fragment {
    ListView simpleList;
    public static final String[] countyName = new String[]{"Burgurs", "Chicken", "Vaggies", "fruits", "Tikki"};
    public static final Integer[] image = {R.mipmap.ice, R.mipmap.chicken, R.mipmap.gg, R.mipmap.ice, R.mipmap.gg};
    public static final String[] countyCode = new String[]{"$7.25", "$8.25", "$2.45", "$11.1", "6.20"};


    List<ListRowModel> listRowItems;
    CustomFavoriteAdapter customListViewAdapter;


    private SortedList myAdapter;

    /* public FavoriteFragment() {
         // Required empty public constructor
     }
 */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_favorite, container, false);


        listRowItems = new ArrayList<ListRowModel>();
        for (int i = 0; i < countyName.length; i++) {
            ListRowModel item = new ListRowModel(image[i], countyName[i], countyCode[i]);
            listRowItems.add(item);
        }


        simpleList = (ListView) rootView.findViewById(R.id.favlv);
        final CustomFavoriteAdapter customListViewAdapter = new CustomFavoriteAdapter(getActivity(), R.layout.favroite_list_row, listRowItems);
        simpleList.setAdapter(customListViewAdapter);
        simpleList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        simpleList.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean check) {
                final int checkedCount = simpleList.getCheckedItemCount();

                mode.setTitle(checkedCount + " Selected");
                customListViewAdapter.toggleSelection(position);
            }


            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                mode.getMenuInflater().inflate(R.menu.multiple_delete, menu);
                return true;

            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.delete:
                        // call getSelectedIds method from customListViewAdapter
                        SparseBooleanArray selected = customListViewAdapter.getSelectedIds();
                        // Captures all selected ids with a loop
                        for (int i = (selected.size() - 1); i >= 0; i--) {
                            if (selected.valueAt(i)) {
                                ListRowModel selectedListItem = customListViewAdapter.getItem(selected.keyAt(i));
                                // Remove selected items using ids
                                customListViewAdapter.remove(selectedListItem);
                            }
                        }
                        mode.finish();
                        return true;
                    default:
                        return false;
                }
            }


            @Override
            public void onDestroyActionMode(ActionMode actionMode) {
                customListViewAdapter.removeSelection();
            }
        });
        return rootView;
    }
}
