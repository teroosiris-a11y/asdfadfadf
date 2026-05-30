<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Registro de Empresa | Sistema Call Center</title>
  <link rel="stylesheet" href="/CallCenter.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>
<c:choose>
  <c:when test="${modoAdmin}">
    <%@ include file="fragments/nav_privado.jsp" %>
  </c:when>
  <c:otherwise>
    <header class="topbar">
      <div class="topbar-inner">
        <div class="brand">
          <img src="/logo.png" alt="Logo Sistema CallCenter" class="brand-logo">
        </div>
        <nav class="menu" aria-label="Navegación principal">
          <a href="/main">Inicio</a>
          <a href="/contacto" class="active">Contacto</a>
          <a href="/publicidad">Publicidad</a>
          <a href="/login" class="session">Login</a>
        </nav>
      </div>
    </header>
  </c:otherwise>
</c:choose>
<div class="footer">Sistema de Call Center</div>
</body>
</html>
