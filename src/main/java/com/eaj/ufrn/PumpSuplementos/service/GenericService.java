package com.eaj.ufrn.PumpSuplementos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class GenericService<T, ID, REPO extends JpaRepository<T, ID>> {

    private REPO repository;

    public void delete(Long id) {
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    public T create(T entity) {
        return repository.save(entity);
    }

    public void update(T entity, ID id) {
        repository.saveAndFlush(entity);
    }
}
