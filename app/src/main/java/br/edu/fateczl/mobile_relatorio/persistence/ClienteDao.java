package br.edu.fateczl.mobile_relatorio.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Cliente;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Cliente;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Cliente;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Cliente;

public class ClienteDao extends GenericDao implements IClienteDao {

    public ClienteDao(Context context) {
        super(context);
    }

    @Override
    public void insert(Cliente cliente) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome", cliente.getNome());
        values.put("cpf", cliente.getCpf());
        values.put("endereco", cliente.getEndereco());
        db.insert("cliente", null, values);
        db.close();
    }

    @Override
    public void update(Cliente cliente) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome", cliente.getNome());
        values.put("endereco", cliente.getEndereco());
        db.update("cliente", values, "cpf = ?", new String[]{cliente.getCpf()});
        db.close();
    }

    @Override
    public void delete(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("cliente", "id = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    @Override
    public Cliente findById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("cliente", new String[]{"id", "nome", "cpf", "endereco"},
                "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            Cliente cliente = new Cliente();
            cliente.setId(cursor.getInt(0));
            cliente.setNome(cursor.getString(1));
            cliente.setCpf(cursor.getString(2));
            cliente.setEndereco(cursor.getString(3));
            cursor.close();
            db.close();
            return cliente;
        } else {
            db.close();
            return null;
        }
    }

    @Override
    public Cliente findByCpf(String cpf) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("cliente", new String[]{"id", "nome", "cpf", "endereco"},
                "cpf = ?", new String[]{cpf}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            Cliente cliente = new Cliente();
            cliente.setId(cursor.getInt(0));
            cliente.setNome(cursor.getString(1));
            cliente.setCpf(cursor.getString(2));
            cliente.setEndereco(cursor.getString(3));
            cursor.close();
            db.close();
            return cliente;
        } else {
            db.close();
            return null;
        }
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> clientes = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM cliente", null);
        if (cursor.moveToFirst()) {
            do {
                Cliente cliente = new Cliente();
                cliente.setId(cursor.getInt(0));
                cliente.setNome(cursor.getString(1));
                cliente.setCpf(cursor.getString(2));
                cliente.setEndereco(cursor.getString(3));
                clientes.add(cliente);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return clientes;
    }
}
