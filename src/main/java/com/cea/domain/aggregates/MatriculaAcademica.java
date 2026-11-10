import java.util.ArrayList;
import java.util.List;

public class MatriculaAcademica {
    private final String matriculaId;
    private final List<String> cursosMatriculados;
    private int creditosTotales;

    public MatriculaAcademica(String matriculaId) {
        this.matriculaId = matriculaId;
        this.cursosMatriculados = new ArrayList<>();
        this.creditosTotales = 0;
    }

    public void agregarCurso(String codigoCurso, int creditosCurso) {
        if (this.creditosTotales + creditosCurso > 20) {
            throw new ExcepcionDeDominio("Se supera el límite máximo de 20 créditos.");
        }
        if (this.cursosMatriculados.contains(codigoCurso)) {
            throw new ExcepcionDeDominio("El curso ya está matriculado.");
        }
        this.cursosMatriculados.add(codigoCurso);
        this.creditosTotales += creditosCurso;
    }

    public int getCreditosTotales() { return creditosTotales; }
}