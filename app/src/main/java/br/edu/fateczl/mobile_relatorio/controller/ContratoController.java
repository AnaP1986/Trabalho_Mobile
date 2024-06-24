package br.edu.fateczl.mobile_relatorio.controller;

import android.content.Context;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Contrato;
import br.edu.fateczl.mobile_relatorio.persistence.IContratoDao;
import br.edu.fateczl.mobile_relatorio.persistence.ContratoDao;


import android.content.Context;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Contrato;
import br.edu.fateczl.mobile_relatorio.persistence.ContratoDao;

public class ContratoController {

    private ContratoDao contratoDao;

    public ContratoController(Context context) {
        contratoDao = new ContratoDao(context);
    }

    public void insert(Contrato contrato) {
        contratoDao.insert(contrato);
    }

    public void update(Contrato contrato) {
        contratoDao.update(contrato);
    }

    public void delete(int id) {
        contratoDao.delete(id);
    }

    public Contrato findByDatas(String dataInicio, String dataFim) {
        return contratoDao.findByDatas(dataInicio, dataFim);
    }

    public List<Contrato> findAll() {
        return contratoDao.findAll();
    }
}
