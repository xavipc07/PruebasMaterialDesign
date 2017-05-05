package com.apps.xavipc.pruebasmaterialdesign.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.xavipc.pruebasmaterialdesign.R;
import com.apps.xavipc.pruebasmaterialdesign.modelos.ImagenMulti;

import java.util.List;

/**
 * Created by XaviPC on 24/04/2017.
 */

public class RecyclerMultiAdapter extends RecyclerView.Adapter<RecyclerMultiAdapter.MyViewHolder> {


    private static final int PRIME_ROW = 0;
    private static final int NON_PRIME_ROW = 1;
    private List<ImagenMulti> mData;
    private LayoutInflater mInflater;

    public RecyclerMultiAdapter(Context context, List<ImagenMulti> data) {
        this.mData = data;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case PRIME_ROW:
                ViewGroup filaPrima = (ViewGroup) mInflater.inflate(R.layout.list_item_num_primo, parent, false);
                MyViewHolder_PRIME holderPrimo = new MyViewHolder_PRIME(filaPrima);
                return holderPrimo;

            case NON_PRIME_ROW:
                ViewGroup filaNoPrima = (ViewGroup) mInflater.inflate(R.layout.list_item_num_no_primo, parent, false);
                MyViewHolder_NON_PRIME holderNoPrimo = new MyViewHolder_NON_PRIME(filaNoPrima);
                return holderNoPrimo;

            default:
                ViewGroup filaSimple = (ViewGroup) mInflater.inflate(R.layout.list_item_num_no_primo, parent, false);
                MyViewHolder_NON_PRIME holderSimple = new MyViewHolder_NON_PRIME(filaSimple);
                return holderSimple;

        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ImagenMulti imagenMultiActual = mData.get(position);

        switch (holder.getItemViewType()) {
            case PRIME_ROW:
                MyViewHolder_PRIME hp = (MyViewHolder_PRIME) holder;
                hp.setData(imagenMultiActual);
                break;

            case NON_PRIME_ROW:
                MyViewHolder_NON_PRIME hnp = (MyViewHolder_NON_PRIME) holder;
                hnp.setData(imagenMultiActual);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        ImagenMulti im = mData.get(position);
        if (im.isPrime()) {
            return PRIME_ROW;
        } else {
            return NON_PRIME_ROW;
        }
    }

    public void agregarElemento(int posición, ImagenMulti ImagenMulti) {
        mData.add(posición, ImagenMulti);
        notifyItemInserted(posición);
        notifyItemRangeChanged(posición, mData.size());
    }

    public void eliminarElemento(int posición) {
        mData.remove(posición);
        notifyItemRemoved(posición);
        notifyItemRangeChanged(posición, mData.size());
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class MyViewHolder_PRIME extends RecyclerMultiAdapter.MyViewHolder {

        TextView titulo;
        ImageView miniatura, tipoFila;


        public MyViewHolder_PRIME(View itemView) {
            super(itemView);

            titulo = (TextView) itemView.findViewById(R.id.tv_titulo3);
            miniatura = (ImageView) itemView.findViewById(R.id.imgRow3);
            tipoFila = (ImageView) itemView.findViewById(R.id.img_num_primo);
        }

        public void setData(ImagenMulti img) {
            this.titulo.setText(img.getTitulo());
            this.miniatura.setImageResource(img.getImageId());
            this.tipoFila.setImageResource(R.drawable.ic_num_primo);
        }
    }

    public class MyViewHolder_NON_PRIME extends RecyclerMultiAdapter.MyViewHolder {

        TextView titulo;
        ImageView miniatura, tipoFila;

        public MyViewHolder_NON_PRIME(View itemView) {
            super(itemView);
            titulo = (TextView) itemView.findViewById(R.id.tv_titulo3);
            miniatura = (ImageView) itemView.findViewById(R.id.imgRow3);
            tipoFila = (ImageView) itemView.findViewById(R.id.img_num_primo);
        }

        public void setData(ImagenMulti img) {
            this.titulo.setText(img.getTitulo());
            this.miniatura.setImageResource(img.getImageId());
            this.tipoFila.setImageResource(R.drawable.ic_num_primo);
        }
    }
}
