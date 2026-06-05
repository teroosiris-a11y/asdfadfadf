<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Editar publicación | SuperAdmin</title>
  <link rel="stylesheet" href="/CallCenter.css?v=job-detail-20260605">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>
<%@ include file="fragments/nav_privado.jsp" %>

<main class="container publication-admin" aria-labelledby="publication-admin-title">
  <section class="section-title">
    <h1 id="publication-admin-title">Editar publicación destacada</h1>
    <p>Desde este apartado puedes ajustar la imagen, los textos principales y el enlace del botón “Más información”.</p>
  </section>

  <c:if test="${not empty mensajeExito}">
    <div class="notice-box success" role="status"><p><c:out value="${mensajeExito}" /></p></div>
  </c:if>

  <form class="publication-admin-form" action="/dashboard/superadmin/publicacion-supervisor" method="post">
    <div class="form-grid">
      <label>Categoría
        <input name="categoria" value="${publicacion.categoria}" required>
      </label>
      <label>Texto del botón
        <input name="buttonLabel" value="${publicacion.buttonLabel}" required>
      </label>
    </div>

    <label>Título
      <textarea name="titulo" required><c:out value="${publicacion.titulo}" /></textarea>
    </label>

    <label>Subtítulo
      <textarea name="subtitulo" required><c:out value="${publicacion.subtitulo}" /></textarea>
    </label>

    <div class="form-grid">
      <label>URL de imagen principal
        <input name="heroImageUrl" value="${publicacion.heroImageUrl}" placeholder="https://... o /imagenes/archivo.png">
      </label>
      <label>Texto alternativo de la imagen
        <input name="heroImageAlt" value="${publicacion.heroImageAlt}">
      </label>
    </div>

    <label>URL del botón “Más información”
      <input name="postulationUrl" value="${publicacion.postulationUrl}" required>
    </label>

    <label>¿En qué consiste esta oportunidad?
      <textarea name="queConsiste" required><c:out value="${publicacion.queConsiste}" /></textarea>
    </label>

    <label>Introducción de funciones
      <textarea name="funcionesIntro" required><c:out value="${publicacion.funcionesIntro}" /></textarea>
    </label>

    <label>Introducción de perfil y requisitos
      <textarea name="perfilIntro" required><c:out value="${publicacion.perfilIntro}" /></textarea>
    </label>

    <label>Introducción de beneficios
      <textarea name="beneficiosIntro" required><c:out value="${publicacion.beneficiosIntro}" /></textarea>
    </label>

    <label>Introducción de vacantes relacionadas
      <textarea name="relacionadosIntro" required><c:out value="${publicacion.relacionadosIntro}" /></textarea>
    </label>

    <label>Introducción de postulación
      <textarea name="postulacionIntro" required><c:out value="${publicacion.postulacionIntro}" /></textarea>
    </label>

    <label>Cierre antes del botón
      <textarea name="cierrePostulacion" required><c:out value="${publicacion.cierrePostulacion}" /></textarea>
    </label>

    <div class="actions">
      <button type="submit"><i class="fa-solid fa-floppy-disk"></i> Guardar cambios</button>
      <a class="button secondary" href="/convocatorias/supervisor-inventarios-operaciones-almacen" target="_blank" rel="noopener noreferrer">Ver publicación</a>
    </div>
  </form>
</main>

<div class="footer">Sistema de Call Center</div>
</body>
</html>
