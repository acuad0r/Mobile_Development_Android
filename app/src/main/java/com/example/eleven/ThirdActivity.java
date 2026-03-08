package com.example.eleven;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    EditText day, time, comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        day = findViewById(R.id.day);
        time = findViewById(R.id.time);
        comment = findViewById(R.id.comment);
    }

    public void returnResult(View view) {

        String result =
                "День: " + day.getText().toString() +
                        "\nВремя: " + time.getText().toString() +
                        "\nКомментарий: " + comment.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("schedule", result);

        setResult(RESULT_OK, intent);

        finish();
    }
}