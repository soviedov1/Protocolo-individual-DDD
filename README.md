# Proyecto CEA - Domain-Driven Design (DDD)

Modelo de dominio para la gestión de matrículas académicas basado en los principios del Diseño Guiado por el Dominio (DDD).

## Estructura del Dominio

El proyecto sigue una arquitectura táctica DDD organizada en el paquete `com.cea.domain`:

```
src/
├── main/java/com/cea/domain/
│   ├── aggregates/
│   │   └── MatriculaAcademica.java      # Raíz del Agregado (Aggregate Root)
│   ├── entities/
│   │   └── Estudiante.java              # Entidad con identidad propia
│   ├── events/
│   │   └── CursoMatriculadoEvent.java   # Evento de dominio inmutable
│   ├── exceptions/
│   │   └── ExcepcionDeDominio.java      # Excepción para reglas de negocio
│   └── valueobjects/
│       ├── CorreoInstitucional.java     # Objeto de Valor con validación de formato
│       └── MontoMatricula.java          # Objeto de Valor con moneda y operaciones
└── test/java/
    └── MatriculaAcademicaTest.java      # Pruebas unitarias de invariantes del dominio
```

## Elementos del Dominio

### 1. Agregado: `MatriculaAcademica`
Es la raíz del agregado encargada de mantener la consistencia e invariantes:
- **Límite máximo de créditos:** No permite superar los 20 créditos totales (`MAX_CREDITOS`).
- **Unicidad de cursos:** Valida que un curso no se matricule más de una vez antes de verificar créditos.
- **Créditos válidos:** No admite créditos negativos.
- **Gestión de eventos de dominio:** Registra `CursoMatriculadoEvent` al matricular cursos y provee `limpiarEventos()` para cuando la infraestructura o capa de aplicación los despacha.
- **Operaciones:** `agregarCurso`, `removerCurso`, `contieneCurso`, `obtenerCreditosDeCurso`, `asignarMonto`.
- **Identidad:** Dos matrículas son iguales si comparten el mismo `matriculaId`.

### 2. Entidad: `Estudiante`
- Identificada por `estudianteId`.
- Posee invariantes de nombre no vacío y correo institucional válido.
- Métodos de negocio: `actualizarNombre` y `actualizarCorreo`.
- Comparación por identidad (`estudianteId`).

### 3. Objetos de Valor (Value Objects)
- **`CorreoInstitucional`:**
  - Inmutable (`final`).
  - Validación de formato de correo.
  - Normalización a minúsculas.
  - Igualdad estructural por valor.
- **`MontoMatricula`:**
  - Inmutable con validación de valor no negativo y código de moneda requerido.
  - Operaciones de dominio: `sumar` y `multiplicar`.
  - Igualdad estructural por valor y moneda.

### 4. Eventos de Dominio
- **`CursoMatriculadoEvent`:** Representa el hecho inmutable de que un curso fue inscrito en una matrícula dada. Incluye marca temporal (`timestamp`).

### 5. Excepciones
- **`ExcepcionDeDominio`:** Runtime exception utilizada para reportar cualquier incumplimiento de las invariantes y reglas de negocio del dominio.
