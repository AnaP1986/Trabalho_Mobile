package br.edu.fateczl.mobile_relatorio.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Contrato;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Contrato;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Contrato;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Contrato;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Contrato;

public class ContratoDao extends GenericDao implements IContratoDao {

    public ContratoDao(Context context) {
        super(context);
    }

    @Override
    public void insert(Contrato contrato) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("dataInicio", contrato.getDataInicio());
        values.put("dataFim", contrato.getDataFim());
        db.insert("contrato", null, values);
        db.close();
    }

    @Override
    public void update(Contrato contrato) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("dataInicio", contrato.getDataInicio());
        values.put("dataFim", contrato.getDataFim());
        db.update("contrato", values, "id = ?", new String[]{String.valueOf(contrato.getId())});
        db.close();
    }

    @Override
    public void delete(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("contrato", "id = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    @Override
    public Contrato findById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("contrato", new String[]{"id", "dataInicio", "dataFim"},
                "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            Contrato contrato = new Contrato();
            contrato.setId(cursor.getInt(0));
            contrato.setDataInicio(cursor.getString(1));
            contrato.setDataFim(cursor.getString(2));
            cursor.close();
            db.close();
            return contrato;
        } else {
            db.close();
            return null;
        }
    }

    @Override
    public Contrato findByDatas(String dataInicio, String dataFim) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("contrato", new String[]{"id", "dataInicio", "dataFim"},
                "dataInicio = ? AND dataFim = ?", new String[]{dataInicio, dataFim}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            Contrato contrato = new Contrato();
            contrato.setId(cursor.getInt(0));
            contrato.setDataInicio(cursor.getString(1));
            contrato.setDataFim(cursor.getString(2));
            cursor.close();
            db.close();
            return contrato;
        } else {
            db.close();
            return null;
        }
    }

    @Override
    public List<Contrato> findAll() {
        List<Contrato> contratos = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM contrato", null);
        if (cursor.moveToFirst()) {
            do {
                Contrato contrato = new Contrato();
                contrato.setId(cursor.getInt(0));
                contrato.setDataInicio(cursor.getString(1));
                contrato.setDataFim(cursor.getString(2));
                contratos.add(contrato);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return contratos;
    }
}
