package com.distribuida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.distribuida.dao.AutorDAO;
import com.distribuida.entities.Autor;

@Controller
@RequestMapping("/Autores")    //path principal
public class AutorController {

    @Autowired 
    private AutorDAO autorDAO;

    @GetMapping("/findAll")       //path secundario
    public String findAll(Model model) {
        List<Autor> autores = autorDAO.findALL();
        model.addAttribute("keyAutores", autores);   // EJ: clave = keyAutores , valor = autores
        return "listar-autores";    // esto es el nombre del formulario EJ: listar-autores.html listar-autores-jsp
    }

    @GetMapping("/findOne")
    public String findOne(@RequestParam("idAutor") @Nullable Integer idAutor,
                          @RequestParam("opcion") @Nullable Integer opcion,
                          Model model) {
        if (idAutor != null) {
            Autor autor = autorDAO.findOne(idAutor);
            model.addAttribute("Autor", autor);
        }

        if (opcion == 1) return "add-autores";   // actualización
        else return "del-autores";              // eliminación
    }

    @PostMapping("/add")
    public String add(@RequestParam("idAutor") @Nullable Integer idAutor,
                      @RequestParam("nombre") @Nullable String nombre,
                      @RequestParam("apellido") @Nullable String apellido,
                      @RequestParam("pais") @Nullable String pais,
                      @RequestParam("direccion") @Nullable String direccion,
                      @RequestParam("telefono") @Nullable String telefono,
                      @RequestParam("correo") @Nullable String correo,
                      Model model) {
        if (idAutor == null) {
            Autor autor = new Autor(0, apellido, correo, direccion, nombre, pais, telefono);
            autorDAO.add(autor);
        } else {
            Autor autor2 = new Autor(idAutor, apellido, correo, direccion, nombre, pais, telefono);
            autorDAO.up(autor2);
        }
        return "redirect:/autores/findAll";   // ir a formulario web por path o url
    }

    @GetMapping("/del")
    public String del(@RequestParam("idAutor") @Nullable Integer idAutor) {
        autorDAO.del(idAutor);
        return "redirect:/autores/findAll";
    }
}
