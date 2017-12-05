package mycollege.asmobisoft.com.restaurentapp.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mycollege.asmobisoft.com.restaurentapp.R;
import mycollege.asmobisoft.com.restaurentapp.request.ResponceParser;
import mycollege.asmobisoft.com.restaurentapp.request.SignUpRequestParser;
import mycollege.asmobisoft.com.restaurentapp.responseparser.SignupResponseParser;
import mycollege.asmobisoft.com.restaurentapp.service.HttpUtility;
import mycollege.asmobisoft.com.restaurentapp.utility.CommonMethods;
import mycollege.asmobisoft.com.restaurentapp.utility.Constant;
import mycollege.asmobisoft.com.restaurentapp.utility.ServiceCallMy;

import static mycollege.asmobisoft.com.restaurentapp.R.id.button_signup;
import static mycollege.asmobisoft.com.restaurentapp.R.id.profileimageView;

/**
 * Created by gaurav on 9/8/17.
 */

public class SignUpActivity extends AppCompatActivity {
    Button btn_signup;
    EditText editTextname;
    EditText editTextphone;
    TextView texttermsandcondition;
    TextView txttc_tv;
    TextView txtaccount;
    ImageView imageView;
    CheckBox checbox;
    Toolbar toolbar;
    private static final int REQUEST_INTERNET = 200;

    private ProgressDialog progressDialog;
    private LinearLayout llNetwork;
    private LinearLayout llView;
    private ArrayList<ResponceParser> mlistData;
    private ImageView ivRefresh;
    String responce = "";
    private ResponceParser mResponceParser;


    private ProgressDialog pDialog;
    private String mResponce;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        imageView = (ImageView) findViewById(profileimageView);

        editTextname = (EditText) findViewById(R.id.et_name);
        editTextname.setHintTextColor(Color.WHITE);
        editTextphone = (EditText) findViewById(R.id.et_phone);
        btn_signup = (Button) findViewById(button_signup);
        txtaccount = (TextView) findViewById(R.id.tv_account);


        txttc_tv = (TextView) findViewById(R.id.tv_tc);
        txttc_tv.setClickable(true);
        txttc_tv.setMovementMethod(LinkMovementMethod.getInstance());
        txttc_tv.setLinkTextColor(Color.GREEN);


        // for crating progress dialog
        pDialog = new ProgressDialog(SignUpActivity.this);
        pDialog.setMessage("Loading...");
        pDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
        pDialog.setCancelable(false);


        String text = "<a href=http://www.asmobisoft.com/privacy-policy.html>Terms and Condition </a>";
        txttc_tv.setText(Html.fromHtml(text));


        checbox = (CheckBox) findViewById(R.id.checkBox_click);
        txtaccount = (TextView) findViewById(R.id.tv_account);
        texttermsandcondition = (TextView) findViewById(R.id.tv_tc);


        txtaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUpActivity.this, SignInActivity.class);

                startActivity(i);
            }
        });
        texttermsandcondition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUpActivity.this, TermsAndConditionActivity.class);
                startActivity(i);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                if (ContextCompat.checkSelfPermission(SignUpActivity.this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(SignUpActivity.this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_INTERNET);
                }
                startActivityForResult(intent, 2);
            }
        });


        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.button_signup:
                        if (isvalidate()) {
                            if (CommonMethods.isOnline(SignUpActivity.this)) {
                                SendRequestAsync mSendPostRequest = new SendRequestAsync();
                                mSendPostRequest.execute();
                            } else {
                                llNetwork.setVisibility(View.VISIBLE);
                                llView.setVisibility(View.GONE);
                            }
                            break;
                        }
                }

            }

        });
    }

    private void showProgressDialog() {
        pDialog.show();
    }

    private void hideProgressDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }




 /*   public class SendPostRequest extends AsyncTask<String, Void, String> {

        protected void onPreExecute() {

            progressDialog = new ProgressDialog(SignUpActivity.this);
            progressDialog.setMessage("Loading..."); // Setting Message
            progressDialog.setTitle("ProgressDialog"); // Setting Title
            // progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
            progressDialog.show(); // Display Progress Dialog
            progressDialog.setCancelable(false);
        }

        protected String doInBackground(String... arg0) {
            callService();
            return "";
        }


        @Override
        protected void onPostExecute(String result) {

            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }


                   *//* if (responce != null || !responce.equals("")) {
                        ResponceParser mResponceData = new ResponceParser();
                        JSONObject obj = null;
                        try {
                            Log.e("ServiceClass", "responce : " + responce);
                            obj = new JSONObject(responce);
                            Log.e("ServiceClass", "Obj : " + obj.getString("responceMessage"));
                            JSONArray c = obj.getJSONArray("responce");

                            if (obj.getString("responceMessage") == "Signup successfully") {
                                for (int i = 0; i < c.length(); i++) {
                                    Log.e("ServiceClass", "Array : " + c.get(i) + "\n");


                                }
                            } else {

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
        }*//*


          if (mResponceParser.responceMessage.equals("Signup successfully")) {
                Intent i = new Intent(SignUpActivity.this, EnterCodeActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            } else {
                Toast.makeText(SignUpActivity.this, "Check Your Network", Toast.LENGTH_SHORT).show();
            }

        }







        private void callService() {


            Gson gson;

            gson = new Gson();

            SignUpRequestParser mObjectHash = new SignUpRequestParser();
            mObjectHash.first_name = "neha";
            mObjectHash.phone_no = "+919736518098";

            String jsonRequestParams = gson.toJson(mObjectHash);
            System.out.println("Json Request Data : " + jsonRequestParams);

            try {
                */

    /**
     * Authentication code service
     *//*
                responce = ServiceCallMy.getSignupData(jsonRequestParams, "Signup");
                Log.e("(((((((((((((", "" + responce);
                Log.d("Gson",responce);
                mResponceParser=gson.fromJson(responce,ResponceParser.class);

            } catch (Exception e) {
                Log.e("exception", "e" + e.toString());
            }
        }
    }*/
    public boolean isvalidate() {

        if (editTextname.getText().toString().trim().length() == 0) {
            editTextname.setError("Please enter username !");
            return false;
        }

        if (editTextphone.getText().toString().trim().length() == 0) {
            editTextphone.setError("Please enter phone !");
            return false;

        }


        return true;
    }

    @Override
    public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 1) {
                File f = null;
                try {
                    f = new File(Environment.getExternalStorageDirectory().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                for (File temp : f.listFiles()) {
                    if (temp.getName().equals("temp.jpg")) {
                        f = temp;
                        break;
                    }
                }
                try {
                    Bitmap bitmap;

                    BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
                    bitmapOptions.inPreferredConfig = Bitmap.Config.RGB_565;
                    bitmap = BitmapFactory.decodeFile(f.getAbsolutePath(), bitmapOptions);
                    imageView.setImageBitmap(bitmap);

                    String path = Environment.getExternalStorageDirectory() + File.separator + "Phoenix" + File.separator + "default";
                    f.delete();
                    OutputStream outFile = null;
                    File file = new File(path, String.valueOf(System.currentTimeMillis()) + ".jpg");
                    try {
                        outFile = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.PNG, 85, outFile);
                        outFile.flush();
                        outFile.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (requestCode == 2) {
                Uri selectedImage = data.getData();
                String[] filePath = {MediaStore.Images.Media.DATA};
                Cursor c = SignUpActivity.this.getContentResolver().query(selectedImage, filePath, null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePath[0]);
                String picturePath = c.getString(columnIndex);
                c.close();
                Bitmap bitmap;
                BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
                bitmapOptions.inPreferredConfig = Bitmap.Config.RGB_565;
                bitmap = BitmapFactory.decodeFile(picturePath);
                File f = new File(picturePath);
                //String imageName = f.getName();
                imageView.setImageBitmap(bitmap);


            }
        }
    }


    private class SendRequestAsync extends AsyncTask<String, Void, String> {
        private SignupResponseParser signupResponseParser;

        @Override
        protected String doInBackground(String... params) {

            CallService();

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            hideProgressDialog();
            Gson gson = new Gson();

            try {
                signupResponseParser = gson.fromJson(mResponce, SignupResponseParser.class);
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            }

            if (signupResponseParser != null) {
                if (signupResponseParser.responseCode.equals("200")) {


                    CommonMethods.showAlert("Sign up successfully", SignUpActivity.this);


                } else {
                    CommonMethods.showAlert(signupResponseParser.responseMessage.toString().trim(), SignUpActivity.this);

                }
            } else {
                CommonMethods.showAlert("Network Error", SignUpActivity.this);

            }
        }

        @Override
        protected void onPreExecute() {
            showProgressDialog();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }

    }

    public String CallService() {
        Map<String, String> params = new HashMap<String, String>();

        SignUpRequestParser signUpRequestParser = new SignUpRequestParser();

        params.put(signUpRequestParser.first_name, "neha");
        params.put(signUpRequestParser.phone_no, "+919736518098");
        System.out.println("Param" + params);

        try {
            HttpUtility.sendPostRequest(Constant.BASE_URL + Constant.METHOD_SIGNUP, params);
            String[] response = HttpUtility.readMultipleLinesRespone();
            for (String line : response) {
                mResponce = line;
                System.out.println("Response : " + mResponce);
                return line;

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        HttpUtility.disconnect();
        return mResponce;
    }
}





