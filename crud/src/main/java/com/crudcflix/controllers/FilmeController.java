package com.crudcflix.controllers;

import com.crudcflix.models.Filme;
import com.crudcflix.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

public class FilmeController {

    @Autowired
    FilmeRepository fr;

    @RequestMapping(value="/cadastrarFilme", method= RequestMethod.GET)
    public String form(){
        return "itens/formFilme";
    }

    @RequestMapping(value="/cadastrarFilme", method= RequestMethod.POST)
    public String form(@Valid Filme f, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Houve um erro no cadastro. Verifique os Campos!");
            return "redirect:cadastrarFilme";
        }
        fr.save(f);
        attributes.addFlashAttribute("mensagem", "Evento cadastrado com sucesso :)");
        return "redirect:cadastrarFilme";
    }


}
