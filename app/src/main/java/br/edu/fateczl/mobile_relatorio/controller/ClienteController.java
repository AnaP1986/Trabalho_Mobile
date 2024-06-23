package br.edu.fateczl.mobile_relatorio.controller;

import android.content.Context;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Cliente;
import br.edu.fateczl.mobile_relatorio.persistence.IClienteDao;
import br.edu.fateczl.mobile_relatorio.persistence.ClienteDao;

public class ClienteController implements IController {
    private IClienteDao clienteDao;

    public ClienteController(Context context) {
        clienteDao = new ClienteDao(context);
    }

    @Override
    public void insert() {
        Cliente cliente = new Cliente();
        // Set the attributes for the cliente object
        clienteDao.insert(cliente);
    }

    @Override
    public void update() {
        Cliente cliente = new Cliente();
        // Set the updated attributes for the cliente object
        clienteDao.update(cliente);
    }

    @Override
    public void delete() {
        int id = 1; // Replace with the actual ID to delete
        clienteDao.delete(id);
    }

    @Override
    public void findById() {
        int id = 1; // Replace with the actual ID to find
        Cliente cliente = clienteDao.findById(id);
    }

    @Override
    public void findAll() {
        List<Cliente> clientes = clienteDao.findAll();
    }
}
