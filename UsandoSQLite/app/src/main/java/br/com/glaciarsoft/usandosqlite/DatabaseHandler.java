package br.com.glaciarsoft.usandosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.glaciarsoft.usandosqlite.entidade.Cadastro;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "banco";


    public DatabaseHandler(Context c){
        super(c,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL("CREATE TABLE IF NOT EXISTS cadastro( _id INTEGER PRIMARY KEY AUTOINCREMENT, NOME TEXT, TELEFONE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int oldVersion, int newVersion) {
        bd.execSQL("DROP TABLE IF EXISTS "+DATABASE_NAME);
        onCreate(bd);
    }

    public void incluir(Cadastro cad){
        SQLiteDatabase bd = getWritableDatabase();

        ContentValues registro = new ContentValues();
        registro.put("NOME", cad.getNome().toString());
        registro.put("TELEFONE", cad.getTelefone().toString());
        bd.insert("cadastro", null, registro);
    }
    public void alterar(Cadastro cad){
        SQLiteDatabase bd = getWritableDatabase();
        ContentValues registros = new ContentValues();
        registros.put("NOME", cad.getNome());
        registros.put("TELEFONE", cad.getTelefone());

        bd.update("cadastro", registros, "_id = "+ cad.getCod(), null );
    }
    public void excluir(int cod){
        SQLiteDatabase bd = getWritableDatabase();
        bd.delete("cadastro", "_id = ?", new String[] {String.valueOf(cod)});
    }
    public Cadastro pesquisar( int cod){
        SQLiteDatabase bd = getWritableDatabase();
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
    public Cursor listar(){
        SQLiteDatabase bd = getWritableDatabase();
        return bd.query( "cadastro", null, null, null, null, null, null );
    }
}
