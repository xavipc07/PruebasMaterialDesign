package com.apps.xavipc.pruebasmaterialdesign.modelos;

import com.apps.xavipc.pruebasmaterialdesign.R;

import java.util.ArrayList;

/**
 * Created by XaviPC on 22/04/2017.
 */

public class Sucursal {

    private int imageId;
    private String titulo;


    public static ArrayList<Sucursal> obtenerSucursales(){
        ArrayList<Sucursal> listaSucursals = new ArrayList<>();
        int[] images = getImages();

        for(int i =0; i< images.length; i++){
            Sucursal Sucursal = new Sucursal();
            Sucursal.setImageId(images[i]);
            Sucursal.setTitulo("Sucursal "+ i);

            listaSucursals.add(Sucursal);
        }
        return listaSucursals;
    }

    public static int[] getImages(){
        int[] images = {
                R.drawable.burrito_mini, R.drawable.hamburguesa_mini, R.drawable.nuggets_mini,
                R.drawable.tacos_mini, R.drawable.torta_mini,R.drawable.burrito_mini2,
                R.drawable.hamburguesa_mini2, R.drawable.torta_mini2, R.drawable.torta_mini3
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

}
