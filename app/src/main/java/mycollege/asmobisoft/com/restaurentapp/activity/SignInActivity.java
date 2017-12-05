package mycollege.asmobisoft.com.restaurentapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import mycollege.asmobisoft.com.restaurentapp.R;

/**
 * Created by gaurav on 10/8/17.
 */
public class SignInActivity extends AppCompatActivity {
    TextView txtforgot;
    Button btnsign;
    Button btnfb;
    EditText editTextphone;
    EditText editTextpaswrd;
    TextView txtsignupp;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        txtforgot = (TextView) findViewById(R.id.tv_forgot);
        btnsign = (Button) findViewById(R.id.btn_signin);
        btnfb = (Button) findViewById(R.id.btn_fb);
        editTextphone = (EditText) findViewById(R.id.et_phonee);
        editTextpaswrd = (EditText) findViewById(R.id.et_passwrd);
        txtsignupp = (TextView) findViewById(R.id.tv_signuppp);


        txtforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignInActivity.this, ForgotPasswordActivity.class);
                startActivity(i);
            }
        });
        btnsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editTextphone.getText().toString().trim().length() == 0) {
                    editTextphone.setError("Phone is not correct?");
                    editTextphone.requestFocus();
                    Toast.makeText(getApplicationContext(), "Please Provide Some Input", Toast.LENGTH_SHORT).show();

                } else if (editTextpaswrd.getText().toString().trim().length() == 0) {
                    editTextpaswrd.setError("Invalid Password");
                    editTextpaswrd.requestFocus();
                    Toast.makeText(getApplicationContext(), "Please Provide Some Input", Toast.LENGTH_SHORT).show();
                } else {


                    Intent i = new Intent(SignInActivity.this, Navigation.class);
                    startActivity(i);
                }
            }
        });
        txtsignupp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(i);
            }
        });
    }
}




