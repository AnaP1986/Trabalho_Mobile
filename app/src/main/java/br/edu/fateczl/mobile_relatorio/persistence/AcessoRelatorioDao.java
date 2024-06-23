package br.edu.fateczl.mobile_relatorio.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.AcessoRelatorio;

public class AcessoRelatorioDao implements IAcessoRelatorioDao {
    private SQLiteDatabase db;

    public AcessoRelatorioDao(Context context) {
        GenericDao genericDao = new GenericDao(context);
        db = genericDao.getWritableDatabase();
    }

    @Override
    public void insert(AcessoRelatorio acessoRelatorio) {
        ContentValues values = new ContentValues();
        values.put("dataAcesso", acessoRelatorio.getDataAcesso());
        values.put("numeroAcesso", acessoRelatorio.getNumeroAcesso());
        values.put("clienteId", acessoRelatorio.getClienteId());
        values.put("relatorioId", acessoRelatorio.getRelatorioId());
        db.insert("AcessoRelatorio", null, values);
    }

    @Override
    public void update(AcessoRelatorio acessoRelatorio) {
        ContentValues values = new ContentValues();
        values.put("dataAcesso", acessoRelatorio.getDataAcesso());
        values.put("numeroAcesso", acessoRelatorio.getNumeroAcesso());
        values.put("clienteId", acessoRelatorio.getClienteId());
        values.put("relatorioId", acessoRelatorio.getRelatorioId());
        db.update("AcessoRelatorio", values, "id = ?", new String[]{String.valueOf(acessoRelatorio.getId())});
    }

    @Override
    public void delete(int id) {
        db.delete("AcessoRelatorio", "id = ?", new String[]{String.valueOf(id)});
    }

    @Override
    public AcessoRelatorio findById(int id) {
        Cursor cursor = db.query("AcessoRelatorio", null, "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            AcessoRelatorio acessoRelatorio = new AcessoRelatorio();
            acessoRelatorio.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
            acessoRelatorio.setDataAcesso(cursor.getString(cursor.getColumnIndexOrThrow("dataAcesso")));
            acessoRelatorio.setNumeroAcesso(cursor.getInt(cursor.getColumnIndexOrThrow("numeroAcesso")));
            acessoRelatorio.setClienteId(cursor.getInt(cursor.getColumnIndexOrThrow("clienteId")));
            acessoRelatorio.setRelatorioId(cursor.getInt(cursor.getColumnIndexOrThrow("relatorioId")));
            cursor.close();
            return acessoRelatorio;
        }
        return null;
    }

    @Override
    public List<AcessoRelatorio> findAll() {
        List<AcessoRelatorio> acessosRelatorio = new ArrayList<>();
        Cursor cursor = db.query("AcessoRelatorio", null, null, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                AcessoRelatorio acessoRelatorio = new AcessoRelatorio();
                acessoRelatorio.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
                acessoRelatorio.setDataAcesso(cursor.getString(cursor.getColumnIndexOrThrow("dataAcesso")));
                acessoRelatorio.setNumeroAcesso(cursor.getInt(cursor.getColumnIndexOrThrow("numeroAcesso")));
                acessoRelatorio.setClienteId(cursor.getInt(cursor.getColumnIndexOrThrow("clienteId")));
                acessoRelatorio.setRelatorioId(cursor.getInt(cursor.getColumnIndexOrThrow("relatorioId")));
                acessosRelatorio.add(acessoRelatorio);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return acessosRelatorio;
    }
}
