package com.traineeprimeiro.domain.services;

import com.traineeprimeiro.domain.entities.EntityBase;
import com.traineeprimeiro.domain.entities.cliente.Cliente;
import com.traineeprimeiro.domain.entities.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class BaseService<T extends EntityBase> {

    protected JpaRepository<T, Long> _repository;

    public BaseService(JpaRepository<T, Long> repository) {
        _repository = repository;
    }

    public boolean ExistsById(long id) {
        boolean entityExists = this._repository.existsById(id);
        return entityExists;
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

    @Transactional
    public T Save(T entity) {
        entity.setId(0);
        return this._repository.save(entity);
    }

    @Transactional
    public T Update(T entity) {
        boolean entityExists = this._repository.existsById(entity.getId());
        if (entityExists) return null;
        return this._repository.save(entity);
    }

    public boolean DeleteById(long id) {
        boolean entityExists = this._repository.existsById(id);
        if (entityExists) this._repository.deleteById(id);
        return entityExists;
    }
}
