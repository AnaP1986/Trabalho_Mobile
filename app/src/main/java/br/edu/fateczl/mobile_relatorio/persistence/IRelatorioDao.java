package br.edu.fateczl.mobile_relatorio.persistence;

import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Relatorio;



public interface IRelatorioDao extends ICRUDDao<Relatorio> {
    Relatorio findByTitulo(String titulo);
}
