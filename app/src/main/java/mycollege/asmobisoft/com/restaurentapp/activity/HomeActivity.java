package mycollege.asmobisoft.com.restaurentapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import mycollege.asmobisoft.com.restaurentapp.Adaptor.HomeAdapter;
import mycollege.asmobisoft.com.restaurentapp.R;

/**
 * Created by gaurav on 5/9/17.
 */

public class HomeActivity extends AppCompatActivity {
    int images[] = {R.mipmap.cake, R.mipmap.cake, R.mipmap.cake
    };
    String[] web = {"Windows", "Twitter", "Google Plus"};

    String[] code = {"$23", "$25", "$20.2"};


    ListView list;
    ImageButton imghome;
    ImageView ivhome;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        ivhome = (ImageView) findViewById(R.id.homee);


        HomeAdapter adapter = new HomeAdapter(HomeActivity.this, web, code, images);
        list = (ListView) findViewById(R.id.list_home);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent i = new Intent(HomeActivity.this, PagerActivity.class);
                    startActivityForResult(i, 0);
                }
                if (position == 0) {
                    Intent i = new Intent(HomeActivity.this, PagerActivity.class);
                    startActivityForResult(i, 1);
                }
                Toast.makeText(HomeActivity.this, "You Clicked at " + web[+position], Toast.LENGTH_SHORT).show();

            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar7);
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
