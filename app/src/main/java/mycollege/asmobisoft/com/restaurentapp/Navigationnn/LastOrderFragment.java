package mycollege.asmobisoft.com.restaurentapp.Navigationnn;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mycollege.asmobisoft.com.restaurentapp.R;
import mycollege.asmobisoft.com.restaurentapp.activity.ActivityTab1;
import mycollege.asmobisoft.com.restaurentapp.activity.ActivityTab2;
import mycollege.asmobisoft.com.restaurentapp.activity.ActivityTab3;

public class LastOrderFragment extends Fragment {

   /* public LastOrderFragment() {
        // Required empty public constructor
    }
*/

   private FragmentTabHost mTabHost;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mTabHost = new FragmentTabHost(getActivity());
        mTabHost.setup(getActivity(), getChildFragmentManager(), R.layout.fragment_last_order);

        mTabHost.addTab(
                mTabHost.newTabSpec("tab1").setIndicator("July 19", null),
                ActivityTab1.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec("tab2").setIndicator("July 28", null),
                ActivityTab2.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec("tab3").setIndicator("Aug 3", null),
                ActivityTab3.class, null);


        return  mTabHost;

    }

}