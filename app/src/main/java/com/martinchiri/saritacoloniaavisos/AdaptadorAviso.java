package com.martinchiri.saritacoloniaavisos;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorAviso extends RecyclerView.Adapter<AdaptadorAviso.AvisoCelda> {
    ArrayList<Aviso> elementos;
    private OnItemClickListener itemClickListener;

    public AdaptadorAviso(ArrayList<Aviso> elementos, OnItemClickListener itemClickListener) {
        this.elementos = elementos;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public AvisoCelda onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.celda_aviso,parent,false);
        return new AvisoCelda(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AvisoCelda holder, int position) {
        Aviso aviso=elementos.get(position);
        holder.bind(aviso,itemClickListener);
    }

    @Override
    public int getItemCount() {
        return elementos.size();
    }

    public class AvisoCelda extends RecyclerView.ViewHolder {
        TextView tvTitulo;
        public AvisoCelda(View itemView) {
            super(itemView);
            tvTitulo=itemView.findViewById(R.id.tvTitulo);
        }
        public void bind(final Aviso aviso, final OnItemClickListener listener){
            final String titulo=aviso.getTitulo();
            this.tvTitulo.setText(titulo);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(aviso,getAdapterPosition());
                }
            });
        }
    }
    public interface OnItemClickListener{
        void onItemClick(Aviso aviso, int position);
    }
}
