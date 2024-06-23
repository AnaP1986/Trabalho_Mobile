package br.edu.fateczl.mobile_relatorio.controller;

import android.content.Context;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Relatorio;
import br.edu.fateczl.mobile_relatorio.persistence.IRelatorioDao;
import br.edu.fateczl.mobile_relatorio.persistence.RelatorioDao;

public class RelatorioController implements IController {
    private IRelatorioDao relatorioDao;

    public RelatorioController(Context context) {
        relatorioDao = new RelatorioDao(context);
    }

    @Override
    public void insert() {
        Relatorio relatorio = new Relatorio();
        // Set the attributes for the relatorio object
        relatorioDao.insert(relatorio);
    }

    @Override
    public void update() {
        Relatorio relatorio = new Relatorio();
        // Set the updated attributes for the relatorio object
        relatorioDao.update(relatorio);
    }

    @Override
    public void delete() {
        int id = 1; // Replace with the actual ID to delete
        relatorioDao.delete(id);
    }

    @Override
    public void findById() {
        int id = 1; // Replace with the actual ID to find
        Relatorio relatorio = relatorioDao.findById(id);
    }

    @Override
    public void findAll() {
        List<Relatorio> relatorios = relatorioDao.findAll();
    }
}
