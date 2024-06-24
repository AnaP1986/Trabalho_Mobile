package br.edu.fateczl.mobile_relatorio.persistence;

import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Contrato;

import br.edu.fateczl.mobile_relatorio.model.Contrato;

public interface IContratoDao extends ICRUDDao<Contrato> {
    Contrato findByDatas(String dataInicio, String dataFim);
}
