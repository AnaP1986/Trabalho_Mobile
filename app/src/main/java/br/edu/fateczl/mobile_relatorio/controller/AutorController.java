package br.edu.fateczl.mobile_relatorio.controller;

import android.content.Context;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Autor;
import br.edu.fateczl.mobile_relatorio.persistence.IAutorDao;
import br.edu.fateczl.mobile_relatorio.persistence.AutorDao;

public class AutorController implements IController {
    private IAutorDao autorDao;

    public AutorController(Context context) {
        autorDao = new AutorDao(context);
    }

    @Override
    public void insert() {
        Autor autor = new Autor();
        // Set the attributes for the autor object
        autorDao.insert(autor);
    }

    @Override
    public void update() {
        Autor autor = new Autor();
        // Set the updated attributes for the autor object
        autorDao.update(autor);
    }

    @Override
    public void delete() {
        int id = 1; // Replace with the actual ID to delete
        autorDao.delete(id);
    }

    @Override
    public void findById() {
        int id = 1; // Replace with the actual ID to find
        Autor autor = autorDao.findById(id);
    }

    @Override
    public void findAll() {
        List<Autor> autores = autorDao.findAll();
    }
}
