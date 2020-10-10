package com.cryptohacks.overhead;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //private Context context;
    private Button start_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start_button = (Button) findViewById(R.id.get_started_button);

        start_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                openActivity();
            }
        });

    }

    public void openActivity(){
        Intent intent = new Intent(this, UserTypeActivity.class);
        startActivity(intent);
    }


}