package com.crudcflix.repository;

import com.crudcflix.models.Filme;
import org.springframework.data.repository.CrudRepository;

public interface FilmeRepository extends CrudRepository<Filme, String> {
    Filme findByCodigo(long codigo);
    Filme findByNome(String nome);
}
