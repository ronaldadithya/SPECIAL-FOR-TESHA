package com.example.aplikasidesa;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AyamkuAdapter extends
        RecyclerView.Adapter<AyamkuAdapter.ViewHolder> {

    ArrayList<ItemModel> dataItem;
    OnNoteListener mOnNoteListener;
    Context mContext;

    @NonNull
    @Override
    public AyamkuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.detail,parent
                        ,false);
        return new ViewHolder(view,mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AyamkuAdapter.ViewHolder holder, int position) {
        TextView text_nama = holder.textNama;
        TextView text_harga = holder.textHarga;
        ImageView i_gambar = holder.gambar;

        text_nama.setText(dataItem.get(position).getNama());
        text_harga.setText("RP."+dataItem.get(position).getHarga());

        i_gambar.setImageResource(dataItem.get(position).getGambar());

        holder.textNama.setOnClickListener(view -> {
            if(dataItem.get(position).getNama().equals("Ayam goreng")){
                Intent intent = new Intent(mContext,produk.class);
                intent.putExtra("TEXT_DEFAULT","Ayam Goreng Utuh 1 ekor");
                intent.putExtra("GAMBAR_DEFAULT",R.drawable.ayam1);
                mContext.startActivity(intent);
            }
            if(dataItem.get(position).getNama().equals("Beras")){
                Intent intent = new Intent(mContext,produk.class);
                intent.putExtra("TEXT_DEFAULT","Beras Produk Lokas 5kg");
                intent.putExtra("GAMBAR_DEFAULT",R.drawable.beras);
                mContext.startActivity(intent);
            }
            if(dataItem.get(position).getNama().equals("Peyek Kacang")){
                Intent intent = new Intent(mContext,produk.class);
                intent.putExtra("TEXT_DEFAULT","Peyek Kacang Premium 5kg");
                intent.putExtra("GAMBAR_DEFAULT",R.drawable.peyekkacang);
                mContext.startActivity(intent);
            }
            if(dataItem.get(position).getNama().equals("Peyek Udang")){
                Intent intent = new Intent(mContext,produk.class);
                intent.putExtra("TEXT_DEFAULT","Peyek Udang Premium 3kg");
                intent.putExtra("GAMBAR_DEFAULT",R.drawable.peyekudang);
                mContext.startActivity(intent);
            }
            if(dataItem.get(position).getNama().equals("Alpukat")){
                Intent intent = new Intent(mContext,produk.class);
                intent.putExtra("TEXT_DEFAULT","Alpukat Musang King 3kg");
                intent.putExtra("GAMBAR_DEFAULT",R.drawable.alpukat);
                mContext.startActivity(intent);
            }
            if(dataItem.get(position).getNama().equals("Kelengkeng")){
                Intent intent = new Intent(mContext,produk.class);
                intent.putExtra("TEXT_DEFAULT","Kelengkeng Musang King 3kg");
                intent.putExtra("GAMBAR_DEFAULT",R.drawable.kelengkeng);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        TextView textNama,textHarga;
        ImageView gambar;

        OnNoteListener mOnNoteListener;
        Context mContext;


        public ViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);

            gambar = itemView.findViewById(R.id.gambarAyam);
            textNama = itemView.findViewById(R.id.noAyam);
            textHarga = itemView.findViewById(R.id.hargaAyam);
            this.mOnNoteListener = onNoteListener;

            gambar.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mOnNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    AyamkuAdapter(Context context, ArrayList<ItemModel> data, OnNoteListener onNoteListener){
        this.dataItem =data;
        this.mOnNoteListener = onNoteListener;
        this.mContext = context;
    }

    public interface OnNoteListener{
        void onNoteClick(int position);
    }

}
