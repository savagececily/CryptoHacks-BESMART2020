package com.cryptohacks.overhead;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserTypeActivity extends AppCompatActivity {

    private Button customerButton;
    private Button employeeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_type);

        customerButton = (Button) findViewById(R.id.customer_button);
        employeeButton = (Button) findViewById((R.id.employee_button));

        customerButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                openCustomerActivity();
            }
        });
        employeeButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                openEmployeeActivity();
            }
        });


    }
    public void openCustomerActivity(){
        Intent intent = new Intent(this, CustomerLoginActivity.class);
        startActivity(intent);
    }
    public void openEmployeeActivity(){
        Intent intent = new Intent(this, EmployeeLoginActivity.class);
        startActivity(intent);
    }
}