package br.edu.fateczl.mobile_relatorio.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Cliente;

public class ClienteDao implements IClienteDao {
    private SQLiteDatabase db;

    public ClienteDao(Context context) {
        GenericDao genericDao = new GenericDao(context);
        db = genericDao.getWritableDatabase();
    }

    @Override
    public void insert(Cliente cliente) {
        ContentValues values = new ContentValues();
        values.put("nome", cliente.getNome());
        values.put("cpf", cliente.getCpf());
        values.put("endereco", cliente.getEndereco());
        db.insert("Cliente", null, values);
    }

    @Override
    public void update(Cliente cliente) {
        ContentValues values = new ContentValues();
        values.put("nome", cliente.getNome());
        values.put("cpf", cliente.getCpf());
        values.put("endereco", cliente.getEndereco());
        db.update("Cliente", values, "id = ?", new String[]{String.valueOf(cliente.getId())});
    }

    @Override
    public void delete(int id) {
        db.delete("Cliente", "id = ?", new String[]{String.valueOf(id)});
    }

    @Override
    public Cliente findById(int id) {
        Cursor cursor = db.query("Cliente", null, "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            Cliente cliente = new Cliente();
            cliente.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
            cliente.setNome(cursor.getString(cursor.getColumnIndexOrThrow("nome")));
            cliente.setCpf(cursor.getString(cursor.getColumnIndexOrThrow("cpf")));
            cliente.setEndereco(cursor.getString(cursor.getColumnIndexOrThrow("endereco")));
            cursor.close();
            return cliente;
        }
        return null;
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> clientes = new ArrayList<>();
        Cursor cursor = db.query("Cliente", null, null, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Cliente cliente = new Cliente();
                cliente.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
                cliente.setNome(cursor.getString(cursor.getColumnIndexOrThrow("nome")));
                cliente.setCpf(cursor.getString(cursor.getColumnIndexOrThrow("cpf")));
                cliente.setEndereco(cursor.getString(cursor.getColumnIndexOrThrow("endereco")));
                clientes.add(cliente);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return clientes;
    }
}
