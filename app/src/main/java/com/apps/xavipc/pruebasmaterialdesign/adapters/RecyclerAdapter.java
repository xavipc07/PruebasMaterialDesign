package com.apps.xavipc.pruebasmaterialdesign.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.xavipc.pruebasmaterialdesign.R;
import com.apps.xavipc.pruebasmaterialdesign.modelos.Platillo;

import java.util.List;

/**
 * Created by XaviPC on 21/04/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {


    private List<Platillo> mData;
    private LayoutInflater mInflater;

    public RecyclerAdapter(Context context, List<Platillo> data){
        this.mData = data;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Platillo platilloActual = mData.get(position);
        holder.setData(platilloActual, position);
        holder.setListeners();
    }

    public void agregarElemento(int posición, Platillo platillo){
        mData.add(posición, platillo);
        notifyItemInserted(posición);
        notifyItemRangeChanged(posición, mData.size());
    }

    public void eliminarElemento(int posición){
        mData.remove(posición);
        notifyItemRemoved(posición);
        notifyItemRangeChanged(posición, mData.size());
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView titulo;
        ImageView miniatura, borrar, agregar;
        int position;
        Platillo platilloActual;

        public MyViewHolder(View itemView) {
            super(itemView);
            titulo = (TextView) itemView.findViewById(R.id.tv_titulo);
            miniatura = (ImageView) itemView.findViewById(R.id.imgRow);
            borrar = (ImageView) itemView.findViewById(R.id.img_borrar);
            agregar = (ImageView) itemView.findViewById(R.id.img_nuevo);
        }

        public void setData(Platillo platilloActual, int position) {
            this.titulo.setText(platilloActual.getTitulo());
            this.miniatura.setImageResource(platilloActual.getImageId());
            this.position = position;
            this.platilloActual = platilloActual;
        }

        public void setListeners(){
            borrar.setOnClickListener(MyViewHolder.this);
            agregar.setOnClickListener(MyViewHolder.this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.img_borrar:
                    eliminarElemento(position);
                    break;
                case R.id.img_nuevo:
                    agregarElemento(position, platilloActual);
                    break;
            }
        }
    }
}
