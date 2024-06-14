package com.mobile.first;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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

public class paletteg extends AppCompatActivity {

    String TAG = paletteg.class.getSimpleName();
    Button btn, btnE;
    Spinner spinner;

    String[] spinnerItems={"Employee Type","Permanent","Temporary","contract","Freelancer"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        Log.d(TAG,"onCreate :: ");
        setContentView(R.layout.activity_paletteg);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn = findViewById(R.id.submit);
        spinner = findViewById(R.id.emptype);
        btnE = findViewById(R.id.buttonExplicit);

        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(paletteg.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(paletteg.this,"Submit", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com"));
                startActivity(intent);
            }
        });

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,spinnerItems);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=spinnerItems[position];
                if (selectedItem.equalsIgnoreCase("Employee Type")){
                    Toast.makeText(paletteg.this,"Cannot select this", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(paletteg.this,selectedItem, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG,"onStart :: ");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG,"onPause :: ");

    }
    @Override
    protected void onPostResume(){
        super.onPostResume();
        Log.d(TAG,"onPostResume :: ");

    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG,"onPostResume :: ");

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"onPostResume :: ");

    }
}