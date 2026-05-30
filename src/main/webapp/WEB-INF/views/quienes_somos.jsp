<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Quienes somos | Sistema Call Center</title>
  <link rel="stylesheet" href="/CallCenter.css?v=legal-pages-20260530">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>
<%@ include file="fragments/nav_publico.jsp" %>

<main class="container public-content legal-content">
  <article class="legal-card about-card" aria-labelledby="quienes-somos-titulo">
    <header class="legal-header about-header">
      <span class="legal-icon" aria-hidden="true">👥</span>
      <div>
        <h1 id="quienes-somos-titulo">Quienes somos</h1>
        <p>Somos un portal informativo orientado a compartir ofertas de empleo, convocatorias y oportunidades laborales para personas que buscan nuevas alternativas de desarrollo profesional.</p>
      </div>
    </header>

    <section class="legal-section" aria-labelledby="nuestra-historia">
      <h2 id="nuestra-historia">Nuestra historia</h2>
      <p>Desde hace algunos años, <a class="legal-link" href="https://empleos-aqui.elproton.com/">https://empleos-aqui.elproton.com/</a> se ha consolidado como un portal informativo orientado a la difusión de ofertas de empleo y oportunidades laborales. Nuestro propósito es brindar información clara, útil y responsable a todas las personas que buscan nuevas alternativas para fortalecer su desarrollo profesional.</p>
      <p>Desde el año 2022, trabajamos de forma constante en la recopilación y publicación de información actualizada sobre vacantes, empresas y convocatorias vigentes en distintos países del mundo hispanohablante.</p>
    </section>

    <section class="legal-section" aria-labelledby="equipo-editorial">
      <h2 id="equipo-editorial">Equipo editorial</h2>
      <div class="legal-grid about-grid">
        <div class="legal-info-box">
          <h3>Jose Chavez</h3>
          <p>Lidera el equipo editorial y coordina la revisión de contenidos para mantener una comunicación clara, transparente y responsable.</p>
        </div>
        <div class="legal-info-box">
          <h3>Milagros Miranda</h3>
          <p>Acompaña la gestión editorial con compromiso por la veracidad, la transparencia y la calidad de cada contenido publicado.</p>
        </div>
      </div>
    </section>

    <section class="legal-section" aria-labelledby="compromiso">
      <h2 id="compromiso">Nuestro compromiso</h2>
      <p>En <a class="legal-link" href="https://empleos-aqui.elproton.com/">https://empleos-aqui.elproton.com/</a> comprendemos la importancia de generar confianza y ofrecer una experiencia positiva a nuestros lectores. Por ello, abordamos una amplia variedad de temas relacionados con el empleo y compartimos contenidos informativos que contribuyen al crecimiento personal y profesional de quienes visitan nuestra plataforma.</p>
      <p>Agradecemos la confianza que depositas en nuestro sitio y reafirmamos nuestro compromiso de seguir siendo un espacio informativo accesible, responsable y cercano, enfocado en acompañarte en la búsqueda de nuevas oportunidades laborales.</p>
    </section>

    <section class="legal-section legal-contact" aria-labelledby="contacto-quienes-somos">
      <h2 id="contacto-quienes-somos">Contacto</h2>
      <p>Si deseas ponerte en contacto con nosotros, puedes hacerlo a través del siguiente correo electrónico:</p>
      <p class="legal-email">📧 AQUI IRA EL CORREO</p>
    </section>
  </article>
</main>

<%@ include file="fragments/footer_publico.jsp" %>
</body>
</html>
