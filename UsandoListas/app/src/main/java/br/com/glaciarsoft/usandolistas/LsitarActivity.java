package br.com.glaciarsoft.usandolistas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.opengl.EGLExt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class LsitarActivity extends AppCompatActivity {

    private ListView lvRegistros;

    private SQLiteDatabase banco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lsitar);

        lvRegistros =(ListView) findViewById(R.id.lvRegistros);

        banco = openOrCreateDatabase("banco", Context.MODE_PRIVATE,null);

        montarListaPrincipal();
    }

    private void montarListaPrincipal() {

        Cursor registros = banco.query("lancamento",null,null,null,null,null,null);
/**
 * uso do elemento criado por nos
 ****************************************************************************************************/
   /*     String colunaBanco[]={"descricao","valor","tipo"};
        int campoTela[]={R.id.tvDescricao,R.id.tvValor,R.id.tvTipo};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.elemento_lista, registros,colunaBanco,campoTela);

        lvRegistros.setAdapter(adapter);*/
 //**************************************************************************************************/

        /**
         * usando componentes interno do andoid
         *
        String colunaBanco[]={"descricao","tipo"};
        int campoTela[]={android.R.id.text1,android.R.id.text2};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, registros,colunaBanco,campoTela);

        lvRegistros.setAdapter(adapter);
         *
         */

        MeuAdapter adapter = new MeuAdapter(this,registros);

        lvRegistros.setAdapter(adapter);

    }
}
