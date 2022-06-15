package com.clemy.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clemy.Repository.UsuarioRepository;
import com.clemy.modelo.Usuario;

@Controller
@RequestMapping
public class LoginController {
	@Autowired
	UsuarioRepository usuarioRepositorio;

	@GetMapping("/login")
	public String index(Usuario usuario) {
		return "login";
	}

	@PostMapping("/IniciarSesion")
	public String iniciarSesion(Usuario usuario) {
		Usuario validar = usuarioRepositorio.findByEmailAndPassword(usuario.getEmail(), usuario.getPassword());
		if (validar == null) {
			return "login";
		} else if (validar.getRoles().get(0).getNombre().equals("Admin")) {
			return "Admin/inicioDash";
		} else if (validar.getRoles().get(0).getNombre().equals("vendedor")) {
			return "vendedor/inicioDashVendedor";
		}
		return "login";
	}
}
