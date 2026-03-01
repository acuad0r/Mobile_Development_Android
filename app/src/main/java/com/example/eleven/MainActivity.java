package com.example.eleven;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Lifecycle";

    EditText fio, group, age, grade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            android.util.Log.d("VERSION", "Android 8.0 or higher");
        }
        Log.d(TAG, "onCreate");

        fio = findViewById(R.id.fio);
        group = findViewById(R.id.group);
        age = findViewById(R.id.age);
        grade = findViewById(R.id.grade);

        if (savedInstanceState != null) {
            fio.setText(savedInstanceState.getString("fio_text"));
            group.setText(savedInstanceState.getString("group_text"));
            age.setText(savedInstanceState.getString("age_text"));
            grade.setText(savedInstanceState.getString("grade_text"));
        }

        Button buttonProgram = findViewById(R.id.buttonProgram);
        buttonProgram.setOnClickListener(v -> openActivity());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("fio_text", fio.getText().toString());
        outState.putString("group_text", group.getText().toString());
        outState.putString("age_text", age.getText().toString());
        outState.putString("grade_text", grade.getText().toString());
    }

    // ДЕКЛАРАТИВНЫЙ способ
    public void openSecondActivity(View view) {
        openActivity();
    }

    private void openActivity() {

        Intent intent = new Intent(this, SecondActivity.class);

        intent.putExtra("fio", fio.getText().toString());
        intent.putExtra("group", group.getText().toString());
        intent.putExtra("age", age.getText().toString());
        intent.putExtra("grade", grade.getText().toString());

        startActivity(intent);
    }
}