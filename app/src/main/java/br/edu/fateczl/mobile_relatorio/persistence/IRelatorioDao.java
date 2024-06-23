package br.edu.fateczl.mobile_relatorio.persistence;

import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Relatorio;

public interface IRelatorioDao {
    void insert(Relatorio relatorio);
    void update(Relatorio relatorio);
    void delete(int id);
    Relatorio findById(int id);
    List<Relatorio> findAll();
}
