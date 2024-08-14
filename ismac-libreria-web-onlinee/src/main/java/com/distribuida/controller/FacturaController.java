package com.distribuida.controller;
 
import java.util.Date;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
 
import com.distribuida.dao.FacturaDAO;
import com.distribuida.entities.Factura;
 
 
@Controller
@RequestMapping("/Facturas") //Path principal
public class FacturaController {
 
	@Autowired
	private FacturaDAO FacturaDAO;
	@GetMapping("/findAll")
	public String findAll(Model model) {
		/*try {
			List<Factura> Facturas=FacturaDAO.findALL();
			model.addAttribute ("Facturas", Facturas);
			return "listar-Facturas";
		}catch(Exception e){
			e.printStackTrace();
		}*/
		List<Factura> Facturas=FacturaDAO.findALL();
		model.addAttribute ("Facturas", Facturas);
		return "listar-Facturas";
	}
	@GetMapping("/findOne")
	public String findOne(@RequestParam("idFactura")@Nullable Integer idFactura
						  ,@RequestParam("opcion") @Nullable Integer opcion
						  ,Model model
			) {
		/*try {
			if(idFactura != null) {
				Factura Factura = FacturaDAO.findOne(idFactura);
				model.addAttribute("Factura", Factura);
			}
			if(opcion == 1) return "add-Facturas";
			else return "del-Facturas";
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		if(idFactura != null) {
			Factura Factura = FacturaDAO.findOne(idFactura);
			model.addAttribute("Factura", Factura);
		}
		if(opcion == 1) return "add-Facturas";
		else return "del-Facturas";
	}
	@PostMapping("/add")
	public String add(@RequestParam("idFactura") @Nullable Integer idFactura
					 ,@RequestParam("cliente") @Nullable String cliente
					 ,@RequestParam("fecha") @Nullable Date fecha
					 ,@RequestParam("iva") @Nullable Integer iva
					 ,@RequestParam("numFactura") @Nullable Integer numFactura
					 ,@RequestParam("total") @Nullable Double total
					 ,@RequestParam("totalNeto") @Nullable Double totalNeto
					 ,Model model
			) {
		/*try {
			if(idFactura == null) {
				Factura factura = new Factura(0, cliente, fecha, iva, numFactura, total, totalNeto);
				FacturaDAO.add(factura);
			}else {
				Factura factura2 = new Factura(idFactura, cliente, fecha, iva, numFactura, total, totalNeto);
				FacturaDAO.up(factura2);
			}
			return "redirect:/Facturas/findAll";
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		if(idFactura == null) {
			Factura factura = new Factura();
			FacturaDAO.add(factura);
		}else {
			Factura factura2 = new Factura();
			FacturaDAO.up(factura2);
		}
		return "redirect:/Facturas/findAll";
	}
	@GetMapping("/dell")
	public String dell(@RequestParam ("idFactura") @Nullable Integer idFactura) {
		/*try {
			FacturaDAO.dell(idFactura);
			return "redirect:/Facturas/findAll";
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		FacturaDAO.del(idFactura);
		return "redirect:/Facturas/findAll";
	}
}