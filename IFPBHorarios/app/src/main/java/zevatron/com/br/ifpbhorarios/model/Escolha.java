package zevatron.com.br.ifpbhorarios.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by zevatron on 01/09/17.
 */

@Table(name = "ESCOLHA", id = "ID")
public class Escolha extends Model {

    @Column(name = "CURSO")
    private String curso;

    @Column (name = "PERIODO")
    private String periodo;

    public static List<Escolha> findAll(){
        return new Select()
                .from(Escolha.class)
                .execute();
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}
