package mycollege.asmobisoft.com.restaurentapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import mycollege.asmobisoft.com.restaurentapp.Adaptor.CustomListAdapter;
import mycollege.asmobisoft.com.restaurentapp.Adaptor.CustomPagerAdapter;
import mycollege.asmobisoft.com.restaurentapp.R;

/**
 * Created by gaurav on 24/8/17.
 */

public class ActivityyPagerr extends AppCompatActivity {
    int minteger = +0;


    ViewPager viewPager;
    int images[] = {R.mipmap.img, R.mipmap.food, R.mipmap.gaura};
    CustomPagerAdapter myCustomPagerAdapter;
    ListView list;
    String[] web = {
            "Gaurav",
            "Shreyansh",
            "Anurag"

    };
    Integer[] imageId = {
            R.mipmap.cake,
            R.mipmap.food,
            R.mipmap.gaurav,


    };
    String[] code = {
            "Comment1",
            "Comment2",
            "Comment3"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityy_pagerr);
        TextView textView = (TextView) findViewById(R.id.integer_number);


        viewPager = (ViewPager) findViewById(R.id.viewPager2);

        myCustomPagerAdapter = new CustomPagerAdapter(ActivityyPagerr.this, images);
        viewPager.setAdapter(myCustomPagerAdapter);
        CustomListAdapter adapter = new CustomListAdapter(ActivityyPagerr.this, web, code, imageId);
        list = (ListView) findViewById(R.id.message_list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(ActivityyPagerr.this, "You Clicked at " + web[+position], Toast.LENGTH_SHORT).show();

            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar9);

        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item);
    }


    public void increaseInteger(View view) {
        minteger = minteger + 1;
        display(minteger);

    }

    public void decreaseInteger(View view) {
        minteger = minteger - 1;
        display(minteger);
    }

    private void display(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.integer_number);
        displayInteger.setText("" + number);


        // add back arrow to toolbar




    }
}




