package com.example.fragmenttutorial;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class MyDialog extends BottomSheetDialogFragment {

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        eventListener = (MyDialogEventListener) context;
    }

    private MyDialogEventListener eventListener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.my_dialog, null, false);
        builder.setView(view);

        Button okBtn = view.findViewById(R.id.btn_dialog_ok);
        Button cancleBtn = view.findViewById(R.id.btn_dialog_cancle);
        EditText editText = view.findViewById(R.id.et_dialog_input);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.length() > 0) {
                    eventListener.onOkButtonClockrd(editText.getText().toString());
                    dismiss();
                }
            }
        });


        cancleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventListener.onCancleButtonClicked();
                dismiss();
            }
        });

        return view;
    }

    public interface MyDialogEventListener {
        void onOkButtonClockrd(String data);

        void onCancleButtonClicked();
    }
}
