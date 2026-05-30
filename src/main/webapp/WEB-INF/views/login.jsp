<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login | Sistema Call Center</title>
  <link rel="stylesheet" href="/CallCenter.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>
<header class="topbar">
  <div class="topbar-inner">
    <div class="brand">
      <img src="/logo.png" alt="Logo Sistema CallCenter" class="brand-logo">
    </div>
    <nav class="menu" aria-label="Navegación principal">
      <a href="/main">Inicio</a>
      <a href="/contacto">Contacto</a>
      <a href="/publicidad">Publicidad</a>
      <a href="/login" class="active session">Login</a>
    </nav>
  </div>
</header>

<main class="login-shell">
  <section class="login-box" aria-labelledby="titulo-login">
    <h2 id="titulo-login">Ingreso al sistema</h2>
    <p>Usa las credenciales asignadas para entrar al panel correspondiente.</p>

    <c:if test="${error}">
      <div class="alert alert-error" role="alert">
        Usuario o contraseña incorrectos. Verifica los datos e intenta nuevamente.
      </div>
    </c:if>
    <c:if test="${not empty estadoBloqueado}">
      <div class="alert alert-error" role="alert">
        ${estadoBloqueado}
      </div>
    </c:if>

    <form action="/login/ingresar" method="post" class="login-form">
      <label for="usuario">Usuario</label>
      <input id="usuario" name="usuario" type="text" autocomplete="username" required autofocus>

      <label for="contrasena">Contraseña</label>
      <input id="contrasena" name="contrasena" type="password" autocomplete="current-password" required>

      <button type="submit">Ingresar</button>
    </form>

    <div class="small-note credentials-note" aria-label="Credenciales de prueba por rol">
      <strong>Credenciales habilitadas:</strong>
      <span>Superadmin: Sa01 / Sa01</span>
      <span>Empresa: Emp01 / Emp01</span>
      <span>Agente: Age01 / Age01</span>
    </div>
  </section>
</main>

<div class="footer">Sistema de Call Center</div>
</body>
</html>
