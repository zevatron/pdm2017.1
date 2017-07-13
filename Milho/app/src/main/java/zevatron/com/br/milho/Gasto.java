package zevatron.com.br.milho;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by zevatron on 05/06/17.
 */

public class Gasto implements Serializable, Comparable<Gasto> {
    private String descricao;
    private int quantidade;
    private float valor;
    private Calendar data;
    private Drawable foto ;

    public Gasto(String descricao, int quantidade, float valor) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valor = valor;
        this.data =  Calendar.getInstance();
    }

    public String toString() {
        return descricao;
    }

    public float getTotal(){
        return this.valor*this.quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Drawable getFoto() {
        return foto;
    }

    public void setFoto(Drawable foto) {
        this.foto = foto;
    }

    @Override
    public int compareTo(@NonNull Gasto o) {
        return this.descricao.compareToIgnoreCase(o.getDescricao());
    }
}
