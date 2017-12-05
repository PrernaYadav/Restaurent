package mycollege.asmobisoft.com.restaurentapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mycollege.asmobisoft.com.restaurentapp.R;

/**
 * Created by gaurav on 10/8/17.
 */

public class EnterCodeActivity extends AppCompatActivity {
    Button btn_done;
    EditText editTextpassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_code);
        btn_done = (Button) findViewById(R.id.btn_done);
        editTextpassword = (EditText) findViewById(R.id.et_password);
        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextpassword.getText().toString().trim().length() == 0) {
                    editTextpassword.setError("Password is not entered");
                    editTextpassword.requestFocus();
                } else {
                    Intent i = new Intent(EnterCodeActivity.this, SignInActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}
