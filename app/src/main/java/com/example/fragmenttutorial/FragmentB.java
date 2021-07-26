package com.example.fragmenttutorial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragmentB extends Fragment {

    public static final String DATA = "KEY";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.add(R.id.frameLayout_b_and_c, new FragmentC());
//        fragmentTransaction.commit();

        TextView textView = view.findViewById(R.id.textView_b);
        String data = getArguments().getString("KEY");
        textView.setText(data);
    }


    public static FragmentB newInstance(String data) {
        
        Bundle args = new Bundle();
        args.putString(DATA, data);

        FragmentB fragment = new FragmentB();
        fragment.setArguments(args);
        return fragment;
    }
}
