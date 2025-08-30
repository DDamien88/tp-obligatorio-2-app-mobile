package com.example.tpo2;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tpo2.libros.Libro;

import java.util.Arrays;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private MutableLiveData<String> mutableError;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    private List<Libro> biblioteca = Arrays.asList(
            new Libro(
                    "Clean Code",
                    "9780132350884",
                    "Robert C. Martin",
                    "Prentice Hall",
                    "Un manual sobre cómo escribir código limpio, mantenible y escalable en proyectos de software.",
                    "Programación",
                    2008,
                    464
            ),

            new Libro(
                    "Design Patterns",
                    "9780201633610",
                    "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides",
                    "Addison-Wesley",
                    "Describe 23 patrones de diseño clásicos que resuelven problemas comunes en desarrollo orientado a objetos.",
                    "Ingeniería de Software",
                    1994,
                    395
            ),

            new Libro(
                    "Introduction",
                    "9780262046305",
                    "Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, Clifford Stein",
                    "MIT Press",
                    "Una referencia académica completa sobre algoritmos y estructuras de datos.",
                    "Algoritmos",
                    2022,
                    1312
            ),

            new Libro(
                    "Refactoring: Improving the Design of Existing Code",
                    "9780134757599",
                    "Martin Fowler",
                    "Addison-Wesley",
                    "Explica cómo mejorar la estructura de un código existente sin cambiar su comportamiento.",
                    "Buenas prácticas",
                    2018,
                    448
            ),

            new Libro(
                    "The Pragmatic Programmer",
                    "9780135957059",
                    "Andrew Hunt, David Thomas",
                    "Addison-Wesley",
                    "Consejos prácticos y filosofía de desarrollo de software para convertirse en un mejor programador.",
                    "Desarrollo",
                    2019,
                    352
            )
    );

    public void buscarLibro(String titulo) {
        for (Libro libro : biblioteca) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                Intent intentLibro = new Intent(getApplication(), ActivityLibroEncontrado.class);
                intentLibro.putExtra("Libro", libro);
                intentLibro.setFlags(intentLibro.FLAG_ACTIVITY_NEW_TASK);
                getApplication().startActivity(intentLibro);
            } else {
                mutableError.setValue("No se encontró el libro");
            }
        }
    }


    public LiveData<String> getMutableError() {
        if (mutableError == null) {
            mutableError = new MutableLiveData<>();
        }
        return mutableError;
    }

}

