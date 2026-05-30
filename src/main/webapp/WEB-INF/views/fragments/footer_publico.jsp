<%--
  fragments/footer_publico.jsp
  Pie de página público compartido para visitantes.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<footer class="public-footer" aria-label="Pie de página público">
  <section class="public-footer-info" aria-label="Información legal y búsqueda">
    <div class="public-footer-disclaimer">
      <h2>Descargo de Responsabilidad</h2>
      <p><strong>empleos-aqui.elproton.com</strong> es un Sitio Web es de carácter informativo acerca de los</p>
      <p>Ofertas de Trabajo. Cabe mencionar que no tenemos ningún tipo de vinculación y</p>
      <p>que no nos lucramos a través de ninguna entidad publica, ni dichas empresas.</p>
    </div>

    <form class="public-footer-search" action="/blog" method="get" role="search" aria-label="Encuentra Vacantes Disponibles">
      <label for="footer-search">Encuentra Vacantes Disponibles</label>
      <div class="public-footer-search-box">
        <input id="footer-search" type="search" name="q" aria-label="Buscar vacantes disponibles">
        <button type="submit" aria-label="Buscar"><i class="fa-solid fa-magnifying-glass"></i></button>
      </div>
    </form>
  </section>

  <section class="public-footer-bottom" aria-label="Enlaces legales">
    <p class="public-footer-copy">© Copyright 2026, All Rights Reserved</p>
    <nav class="public-footer-links" aria-label="Enlaces del pie de página">
      <a href="/politica-cookies">Política de cookies</a>
      <a href="/politica-privacidad">Política de Privacidad</a>
      <a href="/aviso-legal">Aviso Legal</a>
      <a href="/contacto">Contacto</a>
      <a href="/quienes-somos">Quienes somos</a>
    </nav>
  </section>
</footer>
