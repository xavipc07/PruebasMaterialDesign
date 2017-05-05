package com.apps.xavipc.pruebasmaterialdesign;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.apps.xavipc.pruebasmaterialdesign.adapters.RecyclerAdapter;
import com.apps.xavipc.pruebasmaterialdesign.modelos.Platillo;

public class PrincipalActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_con_toolbar);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Principal");
//        toolbar.inflateMenu(R.menu.menu_main);

        setUpDrawer();

        setUpRecyclerView();

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
//
//        } else  {
//
//        }
    }

    private void setUpDrawer() {
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.nav_drwr_fragment);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerFragment.setUpDrawer(R.id.nav_drwr_fragment, drawerLayout, toolbar);
    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerAdapter adapter = new RecyclerAdapter(PrincipalActivity.this, Platillo.obtenerPlatillos());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(this);
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLinearLayoutManagerVertical);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
