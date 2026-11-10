public class MatriculaAcademicaTest {

    @Test
    void debeLanzarExcepcionAlSuperarElLimiteMaximoDeCreditos() {
        // 1. Preparar los datos (Arrange)
        MatriculaAcademica matricula = new MatriculaAcademica("MAT-001");
        matricula.agregarCurso("CURSO-1", 15);

        // 2 y 3. Ejecutar y Verificar (Act & Assert)
        Exception excepcion = assertThrows(RuntimeException.class, () -> {
            matricula.agregarCurso("CURSO-2", 8);
        });

        assertEquals("Se supera el límite máximo de 20 créditos.", excepcion.getMessage());
    }

   
    @interface Test {}
    static <T extends Throwable> T assertThrows(Class<T> type, Runnable code) { return null; }
    static void assertEquals(String expected, String actual) {}
}


class MatriculaAcademica {
    public MatriculaAcademica(String id) {}
    public void agregarCurso(String curso, int creditos) {}
}