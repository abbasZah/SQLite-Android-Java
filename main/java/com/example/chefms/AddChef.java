package com.example.chefms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddChef extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chef);

        Button add = (Button) findViewById(R.id.btn_add);

//Listening to button event
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                EditText txtName = (EditText) findViewById(R.id.et_name);
                EditText txtPhone = (EditText) findViewById(R.id.et_phno);
// Add in database
                DatabaseHandler db = new DatabaseHandler(AddChef.this);
                Log.d("Insert: ", "Inserting ..");

                db.addChef(new Chef(txtName.getText().toString(),txtPhone.getText().toString()));
                Toast.makeText(getApplicationContext(), "Chef Added Successfully" , Toast.LENGTH_SHORT).show();
            }
        });

    }
}
