package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    private StateViewModel StateViewModel;
    private TextView text2;
    private TextView textlic;
    private EditText editText1;
    private Switch switcher;
    private CheckBox checkBox;
    private TextView textedit;


    @Override
    protected void onResume(){
        super.onResume();
        setEditText();
        updateEditText();
    }
    @Override
    protected void onPause(){
        super.onPause();
        setEditText();
        updateEditText();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textedit = findViewById(R.id.textView3);
        text2 = findViewById(R.id.textView2);
        textlic = findViewById(R.id.textView);
        switcher = findViewById(R.id.switch1);
        checkBox = findViewById(R.id.checkBox);
        Button button1 = findViewById(R.id.button);
        editText1 = findViewById(R.id.editTextText);
        StateViewModel = new ViewModelProvider(this).get(StateViewModel.class);


        updateCountText();
        updateState();
        updateMode();
        setEditText();


        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                StateViewModel.incrementCount();
                updateCountText();
            }
        });

        switcher.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (switcher.isChecked()) {
                    StateViewModel.sweetyOn();
                    updateMode();
                } else {
                    StateViewModel.sweetyOff();
                    updateMode();
                }
            }
        });

        checkBox.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    StateViewModel.checkbOn();
                    updateState();
                } else {
                    StateViewModel.checkbOff();
                    updateState();
                }
            }
        });
    }

    private void updateEditText(){
        StateViewModel.updateEditText(editText1.getText().toString());
    }

    private void setEditText(){
        textedit.setText(StateViewModel.setEditText());
    }

    private void updateCountText() {
        textlic
                .setText("Licznik: " + StateViewModel.getcount());
    }
    private void updateState(){
        if (StateViewModel.getcheckb()) {
            text2.setVisibility(View.VISIBLE);
        } else {
            text2.setVisibility(View.INVISIBLE);
        }
    }
    private void updateMode(){
        if (StateViewModel.getsweety()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}