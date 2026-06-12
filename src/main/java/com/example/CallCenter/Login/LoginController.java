package com.example.CallCenter.Login;

import com.example.CallCenter.Empresa.Empresa;
import com.example.CallCenter.Empresa.EmpresaService;
import com.example.CallCenter.auth.UsuarioSistema;
import com.example.CallCenter.auth.UsuarioSistemaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final EmpresaService empresaService;
    private final UsuarioSistemaRepository usuarioSistemaRepository;

    public LoginController(EmpresaService empresaService, UsuarioSistemaRepository usuarioSistemaRepository) {
        this.empresaService = empresaService;
        this.usuarioSistemaRepository = usuarioSistemaRepository;
    }

    @GetMapping
    public String mostrarLogin() {
        return "login";
    }

    @PostMapping("/ingresar")
    public String ingresar(
            @RequestParam("usuario") String usuario,
            @RequestParam("contrasena") String contrasena,
            HttpSession session,
            Model model) {

        UsuarioSistema usuarioSistema = usuarioSistemaRepository.obtenerPorCredenciales(usuario, contrasena);
        if (usuarioSistema != null) {
            String estado = usuarioSistema.getEstado() == null ? "activo" : usuarioSistema.getEstado().toLowerCase();
            if ("activo".equals(estado)) {
                session.setAttribute("rol", usuarioSistema.getRol());
                session.setAttribute("usuario", usuarioSistema.getUsuario());
                if (usuarioSistema.getIdEmpresa() != null) {
                    session.setAttribute("id_empresa", usuarioSistema.getIdEmpresa());
                }
                if (usuarioSistema.getIdAgente() != null) {
                    session.setAttribute("id_agente", usuarioSistema.getIdAgente());
                }
                return "redirect:/dashboard/" + usuarioSistema.getRol();
            }
            model.addAttribute("estadoBloqueado", "Tu usuario no está activo. Contacta al superadmin.");
            return "login";
        }

        Empresa empresa = empresaService.obtenerPorCredenciales(usuario, contrasena);
        if (empresa != null) {
            String estado = empresa.getEstado() == null ? "activo" : empresa.getEstado().toLowerCase();
            if ("activo".equals(estado)) {
                session.setAttribute("rol", "empresa");
                session.setAttribute("usuario", empresa.getUsuario());
                session.setAttribute("id_empresa", empresa.getId());
                return "redirect:/dashboard/empresa";
            }
            if ("suspendido".equals(estado)) {
                model.addAttribute("estadoBloqueado", "Tu empresa está suspendida. Contacta al superadmin.");
                return "login";
            }
            if ("borrado".equals(estado)) {
                model.addAttribute("estadoBloqueado", "Tu empresa fue dada de baja y no tiene acceso.");
                return "login";
            }
        }

        model.addAttribute("error", true);
        return "login";
    }

    @GetMapping("/salir")
    public String salir(HttpSession session) {
        session.invalidate();
        return "redirect:/main";
    }
}
