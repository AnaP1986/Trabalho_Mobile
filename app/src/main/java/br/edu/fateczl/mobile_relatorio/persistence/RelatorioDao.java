package br.edu.fateczl.mobile_relatorio.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Relatorio;

public class RelatorioDao implements IRelatorioDao {
    private SQLiteDatabase db;

    public RelatorioDao(Context context) {
        GenericDao genericDao = new GenericDao(context);
        db = genericDao.getWritableDatabase();
    }

    @Override
    public void insert(Relatorio relatorio) {
        ContentValues values = new ContentValues();
        values.put("titulo", relatorio.getTitulo());
        values.put("resumo", relatorio.getResumo());
        values.put("texto", relatorio.getTexto());
        values.put("isPublico", relatorio.isPublico() ? 1 : 0);
        values.put("autorId", relatorio.getAutorId());
        db.insert("Relatorio", null, values);
    }

    @Override
    public void update(Relatorio relatorio) {
        ContentValues values = new ContentValues();
        values.put("titulo", relatorio.getTitulo());
        values.put("resumo", relatorio.getResumo());
        values.put("texto", relatorio.getTexto());
        values.put("isPublico", relatorio.isPublico() ? 1 : 0);
        values.put("autorId", relatorio.getAutorId());
        db.update("Relatorio", values, "id = ?", new String[]{String.valueOf(relatorio.getId())});
    }

    @Override
    public void delete(int id) {
        db.delete("Relatorio", "id = ?", new String[]{String.valueOf(id)});
    }

    @Override
    public Relatorio findById(int id) {
        Cursor cursor = db.query("Relatorio", null, "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            Relatorio relatorio = new Relatorio();
            relatorio.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
            relatorio.setTitulo(cursor.getString(cursor.getColumnIndexOrThrow("titulo")));
            relatorio.setResumo(cursor.getString(cursor.getColumnIndexOrThrow("resumo")));
            relatorio.setTexto(cursor.getString(cursor.getColumnIndexOrThrow("texto")));
            relatorio.setPublico(cursor.getInt(cursor.getColumnIndexOrThrow("isPublico")) == 1);
            relatorio.setAutorId(cursor.getInt(cursor.getColumnIndexOrThrow("autorId")));
            cursor.close();
            return relatorio;
        }
        return null;
    }

    @Override
    public List<Relatorio> findAll() {
        List<Relatorio> relatorios = new ArrayList<>();
        Cursor cursor = db.query("Relatorio", null, null, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Relatorio relatorio = new Relatorio();
                relatorio.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
                relatorio.setTitulo(cursor.getString(cursor.getColumnIndexOrThrow("titulo")));
                relatorio.setResumo(cursor.getString(cursor.getColumnIndexOrThrow("resumo")));
                relatorio.setTexto(cursor.getString(cursor.getColumnIndexOrThrow("texto")));
                relatorio.setPublico(cursor.getInt(cursor.getColumnIndexOrThrow("isPublico")) == 1);
                relatorio.setAutorId(cursor.getInt(cursor.getColumnIndexOrThrow("autorId")));
                relatorios.add(relatorio);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return relatorios;
    }
}
