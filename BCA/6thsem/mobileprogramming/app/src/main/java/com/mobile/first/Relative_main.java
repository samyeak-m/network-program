package com.mobile.first;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Relative_main extends AppCompatActivity {
    Button btn;

    Spinner spinner;
    String[] spinnerItems ={"c","c++","java","python","kotlin","php","javascript","ruby","swift","objective-c","c#","scala","perl","r","go","html","css","sql","shell","typescript","rust","dart","groovy","lua","matlab","vba","cobol","fortran","abap","pascal","ada","lisp","scheme","prolog","haskell","erlang","ocaml","f#","clojure","kotlin","racket","elm","julia","smalltalk","forth","apex","bash","powershell","pl/sql","t-sql","pl/pgsql","pl/pgsql","mysql","postgresql","sqlite","oracle","mongodb","redis","cassandra","couchbase","couchdb","dynamodb","firebase","realm","sql server","db2","sybase"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_relative_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


            btn = findViewById(R.id.button);
            spinner = findViewById(R.id.spinner);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Relative_main.this, "Button Clicked", Toast.LENGTH_SHORT).show();
                }
        });

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerItems);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Relative_main.this, spinnerItems[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}