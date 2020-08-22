package com.example.anderson.trocatela;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmarActivity extends AppCompatActivity {
    private TextView tvQtd;
    private TextView tvCod;
    private TextView tvValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);
        tvCod=(TextView) findViewById(R.id.tvCod);
        tvQtd=(TextView) findViewById(R.id.tvQtd);
        tvValor=(TextView) findViewById(R.id.tvValor);
        Intent novaTela=getIntent();
        tvCod.setText(novaTela.getStringExtra("cod"));
        tvQtd.setText(novaTela.getStringExtra("qtd"));
        tvValor.setText(novaTela.getStringExtra("valor"));
    }

    public void btConfirmarFimOnClick(View view) {
        Toast.makeText(this,"Op. Indisponivel no Momento", Toast.LENGTH_LONG).show();

    }


    public void btCancelarOnClick(View view) {
        finish();
    }
}
