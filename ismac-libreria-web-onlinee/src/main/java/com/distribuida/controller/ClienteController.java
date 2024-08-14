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

import com.distribuida.dao.ClienteDAO;
import com.distribuida.entities.Cliente;

@Controller
@RequestMapping("/Clientes")    //path principal


public class ClienteController {
	
	//JSP .- Java Server Page, son las paginas web de tecnologia java
	
	@Autowired 
	private ClienteDAO clienteDAO;
	
	@GetMapping("/findAll")       //path secundario
	public String findAll (Model model) {
		
		//try {
			
			List<Cliente> clientes = clienteDAO.findALL();
			
			model.addAttribute("clientes", clientes);   //EJ: clave = keyClientes , valor = clientes
			
			return "clientes-listar";    //esto es el nombre del formulario EJ: listar-clientes.html listar-clientes-jsp
		
//	     }catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		
	}
	
	@GetMapping("//findOne")
	public String findOne(@RequestParam("idCliente") @Nullable Integer idCliente
						, @RequestParam("opcion") @Nullable Integer opcion
						, Model model 
			) {
		//try {
		

		if  (idCliente !=null) {
			Cliente cliente = clienteDAO.findOne(idCliente);
			model.addAttribute("Cliente", cliente);
		}
		
		if(opcion == 1) return "add-clientes";   //actualización
		else return "del-clientes";              //eliminacion
	
//     }catch (Exception e) {
//		// TODO: handle exception
//		e.printStackTrace();
//	   }
		
		
		
		
	}
	
	
	@PostMapping("/add")
	public String add(@RequestParam("idcliente") @Nullable Integer idCliente
					, @RequestParam("cedula") @Nullable String cedula
					, @RequestParam("nombre") @Nullable String nombre
					, @RequestParam("apellido") @Nullable String apellido 
					, @RequestParam("direccion")@Nullable String direccion
					, @RequestParam("telefono") @Nullable String telefono
					, @RequestParam("correo") @Nullable String correo
					, Model model
			) {
		
	//try {
		if(idCliente == null) {
			Cliente cliente = new Cliente(0, cedula, nombre, apellido, direccion, telefono, correo);
			clienteDAO.add(cliente);
		}else {
			Cliente cliente2 = new Cliente(idCliente, cedula, nombre, apellido, direccion, telefono, correo);
			clienteDAO.up(cliente2);
		}
		return "redirect:/cientes/findAll";   //ir a formulario web por path o url
	}

		
//     }catch (Exception e) {
//		// TODO: handle exception
//		e.printStackTrace();
//	   }
		
		
	
	
	@GetMapping("/del")
	public String del (@RequestParam("idCliente") @Nullable Integer idCliente) {
		
		//try {
		
		
		clienteDAO.del(idCliente);
		
		return "redirect:/clientes/findAll";
	}
	
		
//     }catch (Exception e) {
//		// TODO: handle exception
//		e.printStackTrace();
//	   }
		
	
//versionar
}
