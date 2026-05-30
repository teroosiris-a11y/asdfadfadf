<%--
  fragments/nav_publico.jsp
  Barra pública principal con el orden solicitado para visitantes.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="uriActual" value="${pageContext.request.requestURI}" />

<header class="topbar public-topbar">
  <div class="topbar-inner public-topbar-inner">
    <div class="brand">
      <img src="/logo.png" alt="Logo Sistema CallCenter" class="brand-logo">
    </div>

    <form class="public-search" action="/blog" method="get" role="search" aria-label="Buscar contenido">
      <input type="search" name="q" placeholder="Buscar" aria-label="Buscar">
      <button type="submit" aria-label="Buscar"><i class="fa-solid fa-magnifying-glass"></i></button>
    </form>

    <nav class="menu public-menu" aria-label="Navegación principal">
      <a href="/main" class="${uriActual == '/main' || uriActual == '/' ? 'active' : ''}">Inicio</a>
      <a href="/blog" class="${uriActual.contains('/blog') ? 'active' : ''}">🌐 Blog</a>
      <a href="/convocatorias" class="${uriActual.contains('/convocatorias') ? 'active' : ''}">👔 Convocatorias</a>
      <a href="/bonos" class="${uriActual.contains('/bonos') ? 'active' : ''}">🤝 Bonos</a>
      <a href="/becas" class="${uriActual.contains('/becas') ? 'active' : ''}">👩‍🎓 Becas</a>
      <a href="/empresas-publicas" class="${uriActual.contains('/empresas-publicas') ? 'active' : ''}">🏭 Empresas</a>
      <a href="/empleos-fabricas" class="${uriActual.contains('/empleos-fabricas') ? 'active' : ''}">🏬 Empleos en Fabricas</a>
    </nav>
  </div>
</header>
