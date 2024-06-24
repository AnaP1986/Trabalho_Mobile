package br.edu.fateczl.mobile_relatorio.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Relatorio;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Relatorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Relatorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Relatorio;

public class RelatorioDao extends GenericDao implements IRelatorioDao {

    public RelatorioDao(Context context) {
        super(context);
    }

    @Override
    public void insert(Relatorio relatorio) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("titulo", relatorio.getTitulo());
        values.put("resumo", relatorio.getResumo());
        db.insert("relatorio", null, values);
        db.close();
    }

    @Override
    public void update(Relatorio relatorio) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("titulo", relatorio.getTitulo());
        values.put("resumo", relatorio.getResumo());
        db.update("relatorio", values, "id = ?", new String[]{String.valueOf(relatorio.getId())});
        db.close();
    }

    @Override
    public void delete(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("relatorio", "id = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    @Override
    public Relatorio findById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("relatorio", new String[]{"id", "titulo", "resumo"},
                "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            Relatorio relatorio = new Relatorio();
            relatorio.setId(cursor.getInt(0));
            relatorio.setTitulo(cursor.getString(1));
            relatorio.setResumo(cursor.getString(2));
            cursor.close();
            db.close();
            return relatorio;
        } else {
            db.close();
            return null;
        }
    }

    @Override
    public Relatorio findByTitulo(String titulo) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("relatorio", new String[]{"id", "titulo", "resumo"},
                "titulo = ?", new String[]{titulo}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            Relatorio relatorio = new Relatorio();
            relatorio.setId(cursor.getInt(0));
            relatorio.setTitulo(cursor.getString(1));
            relatorio.setResumo(cursor.getString(2));
            cursor.close();
            db.close();
            return relatorio;
        } else {
            db.close();
            return null;
        }
    }

    @Override
    public List<Relatorio> findAll() {
        List<Relatorio> relatorios = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM relatorio", null);
        if (cursor.moveToFirst()) {
            do {
                Relatorio relatorio = new Relatorio();
                relatorio.setId(cursor.getInt(0));
                relatorio.setTitulo(cursor.getString(1));
                relatorio.setResumo(cursor.getString(2));
                relatorios.add(relatorio);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return relatorios;
    }
}
