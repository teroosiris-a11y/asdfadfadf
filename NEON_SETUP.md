# Conexión con Neon PostgreSQL

La aplicación usa Spring JDBC y lee la conexión desde variables de entorno para evitar guardar credenciales reales en el repositorio.

## Variables necesarias

Configura estas variables en tu terminal local o en el panel de variables de entorno de tu hosting:

```bash
export DATABASE_URL="jdbc:postgresql://TU_HOST_NEON/neondb?sslmode=require"
export DATABASE_USERNAME="neondb_owner"
export DATABASE_PASSWORD="TU_PASSWORD_NEON"
```

Neon suele mostrar el string como `postgresql://usuario:password@host/db?sslmode=require`. Para Spring Boot:

1. Agrega `jdbc:` al inicio de la URL.
2. Quita usuario y contraseña de la URL.
3. Coloca el usuario en `DATABASE_USERNAME`.
4. Coloca la contraseña en `DATABASE_PASSWORD`.

## Ejemplo con Neon

```bash
export DATABASE_URL="jdbc:postgresql://ep-gentle-term-at3659kk.c-9.us-east-1.aws.neon.tech/neondb?sslmode=require"
export DATABASE_USERNAME="neondb_owner"
export DATABASE_PASSWORD="TU_PASSWORD_DE_NEON"
```

> No subas credenciales reales a Git. Si compartiste la contraseña, regénérala en Neon antes de usarla en producción.

## Ejecutar la aplicación

```bash
./mvnw spring-boot:run
```

Al iniciar, Spring ejecuta `src/main/resources/schema.sql` para crear las tablas si no existen. Los repositorios cargan datos demo solo cuando cada tabla está vacía.
