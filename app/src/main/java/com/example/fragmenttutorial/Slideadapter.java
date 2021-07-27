package com.example.fragmenttutorial;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class Slideadapter extends FragmentStateAdapter {

    public Slideadapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        String data;
        switch (position) {
            case 0:
                data = "A";
                break;

            case 1:
                data = "B";
                break;

            case 2:
                data = "C";
                break;

            case 3:
                data = "D";
                break;

            case 4:
                data = "E";
                break;

            default:
                data = "";
                break;


        }
        return SlideFragment.newInstance(data);
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
