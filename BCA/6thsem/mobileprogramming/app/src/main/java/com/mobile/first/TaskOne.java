package com.mobile.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TaskOne extends AppCompatActivity {

    Button btnt;
    EditText namet, emailt, addresst, mobilet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_task_one);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnt = findViewById(R.id.buttont);
        namet = findViewById(R.id.namet);
        addresst = findViewById(R.id.addresst);
        emailt = findViewById(R.id.emailt);
        mobilet = findViewById(R.id.mobilet);

        btnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TaskOne.this, "Form Submitted.", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(TaskOne.this, TaskOut.class);

                intent.putExtra("namet", namet.getText().toString());
                intent.putExtra("addresst", addresst.getText().toString());
                intent.putExtra("emailt", emailt.getText().toString());
                intent.putExtra("mobilet", mobilet.getText().toString());

                startActivity(intent);
            }
        });
    }
}
