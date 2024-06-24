package br.edu.fateczl.mobile_relatorio.controller;

import android.content.Context;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Relatorio;
import br.edu.fateczl.mobile_relatorio.persistence.IRelatorioDao;
import br.edu.fateczl.mobile_relatorio.persistence.RelatorioDao;
import android.content.Context;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Relatorio;
import br.edu.fateczl.mobile_relatorio.persistence.RelatorioDao;

public class RelatorioController {

    private RelatorioDao relatorioDao;

    public RelatorioController(Context context) {
        relatorioDao = new RelatorioDao(context);
    }

    public void insert(Relatorio relatorio) {
        relatorioDao.insert(relatorio);
    }

    public void update(Relatorio relatorio) {
        relatorioDao.update(relatorio);
    }

    public void delete(int id) {
        relatorioDao.delete(id);
    }

    public Relatorio findByTitulo(String titulo) {
        return relatorioDao.findByTitulo(titulo);
    }

    public List<Relatorio> findAll() {
        return relatorioDao.findAll();
    }
}
