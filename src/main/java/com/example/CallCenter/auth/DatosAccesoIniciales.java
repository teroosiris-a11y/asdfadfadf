package com.example.CallCenter.auth;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatosAccesoIniciales implements ApplicationRunner {

    private final UsuarioSistemaRepository usuarioSistemaRepository;

    public DatosAccesoIniciales(UsuarioSistemaRepository usuarioSistemaRepository) {
        this.usuarioSistemaRepository = usuarioSistemaRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        usuarioSistemaRepository.asegurarRol("superadmin", "Administrador global del sistema");
        usuarioSistemaRepository.asegurarRol("empresa", "Cuenta de empresa para gestionar agentes y operación");
        usuarioSistemaRepository.asegurarRol("agente", "Cuenta de agente para registrar y atender llamadas");

        usuarioSistemaRepository.asegurarUsuario("Sa01", "Sa01", "superadmin", null, null, "activo");
        usuarioSistemaRepository.asegurarUsuario("Emp01", "Emp01", "empresa", 1, null, "activo");
        usuarioSistemaRepository.asegurarUsuario("Age01", "Age01", "agente", 1, 1, "activo");
        usuarioSistemaRepository.asegurarUsuario("empresa01", "emp01", "empresa", 1, null, "activo");
        usuarioSistemaRepository.asegurarUsuario("agente01", "age01", "agente", 1, 1, "activo");
    }
}
