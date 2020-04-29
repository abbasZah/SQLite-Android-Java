package com.example.chefms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button add_chef = (Button) findViewById(R.id.btn_add_chef);
        add_chef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddChef.class);
                startActivity(i);
            }
        });


        Button show_all_chefs = (Button) findViewById(R.id.btn_show_all_chefs);
        show_all_chefs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ShowAllChef.class);
                startActivity(i);
            }
        });

        Button delete = (Button) findViewById(R.id.btn_delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DeleteChef.class);
                startActivity(i);
            }
        });

    }
}
