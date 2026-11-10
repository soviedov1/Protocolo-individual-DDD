public class CursoMatriculadoEvent {
    private final String matriculaId;
    private final String codigoCurso;
    private final long timestamp;

    public CursoMatriculadoEvent(String matriculaId, String codigoCurso) {
        this.matriculaId = matriculaId;
        this.codigoCurso = codigoCurso;
        this.timestamp = System.currentTimeMillis();
    }
}