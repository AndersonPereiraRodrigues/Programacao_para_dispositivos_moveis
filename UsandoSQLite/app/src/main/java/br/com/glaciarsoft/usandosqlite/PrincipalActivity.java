package br.com.glaciarsoft.usandosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.ConditionVariable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.glaciarsoft.usandosqlite.dao.CadastroDAO;
import br.com.glaciarsoft.usandosqlite.entidade.Cadastro;

public class PrincipalActivity extends AppCompatActivity {
    private EditText etCod;
    private EditText etNome;
    private EditText etTelefone;

    //private SQLiteDatabase bd;//classe do banco
    //CadastroDAO cadDao; //para usar pelo metodo DAO
    private DatabaseHandler cadDao;
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        etCod=(EditText) findViewById(R.id.etCodigo);
        etNome=(EditText) findViewById(R.id.etNome);
        etTelefone=(EditText) findViewById(R.id.etTelefone);

        //cadDao=new CadastroDAO(this); //para usar pelo metodo DAO
        cadDao = new DatabaseHandler(this);
        //bd = this.openOrCreateDatabase("banco", Context.MODE_PRIVATE, null);
        //bd.execSQL("CREATE TABLE IF NOT EXISTS cadastro( _id INTEGER PRIMARY KEY AUTOINCREMENT, NOME TEXT, TELEFONE TEXT)");
        //bd=ConexaoFactory.getConnection(this);
    }

    public void btIncluirOnClck(View view) {
       // ContentValues registro = new ContentValues();
        //registro.put("NOME", etNome.getText().toString());
        //registro.put("TELEFONE", etTelefone.getText().toString());

        //bd.insert("cadastro", null, registro);


        Cadastro cad = new Cadastro();
        cad.setNome(etNome.getText().toString());
        cad.setTelefone(etTelefone.getText().toString());
        cadDao.incluir(cad);
        Toast.makeText(this, "INCLUSAO EFETURADA COM SUCESSO", Toast.LENGTH_LONG).show();
        etTelefone.setText("");
        etNome.setText("");
    }

    public void btExcluirOnClck(View view) {
        String codigo = etCod.getText().toString();
        //int ret = bd.delete("cadastro", "_id = ? ",new String[]{codigo});
        cadDao.excluir(Integer.parseInt(codigo));

        //if(ret>0){
            Toast.makeText(this, "EXCLUIDO COM SUCESSO", Toast.LENGTH_LONG).show();
        //}
        etCod.setText("");
    }

    /*public void btAlterarOnClck(View view) {
        String cod = etCod.getText().toString();*/
/*
        ContentValues registro = new ContentValues();
        registro.put("NOME", etNome.getText().toString());
        registro.put("TELEFONE", etTelefone.getText().toString());*/
/*
Cadastro cad = new Cadastro();
cad.setCod(Integer.parseInt(cod));
        int ret = bd.update("cadastro", registro,"_id=?", new String[] {cod});
        if(ret>0){
            etCod.setText("");
            etNome.setText("");
            etTelefone.setText("");
            Toast.makeText(this, "Registro alterado", Toast.LENGTH_LONG).show();
        }
    }*/
    public void btAlterarOnClick(View view) {

        String cod = etCod.getText().toString();

        Cadastro cad = new Cadastro();
        cad.setCod( Integer.parseInt( cod ) );
        cad.setNome( etNome.getText().toString() );
        cad.setTelefone( etTelefone.getText().toString() );

        cadDao.alterar( cad );

        Toast.makeText(this, "Registro alterado com sucesso!", Toast.LENGTH_LONG).show();
    }

   /* public void btPesquisarOnClck(View view) {
        //String cod = etCod.getText().toString();

        final EditText etCodAlerta =new EditText(this);
        AlertDialog.Builder alerta =new AlertDialog.Builder(this);
        alerta.setTitle("Favor digitar o código");
        alerta.setView(etCodAlerta);
        alerta.setCancelable(false);
        alerta.setNegativeButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String cod =etCodAlerta.getText().toString();
                Cursor registros=bd.query("cadastro", null, "_id=?", new String[]{cod}, null, null, null);
                //Cursor registros=bd.query("cadastro", null, "_id="+etCodAlerta, null, null, null, null);
                String resposta="";
                if(registros.moveToNext()){
                    Toast.makeText(PrincipalActivity.this, resposta, Toast.LENGTH_LONG).show();
                    resposta += registros.getString(registros.getColumnIndex("NOME"))+"-"+ registros.getString(registros.getColumnIndex("TELEFONE"))+"\n";
                }else{
                    resposta="Não encontrado";
                }
                Toast.makeText(PrincipalActivity.this, resposta, Toast.LENGTH_LONG).show();
            }
        });

        alerta.show();

    }*/
   public void btPesquisarOnClick(View view) {
       //String cod = etCod.getText().toString();

       final EditText etCodAlerta = new EditText( this );

       AlertDialog.Builder alerta = new AlertDialog.Builder( this );
       alerta.setTitle( "Favor Digitar o código." );
       alerta.setView( etCodAlerta );
       alerta.setCancelable( false );
       alerta.setNeutralButton("OK", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialogInterface, int i) {

               String cod = etCodAlerta.getText().toString();

               Cadastro cad = cadDao.pesquisar( Integer.parseInt( cod ) );

               if( cad != null ){
                   Toast.makeText(PrincipalActivity.this, "Nome: " + cad.getNome() + " - " + cad.getTelefone(), Toast.LENGTH_SHORT).show();
               }else{
                   Toast.makeText(PrincipalActivity.this, "Registro não encontrado!!", Toast.LENGTH_SHORT).show();
               }
           }
       } );

       alerta.show();

   }

    public void btListarOnClck(View view) {
        /*Cursor registros=bd.query("cadastro", new String[]{"NOME","TELEFONE"}, null, null, null, null, null);
        String resposta="";
        while (registros.moveToNext()){
            resposta += registros.getString(registros.getColumnIndex("NOME"))+"-"+ registros.getString(registros.getColumnIndex("TELEFONE"))+"\n";
        }
        Toast.makeText(this, resposta, Toast.LENGTH_LONG).show();*/
        /*Intent i = new Intent(this,ListarActivity.class);
        startActivity(i);*/
        Cursor registros=cadDao.listar();
        String resposta="";
        while (registros.moveToNext()){
            resposta += registros.getString(registros.getColumnIndex("NOME"))+"-"+ registros.getString(registros.getColumnIndex("TELEFONE"))+"\n";
        }
        Toast.makeText(this, resposta, Toast.LENGTH_LONG).show();

    }
}
