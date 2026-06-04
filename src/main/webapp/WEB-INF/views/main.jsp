<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Inicio | Empleos, bonos y becas</title>
  <link rel="stylesheet" href="/CallCenter.css?v=home-public-20260604">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body class="home-page">
<%@ include file="fragments/nav_publico.jsp" %>

<main class="home-main" aria-label="Inicio">
  <section class="sponsored-space sponsored-space-top" aria-label="Espacio publicitario principal">
    <p>Enlace Patrocinado</p>
    <div class="sponsored-placeholder" aria-hidden="true"></div>
  </section>

  <section class="home-panel home-panel-featured" aria-labelledby="jobs-title">
    <div class="home-hero-copy">
      <span class="home-domain-pill">EMPLEOS-AQUI.ELPROTON.COM</span>
      <h1>Tu puerta a las mejores <span>oportunidades</span></h1>
      <p>Empleos, bonos y becas en un solo lugar, actualizados cada día para ti.</p>
    </div>

    <div class="home-section-heading">
      <span>💼 Vacantes destacadas</span>
      <h2 id="jobs-title">Empleos disponibles ahora</h2>
      <p>Posiciones abiertas en empresas reales. Aplica directo.</p>
    </div>

    <div class="home-card-grid">
      <a class="home-action-card" href="/convocatorias#supervisor-inventarios-operaciones-almacen" aria-label="Ver vacante Supervisor de Inventarios y Operaciones de Almacén">
        <span class="home-card-icon" aria-hidden="true">🏭</span>
        <span class="home-card-body">
          <span class="home-card-category">Logística</span>
          <strong>Supervisor de Inventarios y Operaciones de Almacén: Impulsa tu Desarrollo Profesional</strong>
          <span class="home-card-link">Ver vacante →</span>
        </span>
      </a>

      <a class="home-action-card" href="/convocatorias#tecnico-refrigeracion-aire-acondicionado" aria-label="Ver vacante para Técnico en Refrigeración y Aire Acondicionado">
        <span class="home-card-icon" aria-hidden="true">❄️</span>
        <span class="home-card-body">
          <span class="home-card-category">Técnico</span>
          <strong>¡Únete al Sector de la Climatización! Vacante para Técnico en Refrigeración y Aire Acondicionado</strong>
          <span class="home-card-link">Ver vacante →</span>
        </span>
      </a>

      <a class="home-action-card" href="/convocatorias#gestor-cobranza-telefonica-campo" aria-label="Ver vacante Gestor de Cobranza Telefónica y de Campo">
        <span class="home-card-icon" aria-hidden="true">💰</span>
        <span class="home-card-body">
          <span class="home-card-category">Finanzas</span>
          <strong>Vacante Disponible: Gestor de Cobranza Telefónica y de Campo</strong>
          <span class="home-card-link">Ver vacante →</span>
        </span>
      </a>

      <a class="home-action-card" href="/convocatorias#tecnico-instalador-redes-telecomunicaciones" aria-label="Ver vacante Técnico Instalador de Redes y Telecomunicaciones">
        <span class="home-card-icon" aria-hidden="true">🔁</span>
        <span class="home-card-body">
          <span class="home-card-category">Telecom</span>
          <strong>Técnico Instalador de Redes y Telecomunicaciones</strong>
          <span class="home-card-link">Ver vacante →</span>
        </span>
      </a>

      <a class="home-action-card" href="/convocatorias#auxiliar-recursos-humanos-seleccion" aria-label="Ver vacante Auxiliar de Recursos Humanos y Selección de Personal">
        <span class="home-card-icon" aria-hidden="true">👥</span>
        <span class="home-card-body">
          <span class="home-card-category">RRHH</span>
          <strong>Auxiliar de Recursos Humanos y Selección de Personal</strong>
          <span class="home-card-link">Ver vacante →</span>
        </span>
      </a>

      <a class="home-action-card" href="/convocatorias#disenador-grafico-contenido-digital" aria-label="Ver vacante Diseñador Gráfico y Creador de Contenido Digital">
        <span class="home-card-icon" aria-hidden="true">🖼️</span>
        <span class="home-card-body">
          <span class="home-card-category">Diseño</span>
          <strong>Diseñador Gráfico y Creador de Contenido Digital</strong>
          <span class="home-card-link">Ver vacante →</span>
        </span>
      </a>
    </div>
  </section>

  <section class="sponsored-space" aria-label="Espacio publicitario entre vacantes y bonos">
    <p>Enlace Patrocinado</p>
    <div class="sponsored-placeholder" aria-hidden="true"></div>
  </section>

  <section class="home-panel home-panel-bonuses" aria-labelledby="bonus-title">
    <div class="home-section-heading">
      <span>🤝 Apoyos del gobierno</span>
      <h2 id="bonus-title">Bonos y programas sociales</h2>
      <p>Apoyos económicos gubernamentales a los que puedes acceder hoy.</p>
    </div>

    <div class="home-card-grid">
      <a class="home-action-card bonus-card" href="/bonos#apoyo-discapacidad-permanente" aria-label="Ver apoyo para personas con discapacidad permanente">
        <span class="home-card-icon" aria-hidden="true">🇲🇽</span>
        <span class="home-card-body">
          <span class="home-card-category">Pensión</span>
          <strong>Apoyo para Personas con Discapacidad Permanente: Conoce los Beneficios y Cómo Solicitarlo</strong>
          <span class="home-card-link">Ver bono →</span>
        </span>
      </a>

      <a class="home-action-card bonus-card" href="/bonos#salud-en-tu-comunidad" aria-label="Ver programa Salud en Tu Comunidad">
        <span class="home-card-icon" aria-hidden="true">✚</span>
        <span class="home-card-body">
          <span class="home-card-category">Salud</span>
          <strong>Salud en Tu Comunidad: Atención Médica Más Cerca de las Familias 🏥❤</strong>
          <span class="home-card-link">Ver bono →</span>
        </span>
      </a>

      <a class="home-action-card bonus-card" href="/bonos#adultos-mayores-registro" aria-label="Ver apoyo para personas adultas mayores">
        <span class="home-card-icon" aria-hidden="true">🧓</span>
        <span class="home-card-body">
          <span class="home-card-category">Adultos mayores</span>
          <strong>Apoyo para Personas Adultas Mayores: Beneficios, Requisitos y Cómo Realizar tu Registro 👵👴</strong>
          <span class="home-card-link">Ver bono →</span>
        </span>
      </a>

      <a class="home-action-card bonus-card" href="/bonos#leche-subsidiada" aria-label="Ver programa de leche subsidiada">
        <span class="home-card-icon" aria-hidden="true">🍼</span>
        <span class="home-card-body">
          <span class="home-card-category">Alimentación</span>
          <strong>Nutrición y Apoyo para las Familias: Conoce el Programa de Leche Subsidiada 🥛</strong>
          <span class="home-card-link">Ver bono →</span>
        </span>
      </a>

      <a class="home-action-card bonus-card" href="/bonos#proteccion-familias" aria-label="Ver protección y apoyo para el futuro de las familias">
        <span class="home-card-icon" aria-hidden="true">👨‍👩‍👧</span>
        <span class="home-card-body">
          <span class="home-card-category">Seguro</span>
          <strong>Protección y Apoyo para el Futuro de las Familias ✨</strong>
          <span class="home-card-link">Ver bono →</span>
        </span>
      </a>

      <a class="home-action-card bonus-card" href="/bonos#reconstruyendo-comunidades" aria-label="Ver programa reconstruyendo comunidades">
        <span class="home-card-icon" aria-hidden="true">🏢</span>
        <span class="home-card-body">
          <span class="home-card-category">Vivienda</span>
          <strong>Reconstruyendo Comunidades: Apoyo para la Recuperación de Zonas Afectadas 🏡</strong>
          <span class="home-card-link">Ver bono →</span>
        </span>
      </a>
    </div>
  </section>

  <section class="sponsored-space" aria-label="Espacio publicitario entre bonos y empresas">
    <p>Enlace Patrocinado</p>
    <div class="sponsored-placeholder" aria-hidden="true"></div>
  </section>

  <section class="home-panel home-panel-employers" aria-labelledby="employers-title">
    <div class="home-section-heading">
      <span>🏢 Grandes empleadores</span>
      <h2 id="employers-title">Vacantes en empresas reconocidas</h2>
      <p>Trabaja con las marcas más grandes del país.</p>
    </div>

    <div class="home-card-grid">
      <a class="home-action-card" href="/empresas-publicas#walmart" aria-label="Ver vacante Vendedor en Walmart">
        <span class="home-card-icon" aria-hidden="true">🛒</span>
        <span class="home-card-body">
          <span class="home-card-category">Retail</span>
          <strong>Vendedor en Walmart</strong>
          <span class="home-card-link">Ver vacante →</span>
        </span>
      </a>

      <a class="home-action-card" href="/empresas-publicas#eulen" aria-label="Ver vacante Guardia de Seguridad en Grupo EULEN">
        <span class="home-card-icon" aria-hidden="true">👮</span>
        <span class="home-card-body">
          <span class="home-card-category">Seguridad</span>
          <strong>Guardia de Seguridad en Grupo EULEN</strong>
          <span class="home-card-link">Ver vacante →</span>
        </span>
      </a>

      <a class="home-action-card" href="/empresas-publicas#coca-cola-femsa" aria-label="Ver vacante Chofer Repartidor en Coca-Cola FEMSA">
        <span class="home-card-icon" aria-hidden="true">🚚</span>
        <span class="home-card-body">
          <span class="home-card-category">Distribución</span>
          <strong>Chofer Repartidor en Coca-Cola FEMSA</strong>
          <span class="home-card-link">Ver vacante →</span>
        </span>
      </a>

      <a class="home-action-card" href="/empresas-publicas#starbucks" aria-label="Ver vacante Ayudante de Panadería en Starbucks">
        <span class="home-card-icon" aria-hidden="true">☕</span>
        <span class="home-card-body">
          <span class="home-card-category">Alimentos</span>
          <strong>Ayudante de Panadería en Starbucks</strong>
          <span class="home-card-link">Ver vacante →</span>
        </span>
      </a>

      <a class="home-action-card" href="/empresas-publicas#marriott" aria-label="Ver vacante Auxiliar de Limpieza en Marriott Hotels">
        <span class="home-card-icon" aria-hidden="true">🧹</span>
        <span class="home-card-body">
          <span class="home-card-category">Hospitalidad</span>
          <strong>Auxiliar de Limpieza en Marriott Hotels</strong>
          <span class="home-card-link">Ver vacante →</span>
        </span>
      </a>

      <a class="home-action-card" href="/empresas-publicas#bimbo" aria-label="Ver vacante Empacador en Grupo Bimbo">
        <span class="home-card-icon" aria-hidden="true">🥖</span>
        <span class="home-card-body">
          <span class="home-card-category">Manufactura</span>
          <strong>Empacador en Grupo Bimbo</strong>
          <span class="home-card-link">Ver vacante →</span>
        </span>
      </a>
    </div>
  </section>

  <section class="sponsored-space" aria-label="Espacio publicitario antes de categorías">
    <p>Enlace Patrocinado</p>
    <div class="sponsored-placeholder" aria-hidden="true"></div>
  </section>

  <section class="home-explore" aria-labelledby="explore-title">
    <div class="home-section-heading">
      <span>🗂️ Explora todo</span>
      <h2 id="explore-title">Todas las categorías</h2>
      <p>Encuentra lo que necesitas según tu situación.</p>
    </div>

    <div class="explore-grid">
      <a class="explore-card" href="/convocatorias">
        <span aria-hidden="true">👔</span>
        <strong>Convocatorias</strong>
        <small>Procesos de selección abiertos en el país</small>
        <em>Ver todo →</em>
      </a>
      <a class="explore-card" href="/bonos">
        <span aria-hidden="true">🤝</span>
        <strong>Bonos</strong>
        <small>Apoyos y programas de bienestar social</small>
        <em>Ver todo →</em>
      </a>
      <a class="explore-card" href="/becas">
        <span aria-hidden="true">🎓</span>
        <strong>Becas</strong>
        <small>Financiamiento educativo y académico</small>
        <em>Ver todo →</em>
      </a>
      <a class="explore-card" href="/empresas-publicas">
        <span aria-hidden="true">🏢</span>
        <strong>Empresas</strong>
        <small>Vacantes en grandes corporativos</small>
        <em>Ver todo →</em>
      </a>
      <a class="explore-card explore-card-wide" href="/empleos-fabricas">
        <span aria-hidden="true">🏭</span>
        <strong>Empleos en Fábricas</strong>
        <small>Trabajo en plantas industriales y manufactura</small>
        <em>Ver todo →</em>
      </a>
    </div>
  </section>
</main>

<%@ include file="fragments/footer_publico.jsp" %>
</body>
</html>
