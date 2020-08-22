package br.com.glaciarsoft.usandosqlite.dao;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.com.glaciarsoft.usandosqlite.ConexaoFactory;
import br.com.glaciarsoft.usandosqlite.entidade.Cadastro;

public class CadastroDAO {

    private SQLiteDatabase bd;
    public CadastroDAO(Activity context){
        bd=ConexaoFactory.getConnection(context);
    }


    public void incluir(Cadastro cad){
        ContentValues registro = new ContentValues();
        registro.put("NOME", cad.getNome().toString());
        registro.put("TELEFONE", cad.getTelefone().toString());

        bd.insert("cadastro", null, registro);
    }
    public void excluir( int cod ) {

        /**
         * Colocar os ? para diminuir os parametros que sera deletado as coisas no android.
         * O terceiro parametro é para colocar o parametro em questao.
         **/

        bd.delete("cadastro", "_id = ?", new String[] {String.valueOf(cod)});
    }
    /*public void excluir(int cod){
    bd.delete("cadastro", "_id=?",new String []{String.valueOf(cod)})
    }*/

    public void alterar( Cadastro cad ) {
        ContentValues registros = new ContentValues();
        registros.put("NOME", cad.getNome());
        registros.put("TELEFONE", cad.getTelefone());

        bd.update("cadastro", registros, "_id = "+ cad.getCod(), null );
    }
    public Cadastro pesquisar( int cod ) {

        Cursor registro = bd.query("cadastro", null, "_id = ?", new String[] { String.valueOf( cod ) }, null, null, null);

        if ( registro.moveToNext() ) {
            Cadastro cad = new Cadastro();
            cad.setCod( cod );
            cad.setNome( registro.getString( registro.getColumnIndex( "NOME" ) ) );
            cad.setTelefone( registro.getString( registro.getColumnIndex( "TELEFONE" ) ) );
            return cad;
        } else {
            return null;
        }

    }
    public Cursor listar() {
        return bd.query( "cadastro", null, null, null, null, null, null );
    }
}
