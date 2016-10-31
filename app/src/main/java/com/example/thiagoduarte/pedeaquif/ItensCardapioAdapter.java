package com.example.thiagoduarte.pedeaquif;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by THIAGODUARTE on 26/10/2016.
 */
public class ItensCardapioAdapter  extends BaseAdapter {
    Context ctx;
    List<ItensCardapio> itensCardapios;

    public ItensCardapioAdapter(Context ctx, List<ItensCardapio> itensCardapios) {
        this.ctx = ctx;
        this.itensCardapios = itensCardapios;
    }
    @Override
    public int getCount() {
        return itensCardapios.size();
    }


    @Override
    public Object getItem(int position){
        return itensCardapios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder{
        ImageView imgLogo;
        TextView txtNome;
        TextView txtValor;
        TextView txtTipo;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItensCardapio itensCardapio = itensCardapios.get(position);


       // View linha = LayoutInflater.from(ctx).inflate(R.layout.activity_item__cardapio,null);

        //ImageView imgLogo = (ImageView)linha.findViewById(R.id.imgLogo);
       // TextView txtNome = (TextView)linha.findViewById(R.id.txtNome);
       // TextView txtValor = (TextView)linha.findViewById(R.id.txtValor);
        //TextView txtTipo = (TextView)linha.findViewById(R.id.txtTipo);

        //Resources res =ctx.getResources();
        //TypedArray logos =res.obtainTypedArray(R.array.logos);
        //imgLogo.setImageDrawable(logos.getDrawable(itensCardapio.idNome));

       // txtNome.setText(itensCardapio.nome);
       // txtValor.setText(itensCardapio.valor);
       // txtTipo.setText(itensCardapio.tipo);


       // return linha;

        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(ctx).inflate(R.layout.activity_item__cardapio,null);
            holder = new ViewHolder();
            holder.imgLogo = (ImageView)convertView.findViewById(R.id.imgLogo);
            holder.txtNome = (TextView)convertView.findViewById(R.id.txtNome);
            holder.txtValor = (TextView)convertView.findViewById(R.id.txtValor);
            holder.txtTipo = (TextView)convertView.findViewById(R.id.txtTipo);
            convertView.setTag(holder);

        }else{

            holder =  (ViewHolder)convertView.getTag();
        }

        Resources res =ctx.getResources();
        TypedArray logos =res.obtainTypedArray(R.array.logos);
        holder.imgLogo.setImageDrawable(logos.getDrawable(itensCardapio.idNome));

         holder.txtNome.setText(itensCardapio.nome);
        holder.txtValor.setText(itensCardapio.valor);
       holder.txtTipo.setText(itensCardapio.tipo);

        return convertView;

    }

}
