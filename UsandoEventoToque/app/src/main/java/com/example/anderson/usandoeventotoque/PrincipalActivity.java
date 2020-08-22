package com.example.anderson.usandoeventotoque;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PrincipalActivity extends AppCompatActivity {
    private LinearLayout tela;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        tela = (LinearLayout) findViewById(R.id.tela);

        tela.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                tratarEventoToque(motionEvent);

                return true;//se for false ele trata só um evento o de toque no caso
            }
        });
    }

    private void tratarEventoToque(MotionEvent motionEvent) {
        String msg="";
        if(motionEvent.getAction()== motionEvent.ACTION_DOWN){
            msg = "Presionou na tela";
        }else if(motionEvent.getAction()==MotionEvent.ACTION_UP){
            msg = "Soltou da tela";
        }else if(motionEvent.getAction() == motionEvent.ACTION_MOVE){
            msg = "Arrastou na tela";
        }
        msg +="- Posição: x="+motionEvent.getRawX()+" y="+motionEvent.getRawY();//0x0 conto superior esquerdo
        TextView tvLog = new TextView(this);
        tvLog.setText(msg);
        tela.addView(tvLog);
    }
}
