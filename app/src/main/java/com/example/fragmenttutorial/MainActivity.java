package com.example.fragmenttutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame_layout_fragmentContainer, new FragmentA());
        fragmentTransaction.addToBackStack("FRAGMENT_A");
        fragmentTransaction.commit();


        Button btn_remove = findViewById(R.id.btn_remove);
        btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frame_layout_fragmentContainer);
                // fragmnet hal e hazerom ro nshon mide .
                if (fragment != null) {
                    FragmentTransaction removeTransaction = getSupportFragmentManager().beginTransaction();
                    removeTransaction.remove(fragment);
                    removeTransaction.addToBackStack(null);
                    removeTransaction.commit();
                }

            }
        });

    }
}