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

## Ejecutar en local sin Neon

Si solo quieres probar la aplicación en tu equipo y no tienes configuradas las variables de Neon, usa el perfil `local`. Este perfil usa una base H2 en memoria y evita errores de conexión externa.

### PowerShell

```powershell
.\mvnw.cmd spring-boot:run -D"spring-boot.run.profiles=local"
```

### Bash / Git Bash

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=local
```

## Por qué aparece el error de Hikari

El rastro que termina en `HikariDataSource.getConnection` y `DatabasePopulatorUtils.execute` normalmente significa que Spring intentó abrir la conexión para ejecutar `schema.sql`, pero no pudo conectarse a la base de datos. Las causas más comunes son:

- No configuraste `DATABASE_URL`, `DATABASE_USERNAME` o `DATABASE_PASSWORD`.
- La URL no comienza con `jdbc:postgresql://`.
- La contraseña tiene caracteres especiales y fue pegada mal en la terminal.
- La base Neon está suspendida, el host es incorrecto o falta `sslmode=require`.

Para descartar problemas de conexión externa, primero ejecuta con el perfil `local`.
