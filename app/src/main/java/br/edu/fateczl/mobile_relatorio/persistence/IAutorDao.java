package br.edu.fateczl.mobile_relatorio.persistence;

import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Autor;

public interface IAutorDao {
    void insert(Autor autor);
    void update(Autor autor);
    void delete(int id);
    Autor findById(int id);
    List<Autor> findAll();
}
