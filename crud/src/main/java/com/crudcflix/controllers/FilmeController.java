package com.crudcflix.controllers;

import com.crudcflix.models.Filme;
import com.crudcflix.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class FilmeController {

    @Autowired
    FilmeRepository fr;

    @RequestMapping(value="/cadastrarFilme", method= RequestMethod.GET)
    public String form(){
        return "itens/formFilme";
    }

    @RequestMapping(value="/cadastrarFilme", method= RequestMethod.POST)
    public String form(@Valid Filme f, @RequestParam("imagemFilme") MultipartFile file, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Houve um erro no cadastro. Verifique os Campos!");
            return "redirect:cadastrarFilme";
        }
        try {
            f.setImagem(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        fr.save(f);
        attributes.addFlashAttribute("mensagem", "Filme cadastrado com sucesso :)");
        return "redirect:cadastrarFilme";
    }

    @RequestMapping("/index")
    public ModelAndView listarEventos(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Filme> filmesCadastrados = fr.findAll();
        mv.addObject("filme", filmesCadastrados);

        return mv;
    }

    /*
    @RequestMapping(value="/{codigo}", method=RequestMethod.GET)
    public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo){
        ModelAndView mv = new ModelAndView("detalhesFilme");
        Filme filme = fr.findByCodigo(codigo);
        Iterable<Convidado> convidados = cr.findByEvento(evento);

        mv.addObject("evento", evento);
        mv.addObject("convidados", convidados);
        return mv;
    }

     */


}
