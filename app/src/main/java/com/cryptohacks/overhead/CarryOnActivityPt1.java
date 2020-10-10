package com.cryptohacks.overhead;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CarryOnActivityPt1 extends AppCompatActivity {
    private int CAMERA_PERMISSION_CODE = 1;
    Button yes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carry_on_pt1);

        yes = (Button) findViewById(R.id.yes_button);
        yes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openActivity();

                if (ContextCompat.checkSelfPermission(CarryOnActivityPt1.this,
                        Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    //Intent intent = new Intent(this, ActivityName.class);
                    //startActivity(intent);
                }
                else {
                   // requestCameraPermission();
                }
            }
        });
    }
    private void openActivity(){
        Intent intent = new Intent(this, CarryOnActivityPt2.class);
        startActivity(intent);
    }
 /*   private void requestCameraPermission(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)){
            new AlertDialog.Builder(this)
                    .setMessage("Allow Overhead to access your camera")
                    .setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(CarryOnActivityPt1.this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_CODE);
                        }
                    })
                    .setNegativeButton("Deny", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();
        }
        else {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_CODE);

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == CAMERA_PERMISSION_CODE)  {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // TODO
            } else {
                //TODO
            }
        }
    }*/

}