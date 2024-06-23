package br.edu.fateczl.mobile_relatorio.persistence;

import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Cliente;

public interface IClienteDao {
    void insert(Cliente cliente);
    void update(Cliente cliente);
    void delete(int id);
    Cliente findById(int id);
    List<Cliente> findAll();
}
