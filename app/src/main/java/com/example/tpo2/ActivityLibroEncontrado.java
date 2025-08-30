package com.example.tpo2;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tpo2.databinding.ActivityLibroEncontradoBinding;
import com.example.tpo2.databinding.ActivityMainBinding;
import com.example.tpo2.libros.Libro;

public class ActivityLibroEncontrado extends AppCompatActivity {
    private ActivityLibroEncontradoBinding binding;
    private ActivityLibroEncontradoViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLibroEncontradoBinding.inflate(getLayoutInflater());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ActivityLibroEncontradoViewModel.class);
        setContentView(binding.getRoot());
        vm.getMutableLibro().observe(this, new Observer<Libro>() {
            @Override
            public void onChanged(Libro libro) {
                binding.etTitulo.setText(libro.getTitulo());
                binding.etAutor.setText(libro.getAutor());
                binding.etEditorial.setText(libro.getEditorial());
                binding.etDescripcion.setText(libro.getDescripcion());
                binding.etAnio.setText(String.valueOf(libro.getAnio()));
                binding.etPaginas.setText(String.valueOf(libro.getPaginas()));
            }
        });
        vm.obtenerLibro(getIntent());

        binding.btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View volver) {
                Intent intent = new Intent(getApplication(), MainActivity.class);
                intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                getApplication().startActivity(intent);
            }
        });
    }
}