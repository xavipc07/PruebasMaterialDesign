package com.apps.xavipc.pruebasmaterialdesign;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;

import com.apps.xavipc.pruebasmaterialdesign.adapters.SucursalesAdapter;
import com.apps.xavipc.pruebasmaterialdesign.modelos.Sucursal;

public class ImagenesGrid extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagenes_grid);

        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle("Galería de Imagenes");

        setUpDrawer();

        setUpRecyclerView();
    }

    private void setUpDrawer() {
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.nav_drwr_fragment);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerFragment.setUpDrawer(R.id.nav_drwr_fragment, drawerLayout, toolbar);
    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView2);
        SucursalesAdapter adapter = new SucursalesAdapter(ImagenesGrid.this, Sucursal.obtenerSucursales());
        recyclerView.setAdapter(adapter);

//        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(this);
//        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.HORIZONTAL);
//        recyclerView.setLayoutManager(mLinearLayoutManagerVertical);

        StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(sglm);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
