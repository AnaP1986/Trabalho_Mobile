package br.edu.fateczl.mobile_relatorio.controller;

import android.content.Context;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Autor;
import br.edu.fateczl.mobile_relatorio.persistence.IAutorDao;
import br.edu.fateczl.mobile_relatorio.persistence.AutorDao;
import android.content.Context;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.model.Autor;
import br.edu.fateczl.mobile_relatorio.persistence.AutorDao;

public class AutorController {

    private AutorDao autorDao;

    public AutorController(Context context) {
        autorDao = new AutorDao(context);
    }

    public void insert(Autor autor) {
        autorDao.insert(autor);
    }

    public void update(Autor autor) {
        autorDao.update(autor);
    }

    public void delete(int id) {
        autorDao.delete(id);
    }

    public Autor findByNomeSobrenome(String nome, String sobrenome) {
        return autorDao.findByNomeSobrenome(nome, sobrenome);
    }

    public List<Autor> findAll() {
        return autorDao.findAll();
    }
}
