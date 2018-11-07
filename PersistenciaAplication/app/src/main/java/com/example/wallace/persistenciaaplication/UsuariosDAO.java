package com.example.wallace.persistenciaaplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class UsuariosDAO {

    private SQLiteDatabase mDatabase;

    public UsuariosDAO(Context context) {
        Database helper = new Database(context);
        mDatabase = helper.getWritableDatabase();
    }

    public long inserirUsuario(Usuario usuario) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("usuario", usuario.getNome());
        contentValues.put("senha", usuario.getSenha());
        contentValues.put("nome_completo", usuario.getNomeCompleto());
        if (getUsuario(usuario.getNome())) {
            return mDatabase.insert(Database.TABLE_NAME, null, contentValues);

        } else {
            return -1;
        }
    }

    /**
     *
     * Lista todos os usuários no log da aplicação
     *
     */
    public void getUsuarios() {
        Cursor cursor1 = mDatabase.query(Database.TABLE_NAME, null, null, null, null, null, null);
        while (cursor1.moveToNext()) {
            Log.i("rblb", "usuario: " + cursor1.getString(1));
            Log.i("rblb", "senha: " + cursor1.getString(2));
            Log.i("rblb", "Nome Completo: " + cursor1.getString(3));
        }
        cursor1.close();
    }

    /**
     * verifica se o usuário passado já existe na base de dados.
     * @param nome
     * @return
     */
    public boolean getUsuario(String nome) {
        Cursor cursor1 = mDatabase.rawQuery("SELECT * from usarios_tbl WHERE usuario = '" + nome + "'", null);
        Usuario usuarioTemp = null;
        while (cursor1.moveToNext()) {
            usuarioTemp = new Usuario(cursor1.getString(1), cursor1.getString(2), cursor1.getString(3));
        }
        cursor1.close();
        boolean canInsert = usuarioTemp == null;
        return canInsert;
    }

    public void deleteUsuario(String usuario) {
        mDatabase.delete(Database.TABLE_NAME, "usuario =?", new String[]{usuario});
    }
}
