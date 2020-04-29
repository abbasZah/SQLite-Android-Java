package com.example.chefms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ShowAllChef extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_chef);

        DatabaseHandler db = new DatabaseHandler(this);
// Reading all chefs
        Log.d("Reading: ", "Reading all chefs..");
        List<Chef> chefs = db.getAllChefs();
        String log=null;
        String [] chef_array = new String[chefs.size()];
        int i=0;
        for (Chef cn : chefs) {
            chef_array[i] = cn.getName() +" ("+ cn.getPhoneNumber() + ") ";
            log = log + "Id: " + cn.getId() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
// Writing chefs to log
            Log.d("Name: ", log);
            i++;
        }
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1 , chef_array);
        ListView listView = (ListView) findViewById(R.id.listview1);
        listView.setAdapter(adapter);

    }
}
