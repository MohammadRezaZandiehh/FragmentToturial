package com.example.fragmenttutorial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.EventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ViewPager2 viewPager2 = findViewById(R.id.view_pager_main);
        Slideadapter slideadapter = new Slideadapter(this);
        viewPager2.setAdapter(slideadapter);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        viewPager2.setCurrentItem(2);


        TabLayout tabLayout = findViewById(R.id.tabLayoutMain);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("A");
                        break;

                    case 1:
                        tab.setText("B");
                        break;

                    case 2:
                        tab.setText("C");
                        break;

                    case 3:
                        tab.setText("D");
                        break;

                    case 4:
                        tab.setText("E");
                        break;
                }
            }
        });

        tabLayoutMediator.attach();

    }
}