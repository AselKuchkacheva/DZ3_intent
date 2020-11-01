package com.example.dz3_intent;

import androidx.annotation.Nullable;
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
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private ImageView imageView;
    private EditText editText;
    private Button button;
    public String image;
    public String text;
    public static final int GALLERY_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        resultMain();
        init();

    }

    private void init() {

        button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            sentPicText();
        }
    });
    }

    private void resultMain() {
        imageView = findViewById(R.id.imageSecond);
        editText = findViewById(R.id.editTextSecond);
        button = findViewById(R.id.btnSecond);

        Intent intent = getIntent();
        if (intent != null) {
            text = intent.getStringExtra(MainActivity.KEY_INTENT);
            editText.setText(text);
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Intent.ACTION_PICK);
                intent1.setType("image/*");
                startActivityForResult(intent1, GALLERY_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == GALLERY_REQUEST && resultCode == RESULT_OK && data != null){
            image = data.getDataString();
            Log.d("ololo", image);
        }
    }

    private void sentPicText() {
        Intent intent2 = new Intent(this,MainActivity.class);
        intent2.putExtra("text", text);
        intent2.putExtra("pic", image);
        this.startActivity(intent2);
        Log.d("ololo", "sentPicText: "+text+image);

    }
}