package com.example.CallCenter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import com.example.CallCenter.llamada.Llamada;
import com.example.CallCenter.llamada.LlamadaService;
import com.example.CallCenter.tipificacion.Tipificacion;
import com.example.CallCenter.tipificacion.TipificacionService;
import com.example.CallCenter.Empresa.EmpresaService;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.ArrayList;

@Controller
public class NavegacionController {

    private final LlamadaService llamadaService;
    private final TipificacionService tipificacionService;
    private final EmpresaService empresaService;

    public NavegacionController(LlamadaService llamadaService,
                                TipificacionService tipificacionService,
                                EmpresaService empresaService) {
        this.llamadaService = llamadaService;
        this.tipificacionService = tipificacionService;
        this.empresaService = empresaService;
    }

    // ─── Páginas públicas ──────────────────────────────────────────────────────

    @GetMapping("/")
    public String home() { return "main"; }

    @GetMapping("/main")
    public String paginamain() { return "main"; }

    @GetMapping("/publicidad")
    public String publicidad() { return "publicidad"; }

    @GetMapping("/contacto")
    public String contacto() { return "contacto"; }

    @GetMapping("/blog")
    public String blog(Model model) {
        cargarPaginaPublica(model, "Blog", "🌐", "Noticias, consejos y novedades para mantenerte al día desde nuestra plataforma.");
        return "pagina_publica";
    }

    @GetMapping("/convocatorias")
    public String convocatorias(Model model) {
        cargarPaginaPublica(model, "Convocatorias", "👔", "Encuentra oportunidades y llamados importantes organizados para nuestros visitantes.");
        return "pagina_publica";
    }

    @GetMapping("/bonos")
    public String bonos(Model model) {
        cargarPaginaPublica(model, "Bonos", "🤝", "Consulta beneficios, apoyos y novedades disponibles en un solo lugar.");
        return "pagina_publica";
    }

    @GetMapping("/becas")
    public String becas(Model model) {
        cargarPaginaPublica(model, "Becas", "👩‍🎓", "Revisa opciones educativas y oportunidades de formación destacadas.");
        return "pagina_publica";
    }

    @GetMapping("/empresas-publicas")
    public String empresasPublicas(Model model) {
        cargarPaginaPublica(model, "Empresas", "🏭", "Espacio público para conocer empresas y futuras novedades del portal.");
        return "pagina_publica";
    }

    @GetMapping("/empleos-fabricas")
    public String empleosFabricas(Model model) {
        cargarPaginaPublica(model, "Empleos en Fabricas", "🏬", "Explora ofertas, guías y accesos rápidos relacionados con empleos en fábricas.");
        return "pagina_publica";
    }

    @GetMapping("/politica-cookies")
    public String politicaCookies(Model model) {
        cargarPaginaPublica(model, "Política de cookies", "🍪", "Información provisional sobre el uso de cookies y tecnologías similares en el sitio.");
        return "pagina_publica";
    }

    @GetMapping("/politica-privacidad")
    public String politicaPrivacidad(Model model) {
        cargarPaginaPublica(model, "Política de Privacidad", "🔒", "Información provisional sobre el tratamiento y protección de datos de nuestros visitantes.");
        return "pagina_publica";
    }

    @GetMapping("/aviso-legal")
    public String avisoLegal(Model model) {
        cargarPaginaPublica(model, "Aviso Legal", "⚖️", "Información provisional sobre las condiciones legales y responsabilidades del portal.");
        return "pagina_publica";
    }

    @GetMapping("/quienes-somos")
    public String quienesSomos(Model model) {
        cargarPaginaPublica(model, "Quienes somos", "👥", "Próximamente compartiremos más información sobre el funcionamiento de la página y nuestro propósito.");
        return "pagina_publica";
    }

    private void cargarPaginaPublica(Model model, String titulo, String icono, String descripcion) {
        model.addAttribute("titulo", titulo);
        model.addAttribute("icono", icono);
        model.addAttribute("descripcion", descripcion);
    }

    // ─── Dashboard por rol ────────────────────────────────────────────────────

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session) {
        String rol = (String) session.getAttribute("rol");
        if ("superadmin".equals(rol)) return "redirect:/dashboard/superadmin";
        if ("agente".equals(rol))     return "redirect:/dashboard/agente";
        if ("empresa".equals(rol))    return "redirect:/dashboard/empresa";
        return "redirect:/login";
    }

    @GetMapping("/dashboard/superadmin")
    public String dashboardSuperadmin(HttpSession session) {
        if (!"superadmin".equals(session.getAttribute("rol"))) return "redirect:/login";
        return "dashboard_superadmin";
    }

    @GetMapping("/dashboard/empresa")
    public String dashboardEmpresa(HttpSession session) {
        if (!"empresa".equals(session.getAttribute("rol"))) return "redirect:/login";
        return "dashboard_empresa";
    }

    @GetMapping("/dashboard/agente")
    public String dashboardAgente(HttpSession session) {
        if (!"agente".equals(session.getAttribute("rol"))) return "redirect:/login";
        return "dashboard_agente";
    }

    // ─── Páginas privadas comunes ─────────────────────────────────────────────

    @GetMapping("/gestion")
    public String gestion(HttpSession session) {
        if (session.getAttribute("rol") == null) return "redirect:/login";
        return "gestion";
    }

    @GetMapping("/metricas")
    public String metricas(HttpSession session) {
        if (session.getAttribute("rol") == null) return "redirect:/login";
        return "metricas";
    }

    // ─── SuperAdmin exclusivo ─────────────────────────────────────────────────

    @GetMapping("/empresas")
    public String empresas(
            HttpSession session,
            @RequestParam(value = "mostrar", defaultValue = "false") boolean mostrar,
            Model model) {
        if (!"superadmin".equals(session.getAttribute("rol"))) return "redirect:/login";
        model.addAttribute("mostrarEmpresas", mostrar);
        if (mostrar) {
            model.addAttribute("empresas", empresaService.listarEmpresas());
        }
        return "empresas";
    }

    @GetMapping("/metricas/superadmin")
    public String metricasSuperadmin(
            HttpSession session,
            @RequestParam(value = "id_empresa", required = false) Long idEmpresa,
            Model model) {
        if (!"superadmin".equals(session.getAttribute("rol"))) return "redirect:/login";
        // TODO: cargar empresas y métricas filtradas
        model.addAttribute("totalEmpresas", 5);
        model.addAttribute("totalLlamadas", 128);
        model.addAttribute("totalAgentes", 12);
        model.addAttribute("clientesSatisfechos", 114);
        model.addAttribute("tipificacionComun", "Consulta");
        model.addAttribute("empresaSeleccionada", idEmpresa);
        return "metricas_superadmin";
    }

    // ─── Empresa y Agente ─────────────────────────────────────────────────────

    @GetMapping("/llamadas")
    public String llamadas(HttpSession session, Model model) {
        String rol = (String) session.getAttribute("rol");
        if (!"agente".equals(rol) && !"empresa".equals(rol) && !"superadmin".equals(rol))
            return "redirect:/login";
        model.addAttribute("llamada", new com.example.CallCenter.llamada.Llamada());
        model.addAttribute("mostrarTabla", false);
        model.addAttribute("tiposLlamada", tipificacionService.listarTipificaciones());
        return "llamadas";
    }

    @GetMapping("/tipificaciones")
    public String tipificaciones(HttpSession session, Model model) {
        String rol = (String) session.getAttribute("rol");
        if (!"empresa".equals(rol) && !"superadmin".equals(rol))
            return "redirect:/login";
        model.addAttribute("tipificacion", new com.example.CallCenter.tipificacion.Tipificacion());
        model.addAttribute("tiposLlamada", tipificacionService.listarTipificaciones());
        model.addAttribute("mostrarTabla", false);
        return "tipificaciones";
    }

    @GetMapping("/usuarios")
    public String usuarios(HttpSession session, Model model) {
        String rol = (String) session.getAttribute("rol");
        if (!"empresa".equals(rol) && !"superadmin".equals(rol))
            return "redirect:/login";
        model.addAttribute("agente", new com.example.CallCenter.agente.Agente());
        model.addAttribute("mostrarTabla", false);
        return "usuarios";
    }

    @GetMapping("/adicional1")
    public String adicional1(HttpSession session, Model model) {
        if (session.getAttribute("rol") == null) return "redirect:/login";

        List<Llamada> historial = llamadaService.listarLlamadas();

        List<String> motivosBase = Arrays.asList("Consulta", "Reclamo", "Venta", "Soporte", "Otros");
        List<String> motivosDisponibles = new ArrayList<>(motivosBase);
        tipificacionService.listarTiposLlamada()
                .stream()
                .filter(m -> m != null && !m.trim().isEmpty())
                .map(String::trim)
                .filter(m -> motivosBase.stream().noneMatch(b -> b.equalsIgnoreCase(m)))
                .forEach(motivosDisponibles::add);

        model.addAttribute("historialLlamadas", historial);
        model.addAttribute("motivosDisponibles", motivosDisponibles);
        return "adicional1";
    }

    @GetMapping("/adicional3")
    public String adicional3() { return "adicional3"; }

    @GetMapping("/adicional4")
    public String adicional4() { return "adicional4"; }

    @GetMapping("/adicional5")
    public String adicional5() { return "adicional5"; }
}