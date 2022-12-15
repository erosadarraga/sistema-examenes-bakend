package com.sistema.examenes;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sistema.examenes.entidades.Rol;
import com.sistema.examenes.entidades.Usuario;
import com.sistema.examenes.entidades.UsuarioRol;
import com.sistema.examenes.servicios.UsuarioService;

@SpringBootApplication
public class SistemaExamenesBakendApplication implements CommandLineRunner {

	@Autowired
	private UsuarioService usuarioService;

	public static void main(String[] args) {
		SpringApplication.run(SistemaExamenesBakendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Usuario usuario = new Usuario();

		usuario.setNombre("Eros");
		usuario.setEmail("eros@gmail.com");
		usuario.setTelefone("123456789");
		usuario.setApellido("adarraga");
		usuario.setUsername("erosdev");
		usuario.setPassword("sasa");
		usuario.setPerfil("FOTO.PNG");

		Rol rol = new Rol();
		rol.setRolId(1L);
		rol.setNombre("ADMIN");

		Set<UsuarioRol> usuariosRoles = new HashSet<>();

		UsuarioRol usuarioRol = new UsuarioRol();
		usuarioRol.setRol(rol);
		usuarioRol.setUsuario(usuario);
		usuariosRoles.add(usuarioRol);

		Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario, usuariosRoles);
		System.out.println(usuarioGuardado.getUsername());

	}

}
