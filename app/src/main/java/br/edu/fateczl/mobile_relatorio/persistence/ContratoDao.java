package br.edu.fateczl.mobile_relatorio.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Contrato;

public class ContratoDao implements IContratoDao {
    private SQLiteDatabase db;

    public ContratoDao(Context context) {
        GenericDao genericDao = new GenericDao(context);
        db = genericDao.getWritableDatabase();
    }

    @Override
    public void insert(Contrato contrato) {
        ContentValues values = new ContentValues();
        values.put("dataInicio", contrato.getDataInicio());
        values.put("dataFim", contrato.getDataFim());
        values.put("clienteId", contrato.getClienteId());
        db.insert("Contrato", null, values);
    }

    @Override
    public void update(Contrato contrato) {
        ContentValues values = new ContentValues();
        values.put("dataInicio", contrato.getDataInicio());
        values.put("dataFim", contrato.getDataFim());
        values.put("clienteId", contrato.getClienteId());
        db.update("Contrato", values, "id = ?", new String[]{String.valueOf(contrato.getId())});
    }

    @Override
    public void delete(int id) {
        db.delete("Contrato", "id = ?", new String[]{String.valueOf(id)});
    }

    @Override
    public Contrato findById(int id) {
        Cursor cursor = db.query("Contrato", null, "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            Contrato contrato = new Contrato();
            contrato.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
            contrato.setDataInicio(cursor.getString(cursor.getColumnIndexOrThrow("dataInicio")));
            contrato.setDataFim(cursor.getString(cursor.getColumnIndexOrThrow("dataFim")));
            contrato.setClienteId(cursor.getInt(cursor.getColumnIndexOrThrow("clienteId")));
            cursor.close();
            return contrato;
        }
        return null;
    }

    @Override
    public List<Contrato> findAll() {
        List<Contrato> contratos = new ArrayList<>();
        Cursor cursor = db.query("Contrato", null, null, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Contrato contrato = new Contrato();
                contrato.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
                contrato.setDataInicio(cursor.getString(cursor.getColumnIndexOrThrow("dataInicio")));
                contrato.setDataFim(cursor.getString(cursor.getColumnIndexOrThrow("dataFim")));
                contrato.setClienteId(cursor.getInt(cursor.getColumnIndexOrThrow("clienteId")));
                contratos.add(contrato);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return contratos;
    }
}
