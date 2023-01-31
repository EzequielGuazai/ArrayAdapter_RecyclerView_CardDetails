package com.example.teste1_ezequielguazaijunior;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.teste1_ezequielguazaijunior.databinding.ActivityDetalhesBinding;

public class DetalhesActivity extends AppCompatActivity {

    private ActivityDetalhesBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetalhesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String autor = bundle.getString("nome");
            String titulo = bundle.getString("titulo");
            String ano = String.valueOf(bundle.getString("ano"));
            String editora = bundle.getString("editora");

            binding.autorDetalhesTv.setText(autor);
            binding.tituloDetalhesTv.setText(titulo);
            binding.anoDetalhesTv.setText(ano);
            binding.editoraDetalhesTv.setText(editora);

        }
    }
}