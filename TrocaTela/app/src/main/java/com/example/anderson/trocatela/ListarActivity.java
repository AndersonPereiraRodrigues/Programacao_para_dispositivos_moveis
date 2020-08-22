package com.example.anderson.trocatela;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ListarActivity extends AppCompatActivity {
    private ListView lvProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        lvProdutos=(ListView) findViewById(R.id.lvProdutos);

        lvProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                lvProdutosOnItemClick(pos);
            }

        });

    }
    private void lvProdutosOnItemClick(int pos) {
        Toast.makeText( this, "Elemento: "+pos+" selecionado", Toast.LENGTH_LONG).show();
        int cod= pos+1;
        Intent nova=getIntent();
        nova.putExtra("cod",cod);
        setResult(0,nova);
        finish();
    }
}
