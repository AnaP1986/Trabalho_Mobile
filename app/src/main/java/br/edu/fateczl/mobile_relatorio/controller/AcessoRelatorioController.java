package br.edu.fateczl.mobile_relatorio.controller;

import android.content.Context;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.AcessoRelatorio;
import br.edu.fateczl.mobile_relatorio.persistence.IAcessoRelatorioDao;
import br.edu.fateczl.mobile_relatorio.persistence.AcessoRelatorioDao;

public class AcessoRelatorioController implements IController {
    private IAcessoRelatorioDao acessoRelatorioDao;

    public AcessoRelatorioController(Context context) {
        acessoRelatorioDao = new AcessoRelatorioDao(context);
    }

    @Override
    public void insert() {
        AcessoRelatorio acessoRelatorio = new AcessoRelatorio();
        // Set the attributes for the acessoRelatorio object
        acessoRelatorioDao.insert(acessoRelatorio);
    }

    @Override
    public void update() {
        AcessoRelatorio acessoRelatorio = new AcessoRelatorio();
        // Set the updated attributes for the acessoRelatorio object
        acessoRelatorioDao.update(acessoRelatorio);
    }

    @Override
    public void delete() {
        int id = 1; // Replace with the actual ID to delete
        acessoRelatorioDao.delete(id);
    }

    @Override
    public void findById() {
        int id = 1; // Replace with the actual ID to find
        AcessoRelatorio acessoRelatorio = acessoRelatorioDao.findById(id);
    }

    @Override
    public void findAll() {
        List<AcessoRelatorio> acessosRelatorio = acessoRelatorioDao.findAll();
    }
}
