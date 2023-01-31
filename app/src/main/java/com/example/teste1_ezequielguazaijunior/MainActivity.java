package com.example.teste1_ezequielguazaijunior;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.teste1_ezequielguazaijunior.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private String novoNome, novoTitulo, novaEditora;
    private int novoAno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String autor = bundle.getString("nome");
            String titulo = bundle.getString("titulo");
            String ano = String.valueOf(bundle.getInt("ano"));
            String editora = bundle.getString("editora");

            binding.autorEd.setText(autor);
            binding.tituloEd.setText(titulo);
            binding.anoEd.setText(ano);
            binding.editoraEd.setText(editora);
        }

        binding.gravarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    novoNome = binding.autorEd.getText().toString();
                    novoTitulo = binding.tituloEd.getText().toString();
                    novoAno = Integer.parseInt(binding.anoEd.getText().toString());
                    novaEditora = binding.editoraEd.getText().toString();

                    LivroModel livro = new LivroModel(novoNome, novoTitulo, novaEditora, novoAno);
                    DataAccessObject.livroModels.add(livro);

                    binding.anoEd.setText(null);
                    binding.autorEd.setText(null);
                    binding.tituloEd.setText(null);
                    binding.editoraEd.setText(null);

                    Toast.makeText(MainActivity.this, "Gravado", Toast.LENGTH_SHORT).show();
                }catch (NumberFormatException e){
                    Toast.makeText(MainActivity.this, "Preencha correctamente os campos", Toast.LENGTH_SHORT).show();
                }catch (NullPointerException e){
                    Toast.makeText(MainActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.listarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListarActivity.class);
                for (LivroModel estudante: DataAccessObject.livroModels){
                    intent.putExtra("nome", estudante.getAutor());
                    intent.putExtra("titulo", estudante.getTitulo());
                    intent.putExtra("ano", estudante.getAno());
                    intent.putExtra("editora", estudante.getEditora());
                }
                startActivity(intent);
            }
        });

    }

}