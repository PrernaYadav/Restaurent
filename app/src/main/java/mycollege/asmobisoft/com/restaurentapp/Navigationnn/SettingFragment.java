package mycollege.asmobisoft.com.restaurentapp.Navigationnn;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import mycollege.asmobisoft.com.restaurentapp.R;

public class SettingFragment extends Fragment {

   /* public SettingFragment() {
        // Required empty public constructor
    }*/

    private FragmentTabHost mTabHost;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_setting, container, false);

        TabHost host = (TabHost)rootView.findViewById(R.id.tabhost);
        host.setup();
        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Tab One");
        spec.setContent(R.id.tab1);
        spec.setIndicator("My Addresses");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Tab Two");
        spec.setContent(R.id.tab2);
        spec.setIndicator("My Cards");
        host.addTab(spec);
return  rootView;
    }


}