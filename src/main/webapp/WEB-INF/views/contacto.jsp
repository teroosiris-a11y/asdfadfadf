<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Contacto | Sistema Call Center</title>
  <link rel="stylesheet" href="/CallCenter.css?v=contact-page-20260530">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>
<%@ include file="fragments/nav_publico.jsp" %>

<main class="container public-content contact-content">
  <section class="contact-card" aria-labelledby="contacto-titulo">
    <div class="contact-intro">
      <span class="contact-icon" aria-hidden="true">✉️</span>
      <div>
        <h1 id="contacto-titulo">Contacto</h1>
        <p>Completa el formulario y cuéntanos cómo podemos ayudarte. Revisaremos tu mensaje para responderte lo antes posible.</p>
      </div>
    </div>

    <form class="contact-form" action="#" method="post">
      <div class="contact-field">
        <label for="nombre">Tu nombre</label>
        <input id="nombre" name="nombre" type="text" autocomplete="name" required>
      </div>

      <div class="contact-field">
        <label for="correo">Tu correo electrónico</label>
        <input id="correo" name="correo" type="email" autocomplete="email" required>
      </div>

      <div class="contact-field">
        <label for="asunto">Asunto</label>
        <input id="asunto" name="asunto" type="text" required>
      </div>

      <div class="contact-field">
        <label for="mensaje">Tu mensaje (opcional)</label>
        <textarea id="mensaje" name="mensaje" rows="10"></textarea>
      </div>

      <button class="contact-submit" type="submit">Enviar</button>
    </form>
  </section>
</main>

<%@ include file="fragments/footer_publico.jsp" %>
</body>
</html>
