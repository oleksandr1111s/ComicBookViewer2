package com.example.comicbookviewer;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class MainActivity extends AppCompatActivity {
    private TextView tvDisplay;
    private boolean bNewNumber = true;
    private ImageView imageComic;
    private Button btnPrevious, btnNext, btnFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.calculator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tvDisplay = findViewById(R.id.textView);
        findViewById(R.id.b1).setOnClickListener(v -> addDigit("1"));
        findViewById(R.id.b2).setOnClickListener(v -> addDigit("2"));
        findViewById(R.id.b3).setOnClickListener(v -> addDigit("3"));
        findViewById(R.id.b4).setOnClickListener(v -> addDigit("4"));
        findViewById(R.id.b5).setOnClickListener(v -> addDigit("5"));
        findViewById(R.id.b6).setOnClickListener(v -> addDigit("6"));
        findViewById(R.id.b7).setOnClickListener(v -> addDigit("7"));
        findViewById(R.id.b8).setOnClickListener(v -> addDigit("8"));
        findViewById(R.id.b9).setOnClickListener(v -> addDigit("9"));
        findViewById(R.id.b0).setOnClickListener(v -> addDigit("0"));
        findViewById(R.id.ac).setOnClickListener(v -> clearAll());
        findViewById(R.id.back).setOnClickListener(v -> clearDigit());
    }

    private void clearDigit() {
        if (bNewNumber) {
            return;
        }
        String text = tvDisplay.getText().toString();
        if (text.length() > 1) {
            tvDisplay.setText(text.substring(0, text.length() - 1));
        } else {
            tvDisplay.setText("0");
            bNewNumber = true;
        }
    }

        private void clearAll () {
            bNewNumber = true;
            setTextSize();
            tvDisplay.setText("0");
        }

        private void addDigit (String number){
            if (tvDisplay.length() > 9) {
                tvDisplay.setTextSize(32);
            } else
                tvDisplay.setTextSize(64);

            if (bNewNumber) {
                tvDisplay.setText(number);
                bNewNumber = false;
            } else {
                tvDisplay.append(number);
            }
        }
        private void setTextSize () {
            if (tvDisplay.length() > 9) {
                tvDisplay.setTextSize(32);
            } else
                tvDisplay.setTextSize(64);
        }
    }