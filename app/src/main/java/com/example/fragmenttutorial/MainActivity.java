package com.example.fragmenttutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.EventListener;

public class MainActivity extends AppCompatActivity implements MyDialog.MyDialogEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btn_main_showDialog);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog myDialog = new MyDialog();
                myDialog.setCancelable(false);
                myDialog.show(getSupportFragmentManager(), null);
            }
        });

    }

    @Override
    public void onOkButtonClockrd(String data) {
        TextView textView = findViewById(R.id.textView);
        textView.setText(data);
    }

    @Override
    public void onCancleButtonClicked() {
        Toast.makeText(this, "Cancle Button Clicked", Toast.LENGTH_SHORT).show();
    }
}