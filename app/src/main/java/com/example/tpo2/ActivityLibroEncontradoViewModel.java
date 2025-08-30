package com.example.tpo2;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tpo2.libros.Libro;

public class ActivityLibroEncontradoViewModel extends AndroidViewModel {
    private MutableLiveData<Libro> libroMutable;

    public ActivityLibroEncontradoViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Libro> getMutableLibro() {
        if (libroMutable == null) {
            libroMutable = new MutableLiveData<>();
        }
        return libroMutable;
    }

    public void obtenerLibro(Intent libroIntent) {
       Libro lib = libroIntent.getSerializableExtra("Libro", Libro.class);
        libroMutable.setValue(lib);
    }

}
