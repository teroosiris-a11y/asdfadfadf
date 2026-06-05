package com.example.CallCenter;

public class PublicacionConfig {
    private String slug;
    private String categoria;
    private String titulo;
    private String subtitulo;
    private String heroImageUrl;
    private String heroImageAlt;
    private String postulationUrl;
    private String buttonLabel;
    private String queConsiste;
    private String funcionesIntro;
    private String perfilIntro;
    private String beneficiosIntro;
    private String relacionadosIntro;
    private String postulacionIntro;
    private String cierrePostulacion;

    public PublicacionConfig() {
    }

    public PublicacionConfig(PublicacionConfig other) {
        this.slug = other.slug;
        this.categoria = other.categoria;
        this.titulo = other.titulo;
        this.subtitulo = other.subtitulo;
        this.heroImageUrl = other.heroImageUrl;
        this.heroImageAlt = other.heroImageAlt;
        this.postulationUrl = other.postulationUrl;
        this.buttonLabel = other.buttonLabel;
        this.queConsiste = other.queConsiste;
        this.funcionesIntro = other.funcionesIntro;
        this.perfilIntro = other.perfilIntro;
        this.beneficiosIntro = other.beneficiosIntro;
        this.relacionadosIntro = other.relacionadosIntro;
        this.postulacionIntro = other.postulacionIntro;
        this.cierrePostulacion = other.cierrePostulacion;
    }

    public static PublicacionConfig supervisorInventariosDefault() {
        PublicacionConfig config = new PublicacionConfig();
        config.slug = "supervisor-inventarios-operaciones-almacen";
        config.categoria = "Logística";
        config.titulo = "Supervisor de Inventarios y Operaciones de Almacén: Impulsa tu Desarrollo Profesional";
        config.subtitulo = "Una posición clave dentro de la logística moderna.";
        config.heroImageUrl = "";
        config.heroImageAlt = "Imagen destacada de supervisor de almacén y control de inventarios";
        config.postulationUrl = "https://www.linkedin.com/jobs/";
        config.buttonLabel = "Más información";
        config.queConsiste = "El sector logístico en México experimenta un crecimiento constante y acelerado, impulsado por el e-commerce y la globalización de cadenas de suministro. En este dinámico entorno, la figura del Supervisor de Almacén y Control de Inventarios se ha vuelto esencial. Este rol clave asegura eficiencia operativa y correcta gestión de recursos. Impacta directamente en la rentabilidad y satisfacción del cliente. Un profesional en esta área es el cerebro detrás del movimiento de mercancías, desde su recepción hasta su despacho. Su labor va más allá de solo contar productos; implica estrategia, planificación y supervisión constante. Es una carrera con gran demanda actual, ofreciendo retos y oportunidades para quienes buscan desarrollo en logística. Si tienes visión organizada y te apasiona la eficiencia, este camino es para ti.";
        config.funcionesIntro = "Las responsabilidades de un Supervisor de Almacén y Control de Inventarios son variadas y cruciales para cualquier operación logística. Tu liderazgo será clave para el equipo de trabajo. La capacidad de optimizar procesos es fundamental. A continuación se detallan las principales funciones que ejercerás:";
        config.perfilIntro = "Para destacar como Supervisor de Almacén y Control de Inventarios en México, se busca un perfil proactivo con sólidas habilidades de liderazgo. No existe una edad específica, pero se valora la madurez y experiencia práctica comprobable. La escolaridad mínima suele ser bachillerato técnico o general. Estudios universitarios en logística, administración o ingenierías son un plus.";
        config.beneficiosIntro = "Trabajar como Supervisor de Almacén y Control de Inventarios en México ofrece atractivos beneficios y oportunidades de crecimiento. Las empresas formales brindan un paquete de compensaciones competitivo. Estos son algunos de los beneficios y ventajas que podrías obtener:";
        config.relacionadosIntro = "Si el rol de Supervisor de Almacén y Control de Inventarios capta tu atención, pero deseas explorar otras opciones laborales similares, el mercado mexicano tiene un abanico que ofrecerte. Estos puestos comparten la esencia de gestión logística y de inventarios, con matices distintos. Son excelentes alternativas para aplicar tus habilidades en diversos entornos.";
        config.postulacionIntro = "Para asegurar una postulación exitosa para un puesto tan competitivo como Supervisor de Almacén y Control de Inventarios, la preparación es clave. Un currículum vitae bien elaborado y una actitud proactiva te diferenciarán. Sigue estos pasos estratégicos para maximizar tus posibilidades:";
        config.cierrePostulacion = "Al final de este post encontrarás el enlace oficial para postularte directamente a la vacante de Supervisor de Almacén y Control de Inventarios. No pierdas esta valiosa oportunidad de dar un giro positivo a tu carrera profesional.";
        return config;
    }

    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getSubtitulo() { return subtitulo; }
    public void setSubtitulo(String subtitulo) { this.subtitulo = subtitulo; }
    public String getHeroImageUrl() { return heroImageUrl; }
    public void setHeroImageUrl(String heroImageUrl) { this.heroImageUrl = heroImageUrl; }
    public String getHeroImageAlt() { return heroImageAlt; }
    public void setHeroImageAlt(String heroImageAlt) { this.heroImageAlt = heroImageAlt; }
    public String getPostulationUrl() { return postulationUrl; }
    public void setPostulationUrl(String postulationUrl) { this.postulationUrl = postulationUrl; }
    public String getButtonLabel() { return buttonLabel; }
    public void setButtonLabel(String buttonLabel) { this.buttonLabel = buttonLabel; }
    public String getQueConsiste() { return queConsiste; }
    public void setQueConsiste(String queConsiste) { this.queConsiste = queConsiste; }
    public String getFuncionesIntro() { return funcionesIntro; }
    public void setFuncionesIntro(String funcionesIntro) { this.funcionesIntro = funcionesIntro; }
    public String getPerfilIntro() { return perfilIntro; }
    public void setPerfilIntro(String perfilIntro) { this.perfilIntro = perfilIntro; }
    public String getBeneficiosIntro() { return beneficiosIntro; }
    public void setBeneficiosIntro(String beneficiosIntro) { this.beneficiosIntro = beneficiosIntro; }
    public String getRelacionadosIntro() { return relacionadosIntro; }
    public void setRelacionadosIntro(String relacionadosIntro) { this.relacionadosIntro = relacionadosIntro; }
    public String getPostulacionIntro() { return postulacionIntro; }
    public void setPostulacionIntro(String postulacionIntro) { this.postulacionIntro = postulacionIntro; }
    public String getCierrePostulacion() { return cierrePostulacion; }
    public void setCierrePostulacion(String cierrePostulacion) { this.cierrePostulacion = cierrePostulacion; }
}
