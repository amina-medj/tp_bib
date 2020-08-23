package com.example.mydb;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    DBHelper mydb;
    EditText editTitre, editAuteur, editMotcles, editTextId;
    Button btnInsert;
    Button btnUpd;
    Button btnDlt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new DBHelper(this);
        editTitre = (EditText) findViewById(R.id.editText_titre);
        editAuteur = (EditText) findViewById(R.id.editText_auteur);
        editMotcles = (EditText) findViewById(R.id.editText_motc);
        editTextId = (EditText) findViewById(R.id.editText_id);
        btnInsert = (Button) findViewById(R.id.button_add);
        btnUpd = (Button) findViewById(R.id.button_update);
        btnDlt = (Button) findViewById(R.id.button_delete);
        Insert();
        UpdateData();
        DeleteData();

    }

    public void Insert() {
        btnInsert.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = mydb.insertBooks(editTitre.getText().toString(),
                                editAuteur.getText().toString(),
                                editMotcles.getText().toString());
                        if (isInserted == true)
                            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }


    public void UpdateData() {
        btnUpd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = mydb.updateBooks(editTextId.getText().toString(),
                                editTitre.getText().toString(),
                                editAuteur.getText().toString(), editMotcles.getText().toString());
                        if (isUpdate == true)
                            Toast.makeText(MainActivity.this, "Data Update", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Data not Updated", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void DeleteData() {
        btnDlt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = mydb.deleteContact(editTextId.getText().toString());
                        if (deletedRows > 0)
                            Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Data not Deleted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}

