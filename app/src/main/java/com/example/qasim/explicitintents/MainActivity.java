package com.example.qasim.explicitintents;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etname;
    Button btnAct2;
    Button btnAct3;
    TextView tvResult;
    final int ACTIVITY3 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname = findViewById(R.id.etName);
        btnAct2 = findViewById(R.id.btnAct2);
        btnAct3 = findViewById(R.id.btnAct3);
        tvResult = findViewById(R.id.tvResults);

        btnAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etname.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
                } else {
                    String name = etname.getText().toString().trim();

                    Intent intent = new Intent(MainActivity.this,
                            com.example.qasim.explicitintents.Activity2.class);
                    intent.putExtra("name", name);
                    startActivity(intent);
                }

            }
        });

        btnAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        com.example.qasim.explicitintents.Activity3.class);
                startActivityForResult(intent, ACTIVITY3);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ACTIVITY3) {
            if (resultCode == RESULT_OK) {
                tvResult.setText(data.getStringExtra("surname"));
            }
            if (resultCode == RESULT_CANCELED) {
                tvResult.setText("No Data Received!");
            }
        }
    }
}
