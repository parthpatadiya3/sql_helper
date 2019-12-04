package com.example.sql_helper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity
{
TextView t;
    String log="";
    EditText name,phone_number,id_of_data;
    Button insert,delete,show;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        final DatabaseHandler db = new DatabaseHandler(this);
t=findViewById(R.id.tv);
insert=findViewById(R.id.insert);
show=findViewById(R.id.update);
name=findViewById(R.id.name);
delete=findViewById(R.id.delete);
id_of_data=findViewById(R.id.id_of_data);
phone_number=findViewById(R.id.phone_number);
insert.setOnClickListener(new View.OnClickListener() {
                              @Override
                              public void onClick(View view) {
                                  Log.d("Insert: ", "Inserting ..");
                                  db.addContact(new Contact(name.getText().toString(),phone_number.getText().toString()));

                              }
                          });
        // Inserting Contacts

        // Reading all contacts
 show.setOnClickListener(new View.OnClickListener() {
                             @Override
                             public void onClick(View view) {
                                 t.setVisibility(View.VISIBLE);
                                 Log.d("Reading: ", "Reading all contacts..");
                                 List<Contact> contacts = db.getAllContacts();

                                 for (Contact cn : contacts) {
                                     log += "\nId: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " +
                                             cn.getPhoneNumber();
                                     // Writing Contacts to log


                                     Log.d("Name", log);

                                 }
                                 t.setText(log+"\n");


                             }
                         });
    delete.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
      db.deleteContact(new Contact(name.getText().toString(),phone_number.getText().toString()));
        }
    });
    }
}
