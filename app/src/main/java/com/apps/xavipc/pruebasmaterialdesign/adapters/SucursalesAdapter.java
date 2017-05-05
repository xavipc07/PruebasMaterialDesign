package com.apps.xavipc.pruebasmaterialdesign.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.xavipc.pruebasmaterialdesign.R;
import com.apps.xavipc.pruebasmaterialdesign.modelos.Sucursal;

import java.util.List;

/**
 * Created by XaviPC on 22/04/2017.
 */

public class SucursalesAdapter extends RecyclerView.Adapter<SucursalesAdapter.MyViewHolder> {


    private List<Sucursal> mData;
    private LayoutInflater mInflater;

    public SucursalesAdapter(Context context, List<Sucursal> data){
        this.mData = data;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_item2, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Sucursal sucursalActual = mData.get(position);
        holder.setData(sucursalActual, position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titulo;
        ImageView miniatura;


        public MyViewHolder(View itemView) {
            super(itemView);
            titulo = (TextView) itemView.findViewById(R.id.tv_titulo2);
            miniatura = (ImageView) itemView.findViewById(R.id.imgRow2);
        }

        public void setData(Sucursal sucursalActual, int position) {
            this.titulo.setText(sucursalActual.getTitulo());
            this.miniatura.setImageResource(sucursalActual.getImageId());
        }
    }
}