package br.com.glaciarsoft.usandolistas;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MeuAdapter extends BaseAdapter {

    private Context context;
    private Cursor registros;

    public MeuAdapter(Context context, Cursor registros){
        this.context =context;
        this.registros=registros;
    }

    @Override
    public int getCount() {
        return registros.getCount();
    }

    @Override
    public Object getItem(int posicao) {
        return registros.moveToPosition(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return posicao;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View v= inflater.inflate(R.layout.elemento_lista, null);

        TextView tvDescricao = v.findViewById(R.id.tvDescricao);
        TextView tvValor = v.findViewById(R.id.tvValor);
        ImageView ivTipo = v.findViewById(R.id.ivTipo);

        registros.moveToPosition(posicao);

        tvDescricao.setText(registros.getString(registros.getColumnIndex("descricao")));
        tvValor.setText(String.valueOf(registros.getDouble(registros.getColumnIndex("valor"))));
        String tipo = registros.getString(registros.getColumnIndex("tipo"));
        if(tipo.equalsIgnoreCase("Crédito")){
            ivTipo.setImageResource(android.R.drawable.btn_plus);
        }else{
            ivTipo.setImageResource(android.R.drawable.btn_minus);
        }
        return v;
    }
}
