package br.edu.fateczl.mobile_relatorio.persistence;

import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Contrato;

public interface IContratoDao {
    void insert(Contrato contrato);
    void update(Contrato contrato);
    void delete(int id);
    Contrato findById(int id);
    List<Contrato> findAll();
}
