package com.clemy.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DireccionamientoController {
	
	@GetMapping("/")
	public String paginaInicio() {
		return "index";
	}
	@GetMapping("/Clemy")
	public String Inicio() {
		return "index";
	}
	@GetMapping("/indexDash")
	public String InicioDashboard() {
		return "Admin/inicioDash";
	}
	@GetMapping("/indexDashVendedor")
	public String DashboardVende() {
		return "vendedor/inicioDashVendedor";
	}

}
