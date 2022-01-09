package com.example.aplikasidesa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        AyamkuAdapter.OnNoteListener {

    RecyclerView recyclerView;
    AyamkuAdapter ayamkuAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ItemModel> data;
    Button reset;

    public TextView harga;
    public TextView total_harga;
    public TextView total_pembayaran;
    public int total_harga_Integer;
    public String total2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        harga = findViewById(R.id.hargaAyam);
        reset = findViewById(R.id.reset);
        total_harga = findViewById(R.id.TotalHarga);
        total_harga_Integer = 0;
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        data = new ArrayList<>();
        for (int i = 0; i< Ayamku.nama.length; i++){
            data.add(new ItemModel(
                    Ayamku.nama[i],
                    Ayamku.harga[i],
                    Ayamku.gambar[i]
            ));
        }
        ayamkuAdapter = new AyamkuAdapter(this,data,this);
        recyclerView.setAdapter(ayamkuAdapter);
        total_harga.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                total2 = total_harga.getText().toString();
                Intent intent = new Intent(MainActivity.this, kalkulator.class);
                intent.putExtra("TOTALTAGIHAN", total2);
                startActivity(intent); } });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Intent i = new Intent(this, UpdateAccount.class);
                startActivity(i);
            case R.id.item2:
                Toast.makeText(this, "024-722***", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Toast.makeText(this, "08597********", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item4:
                Toast.makeText(this, "Maps Lokasi", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }



    @Override
    public void onNoteClick(int position) {
        int i = Integer.parseInt(Ayamku.harga[position]);
        total_harga_Integer = total_harga_Integer+i;
        total_harga.setText(""+total_harga_Integer);

    }

    public void reset_harga(View view){
        total_harga_Integer = 0;
        total_harga.setText(" ");
    }
}
