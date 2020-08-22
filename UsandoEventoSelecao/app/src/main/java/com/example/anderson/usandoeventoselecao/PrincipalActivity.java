package com.example.anderson.usandoeventoselecao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;

public class PrincipalActivity extends AppCompatActivity {
    private Spinner spimagem;
    private ImageView ivimagem;
    private String spOption[] = {
            "img01","img02","img03","img04","img06" };

    private int spOptionsId[] = {R.mipmap.img01,R.mipmap.img02,R.mipmap.img03,R.mipmap.img04,R.mipmap.img06};
    private ProgressBar progresso;
    private int id;
    private int ativ =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        spimagem = (Spinner) findViewById(R.id.spimagem);
        ivimagem = (ImageView) findViewById(R.id.ivImagem);
        progresso = (ProgressBar) findViewById(R.id.progresso);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, spOption);
        spimagem.setAdapter(adapter);
        spimagem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int id, long l) {
                tratarSelecao(id);
                /*if(id==1) {//pode ser usado ifs
                    ivimagem.setImageResource(R.mipmap.img01);
                }else if(id==2){
                    ivimagem.setImageResource(R.mipmap.img01);
                }*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void tratarSelecao(int id) {
        this.id=id;
        new ConexaoThread().start(); // inicia multi thread

    }
    class ConexaoThread extends Thread{

        public void run(){
            try{
                for(int i=0;i<=100; i++){
                    progresso.setProgress(i);
                    Thread.sleep(100);
                }

                PrincipalActivity.this.runOnUiThread(new Thread(){
                    public void run(){
                        ivimagem.setImageResource(spOptionsId[id]);
                    }
                });

            }catch (Exception e){

            }
        }

    }

}
