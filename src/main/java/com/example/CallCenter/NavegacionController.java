package com.example.CallCenter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
    private final PublicacionConfigService publicacionConfigService;

    public NavegacionController(LlamadaService llamadaService,
                                TipificacionService tipificacionService,
                                EmpresaService empresaService,
                                PublicacionConfigService publicacionConfigService) {
        this.llamadaService = llamadaService;
        this.tipificacionService = tipificacionService;
        this.empresaService = empresaService;
        this.publicacionConfigService = publicacionConfigService;
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
        cargarPaginaPublica(
                model,
                "Convocatorias",
                "💼",
                "Posiciones abiertas en empresas reales. Aplica directo.",
                "Vacantes destacadas",
                "Empleos disponibles ahora",
                "Más Información ->",
                List.of(
                        item("🏭", "Logística", "Supervisor de Inventarios y Operaciones de Almacén: Impulsa tu Desarrollo Profesional", "/convocatorias/supervisor-inventarios-operaciones-almacen", "Imagen para Supervisor de Inventarios"),
                        item("❄️", "Técnico", "¡Únete al Sector de la Climatización! Vacante para Técnico en Refrigeración y Aire Acondicionado", "/convocatorias/tecnico-refrigeracion-aire-acondicionado", "Imagen para Técnico en Refrigeración"),
                        item("💰", "Finanzas", "Vacante Disponible: Gestor de Cobranza Telefónica y de Campo", "/convocatorias/gestor-cobranza-telefonica-campo", "Imagen para Gestor de Cobranza"),
                        item("🔁", "Telecom", "Técnico Instalador de Redes y Telecomunicaciones", "/convocatorias/tecnico-instalador-redes-telecomunicaciones", "Imagen para Técnico Instalador"),
                        item("👥", "RRHH", "Auxiliar de Recursos Humanos y Selección de Personal", "/convocatorias/auxiliar-recursos-humanos-seleccion", "Imagen para Recursos Humanos"),
                        item("🖼️", "Diseño", "Diseñador Gráfico y Creador de Contenido Digital", "/convocatorias/disenador-grafico-contenido-digital", "Imagen para Diseño Gráfico")
                )
        );
        return "pagina_publica";
    }

    @GetMapping("/bonos")
    public String bonos(Model model) {
        cargarPaginaPublica(
                model,
                "Bonos",
                "🤝",
                "Apoyos económicos gubernamentales a los que puedes acceder hoy.",
                "Apoyos del gobierno",
                "Bonos y programas sociales",
                "Más Información ->",
                List.of(
                        item("🇲🇽", "Pensión", "Apoyo para Personas con Discapacidad Permanente: Conoce los Beneficios y Cómo Solicitarlo", "/bonos/apoyo-discapacidad-permanente", "Imagen para apoyo de discapacidad"),
                        item("✚", "Salud", "Salud en Tu Comunidad: Atención Médica Más Cerca de las Familias 🏥❤", "/bonos/salud-en-tu-comunidad", "Imagen para salud comunitaria"),
                        item("🧓", "Adultos mayores", "Apoyo para Personas Adultas Mayores: Beneficios, Requisitos y Cómo Realizar tu Registro 👵👴", "/bonos/adultos-mayores-registro", "Imagen para adultos mayores"),
                        item("🍼", "Alimentación", "Nutrición y Apoyo para las Familias: Conoce el Programa de Leche Subsidiada 🥛", "/bonos/leche-subsidiada", "Imagen para leche subsidiada"),
                        item("👨‍👩‍👧", "Seguro", "Protección y Apoyo para el Futuro de las Familias ✨", "/bonos/proteccion-familias", "Imagen para protección familiar"),
                        item("🏢", "Vivienda", "Reconstruyendo Comunidades: Apoyo para la Recuperación de Zonas Afectadas 🏡", "/bonos/reconstruyendo-comunidades", "Imagen para reconstrucción de comunidades")
                )
        );
        return "pagina_publica";
    }

    @GetMapping("/becas")
    public String becas(Model model) {
        cargarPaginaPublica(model, "Becas", "👩‍🎓", "Revisa opciones educativas y oportunidades de formación destacadas.");
        return "pagina_publica";
    }

    @GetMapping("/empresas-publicas")
    public String empresasPublicas(Model model) {
        cargarPaginaPublica(
                model,
                "Empresas",
                "🏢",
                "Trabaja con las marcas más grandes del país.",
                "Grandes empleadores",
                "Vacantes en empresas reconocidas",
                "Más Información ->",
                List.of(
                        item("🏡", "Reconstrucción", "construir para Avanzar: Conoce el Programa Nacional de Reconstrucción 🏡✨", "/empresas-publicas/programa-nacional-reconstruccion", "Imagen para reconstrucción"),
                        item("👮", "Seguridad", "Seguridad y Protección: Una Carrera con Propósito y Estabilidad 🛡️✨", "/empresas-publicas/seguridad-proteccion", "Imagen para seguridad"),
                        item("🚚", "Distribución", "Conductor Distribuidor: Una Carrera con Estabilidad y Crecimiento", "/empresas-publicas/conductor-distribuidor", "Imagen para conductor distribuidor"),
                        item("🥖", "Alimentos", "Ayudante de Panadería: Oportunidad para Crecer en el Mundo de la Panificación", "/empresas-publicas/ayudante-panaderia", "Imagen para panadería"),
                        item("🧹", "Hospitalidad", "Auxiliar de Limpieza en Hotelería: Oportunidad para Formar Parte de un Equipo Profesional", "/empresas-publicas/auxiliar-limpieza-hoteleria", "Imagen para limpieza hotelera"),
                        item("📦", "Manufactura", "Construye una Carrera con Impacto", "/empresas-publicas/empacador-carrera-impacto", "Imagen para manufactura")
                )
        );
        return "pagina_publica";
    }

    @GetMapping("/empleos-fabricas")
    public String empleosFabricas(Model model) {
        cargarPaginaPublica(model, "Empleos en Fabricas", "🏬", "Explora ofertas, guías y accesos rápidos relacionados con empleos en fábricas.");
        return "pagina_publica";
    }


    @GetMapping("/convocatorias/{slug}")
    public String detalleConvocatoria(@org.springframework.web.bind.annotation.PathVariable String slug, Model model) {
        PublicacionConfig publicacion = publicacionConfigService.obtenerPorSlug(slug);
        if (publicacion == null) {
            return "redirect:/convocatorias";
        }
        model.addAttribute("publicacion", publicacion);
        model.addAttribute("volverUrl", "/convocatorias");
        model.addAttribute("siguienteUrl", "/bonos");
        return "publicacion_empleo";
    }

    @GetMapping("/bonos/{slug}")
    public String detalleBono(@org.springframework.web.bind.annotation.PathVariable String slug, Model model) {
        PublicacionConfig publicacion = publicacionConfigService.obtenerPorSlug(slug);
        if (publicacion == null) {
            return "redirect:/bonos";
        }
        model.addAttribute("publicacion", publicacion);
        model.addAttribute("volverUrl", "/bonos");
        model.addAttribute("siguienteUrl", "/main");
        return "publicacion_empleo";
    }

    @GetMapping("/empresas-publicas/{slug}")
    public String detalleEmpresaPublica(@org.springframework.web.bind.annotation.PathVariable String slug, Model model) {
        PublicacionConfig publicacion = publicacionConfigService.obtenerPorSlug(slug);
        if (publicacion == null) {
            return "redirect:/empresas-publicas";
        }
        model.addAttribute("publicacion", publicacion);
        model.addAttribute("volverUrl", "/empresas-publicas");
        model.addAttribute("siguienteUrl", "/main");
        return "publicacion_empleo";
    }

    @GetMapping("/politica-cookies")
    public String politicaCookies() {
        return "politica_cookies";
    }

    @GetMapping("/politica-privacidad")
    public String politicaPrivacidad() {
        return "politica_privacidad";
    }

    @GetMapping("/aviso-legal")
    public String avisoLegal() {
        return "aviso_legal";
    }

    @GetMapping("/quienes-somos")
    public String quienesSomos() {
        return "quienes_somos";
    }

    private void cargarPaginaPublica(Model model, String titulo, String icono, String descripcion) {
        model.addAttribute("titulo", titulo);
        model.addAttribute("icono", icono);
        model.addAttribute("descripcion", descripcion);
    }

    private void cargarPaginaPublica(Model model,
                                     String titulo,
                                     String icono,
                                     String descripcion,
                                     String etiqueta,
                                     String subtitulo,
                                     String textoBoton,
                                     List<Map<String, String>> publicaciones) {
        cargarPaginaPublica(model, titulo, icono, descripcion);
        model.addAttribute("etiqueta", etiqueta);
        model.addAttribute("subtitulo", subtitulo);
        model.addAttribute("textoBoton", textoBoton);
        model.addAttribute("publicaciones", publicaciones);
    }

    private Map<String, String> item(String icono, String categoria, String titulo, String url, String imagenAlt) {
        return Map.of(
                "icono", icono,
                "categoria", categoria,
                "titulo", titulo,
                "url", url,
                "imagenAlt", imagenAlt
        );
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


    @GetMapping("/dashboard/superadmin/publicacion-supervisor")
    public String editarPublicacionSupervisor(HttpSession session, Model model) {
        if (!"superadmin".equals(session.getAttribute("rol"))) return "redirect:/login";
        model.addAttribute("publicacion", publicacionConfigService.obtenerSupervisorInventarios());
        return "superadmin_publicacion";
    }

    @PostMapping("/dashboard/superadmin/publicacion-supervisor")
    public String guardarPublicacionSupervisor(
            HttpSession session,
            @ModelAttribute PublicacionConfig publicacion,
            Model model) {
        if (!"superadmin".equals(session.getAttribute("rol"))) return "redirect:/login";
        publicacionConfigService.guardarSupervisorInventarios(publicacion);
        model.addAttribute("publicacion", publicacionConfigService.obtenerSupervisorInventarios());
        model.addAttribute("mensajeExito", "La publicación fue actualizada correctamente.");
        return "superadmin_publicacion";
    }

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