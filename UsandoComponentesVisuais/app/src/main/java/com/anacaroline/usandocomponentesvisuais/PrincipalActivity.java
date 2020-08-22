package com.anacaroline.usandocomponentesvisuais;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RadioButton;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PrincipalActivity extends AppCompatActivity {

    private RadioButton rbMasc;
    private RadioButton rbFem;

    private CheckBox cbNatacao;
    private CheckBox cbCorrida;
    private CheckBox cbFutebol;

    private DatePicker dpData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        rbMasc = (RadioButton) findViewById(R.id.rbMasc);
        rbFem = (RadioButton) findViewById(R.id.rbFem);;

        cbNatacao = (CheckBox) findViewById(R.id.cbNatacao);
        cbCorrida = (CheckBox) findViewById(R.id.cbCorrida);
        cbFutebol = (CheckBox) findViewById(R.id.cbFutebol);

        dpData = (DatePicker) findViewById(R.id.dpData);
    }

    public void btTestarComponenteOnClick (View view){

        //testando RadioGroup
        if(rbMasc.isChecked()){// isChecked verifica se o botao esta marcado
            //ação1
        }
        else{
            //ação2
        }

        if(cbNatacao.isChecked()){
            //açao1
        }
        if(cbCorrida.isChecked()){
            //acao2
        }

        if(cbFutebol.isChecked()){
            //acao3
        }

        int dia = dpData.getDayOfMonth();
        int mes = dpData.getMonth();
        int ano = dpData.getYear();

        String dataFormatada = dia + "/" + (mes+1) + "/" + ano;

        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date info = formatador.parse(dataFormatada);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
