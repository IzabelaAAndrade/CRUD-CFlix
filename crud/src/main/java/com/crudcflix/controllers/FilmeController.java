package com.crudcflix.controllers;

import com.crudcflix.models.Comentario;
import com.crudcflix.models.Filme;
import com.crudcflix.repository.ComentarioRepository;
import com.crudcflix.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class FilmeController {

    @Autowired
    FilmeRepository fr;

    @Autowired
    ComentarioRepository cr;

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
        mv.addObject("filmes", filmesCadastrados);

        return mv;
    }


    @RequestMapping(value="/{codigo}", method=RequestMethod.GET)
    public ModelAndView detalhesFilme(@PathVariable("codigo") long codigo){
        ModelAndView mv = new ModelAndView("itens/detalhesFilme");
        Filme filme = fr.findByCodigo(codigo);
        Iterable<Comentario> comentarios = cr.findByFilme(filme);

        mv.addObject("filme", filme);
        mv.addObject("comentarios", comentarios);
        return mv;
    }

    @RequestMapping("/deletarFilme")
    public String deletarFilme(long codigo){
        Filme filme = fr.findByCodigo(codigo);
        fr.delete(filme);
        return "redirect:/index";
    }

    @RequestMapping(value="/{codigo}", method=RequestMethod.POST)
    public String detalhesFilmePost(@PathVariable("codigo") long codigo , @Valid Comentario comentario, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
        }
        Filme filme = fr.findByCodigo(codigo);
        comentario.setFilme(filme);
        cr.save(comentario);
        attributes.addFlashAttribute("mensagem", "Comentário adicionado com sucesso!");
        return "redirect:/{codigo}";
    }

    @RequestMapping("/deletarComentario")
    public String deletarComentario(long cd){
        Comentario comentario = cr.findByCd(cd);
        cr.delete(comentario);

        Filme filme = comentario.getFilme();
        long codigoLong = filme.getCodigo();
        String codigo = "" + codigoLong;

        return "redirect:/" + codigo;
    }

    @GetMapping("/imagem/{codigo}")
    @ResponseBody
    public byte[] exibirImagem(@PathVariable("codigo") long codigo){
        Filme filme = this.fr.findByCodigo(codigo);
        return filme.getImagem();
    }




}
