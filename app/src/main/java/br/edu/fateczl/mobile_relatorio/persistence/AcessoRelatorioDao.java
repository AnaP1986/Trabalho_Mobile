package br.edu.fateczl.mobile_relatorio.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.AcessoRelatorio;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.AcessoRelatorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.AcessoRelatorio;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.AcessoRelatorio;

public class AcessoRelatorioDao extends GenericDao implements IAcessoRelatorioDao {

    public AcessoRelatorioDao(Context context) {
        super(context);
    }

    @Override
    public void insert(AcessoRelatorio acessoRelatorio) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("dataAcesso", acessoRelatorio.getDataAcesso());
        values.put("numeroAcesso", acessoRelatorio.getNumeroAcesso());
        values.put("clienteId", acessoRelatorio.getClienteId());
        values.put("relatorioId", acessoRelatorio.getRelatorioId());
        db.insert("acesso_relatorio", null, values);
        db.close();
    }

    @Override
    public void update(AcessoRelatorio acessoRelatorio) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("dataAcesso", acessoRelatorio.getDataAcesso());
        values.put("numeroAcesso", acessoRelatorio.getNumeroAcesso());
        values.put("clienteId", acessoRelatorio.getClienteId());
        values.put("relatorioId", acessoRelatorio.getRelatorioId());
        db.update("acesso_relatorio", values, "id = ?", new String[]{String.valueOf(acessoRelatorio.getId())});
        db.close();
    }

    @Override
    public void delete(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("acesso_relatorio", "id = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    @Override
    public AcessoRelatorio findById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("acesso_relatorio", new String[]{"id", "dataAcesso", "numeroAcesso", "clienteId", "relatorioId"},
                "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            AcessoRelatorio acessoRelatorio = new AcessoRelatorio();
            acessoRelatorio.setId(cursor.getInt(0));
            acessoRelatorio.setDataAcesso(cursor.getString(1));
            acessoRelatorio.setNumeroAcesso(cursor.getInt(2));
            acessoRelatorio.setClienteId(cursor.getInt(3));
            acessoRelatorio.setRelatorioId(cursor.getInt(4));
            cursor.close();
            db.close();
            return acessoRelatorio;
        } else {
            db.close();
            return null;
        }
    }

    @Override
    public List<AcessoRelatorio> findAll() {
        List<AcessoRelatorio> acessosRelatorio = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM acesso_relatorio", null);
        if (cursor.moveToFirst()) {
            do {
                AcessoRelatorio acessoRelatorio = new AcessoRelatorio();
                acessoRelatorio.setId(cursor.getInt(0));
                acessoRelatorio.setDataAcesso(cursor.getString(1));
                acessoRelatorio.setNumeroAcesso(cursor.getInt(2));
                acessoRelatorio.setClienteId(cursor.getInt(3));
                acessoRelatorio.setRelatorioId(cursor.getInt(4));
                acessosRelatorio.add(acessoRelatorio);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return acessosRelatorio;
    }
}
