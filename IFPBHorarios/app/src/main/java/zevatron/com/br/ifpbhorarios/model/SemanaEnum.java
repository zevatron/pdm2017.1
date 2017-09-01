package zevatron.com.br.ifpbhorarios.model;

/**
 * Created by zevatron on 30/08/17.
 */

public enum SemanaEnum {
    SEGUNDA("1"),
    TERÇA("2"),
    QUARTA("3"),
    QUINTA("4"),
    SEXTA("5");

    private String codigo;

    SemanaEnum(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
