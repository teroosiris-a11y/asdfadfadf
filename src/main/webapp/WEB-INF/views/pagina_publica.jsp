<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>${titulo} | Sistema Call Center</title>
  <link rel="stylesheet" href="/CallCenter.css?v=blue-public-20260610">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body class="public-list-page">
<%@ include file="fragments/nav_publico.jsp" %>

<c:choose>
  <c:when test="${not empty publicaciones}">
    <main class="category-main" aria-label="${titulo}">
      <section class="category-heading" aria-labelledby="titulo-publico">
        <span class="category-kicker">${icono} ${etiqueta}</span>
        <h1 id="titulo-publico">${subtitulo}</h1>
        <p>${descripcion}</p>
      </section>

      <section class="category-sponsored category-sponsored-top" aria-label="Espacio publicitario superior">
        <p>Enlace Patrocinado</p>
        <div class="category-ad-placeholder" aria-hidden="true"></div>
      </section>

      <section class="category-list" aria-label="Listado de ${titulo}">
        <c:forEach var="publicacion" items="${publicaciones}">
          <article class="category-row-card">
            <a class="category-image-slot" href="${publicacion.url}" aria-label="${publicacion.imagenAlt}">
              <span aria-hidden="true">${publicacion.icono}</span>
              <small>Espacio para imagen</small>
            </a>
            <div class="category-row-copy">
              <span class="category-row-tag">${publicacion.categoria}</span>
              <h2><a href="${publicacion.url}">${publicacion.titulo}</a></h2>
              <p>Enlace Patrocinado ${publicacion.titulo}</p>
              <a class="category-info-button" href="${publicacion.url}">${textoBoton}</a>
            </div>
          </article>
        </c:forEach>
      </section>

      <section class="category-sponsored category-sponsored-bottom" aria-label="Espacio publicitario inferior">
        <p>Enlace Patrocinado</p>
        <div class="category-ad-placeholder" aria-hidden="true"></div>
      </section>
    </main>
  </c:when>
  <c:otherwise>
    <main class="container public-content">
      <section class="hero public-hero" aria-labelledby="titulo-publico">
        <div class="hero-copy">
          <h1 id="titulo-publico">${icono} ${titulo}</h1>
          <p>${descripcion}</p>
        </div>
      </section>
    </main>
  </c:otherwise>
</c:choose>

<%@ include file="fragments/footer_publico.jsp" %>
</body>
</html>
