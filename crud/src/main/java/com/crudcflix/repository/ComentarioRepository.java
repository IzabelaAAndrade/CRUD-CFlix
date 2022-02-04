package com.crudcflix.repository;

import com.crudcflix.models.Comentario;
import com.crudcflix.models.Filme;
import org.springframework.data.repository.CrudRepository;

public interface ComentarioRepository extends CrudRepository<Comentario, String> {
    Iterable<Comentario> findByFilme(Filme filme);
    Comentario findByCd(long cd);
}
