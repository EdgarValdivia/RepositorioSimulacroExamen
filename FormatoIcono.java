package com.example.edgarvaldivia.xprestamosgingerbread;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by edgarvaldivia on 25/05/16.
 */

public class FormatoIcono extends BaseAdapter {
   Context ct;
   String info[];
   int monos[];
    LayoutInflater lf;

   public FormatoIcono(Context ct,String info[],int monos[]){
       this.ct=ct;
       this.info=info;
       this.monos=monos;
   }//constructor



    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView informacion;
        ImageView estados;

        lf = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View vistaItem = lf.inflate(R.layout.formato, parent, false);

        informacion = (TextView) vistaItem.findViewById(R.id.txtFormato);
        estados = (ImageView) vistaItem.findViewById(R.id.imageFormato);

        informacion.setText(info[position]);
        estados.setImageResource(monos[position]);
        return vistaItem;
    }
}
