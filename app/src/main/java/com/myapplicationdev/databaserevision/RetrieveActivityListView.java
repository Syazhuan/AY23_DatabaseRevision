package com.myapplicationdev.databaserevision;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RetrieveActivityListView extends AppCompatActivity {

    Button btnGetNotes;

    ListView lv;
    ArrayAdapter<Note> aa;
    ArrayList<Note> al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_lv);

        btnGetNotes = findViewById(R.id.btnGetTasks);
        lv = findViewById(R.id.lv);

        al = new ArrayList<>();
        aa = new ArrayAdapter<Note>(RetrieveActivityListView.this, android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

        btnGetNotes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the activity's Context
                DBHelper dbHelper = new DBHelper(RetrieveActivityListView.this);

                // Assuming your DBHelper class has a method to retrieve notes from the database
                ArrayList<Note> retrievedNotes = dbHelper.getNotesInObjects();

                // Clear the ArrayList and add the retrieved notes
                al.clear();
                al.addAll(retrievedNotes);

                // Notify the ArrayAdapter that the data has changed
                aa.notifyDataSetChanged();

                // Close the database connection
                dbHelper.close();

                // Register ListView for context menu
                registerForContextMenu(lv);

            }
        });
    }
}