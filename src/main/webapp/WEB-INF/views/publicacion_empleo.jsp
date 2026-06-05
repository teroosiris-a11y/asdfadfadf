<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title><c:out value="${publicacion.titulo}" /> | Empleos</title>
  <meta name="description" content="Información detallada de oportunidad laboral y recomendaciones para postular.">
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

  <article class="job-article" id="${publicacion.slug}">
    <header class="job-hero">
      <div class="job-hero-image" aria-label="Imagen destacada">
        <c:choose>
          <c:when test="${not empty publicacion.heroImageUrl}">
            <img src="${publicacion.heroImageUrl}" alt="${publicacion.heroImageAlt}">
          </c:when>
          <c:otherwise>
            <span class="job-hero-placeholder-icon" aria-hidden="true"><c:out value="${publicacion.icono}" /></span>
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

    <div class="job-content-body">
      <c:out value="${publicacion.contenidoHtml}" escapeXml="false" />
    </div>

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
