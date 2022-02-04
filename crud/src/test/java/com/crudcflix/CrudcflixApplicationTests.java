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

@SpringBootTest
class CrudcflixApplicationTests {

//    FilmeController fc = new FilmeController();
//
//    @Test
//    public void insercaoTeste() {
//        Filme filmeTeste = new Filme();
//
//        filmeTeste.setNome("The K2");
//        filmeTeste.setDt_lancamento("23/09/2016");
//        filmeTeste.setDescricao("The K2 é uma telenovela sul-coreana exibida pelo canal tvN de 23 de setembro a 12 de novembro de 2016, estrelada por Ji Chang-wook, Song Yoon-ah, Im Yoon-ah e Jo Sung-ha\n");
//
//        fc.form(filmeTeste, null, null, null);
//
//
//    }
//
//    @Test
//    public void consultaTeste(){
//
//    }
//
//    @Test
//    public void formatacaoTeste(){
//
//    }
//
//    @Test
//    public void atualizacaoTeste(){
//
//    }
//
//    @Test
//    public void exclusaoTeste(){
//
//    }
//
//
//}

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes= {DataConfiguration.class, CrudcflixApplication.class})
//@DataJpaTest
//public class CrudcflixApplicationTests{
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private FilmeRepository fr;
//
//    @Test
//    public void testeInsercao() {
//
//        Filme filmeTeste = new Filme();
//
//        filmeTeste.setNome("The K2");
//        filmeTeste.setDt_lancamento("23/09/2016");
//        filmeTeste.setDescricao("The K2 é uma telenovela sul-coreana exibida pelo canal tvN de 23 de setembro a 12 de novembro de 2016, estrelada por Ji Chang-wook, Song Yoon-ah, Im Yoon-ah e Jo Sung-ha\n");
//
//        entityManager.persist(filmeTeste);
//
//        Filme filmeBuscado = fr.findByNome("The K2");
//
//        Assertions.assertThat(filmeBuscado.getNome()).isEqualTo("The K2");
//    }
}