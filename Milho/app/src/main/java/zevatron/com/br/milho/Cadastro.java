package zevatron.com.br.milho;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zevatron on 05/06/17.
 */

public class Cadastro {
    private List<Gasto> gastos;
    private static Cadastro instance = null;

    private Cadastro() {
        this.gastos = new ArrayList<Gasto>();
    }

    public static Cadastro getInstance(){
        if(instance==null)
            instance = new Cadastro();
        return instance;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    public void add(Gasto g){
        this.gastos.add(g);
    }

    public void remove(int posicao){
        this.gastos.remove(posicao);
    }

    public List<Gasto> findGasto(String descricao){
        for (Gasto g : gastos){
            List<Gasto>encontrados = new ArrayList<Gasto>();
            if(g.getDescricao().equalsIgnoreCase(descricao)){
                encontrados.add(g);
            }
            return encontrados;
        }
        return null;
    }
    public void clear(){
        gastos.clear();
    }

    public float getTotal(){
        float soma = 0;
        for (Gasto g : this.gastos){
            soma += g.getTotal();
        }
        return soma;
    }

    public Gasto get(int position) {
        return this.gastos.get(position);
    }

    public int getQuantidadeGastos(){
        return gastos.size();
    }


}
