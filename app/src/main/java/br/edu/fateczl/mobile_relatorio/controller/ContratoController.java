package br.edu.fateczl.mobile_relatorio.controller;

import android.content.Context;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Contrato;
import br.edu.fateczl.mobile_relatorio.persistence.IContratoDao;
import br.edu.fateczl.mobile_relatorio.persistence.ContratoDao;

public class ContratoController implements IController {
    private IContratoDao contratoDao;

    public ContratoController(Context context) {
        contratoDao = new ContratoDao(context);
    }

    @Override
    public void insert() {
        Contrato contrato = new Contrato();
        // Set the attributes for the contrato object
        contratoDao.insert(contrato);
    }

    @Override
    public void update() {
        Contrato contrato = new Contrato();
        // Set the updated attributes for the contrato object
        contratoDao.update(contrato);
    }

    @Override
    public void delete() {
        int id = 1; // Replace with the actual ID to delete
        contratoDao.delete(id);
    }

    @Override
    public void findById() {
        int id = 1; // Replace with the actual ID to find
        Contrato contrato = contratoDao.findById(id);
    }

    @Override
    public void findAll() {
        List<Contrato> contratos = contratoDao.findAll();
    }
}
