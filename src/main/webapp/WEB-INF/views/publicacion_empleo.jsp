<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title><c:out value="${publicacion.titulo}" /> | Empleos</title>
  <meta name="description" content="Información de la oportunidad laboral Supervisor de Almacén y Control de Inventarios.">
  <link rel="stylesheet" href="/CallCenter.css?v=job-detail-20260605">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body class="public-job-page">
<%@ include file="fragments/nav_publico.jsp" %>

<main class="job-detail-shell" aria-label="Detalle de oportunidad laboral">
  <section class="sponsored-space sponsored-space-top job-sponsored" aria-label="Enlace patrocinado superior">
    <p>Enlace Patrocinado</p>
    <div class="sponsored-placeholder" aria-hidden="true"></div>
  </section>

  <article class="job-article" id="supervisor-inventarios-operaciones-almacen">
    <header class="job-hero">
      <div class="job-hero-image" aria-label="Imagen destacada">
        <c:choose>
          <c:when test="${not empty publicacion.heroImageUrl}">
            <img src="${publicacion.heroImageUrl}" alt="${publicacion.heroImageAlt}">
          </c:when>
          <c:otherwise>
            <span class="job-hero-placeholder-icon" aria-hidden="true">🏭</span>
            <span class="job-hero-placeholder-text">Espacio reservado para la imagen principal</span>
          </c:otherwise>
        </c:choose>
      </div>
      <div class="job-hero-card">
        <span class="job-category"><c:out value="${publicacion.categoria}" /></span>
        <h1><c:out value="${publicacion.titulo}" /></h1>
        <p><c:out value="${publicacion.subtitulo}" /></p>
      </div>
    </header>

    <section class="job-section job-intro-card" aria-labelledby="intro-title">
      <h2 id="intro-title">¿En qué consiste esta oportunidad laboral? 💼🔥</h2>
      <p><c:out value="${publicacion.queConsiste}" /></p>
    </section>

    <section class="sponsored-space job-sponsored" aria-label="Enlace patrocinado entre introducción y funciones">
      <p>Enlace Patrocinado</p>
      <div class="sponsored-placeholder" aria-hidden="true"></div>
    </section>

    <section class="job-section" aria-labelledby="funciones-title">
      <h2 id="funciones-title">Funciones principales del puesto 🛠️📋</h2>
      <p><c:out value="${publicacion.funcionesIntro}" /></p>
      <ul class="job-list">
        <li>Coordinar y supervisar al personal de almacén, asegurando la correcta ejecución de procesos de carga, descarga, almacenamiento y preparación de pedidos.</li>
        <li>Implementar y mantener sistemas de control de inventarios, realizando conteos cíclicos y físicos para garantizar exactitud entre stock físico y sistema digital.</li>
        <li>Identificar y resolver discrepancias de inventario, investigando causas raíz y proponiendo acciones correctivas eficaces para prevenir errores futuros.</li>
        <li>Optimizar el uso del espacio del almacén y los flujos de materiales, buscando mejoras continuas en eficiencia operativa.</li>
        <li>Generar reportes de existencias, rotación de productos, obsolescencia y productividad para la toma de decisiones.</li>
      </ul>
    </section>

    <section class="job-section" aria-labelledby="perfil-title">
      <h2 id="perfil-title">Perfil ideal y requisitos 📝👔</h2>
      <p><c:out value="${publicacion.perfilIntro}" /></p>
      <p>La experiencia previa es fundamental; la mayoría de empresas solicitan al menos dos a tres años en puestos similares. Esto incluye haber manejado personal y contacto directo con sistemas de gestión de almacenes (WMS) o ERP.</p>
      <ul class="job-list">
        <li><strong>Habilidades técnicas esenciales:</strong> dominio de sistemas ERP como SAP, Oracle, Aspel, Infor o WMS específicos.</li>
        <li>Conocimiento en procesos de inventarios cíclicos, físicos y just-in-time.</li>
        <li>Habilidad para interpretar reportes de existencias, rotación de productos y obsolescencia.</li>
        <li>Manejo avanzado de herramientas de oficina, especialmente hojas de cálculo y bases de datos.</li>
        <li>Conocimiento de seguridad industrial, manejo de materiales peligrosos y buenas prácticas.</li>
      </ul>
    </section>

    <section class="sponsored-space job-sponsored" aria-label="Enlace patrocinado entre requisitos y beneficios">
      <p>Enlace Patrocinado</p>
      <div class="sponsored-placeholder" aria-hidden="true"></div>
    </section>

    <section class="job-section" aria-labelledby="beneficios-title">
      <h2 id="beneficios-title">Beneficios que podrías obtener 🎁💰</h2>
      <p><c:out value="${publicacion.beneficiosIntro}" /></p>
      <ul class="job-list">
        <li>Prestaciones de ley: acceso a IMSS, Infonavit, aguinaldo, vacaciones pagadas y prima vacacional conforme a la legislación mexicana.</li>
        <li>Beneficios superiores: vales de despensa, fondo de ahorro, seguro de vida, gastos médicos mayores, transporte, comedor subsidiado o bonos de productividad.</li>
        <li>Capacitación continua en nuevas tecnologías logísticas, sistemas de gestión avanzados y programas de liderazgo.</li>
        <li>Crecimiento profesional para ascender a Coordinador de Logística, Gerente de Almacén o posiciones estratégicas en cadena de suministro.</li>
      </ul>
    </section>

    <section class="job-section" aria-labelledby="relacionadas-title">
      <h2 id="relacionadas-title">Vacantes relacionadas que podrían interesarte 📌🚀</h2>
      <p><c:out value="${publicacion.relacionadosIntro}" /></p>
      <ul class="job-list job-related-list">
        <li>Coordinador de Logística y Distribución 🚚</li>
        <li>Analista de Inventarios y Cadena de Suministro 📊</li>
        <li>Jefe de Bodega o Centro de Distribución 🏭</li>
        <li>Encargado de Operaciones de Almacén 📦</li>
        <li>Planeador de Materiales y Demanda 🧾</li>
        <li>Especialista en Control de Calidad de Producto Terminado ✅</li>
      </ul>
    </section>

    <section class="job-section" aria-labelledby="postular-title">
      <h2 id="postular-title">Cómo postularte correctamente 🔎</h2>
      <p><c:out value="${publicacion.postulacionIntro}" /></p>
      <ul class="job-list">
        <li>Actualiza tu currículum vitae (CV): destaca experiencia en gestión de almacenes, control de inventarios y liderazgo de equipos. Cuantifica logros siempre que sea posible.</li>
        <li>Utiliza canales de búsqueda adecuados: explora plataformas como OCC Mundial, LinkedIn, Indeed o bolsas de trabajo especializadas.</li>
        <li>Prepara una carta de presentación impactante y personalizada para cada oferta.</li>
        <li>Prepárate a fondo para la entrevista: anticipa preguntas sobre manejo de personal, solución de problemas de inventario e implementación de mejoras.</li>
      </ul>
    </section>

    <section class="job-section job-cta-section" aria-labelledby="enlace-postulacion-title">
      <h2 id="enlace-postulacion-title">Enlace de postulación al final del artículo 🔗✨</h2>
      <p><c:out value="${publicacion.cierrePostulacion}" /></p>
      <a class="job-info-button" href="${publicacion.postulationUrl}" target="_blank" rel="noopener noreferrer">
        <span aria-hidden="true">🔍</span> <c:out value="${publicacion.buttonLabel}" />
      </a>
    </section>
  </article>

  <nav class="job-entry-nav" aria-label="Navegación entre entradas">
    <a href="/convocatorias">← Entrada anterior</a>
    <a href="/bonos">Entrada siguiente →</a>
  </nav>

  <section class="other-jobs" aria-labelledby="otras-ofertas-title">
    <h2 id="otras-ofertas-title">Otras Ofertas de Empleo</h2>
    <div class="other-jobs-grid">
      <article class="other-job-card">
        <div class="other-job-image placeholder">Imagen pendiente</div>
        <h3>Programa Nacional de Reconstrucción</h3>
        <p>Por Jose Chavez / 27/05/2026</p>
      </article>
      <article class="other-job-card">
        <div class="other-job-image placeholder">Imagen pendiente</div>
        <h3>Seguro de Vida para Jefas de Familia</h3>
        <p>Por Jose Chavez / 27/05/2026</p>
      </article>
      <article class="other-job-card">
        <div class="other-job-image placeholder">Imagen pendiente</div>
        <h3>Programa de Abasto Social de Leche</h3>
        <p>Por Jose Chavez / 27/05/2026</p>
      </article>
      <article class="other-job-card">
        <div class="other-job-image placeholder">Imagen pendiente</div>
        <h3>Beca Universal Rita Cetina</h3>
        <p>Por Jose Chavez / 27/05/2026</p>
      </article>
    </div>
  </section>
</main>

<%@ include file="fragments/footer_publico.jsp" %>
</body>
</html>
