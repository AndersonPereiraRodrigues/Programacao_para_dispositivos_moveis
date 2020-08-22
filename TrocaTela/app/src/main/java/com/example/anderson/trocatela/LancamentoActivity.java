package com.example.anderson.trocatela;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LancamentoActivity extends AppCompatActivity {
    private EditText etCod;
    private EditText etQtd;
    private EditText etValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancamento);
        etCod=(EditText) findViewById(R.id.etCod);
        etQtd=(EditText) findViewById(R.id.etQtd);
        etValor=(EditText) findViewById(R.id.etValor);
    }

    public void btListarProdutosOnClick(View view) {
        Intent novaTela= new Intent(LancamentoActivity.this, ListarActivity.class);
        startActivityForResult(novaTela, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(data!=null){
                //TODO
                int cod = data.getIntExtra("cod",0);
                etCod.setText(String.valueOf(cod));
            }
        }
    }

    public void btConfirmarOnClick(View view) {
        Intent novaTela= new Intent(LancamentoActivity.this, ConfirmarActivity.class);
        novaTela.putExtra("cod",etCod.getText().toString());
        novaTela.putExtra("qtd",etQtd.getText().toString());
        novaTela.putExtra("valor",etValor.getText().toString());
        startActivity(novaTela);
    }
}
