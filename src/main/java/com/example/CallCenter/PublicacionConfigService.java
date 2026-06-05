package com.example.CallCenter;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

@Service
public class PublicacionConfigService {
    private static final Path CONFIG_PATH = Path.of("data", "publicacion-supervisor.properties");

    private PublicacionConfig supervisorInventarios;

    public PublicacionConfigService() {
        supervisorInventarios = PublicacionConfig.supervisorInventariosDefault();
        cargarDesdeArchivo();
    }

    public synchronized PublicacionConfig obtenerSupervisorInventarios() {
        PublicacionConfig publicacion = new PublicacionConfig(supervisorInventarios);
        if (publicacion.getContenidoHtml() == null || publicacion.getContenidoHtml().isBlank()) {
            publicacion.setContenidoHtml(PublicacionConfig.supervisorInventariosDefault().getContenidoHtml());
        }
        return publicacion;
    }

    public synchronized PublicacionConfig obtenerPorSlug(String slug) {
        if ("supervisor-inventarios-operaciones-almacen".equals(slug)) {
            return obtenerSupervisorInventarios();
        }
        if ("tecnico-refrigeracion-aire-acondicionado".equals(slug)) {
            return PublicacionConfig.tecnicoRefrigeracionDefault();
        }
        if ("gestor-cobranza-telefonica-campo".equals(slug)) {
            return PublicacionConfig.gestorCobranzaDefault();
        }
        if ("tecnico-instalador-redes-telecomunicaciones".equals(slug)) {
            return PublicacionConfig.tecnicoRedesDefault();
        }
        if ("auxiliar-recursos-humanos-seleccion".equals(slug)) {
            return PublicacionConfig.auxiliarRecursosHumanosDefault();
        }
        return null;
    }

    public synchronized void guardarSupervisorInventarios(PublicacionConfig config) {
        config.setSlug("supervisor-inventarios-operaciones-almacen");
        supervisorInventarios = new PublicacionConfig(config);
        guardarEnArchivo();
    }

    private void cargarDesdeArchivo() {
        if (!Files.exists(CONFIG_PATH)) {
            return;
        }

        Properties properties = new Properties();
        try (InputStream inputStream = Files.newInputStream(CONFIG_PATH)) {
            properties.load(inputStream);
            aplicarSiExiste(properties, "categoria", supervisorInventarios::setCategoria);
            aplicarSiExiste(properties, "titulo", supervisorInventarios::setTitulo);
            aplicarSiExiste(properties, "subtitulo", supervisorInventarios::setSubtitulo);
            aplicarSiExiste(properties, "heroImageUrl", supervisorInventarios::setHeroImageUrl);
            aplicarSiExiste(properties, "heroImageAlt", supervisorInventarios::setHeroImageAlt);
            aplicarSiExiste(properties, "postulationUrl", supervisorInventarios::setPostulationUrl);
            aplicarSiExiste(properties, "buttonLabel", supervisorInventarios::setButtonLabel);
            aplicarSiExiste(properties, "icono", supervisorInventarios::setIcono);
            aplicarSiExiste(properties, "queConsiste", supervisorInventarios::setQueConsiste);
            aplicarSiExiste(properties, "funcionesIntro", supervisorInventarios::setFuncionesIntro);
            aplicarSiExiste(properties, "perfilIntro", supervisorInventarios::setPerfilIntro);
            aplicarSiExiste(properties, "beneficiosIntro", supervisorInventarios::setBeneficiosIntro);
            aplicarSiExiste(properties, "relacionadosIntro", supervisorInventarios::setRelacionadosIntro);
            aplicarSiExiste(properties, "postulacionIntro", supervisorInventarios::setPostulacionIntro);
            aplicarSiExiste(properties, "cierrePostulacion", supervisorInventarios::setCierrePostulacion);
        } catch (IOException ignored) {
            supervisorInventarios = PublicacionConfig.supervisorInventariosDefault();
        }
    }

    private void guardarEnArchivo() {
        Properties properties = new Properties();
        properties.setProperty("categoria", textoSeguro(supervisorInventarios.getCategoria()));
        properties.setProperty("titulo", textoSeguro(supervisorInventarios.getTitulo()));
        properties.setProperty("subtitulo", textoSeguro(supervisorInventarios.getSubtitulo()));
        properties.setProperty("heroImageUrl", textoSeguro(supervisorInventarios.getHeroImageUrl()));
        properties.setProperty("heroImageAlt", textoSeguro(supervisorInventarios.getHeroImageAlt()));
        properties.setProperty("postulationUrl", textoSeguro(supervisorInventarios.getPostulationUrl()));
        properties.setProperty("buttonLabel", textoSeguro(supervisorInventarios.getButtonLabel()));
        properties.setProperty("icono", textoSeguro(supervisorInventarios.getIcono()));
        properties.setProperty("queConsiste", textoSeguro(supervisorInventarios.getQueConsiste()));
        properties.setProperty("funcionesIntro", textoSeguro(supervisorInventarios.getFuncionesIntro()));
        properties.setProperty("perfilIntro", textoSeguro(supervisorInventarios.getPerfilIntro()));
        properties.setProperty("beneficiosIntro", textoSeguro(supervisorInventarios.getBeneficiosIntro()));
        properties.setProperty("relacionadosIntro", textoSeguro(supervisorInventarios.getRelacionadosIntro()));
        properties.setProperty("postulacionIntro", textoSeguro(supervisorInventarios.getPostulacionIntro()));
        properties.setProperty("cierrePostulacion", textoSeguro(supervisorInventarios.getCierrePostulacion()));

        try {
            Files.createDirectories(CONFIG_PATH.getParent());
            try (OutputStream outputStream = Files.newOutputStream(CONFIG_PATH)) {
                properties.store(outputStream, "Configuración editable de la publicación destacada");
            }
        } catch (IOException ignored) {
            // La publicación sigue disponible en memoria aunque el archivo no pueda escribirse.
        }
    }

    private void aplicarSiExiste(Properties properties, String key, java.util.function.Consumer<String> setter) {
        String value = properties.getProperty(key);
        if (value != null) {
            setter.accept(value);
        }
    }

    private String textoSeguro(String value) {
        return value == null ? "" : value;
    }
}
