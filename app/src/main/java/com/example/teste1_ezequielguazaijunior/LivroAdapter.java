package com.example.teste1_ezequielguazaijunior;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class LivroAdapter extends RecyclerView.Adapter<LivroAdapter.ViewHolder> {

    private ArrayList<LivroModel> listar;
    public LivroAdapter(ArrayList<LivroModel> listar) {
        this.listar = listar;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.autorTv.setText(listar.get(position).getAutor());
        holder.tituloTv.setText(listar.get(position).getTitulo());
    }

    @Override
    public int getItemCount() {
        return listar.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView autorTv, tituloTv;
        public TextView autor_detalhes_tv, titulo_detalhes_tv, ano_detalhes_tv, editora_detalhes_tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            autorTv = itemView.findViewById(R.id.autorTv);
            tituloTv = itemView.findViewById(R.id.tituloTv);

            autor_detalhes_tv = itemView.findViewById(R.id.autor_detalhes_tv);
            titulo_detalhes_tv = itemView.findViewById(R.id.titulo_detalhes_Tv);
            ano_detalhes_tv = itemView.findViewById(R.id.ano_detalhes_tv);
            editora_detalhes_tv = itemView.findViewById(R.id.editora_detalhes_tv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    abrirNovaActivity();
                }

            });
        }
        private void abrirNovaActivity() {
            Intent intent = new Intent(itemView.getContext(), DetalhesActivity.class);
            int position = getAdapterPosition();
            intent.putExtra("nome", listar.get(position).getAutor());
            intent.putExtra("titulo", listar.get(position).getTitulo());
            intent.putExtra("ano", String.valueOf(listar.get(position).getAno()));
            intent.putExtra("editora", listar.get(position).getEditora());

            itemView.getContext().startActivity(intent);
        }
    }
}
