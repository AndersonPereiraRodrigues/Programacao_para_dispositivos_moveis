package com.example.anderson.usandoeventofoco;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity {
    private EditText etTexto1;
    private EditText etTexto2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        etTexto1 = (EditText) findViewById(R.id.etTexto1);
        etTexto2 = (EditText) findViewById(R.id.etTexto2);

        etTexto1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                tratarEventoFoco(b);
            }
        });
        etTexto2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if(keyCode>= KeyEvent.KEYCODE_A && keyCode<= KeyEvent.KEYCODE_Z){
                    return false;
                }else {
                    return true;
                }
            }
        });
    }

    private void tratarEventoFoco(boolean temFoco) {
        if(temFoco){
            //apresentaAlerta("componente ganhou foco");
            Toast.makeText(this, "componente ganhou foco", Toast.LENGTH_LONG).show();
        }else{
            //apresentaAlerta("componente perdeu foco");
            Toast.makeText(this, "componente perdeu foco", Toast.LENGTH_LONG).show();
        }
    }
    private void apresentaAlerta(String msg){
        AlertDialog.Builder alerta =new AlertDialog.Builder(this);
        alerta.setTitle("Atenção");
        alerta.setMessage(msg);
        alerta.setNeutralButton("ok",null);
        alerta.show();
    }
}
