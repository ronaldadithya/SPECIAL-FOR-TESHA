package com.example.aplikasidesa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class produk extends AppCompatActivity {

    TextView textDefault;
    ImageView imageDefault;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produk);

        textDefault = findViewById(R.id.textdetail);
        imageDefault = findViewById(R.id.gambardetail);

        Intent intent = getIntent();
        String namaAplikasi = intent.getStringExtra("TEXT_DEFAULT");
        int logoAplikasi = intent.getIntExtra("GAMBAR_DEFAULT", 0);

        textDefault.setText(namaAplikasi);
        imageDefault.setImageResource(logoAplikasi);
    }
}