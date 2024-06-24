package br.edu.fateczl.mobile_relatorio.controller;

import android.content.Context;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Cliente;
import br.edu.fateczl.mobile_relatorio.persistence.IClienteDao;
import br.edu.fateczl.mobile_relatorio.persistence.ClienteDao;

import android.content.Context;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Cliente;
import br.edu.fateczl.mobile_relatorio.persistence.ClienteDao;

public class ClienteController {

    private ClienteDao clienteDao;

    public ClienteController(Context context) {
        clienteDao = new ClienteDao(context);
    }

    public void insert(Cliente cliente) {
        clienteDao.insert(cliente);
    }

    public void update(Cliente cliente) {
        clienteDao.update(cliente);
    }

    public void delete(int id) {
        clienteDao.delete(id);
    }

    public Cliente findByCpf(String cpf) {
        return clienteDao.findByCpf(cpf);
    }

    public List<Cliente> findAll() {
        return clienteDao.findAll();
    }
}
