package com.cryptohacks.overhead;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class CarryOnActivityPt3 extends AppCompatActivity {

    private Spinner num_bags = (Spinner) findViewById(R.id.num_bags);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carry_on_pt3);



    }
}