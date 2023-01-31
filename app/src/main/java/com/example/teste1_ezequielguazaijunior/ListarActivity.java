package com.example.teste1_ezequielguazaijunior;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teste1_ezequielguazaijunior.databinding.ActivityListarBinding;


public class ListarActivity extends AppCompatActivity {

    private ActivityListarBinding binding;
    private RecyclerView recyclerView;
    private LivroAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //pegar o recyclerView da nossa activity onde esta o recycler
        recyclerView = binding.recyclerView;
        //colocamos o layout manager a nossa escolha
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //pegamos o adapter que criamos
        adapter = new LivroAdapter(DataAccessObject.livroModels);
        //e colocamos o adapter no recycler view
        recyclerView.setAdapter(adapter);

        //colocamos acao no nosso botao para voltarmos ao main
        binding.adicionarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListarActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}