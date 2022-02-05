package com.crudcflix;

import com.crudcflix.controllers.FilmeController;
import com.crudcflix.models.Filme;
import com.crudcflix.repository.FilmeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest()
@WebAppConfiguration
public class CrudcflixApplicationTests {

    @Autowired
    private FilmeRepository fr;

    @Test
    public void testeInsercao() {

        Filme filmeTeste = new Filme();

        filmeTeste.setNome("The K2");
        filmeTeste.setDt_lancamento("23/09/2016");
        filmeTeste.setDescricao("The K2 é uma telenovela sul-coreana exibida pelo canal tvN de 23 de setembro a 12 de novembro de 2016, estrelada por Ji Chang-wook, Song Yoon-ah, Im Yoon-ah e Jo Sung-ha\n");

        fr.save(filmeTeste);

        Filme filmeBuscado = fr.findByNome("The K2");

        Assertions.assertThat(filmeBuscado.getNome()).isEqualTo("The K2");
    }

    @Test
    public void testeConsulta() {

        Filme filmeBuscado = fr.findByNome("The K2");

        Assertions.assertThat(filmeBuscado.getNome()).isEqualTo("The K2");
    }

    @Test
    public void testeFormatacao() {

        Filme filmeTeste = new Filme();

        filmeTeste.setNome("Lala land");
        filmeTeste.setDt_lancamento("23/mm/aaaa");
        filmeTeste.setDescricao("Não é kdrama\n");

        fr.save(filmeTeste);

        Filme filmeBuscado = fr.findByNome("Lala land");

        Assertions.assertThat(filmeBuscado.getNome()).isNotEqualTo("Lala land");
    }

    @Test
    public void testeExclusao() {

        Filme filmeBuscado = fr.findByNome("Goblin");

        fr.delete(filmeBuscado);

        filmeBuscado = fr.findByNome("Goblin");

        Assertions.assertThat(filmeBuscado).isNull();
    }

}