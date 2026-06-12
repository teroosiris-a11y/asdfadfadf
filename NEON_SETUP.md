# Conexión con Neon PostgreSQL

La aplicación usa Spring JDBC y lee la conexión desde variables de entorno para evitar guardar credenciales reales en el repositorio.

## Variables necesarias

La forma más sencilla es crear un archivo `.env` en la raíz del proyecto y pegar ahí la cadena JDBC que Neon muestra para Java.

1. Copia `.env.example` como `.env`.
2. Pega tu cadena JDBC completa en `DATABASE_URL`.
3. No necesitas configurar `DATABASE_USERNAME` ni `DATABASE_PASSWORD` si la URL ya trae `user=` y `password=`.
4. Ejecuta Maven normalmente.

Ejemplo de `.env`:

```properties
DATABASE_URL=jdbc:postgresql://TU_HOST_NEON/neondb?user=neondb_owner&password=TU_PASSWORD_NEON&sslmode=require&channelBinding=require
```

> El archivo `.env` real está ignorado por Git. No subas credenciales reales al repositorio.

## Ejemplo con Neon

### Opción recomendada: archivo `.env`

En la raíz del proyecto, crea o edita `.env`:

```properties
DATABASE_URL=jdbc:postgresql://ep-gentle-term-at3659kk-pooler.c-9.us-east-1.aws.neon.tech/neondb?user=neondb_owner&password=TU_PASSWORD_DE_NEON&sslmode=require&channelBinding=require
```

Después ejecuta:

```powershell
.\mvnw.cmd spring-boot:run
```

### Alternativa: variables de entorno en PowerShell / Windows

En PowerShell las variables de entorno deben empezar con `$env:`. Si escribes `DATABASE_URL="..."`, Spring no recibe la variable y deja el texto literal `${DATABASE_URL}`.

```powershell
$env:DATABASE_URL="jdbc:postgresql://ep-gentle-term-at3659kk-pooler.c-9.us-east-1.aws.neon.tech/neondb?user=neondb_owner&password=TU_PASSWORD_DE_NEON&sslmode=require&channelBinding=require"
.\mvnw.cmd spring-boot:run
```

### Alternativa: variables de entorno en Bash / Git Bash / Linux / macOS

```bash
export DATABASE_URL="jdbc:postgresql://ep-gentle-term-at3659kk-pooler.c-9.us-east-1.aws.neon.tech/neondb?user=neondb_owner&password=TU_PASSWORD_DE_NEON&sslmode=require&channelBinding=require"
./mvnw spring-boot:run
```

> No subas credenciales reales a Git. Si compartiste la contraseña, regénérala en Neon antes de usarla en producción.

## Ejecutar la aplicación

Después de configurar las variables de entorno en la misma terminal, ejecuta:

```bash
./mvnw spring-boot:run
```

En Windows PowerShell usa:

```powershell
.\mvnw.cmd spring-boot:run
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

- No configuraste `DATABASE_URL` en `.env` o en la misma terminal donde ejecutas Maven.
- En PowerShell usaste sintaxis de Bash (`DATABASE_URL="..."` o `export ...`) en lugar de `$env:DATABASE_URL="..."`.
- La URL no comienza con `jdbc:postgresql://`.
- Tu `DATABASE_URL` no se cargó desde `.env` o no quedó como variable de entorno de la misma terminal.
- La contraseña tiene caracteres especiales y fue pegada mal en la terminal.
- La base Neon está suspendida, el host es incorrecto o falta `sslmode=require`.

Para descartar problemas de conexión externa, primero ejecuta con el perfil `local`.

## Tablas de acceso y roles

Además de las tablas operativas (`empresas`, `agentes`, `tipificaciones` y `llamadas`), el archivo `src/main/resources/schema.sql` crea estas tablas de autenticación en Neon cada vez que arranca la aplicación:

| Tabla | Propósito |
| --- | --- |
| `roles` | Catálogo de niveles del sistema: `superadmin`, `empresa` y `agente`. |
| `usuarios_sistema` | Usuarios que pueden iniciar sesión, con su rol y vínculo opcional a `empresas` o `agentes`. |

La clase `DatosAccesoIniciales` carga automáticamente estos accesos base si no existen:

| Usuario | Contraseña | Rol |
| --- | --- | --- |
| `Sa01` | `Sa01` | `superadmin` |
| `Emp01` | `Emp01` | `empresa` |
| `Age01` | `Age01` | `agente` |
| `empresa01` | `emp01` | `empresa` |
| `agente01` | `age01` | `agente` |

Cuando se registra una empresa nueva desde la aplicación, también se crea su usuario en `usuarios_sistema` con rol `empresa`. Cuando se crea un agente nuevo, también se crea su usuario con rol `agente`.
