package mycollege.asmobisoft.com.restaurentapp.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mycollege.asmobisoft.com.restaurentapp.R;

/**
 * Created by gaurav on 29/8/17.
 */

public class FragmentSettingTab2 extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_setting_layout2, container, false);

        return v;
    }
}

