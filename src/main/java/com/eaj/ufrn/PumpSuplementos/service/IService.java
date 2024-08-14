package com.eaj.ufrn.PumpSuplementos.service;

import java.util.List;
import java.util.Optional;

public interface IService<T, ID> {
    public void deleteById(ID id);
    public List<T> findAll();
    public Optional<T> findById(ID id);
    public void create(T entity);
    public Optional<T> update(T entity);
}
