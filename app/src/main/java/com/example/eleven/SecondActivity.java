package com.example.eleven;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        result = findViewById(R.id.result);

        Bundle data = getIntent().getExtras();

        if (data != null) {
            String fio = data.getString("fio");
            String group = data.getString("group");
            String age = data.getString("age");
            String grade = data.getString("grade");

            result.setText(
                    "ФИО: " + fio +
                            "\nГруппа: " + group +
                            "\nВозраст: " + age +
                            "\nОценка: " + grade
            );
        }
    }
}