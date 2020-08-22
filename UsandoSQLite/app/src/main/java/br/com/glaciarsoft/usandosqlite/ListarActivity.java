package br.com.glaciarsoft.usandosqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListarActivity extends AppCompatActivity {

    private ListView lvResgistro;
    private SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        lvResgistro = (ListView) findViewById(R.id.lvRegistro);

        //bd=this.openOrCreateDatabase("banco", Context.MODE_PRIVATE, null);
        bd=ConexaoFactory.getConnection(this);
        montarLista();

    }

    private void montarLista() {
        Cursor registro = bd.query("cadastro", null,null,null,null,null,null,null);
        String campo[]={"NOME","TELEFONE"};
        int id_campo[]={android.R.id.text1,android.R.id.text2};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, registro,campo,id_campo);

        lvResgistro.setAdapter(adapter);
    }
}
