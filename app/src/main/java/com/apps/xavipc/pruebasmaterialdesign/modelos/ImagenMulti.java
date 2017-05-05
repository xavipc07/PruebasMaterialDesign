package com.apps.xavipc.pruebasmaterialdesign.modelos;

import com.apps.xavipc.pruebasmaterialdesign.R;

import java.util.ArrayList;

/**
 * Created by XaviPC on 24/04/2017.
 */

public class ImagenMulti {

    private int imageId;
    private String titulo;
    private String descripción;
    private boolean prime;

    public static ArrayList<ImagenMulti> obtenerPlatillos() {
        ArrayList<ImagenMulti> listaPlatillos = new ArrayList<>();
        int[] images = getImages();

        for (int i = 0; i < images.length; i++) {
            ImagenMulti platillo = new ImagenMulti();
            platillo.setImageId(images[i]);
            platillo.setTitulo("Platillo " + i);
            platillo.setPrime(checkPrime(i));

            listaPlatillos.add(platillo);
        }
        return listaPlatillos;
    }

    private static boolean checkPrime(int posición) {
        if (posición == 0 || posición == 1) {
            return false;
        }
        for (int i = 2; i <= posición / 2; i++) {
            if (posición % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] getImages() {
        int[] images = {
                R.drawable.burrito_mini, R.drawable.hamburguesa_mini, R.drawable.nuggets_mini,
                R.drawable.platillo_especial_mini, R.drawable.tacos_mini, R.drawable.torta_mini,
                R.drawable.burrito_mini2, R.drawable.platillo_especial2, R.drawable.hamburguesa_mini2,
                R.drawable.torta_mini2, R.drawable.torta_mini3
        };

        return images;
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

    public boolean isPrime() {
        return prime;
    }

    public void setPrime(boolean prime) {
        this.prime = prime;
    }
}
