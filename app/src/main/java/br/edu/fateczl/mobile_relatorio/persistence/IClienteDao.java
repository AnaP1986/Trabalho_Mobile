package br.edu.fateczl.mobile_relatorio.persistence;

import br.edu.fateczl.mobile_relatorio.model.Cliente;


import br.edu.fateczl.mobile_relatorio.model.Cliente;

public interface IClienteDao extends ICRUDDao<Cliente> {
    Cliente findByCpf(String cpf);
}
