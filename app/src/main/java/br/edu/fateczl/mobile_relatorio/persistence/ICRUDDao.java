package br.edu.fateczl.mobile_relatorio.persistence;

import java.util.List;

public interface ICRUDDao<T> {
    void insert(T obj);
    void update(T obj);
    void delete(int id);
    T findById(int id);
    List<T> findAll();
}
