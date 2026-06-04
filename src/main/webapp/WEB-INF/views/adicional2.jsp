<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Registro de Empresa | Sistema Call Center</title>
  <link rel="stylesheet" href="/CallCenter.css?v=blue-public-20260604">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>
<c:choose>
  <c:when test="${modoAdmin}">
    <%@ include file="fragments/nav_privado.jsp" %>
  </c:when>
  <c:otherwise>
    <%@ include file="fragments/nav_publico.jsp" %>
  </c:otherwise>
</c:choose>
<div class="footer">Sistema de Call Center</div>
</body>
</html>
