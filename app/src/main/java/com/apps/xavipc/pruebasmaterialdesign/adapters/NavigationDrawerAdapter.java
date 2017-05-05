package com.apps.xavipc.pruebasmaterialdesign.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.xavipc.pruebasmaterialdesign.ImagenesGrid;
import com.apps.xavipc.pruebasmaterialdesign.PrincipalActivity;
import com.apps.xavipc.pruebasmaterialdesign.R;
import com.apps.xavipc.pruebasmaterialdesign.modelos.NavigationDrawerItem;

import java.util.Collections;
import java.util.List;

/**
 * Created by XaviPC on 25/04/2017.
 */

public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.MyViewHolder> {
    private List<NavigationDrawerItem> mDataList = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    public NavigationDrawerAdapter(Context context, List<NavigationDrawerItem> data){
        this.context = context;
        this.mDataList = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.nav_drawer_list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        NavigationDrawerItem actual = mDataList.get(position);

        holder.imgIcon.setImageResource(actual.getImageId());
        holder.title.setText(actual.getTitulo());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(context, holder.title.getText().toString(), Toast.LENGTH_SHORT).show();

                switch (holder.title.getText().toString()){
                    case "Principal":
                        v.getContext().startActivity(new Intent(v.getContext(), PrincipalActivity.class));
                        break;
                    case "Menu":
                        v.getContext().startActivity(new Intent(v.getContext(), ImagenesGrid.class));
                        break;
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView imgIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.text_menu);
            imgIcon = (ImageView) itemView.findViewById(R.id.iconoMenu);
        }
    }
}
