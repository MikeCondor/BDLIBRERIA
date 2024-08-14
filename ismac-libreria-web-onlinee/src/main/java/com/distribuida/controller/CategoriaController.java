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

import com.distribuida.dao.CategoriaDAO;
import com.distribuida.entities.Categoria;

@Controller
@RequestMapping("/Categorias")    //path principal
public class CategoriaController {
	
	@Autowired 
	private CategoriaDAO categoriaDAO;
	
	@GetMapping("/findAll")       //path secundario
	public String findAll(Model model) {
		List<Categoria> categorias = categoriaDAO.findALL();
		model.addAttribute("keyCategorias", categorias);   // EJ: clave = keyCategorias, valor = categorias
		return "listar-categorias";    // esto es el nombre del formulario EJ: listar-categorias.html listar-categorias-jsp
	}
	
	@GetMapping("/findOne")
	public String findOne(@RequestParam("idCategoria") @Nullable Integer idCategoria,
                          @RequestParam("opcion") @Nullable Integer opcion,
                          Model model) {
		if (idCategoria != null) {
			Categoria categoria = categoriaDAO.findOne(idCategoria);
			model.addAttribute("Categoria", categoria);
		}
		
		if(opcion == 1) return "add-categorias";   // actualización
		else return "del-categorias";              // eliminación
	}
	
	@PostMapping("/add")
	public String add(@RequestParam("idCategoria") @Nullable Integer idCategoria,
                      @RequestParam("categoria") @Nullable String categoria,
                      @RequestParam("descripcion") @Nullable String descripcion,
                      Model model) {
		if(idCategoria == null) {
			Categoria nuevaCategoria = new Categoria(0, categoria, descripcion);
			categoriaDAO.add(nuevaCategoria);
		} else {
			Categoria categoriaExistente = new Categoria(idCategoria, categoria, descripcion);
			categoriaDAO.up(categoriaExistente);
		}
		return "redirect:/categorias/findAll";   // ir a formulario web por path o url
	}

	@GetMapping("/del")
	public String del(@RequestParam("idCategoria") @Nullable Integer idCategoria) {
		categoriaDAO.del(idCategoria);
		return "redirect:/categorias/findAll";
	}
}
