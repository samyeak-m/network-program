package com.mobile.first;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TaskOut extends AppCompatActivity {

    TextView nameo,addresso,emailo,mobileo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_task_out);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nameo=findViewById(R.id.nameout);
        addresso=findViewById(R.id.addressout);
        emailo=findViewById(R.id.emailout);
        mobileo=findViewById(R.id.mobileout);

        nameo.setText((getIntent().getStringExtra("namet")));
        addresso.setText((getIntent().getStringExtra("addresst")));
        emailo.setText((getIntent().getStringExtra("emailt")));
        mobileo.setText((getIntent().getStringExtra("mobilet")));
    }
}