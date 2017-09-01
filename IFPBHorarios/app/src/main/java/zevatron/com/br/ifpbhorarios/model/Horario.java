package zevatron.com.br.ifpbhorarios.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

@Table(name="HORARIO",id = "ID")
public class Horario extends Model{

	@Column(name="DOCENTE")
	private String docente;
	
	@Column(name="LOCALIZACAO")
	private String localizacao;
	
	@Column (name="DIA_SEMANA")
	private String diaSemana;
	
	@Column(name="COD_HORARIO")
	private String codigoHorario;
	
	@Column(name="TURMA")
	private String turma;
	
	@Column(name="PERIODO")
	private String periodo;
	
	@Column(name="DISCIPLINA")
	private String disciplina;
	
	@Column(name="CURSO")
	private String curso;

    public static List<Horario> listar(){
        return new Select().all().from(Horario.class).execute();
    }

	public static List<Horario> getHorarios(String curso, String periodo){
		return new Select().from(Horario.class)
                .where("CURSO = ?",curso)
                .and("PERIODO = ?	" , periodo).execute();
	}

	public static List<Horario>getCursos(){
        return new Select()
                .from(Horario.class).groupBy("CURSO").orderBy("CURSO")
                .execute();
    }

    public static List<Horario>getPeriodos(String curso){
		return new Select()
				.from(Horario.class)
				.where("CURSO = ?",curso)
				.groupBy("PERIODO")
				.execute();
	}

	public String getDocente() {
		return docente;
	}

	public void setDocente(String docente) {
		this.docente = docente;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String getCodigoHorario() {
		return codigoHorario;
	}

	public void setCodigoHorario(String codigoHorario) {
		this.codigoHorario = codigoHorario;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
}
