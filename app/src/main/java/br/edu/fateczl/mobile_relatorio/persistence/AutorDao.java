package br.edu.fateczl.mobile_relatorio.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Autor;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Autor;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Autor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Autor;

public class AutorDao extends GenericDao implements IAutorDao {

    public AutorDao(Context context) {
        super(context);
    }

    @Override
    public void insert(Autor autor) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome", autor.getNome());
        values.put("sobrenome", autor.getSobrenome());
        db.insert("autor", null, values);
        db.close();
    }

    @Override
    public void update(Autor autor) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome", autor.getNome());
        values.put("sobrenome", autor.getSobrenome());
        db.update("autor", values, "id = ?", new String[]{String.valueOf(autor.getId())});
        db.close();
    }

    @Override
    public void delete(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("autor", "id = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    @Override
    public Autor findById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("autor", new String[]{"id", "nome", "sobrenome"},
                "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            Autor autor = new Autor();
            autor.setId(cursor.getInt(0));
            autor.setNome(cursor.getString(1));
            autor.setSobrenome(cursor.getString(2));
            cursor.close();
            db.close();
            return autor;
        } else {
            db.close();
            return null;
        }
    }

    @Override
    public Autor findByNomeSobrenome(String nome, String sobrenome) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("autor", new String[]{"id", "nome", "sobrenome"},
                "nome = ? AND sobrenome = ?", new String[]{nome, sobrenome}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            Autor autor = new Autor();
            autor.setId(cursor.getInt(0));
            autor.setNome(cursor.getString(1));
            autor.setSobrenome(cursor.getString(2));
            cursor.close();
            db.close();
            return autor;
        } else {
            db.close();
            return null;
        }
    }

    @Override
    public List<Autor> findAll() {
        List<Autor> autores = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM autor", null);
        if (cursor.moveToFirst()) {
            do {
                Autor autor = new Autor();
                autor.setId(cursor.getInt(0));
                autor.setNome(cursor.getString(1));
                autor.setSobrenome(cursor.getString(2));
                autores.add(autor);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return autores;
    }
}
