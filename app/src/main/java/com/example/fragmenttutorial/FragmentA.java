package com.example.fragmenttutorial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import static com.example.fragmenttutorial.FragmentB.DATA;

public class FragmentA extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button bTNgoToB = view.findViewById(R.id.btn_A_goToB);


        bTNgoToB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText_a = view.findViewById(R.id.editText_a);
//                String data = editText_a.getText().toString();
//                Bundle bundle = new Bundle();
//                bundle.putString(DATA, data);
//
                FragmentB fragmentB = new FragmentB();
//                fragmentB.setArguments(bundle);

                FragmentTransaction fragmentTransaction1 = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.frame_layout_fragmentContainer, FragmentB.newInstance(
                        editText_a.getText().toString()
                ));
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();


                // code ja be jaei hamrah ba animation esh :

//                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//                transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
//                transaction.replace(R.id.frame_layout_fragmentContainer, new FragmentB());
//                transaction.addToBackStack(null);
//                transaction.commit();
            }
        });

    }
}
