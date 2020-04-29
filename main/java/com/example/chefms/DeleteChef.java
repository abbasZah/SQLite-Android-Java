package com.example.chefms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteChef extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_chef);

        Button btnDelete = (Button) findViewById(R.id.btnDel_DB);
//Listening to button event
        btnDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                EditText txtPhone_del = (EditText)
                        findViewById(R.id.txt_phone_del);

// Add in database

                DatabaseHandler db = new DatabaseHandler(DeleteChef.this);

                Log.d("deleting: ", "Deleting ..");
                boolean found =
                        db.checkIfExist((txtPhone_del.getText().toString()));
                if(found)
                {
// deleting

                    Chef ct = new Chef();

                    ct.setPhoneNumber((txtPhone_del.getText().toString()));
                    db.deleteChef(ct);
                    Toast.makeText(getApplicationContext(), "Record Deleted",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Record Not Found",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
