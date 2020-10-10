package com.cryptohacks.overhead;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CustomerLoginActivity extends AppCompatActivity {

    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);

        next = (Button) findViewById(R.id.next_button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });

    }

    public void openActivity() {
        // Confirm Matching User/Flight - Teradata
        if(getResult()){
            Intent intent = new Intent(this, CarryOnActivityPt1.class);
            startActivity(intent);
        }
        else{
            new AlertDialog.Builder(this)
                    .setMessage("Last Name and Flight Confirmation do not match.")
                    .setPositiveButton("Try Again.", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    }).create().show();
        }

    }

    private boolean getResult(){
        // Comfirm Matching User/Flight

        return true;
    }
}