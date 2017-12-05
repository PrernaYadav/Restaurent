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

public class ForgotPasswordActivity extends AppCompatActivity {
    Button btnsend;
    EditText editTextforgtpasswrd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        btnsend = (Button) findViewById(R.id.btn_send);
        editTextforgtpasswrd = (EditText) findViewById(R.id.et_forgtpaswrd);
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextforgtpasswrd.getText().toString().trim().length() == 0) {
                    editTextforgtpasswrd.setError("Enter your password");
                    editTextforgtpasswrd.requestFocus();
                } else {
                    Intent i = new Intent(ForgotPasswordActivity.this, SignInActivity.class);
                    startActivity(i);
                }
            }
        });

    }

}
