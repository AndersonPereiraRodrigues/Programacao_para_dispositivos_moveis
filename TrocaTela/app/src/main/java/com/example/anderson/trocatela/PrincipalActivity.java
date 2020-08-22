package com.example.anderson.trocatela;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrincipalActivity extends AppCompatActivity {
    //private Button btSair;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //btSair = (Button) findViewById(R.id.btSair);
       // btSair.setOnClickListener(new View.OnClickListener() {
        //    @Override
         //   public void onClick(View view) {
          //      btSairOncClick();
           // }
       // });
    }

    public void btSairOnClick(View view) {
        finish();
    }

    public void btLancamentoOnClick(View view) {
        Intent novaTela= new Intent(PrincipalActivity.this, LancamentoActivity.class);
        startActivity(novaTela);
        //finish();
    }
    //private void btSairOncClick(){
    //    finish();
    //}
}
