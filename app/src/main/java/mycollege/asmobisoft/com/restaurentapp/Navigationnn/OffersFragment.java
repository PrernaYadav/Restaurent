package mycollege.asmobisoft.com.restaurentapp.Navigationnn;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mycollege.asmobisoft.com.restaurentapp.Adaptor.OfferPagerAdapter;
import mycollege.asmobisoft.com.restaurentapp.R;

import static mycollege.asmobisoft.com.restaurentapp.R.id.offerviewPager;

public class OffersFragment extends Fragment {

/*    public OffersFragment() {
        // Required empty public constructor
    }
*/

    ViewPager viewPager;
    int images[] = {R.mipmap.img, R.mipmap.img, R.mipmap.img};
    String string[]={"Window Fries","Fresh Vaggies","Classic Double Stuff"};
    String string1[]={"1","2","3"};

    OfferPagerAdapter myOfferPagerAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_offers, container, false);

        viewPager = (ViewPager)rootView.findViewById(offerviewPager);

        OfferPagerAdapter myOfferPagerAdapter = new OfferPagerAdapter(getActivity(), string, string1,images);
        viewPager.setAdapter(myOfferPagerAdapter);


        // Inflate the layout for this fragment
        return rootView;
    }

}