package mycollege.asmobisoft.com.restaurentapp.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import mycollege.asmobisoft.com.restaurentapp.Adaptor.LastOrderListAdapter;
import mycollege.asmobisoft.com.restaurentapp.R;

public class ActivityTab3 extends Fragment  {
    ListView list;
    ListView simpleList;
    String name[] = {"Burgurs", "Chicken", "Vaggies"};
    int image[] = {R.mipmap.ice, R.mipmap.chicken, R.mipmap.gg};
    TabLayout tabLayout;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab3, container, false);



        simpleList = (ListView)v.findViewById(R.id.list);
        final LastOrderListAdapter listAdapter = new LastOrderListAdapter(getActivity(), name, image);
        simpleList.setAdapter(listAdapter);



        return v;


    }

}