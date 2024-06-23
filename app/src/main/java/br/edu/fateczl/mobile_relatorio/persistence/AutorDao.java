package br.edu.fateczl.mobile_relatorio.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Autor;

public class AutorDao implements IAutorDao {
    private SQLiteDatabase db;

    public AutorDao(Context context) {
        GenericDao genericDao = new GenericDao(context);
        db = genericDao.getWritableDatabase();
    }

    @Override
    public void insert(Autor autor) {
        ContentValues values = new ContentValues();
        values.put("nome", autor.getNome());
        values.put("apelido", autor.getApelido());
        values.put("isAnonimo", autor.isAnonimo() ? 1 : 0);
        db.insert("Autor", null, values);
    }

    @Override
    public void update(Autor autor) {
        ContentValues values = new ContentValues();
        values.put("nome", autor.getNome());
        values.put("apelido", autor.getApelido());
        values.put("isAnonimo", autor.isAnonimo() ? 1 : 0);
        db.update("Autor", values, "id = ?", new String[]{String.valueOf(autor.getId())});
    }

    @Override
    public void delete(int id) {
        db.delete("Autor", "id = ?", new String[]{String.valueOf(id)});
    }

    @Override
    public Autor findById(int id) {
        Cursor cursor = db.query("Autor", null, "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            Autor autor = new Autor();
            autor.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
            autor.setNome(cursor.getString(cursor.getColumnIndexOrThrow("nome")));
            autor.setApelido(cursor.getString(cursor.getColumnIndexOrThrow("apelido")));
            autor.setAnonimo(cursor.getInt(cursor.getColumnIndexOrThrow("isAnonimo")) == 1);
            cursor.close();
            return autor;
        }
        return null;
    }

    @Override
    public List<Autor> findAll() {
        List<Autor> autores = new ArrayList<>();
        Cursor cursor = db.query("Autor", null, null, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Autor autor = new Autor();
                autor.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
                autor.setNome(cursor.getString(cursor.getColumnIndexOrThrow("nome")));
                autor.setApelido(cursor.getString(cursor.getColumnIndexOrThrow("apelido")));
                autor.setAnonimo(cursor.getInt(cursor.getColumnIndexOrThrow("isAnonimo")) == 1);
                autores.add(autor);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return autores;
    }
}
