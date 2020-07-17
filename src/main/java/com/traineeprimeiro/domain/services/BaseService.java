package com.traineeprimeiro.domain.services;

import com.traineeprimeiro.domain.entities.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class BaseService<T> {

    protected JpaRepository<T, Long> _repository;

    public BaseService(JpaRepository<T, Long> repository) {
        _repository = repository;
    }

    public T Save(T entity) {
        return this._repository.save(entity);
    }

    public List<T> FindAll() {
        List<T> entity = this._repository.findAll();
        return entity;
    }

    public T FindById(long id) {
        Optional<T> entity = this._repository.findById(id);
        if (!entity.isPresent()) return  null;
        return entity.get();
    }

    public void DeleteById(long id) {
        this._repository.deleteById(id);
    }
}
