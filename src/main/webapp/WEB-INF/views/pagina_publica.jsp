<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>${titulo} | Sistema Call Center</title>
  <link rel="stylesheet" href="/CallCenter.css?v=blue-public-20260604">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>
<%@ include file="fragments/nav_publico.jsp" %>

<main class="container public-content">
  <section class="hero public-hero" aria-labelledby="titulo-publico">
    <div class="hero-copy">
      <h1 id="titulo-publico">${icono} ${titulo}</h1>
      <p>${descripcion}</p>
    </div>
  </section>
</main>

<%@ include file="fragments/footer_publico.jsp" %>
</body>
</html>
