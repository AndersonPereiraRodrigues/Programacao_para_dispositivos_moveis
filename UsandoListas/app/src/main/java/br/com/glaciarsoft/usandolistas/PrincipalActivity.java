package br.com.glaciarsoft.usandolistas;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity {
    private Spinner stTipo;
    private EditText etDescricao;
    private EditText etValor;

    private SQLiteDatabase banco;

    String tipo[]= {"Crédito", "Débito"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        stTipo = (Spinner) findViewById(R.id.spTipo);
        etDescricao=(EditText) findViewById(R.id.etDescicao);
        etValor=(EditText) findViewById(R.id.etValor);

        ArrayAdapter tipoAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, tipo);
        stTipo.setAdapter(tipoAdapter);

        banco = openOrCreateDatabase("banco",Context.MODE_PRIVATE, null);
        banco.execSQL("CREATE TABLE IF NOT EXISTS lancamento(_id INTEGER PRIMARY KEY AUTOINCREMENT, descricao TEXT, valor DECIMAL, tipo TEXT)");
    }

    public void btLancarOnClick(View view) {
        String tipo = (String) stTipo.getItemAtPosition(stTipo.getSelectedItemPosition());

        ContentValues registro=  new ContentValues();
        registro.put("descricao",etDescricao.getText().toString());
        registro.put("valor",Double.parseDouble(etValor.getText().toString()));
        registro.put("tipo",tipo);

        banco.insert("lancamento",null, registro);
        Toast.makeText(this, "Sucesso",Toast.LENGTH_LONG).show();
    }

    public void btListarOnClick(View view) {
        startActivity(new Intent(this,LsitarActivity.class));
    }
}
