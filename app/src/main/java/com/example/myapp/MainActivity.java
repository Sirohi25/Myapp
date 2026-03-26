package com.example.myapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ✅ Crash handler (सही जगह)
        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
            try {
                java.io.FileWriter writer = new java.io.FileWriter("/sdcard/crash.txt", true);
                writer.write(throwable.toString());
                writer.write("\n\n");
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            String text = editText.getText().toString();
            textView.setText(text);
        });
    }
}
