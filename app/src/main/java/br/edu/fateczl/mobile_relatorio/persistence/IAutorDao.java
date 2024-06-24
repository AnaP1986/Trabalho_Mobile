package br.edu.fateczl.mobile_relatorio.persistence;

import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Autor;

public interface IAutorDao extends ICRUDDao<Autor> {
    Autor findByNomeSobrenome(String nome, String sobrenome);
}
