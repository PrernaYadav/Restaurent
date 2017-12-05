package mycollege.asmobisoft.com.restaurentapp.Navigationnn;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import mycollege.asmobisoft.com.restaurentapp.R;
import mycollege.asmobisoft.com.restaurentapp.activity.HomeActivity;
import mycollege.asmobisoft.com.restaurentapp.staggeredgridlayout.GridAdapter;
import mycollege.asmobisoft.com.restaurentapp.staggeredgridlayout.SpacesItemDecoration;

public class MenuFragment extends Fragment {
    Toolbar mToolbar;
    RecyclerView menu_grid;
    ImageView fruit;
    TextView Title;

    int[] imgList = {R.mipmap.d, R.mipmap.fruits, R.mipmap.sal,

    };
    String[] nameList = {"Drinks", "Fruits", "Salads",};
    String[] count = {"20", "30", "18",};
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);


        mToolbar = (Toolbar) rootView.findViewById(R.id.toolbar);


        fruit = (ImageView) rootView.findViewById(R.id.menuimageView2);
        fruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), HomeActivity.class);
                startActivity(i);
            }
        });

        if (mToolbar != null) {
            ((ActionBarActivity) getActivity()).setSupportActionBar(mToolbar);
            ((ActionBarActivity) getActivity()).getSupportActionBar().setTitle("Staggered Grid");
        }

        menu_grid = (RecyclerView) rootView.findViewById(R.id.menu_grid);


        menu_grid.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        GridAdapter adapter = new GridAdapter(getActivity(), imgList, nameList,count);
        menu_grid.setAdapter(adapter);
        SpacesItemDecoration decoration = new SpacesItemDecoration(16);
        menu_grid.addItemDecoration(decoration);

        return rootView;
    }


}

