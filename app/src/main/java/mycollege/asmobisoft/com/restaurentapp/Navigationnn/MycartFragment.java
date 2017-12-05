package mycollege.asmobisoft.com.restaurentapp.Navigationnn;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import mycollege.asmobisoft.com.restaurentapp.Adaptor.MyCartAdapter;
import mycollege.asmobisoft.com.restaurentapp.R;
import mycollege.asmobisoft.com.restaurentapp.activity.OrderingActivity;

public class MycartFragment extends Fragment {

   /* public MycartFragment() {
        // Required empty public constructor
    }*/
   ListView simpleList;
    String name[] = {"Burgurs", "Chicken", "Vaggies",};
    int image[] = {R.mipmap.ice, R.mipmap.chicken, R.mipmap.gg};

TextView textbuy;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_my_cart, container, false);


        textbuy=(TextView)rootView.findViewById(R.id.tv_buy);
        textbuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent (getActivity(), OrderingActivity.class);
                startActivity(i);
            }
        });


        simpleList = (ListView)rootView.findViewById(R.id.lv);
        MyCartAdapter myCartAdapter = new MyCartAdapter(getActivity(), name, image);
        simpleList.setAdapter(myCartAdapter);

        // Inflate the layout for this fragment
        return rootView;
    }


}