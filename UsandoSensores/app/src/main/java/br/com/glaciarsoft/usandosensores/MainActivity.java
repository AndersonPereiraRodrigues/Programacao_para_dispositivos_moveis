package br.com.glaciarsoft.usandosensores;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SensorManager sm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sm = (SensorManager) getSystemService(SENSOR_SERVICE);

    }

    public void btSensorOnClick(View view) {
        startActivity(new Intent(this, usandoSensorActivity.class));


    }

    private String[] montaListaSensores() {
        List<Sensor> sensores=sm.getSensorList(Sensor.TYPE_ALL);
        Iterator<Sensor> iterator = sensores.iterator();

        String resultado[]=new String[sensores.size()];
        int i=0;
        while (iterator.hasNext()){
            Sensor sensor=iterator.next();
            resultado[i]=sensor.getName();
            i++;
        }

        return resultado;
    }

    public void btListarOnClick(View view) {
        ListView lista =new ListView(this);
        String sensores[] = montaListaSensores();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,sensores);
        lista.setAdapter(adapter);

        AlertDialog.Builder alerta=new AlertDialog.Builder(this);
        alerta.setView(lista);
        alerta.setCancelable(false);
        alerta.setNegativeButton("OK",null);

        alerta.show();
    }
}
