package com.apps.xavipc.pruebasmaterialdesign.modelos;

import com.apps.xavipc.pruebasmaterialdesign.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XaviPC on 25/04/2017.
 */

public class NavigationDrawerItem {

    private String titulo;
    private int imageId;

    public static List<NavigationDrawerItem> getData() {
        List<NavigationDrawerItem> dataList = new ArrayList<>();

        int[] imageIds = getImagenes();
        String[] titulos = getTitulos();

        for (int i = 0; i < titulos.length; i++) {
            NavigationDrawerItem navItem = new NavigationDrawerItem();
            navItem.setTitulo(titulos[i]);
            navItem.setImageId(imageIds[i]);
            dataList.add(navItem);
        }
        return dataList;
    }

    private static String[] getTitulos() {
        return new String[] {"Principal", "Menu", "Sucursales", "Fotos", "Videos", "BLP Cam", "Encuesta de Servicio", "Buzón"};
    }

    private static int[] getImagenes() {

        return new int[]{
                R.drawable.ic_principal, R.drawable.ic_restaurant_menu, R.drawable.ic_sucursales,
                R.drawable.ic_fotos, R.drawable.ic_videos, R.drawable.ic_photo_camara,
                R.drawable.ic_encuesta, R.drawable.ic_buzon
        };
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
