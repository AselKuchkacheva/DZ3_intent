package com.example.dz3_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    private Button button1;
    private Button button2;
    public static final String KEY_INTENT = "key";
    public static final int REQUEST_CODE = 100;
    public String text1, image1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        getInt2();
    }


    private void init() {
        imageView = findViewById(R.id.imageMain);
        textView = findViewById(R.id.txtViewMain);
        button1 = findViewById(R.id.btnMain1);
        button2 = findViewById(R.id.btnMain2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(KEY_INTENT, "Заполнение EDIT_TEXT");
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, "asel.kuchkacheva@gmail.com");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Отправка");
                intent.putExtra(Intent.EXTRA_TEXT, text1);
                startActivity(Intent.createChooser(intent, "Send Email"));
            }
        });
    }

    private void getInt2() {
        if (getIntent().getStringExtra("text") != null && getIntent().getStringExtra("pic") != null) {
            Intent intent = getIntent();
            text1 = intent.getStringExtra("text");
            image1 = intent.getStringExtra("pic");

            imageView.setImageURI(Uri.parse(image1));
            textView.setText(text1);
        }
        Log.d("ololo", "getInt2: " + text1 + image1);
    }

}