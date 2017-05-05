package com.apps.xavipc.pruebasmaterialdesign;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class NuevosLayout extends AppCompatActivity{

    public NuevosLayout() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "Esto es una prueba", Toast.LENGTH_SHORT).show();
    }
}
