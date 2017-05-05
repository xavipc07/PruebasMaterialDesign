package com.apps.xavipc.pruebasmaterialdesign.modelos;

import com.apps.xavipc.pruebasmaterialdesign.R;

import java.util.ArrayList;

/**
 * Created by XaviPC on 21/04/2017.
 */

public class Platillo {

    private int imageId;
    private String titulo;
    private String descripción;

    public static ArrayList<Platillo> obtenerPlatillos(){
        ArrayList<Platillo> listaPlatillos = new ArrayList<>();
        int[] images = getImages();

        for(int i =0; i< images.length; i++){
            Platillo platillo = new Platillo();
            platillo.setImageId(images[i]);
            platillo.setTitulo("Platillo "+ i);

            listaPlatillos.add(platillo);
        }
        return listaPlatillos;
    }

    public static int[] getImages(){
        int[] images = {
                R.drawable.burrito_mini, R.drawable.hamburguesa_mini, R.drawable.nuggets_mini,
                R.drawable.platillo_especial_mini, R.drawable.tacos_mini, R.drawable.torta_mini,
                R.drawable.burrito_mini2, R.drawable.platillo_especial2, R.drawable.hamburguesa_mini2,
                R.drawable.torta_mini2, R.drawable.torta_mini3
        };

        return  images;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }
}
