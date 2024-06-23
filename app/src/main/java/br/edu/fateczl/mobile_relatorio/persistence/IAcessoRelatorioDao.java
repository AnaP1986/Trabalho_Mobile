package br.edu.fateczl.mobile_relatorio.persistence;

import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.AcessoRelatorio;

public interface IAcessoRelatorioDao {
    void insert(AcessoRelatorio acessoRelatorio);
    void update(AcessoRelatorio acessoRelatorio);
    void delete(int id);
    AcessoRelatorio findById(int id);
    List<AcessoRelatorio> findAll();
}
