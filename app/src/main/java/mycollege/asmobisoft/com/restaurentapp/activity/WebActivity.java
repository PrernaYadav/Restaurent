package mycollege.asmobisoft.com.restaurentapp.activity;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import mycollege.asmobisoft.com.restaurentapp.R;

public class WebActivity extends AppCompatActivity {


    private static final int PERMISSION_CALLBACK_CONSTANT = 100;
    private static final int REQUEST_PERMISSION_SETTING = 101;
    String[] permissionsRequired = new String[]{Manifest.permission.SEND_SMS,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CALL_PHONE};


    private TextView textView;
    private Button btnCheckPermissions;
    private SharedPreferences permissionStatus;
    private boolean sentToSettings = false;


    Button btnproceed;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_layout);

        SharedPreferences pref=getSharedPreferences("ActivityPref", Context.MODE_PRIVATE);
        if(pref.getBoolean("Activity_executed" ,false)){
            Intent i = new Intent(WebActivity.this, MainActivity.class);
            startActivity(i);
            finish();

        }else{

            SharedPreferences.Editor ed = pref.edit();
            ed.putBoolean("Activity_executed",true);
            ed.commit();
        }


        permissionStatus = getSharedPreferences("permissionStatus", MODE_PRIVATE);
        textView = (TextView) findViewById(R.id.tv_notnow);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WebActivity.this, MainActivity.class);

                startActivity(i);
            }
        });


        btnproceed = (Button) findViewById(R.id.btn_proceed);
        btnproceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(WebActivity.this, permissionsRequired[0]) != PackageManager.PERMISSION_GRANTED
                        || ActivityCompat.checkSelfPermission(WebActivity.this, permissionsRequired[1]) != PackageManager.PERMISSION_GRANTED
                        || ActivityCompat.checkSelfPermission(WebActivity.this, permissionsRequired[2]) != PackageManager.PERMISSION_GRANTED
                        || ActivityCompat.checkSelfPermission(WebActivity.this, permissionsRequired[3]) != PackageManager.PERMISSION_GRANTED
                        || ActivityCompat.checkSelfPermission(WebActivity.this, permissionsRequired[4]) != PackageManager.PERMISSION_GRANTED
                        || ActivityCompat.checkSelfPermission(WebActivity.this, permissionsRequired[5]) != PackageManager.PERMISSION_GRANTED) {


                    if (ActivityCompat.shouldShowRequestPermissionRationale(WebActivity.this, permissionsRequired[0])
                            || ActivityCompat.shouldShowRequestPermissionRationale(WebActivity.this, permissionsRequired[1])
                            || ActivityCompat.shouldShowRequestPermissionRationale(WebActivity.this, permissionsRequired[2])
                            || ActivityCompat.shouldShowRequestPermissionRationale(WebActivity.this, permissionsRequired[3])
                            || ActivityCompat.shouldShowRequestPermissionRationale(WebActivity.this, permissionsRequired[4])
                            || ActivityCompat.shouldShowRequestPermissionRationale(WebActivity.this, permissionsRequired[5])) {
                        //Show Information about why you need the permission
                        AlertDialog.Builder builder = new AlertDialog.Builder(WebActivity.this);
                        builder.setTitle("Need Multiple Permissions");
                        builder.setMessage("This app needs Camera and Location permissions.");
                        builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                ActivityCompat.requestPermissions(WebActivity.this, permissionsRequired, PERMISSION_CALLBACK_CONSTANT);
                            }
                        });
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        builder.show();
                    } else if (permissionStatus.getBoolean(permissionsRequired[0], false)) {
                        //Previously Permission Request was cancelled with 'Dont Ask Again',
                        // Redirect to Settings after showing Information about why you need the permission
                        AlertDialog.Builder builder = new AlertDialog.Builder(WebActivity.this);
                        builder.setTitle("Need Multiple Permissions");
                        builder.setMessage("This app needs Camera and Location permissions.");
                        builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                sentToSettings = true;
                                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                Uri uri = Uri.fromParts("package", getPackageName(), null);
                                intent.setData(uri);
                                startActivityForResult(intent, REQUEST_PERMISSION_SETTING);
                                Toast.makeText(getBaseContext(), "Go to Permissions to Grant  Camera and Location", Toast.LENGTH_LONG).show();
                            }
                        });
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        builder.show();
                    } else {
                        //just request the permission
                        ActivityCompat.requestPermissions(WebActivity.this, permissionsRequired, PERMISSION_CALLBACK_CONSTANT);
                    }


                    SharedPreferences.Editor editor = permissionStatus.edit();
                    editor.putBoolean(permissionsRequired[0], true);
                    editor.commit();
                } else {
                    //You already have the permission, just go ahead.
                    proceedAfterPermission();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_CALLBACK_CONSTANT) {
            //check if all permissions are granted
            boolean allgranted = false;
            for (int i = 0; i < grantResults.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    allgranted = true;
                } else {
                    allgranted = false;
                    break;
                }
            }

            if (allgranted) {
                proceedAfterPermission();
            } else if (ActivityCompat.shouldShowRequestPermissionRationale(WebActivity.this, permissionsRequired[0])
                    || ActivityCompat.shouldShowRequestPermissionRationale(WebActivity.this, permissionsRequired[1])
                    || ActivityCompat.shouldShowRequestPermissionRationale(WebActivity.this, permissionsRequired[2])
                    || ActivityCompat.shouldShowRequestPermissionRationale(WebActivity.this, permissionsRequired[3])
                    || ActivityCompat.shouldShowRequestPermissionRationale(WebActivity.this, permissionsRequired[4])
                    || ActivityCompat.shouldShowRequestPermissionRationale(WebActivity.this, permissionsRequired[5])) {

                AlertDialog.Builder builder = new AlertDialog.Builder(WebActivity.this);
                builder.setTitle("Need Multiple Permissions");
                builder.setMessage("This app needs Camera and Location permissions.");
                builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        ActivityCompat.requestPermissions(WebActivity.this, permissionsRequired, PERMISSION_CALLBACK_CONSTANT);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            } else {
                Toast.makeText(getBaseContext(), "Unable to get Permission", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_PERMISSION_SETTING) {
            if (ActivityCompat.checkSelfPermission(WebActivity.this, permissionsRequired[0]) == PackageManager.PERMISSION_GRANTED) {
                //Got Permission
                proceedAfterPermission();
            }
        }
    }

    private void proceedAfterPermission() {
        Intent i = new Intent(WebActivity.this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);

        Toast.makeText(getBaseContext(), "We got All Permissions", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if (sentToSettings) {
            if (ActivityCompat.checkSelfPermission(WebActivity.this, permissionsRequired[0]) == PackageManager.PERMISSION_GRANTED) {
                //Got Permission
                proceedAfterPermission();
            }
        }


    }
}