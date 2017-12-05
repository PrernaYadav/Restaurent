package mycollege.asmobisoft.com.restaurentapp.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import mycollege.asmobisoft.com.restaurentapp.Adaptor.CustomPagerAdapter;
import mycollege.asmobisoft.com.restaurentapp.Adaptor.MessagelistAdapter;
import mycollege.asmobisoft.com.restaurentapp.R;

public class PagerActivity extends AppCompatActivity {
    int minteger = +0;

    CustomPagerAdapter myCustomPagerAdapter;
    ViewPager viewPager;
    int images[] = {R.mipmap.img, R.mipmap.food, R.mipmap.gaura};


    MessagelistAdapter adapter;
    ListView list;
    String[] web = {
            "Anurag",
            "Shreyansh",
            "Gaurav"

    };
    Integer[] imageId = {
            R.mipmap.cake,
            R.mipmap.food,
            R.mipmap.gaurav


    };
    String[] code = {
            "Comment1",
            "Comment2",
            "Comment3"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);

        TextView txtcart = (TextView) findViewById(R.id.tv_addcart);
        txtcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PagerActivity.this, ActivityyPagerr.class);
                startActivity(i);
            }
        });


        viewPager = (ViewPager) findViewById(R.id.viewPager);
        myCustomPagerAdapter = new CustomPagerAdapter(PagerActivity.this, images);
        viewPager.setAdapter(myCustomPagerAdapter);


        adapter = new MessagelistAdapter(PagerActivity.this, web, code, imageId);
        list = (ListView) findViewById(R.id.message_list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(PagerActivity.this, "You Clicked at " + web[+position], Toast.LENGTH_SHORT).show();

            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar10);

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

}


