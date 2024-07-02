package com.mobile.first;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragTask extends AppCompatActivity {

    Button fragbtn1,fragbtn2,fragbtn3,fragbtn4;

    FrameLayout fragframeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_frag_task);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fragbtn1 = findViewById(R.id.fragbtn1);
        fragbtn2 = findViewById(R.id.fragbtn2);
        fragbtn3 = findViewById(R.id.fragbtn3);
        fragbtn4 = findViewById(R.id.fragbtn4);

        fragframeLayout = findViewById(R.id.fragtask);

        fragbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new TaskFragment1());

            }
        });

        fragbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new TaskFragment2());

            }
        });

        fragbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new TaskFragment3());

            }
        });

        fragbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new TaskFragment4());

            }
        });

    }

    private void loadFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragtask,fragment);
        fragmentTransaction.commit();
    }
}