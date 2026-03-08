package com.example.eleven;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView fioResult, groupResult, ageResult, gradeResult;

    ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        fioResult = findViewById(R.id.fioResult);
        groupResult = findViewById(R.id.groupResult);
        ageResult = findViewById(R.id.ageResult);
        gradeResult = findViewById(R.id.gradeResult);

        Bundle data = getIntent().getExtras();

        if (data != null) {

            String fio = data.getString("fio");
            String group = data.getString("group");
            String age = data.getString("age");
            String grade = data.getString("grade");

            fioResult.setText(fio);
            groupResult.setText(group);
            ageResult.setText(age);
            gradeResult.setText(grade);
        }

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {

                    if (result.getResultCode() == RESULT_OK) {

                        Intent dataResult = result.getData();

                        if (dataResult != null) {

                            String schedule = dataResult.getStringExtra("schedule");

                            gradeResult.setText(
                                    gradeResult.getText() + "\n\n" + schedule
                            );
                        }
                    }
                });
    }

    public void openThird(View view) {

        Intent intent = new Intent(this, ThirdActivity.class);

        launcher.launch(intent);
    }

    public void goBack(View view) {

        finish();
    }
}