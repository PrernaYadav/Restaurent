package mycollege.asmobisoft.com.restaurentapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import mycollege.asmobisoft.com.restaurentapp.R;

/**
 * Created by gaurav on 30/8/17.
 */

public class OrderingActivity extends AppCompatActivity {
    TextView textView;
    TextView textView1;
    TextView textViewocheckout;
    ImageButton btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ordering);
        textViewocheckout = (TextView) findViewById(R.id.tv_checkout);
        textView = (TextView) findViewById(R.id.tv_cardno);
        textView1 = (TextView) findViewById(R.id.tv_cardno2);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OrderingActivity.this, ADD_CC.class);
                startActivity(i);
            }
        });
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OrderingActivity.this, ADD_CC.class);
                startActivity(i);
            }
        });


        textViewocheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OrderingActivity.this, ADD_CC.class);
                startActivity(i);
            }
        });


        // toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);

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

