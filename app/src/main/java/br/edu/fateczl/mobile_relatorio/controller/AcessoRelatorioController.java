package br.edu.fateczl.mobile_relatorio.controller;

import android.content.Context;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.AcessoRelatorio;
import br.edu.fateczl.mobile_relatorio.persistence.IAcessoRelatorioDao;
import br.edu.fateczl.mobile_relatorio.persistence.AcessoRelatorioDao;
import android.content.Context;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.AcessoRelatorio;
import br.edu.fateczl.mobile_relatorio.persistence.AcessoRelatorioDao;

public class AcessoRelatorioController {

    private AcessoRelatorioDao acessoRelatorioDao;

    public AcessoRelatorioController(Context context) {
        acessoRelatorioDao = new AcessoRelatorioDao(context);
    }

    public void insert(AcessoRelatorio acessoRelatorio) {
        acessoRelatorioDao.insert(acessoRelatorio);
    }

    public void update(AcessoRelatorio acessoRelatorio) {
        acessoRelatorioDao.update(acessoRelatorio);
    }

    public void delete(int id) {
        acessoRelatorioDao.delete(id);
    }

    public AcessoRelatorio findById(int id) {
        return acessoRelatorioDao.findById(id);
    }

    public List<AcessoRelatorio> findAll() {
        return acessoRelatorioDao.findAll();
    }
}
