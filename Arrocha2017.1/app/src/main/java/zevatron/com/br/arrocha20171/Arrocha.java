package zevatron.com.br.arrocha20171;

import java.util.Random;

/**
 * Created by zevatron on 15/05/17.
 */

public class Arrocha {
    private int lInferior, lSuperior, secreto,chute;

    public Arrocha() {
        this.lSuperior=100;
        this.lInferior=1;
        Random r = new Random();
        secreto = r.nextInt(98)+2;
    }

    public int getChute() {
        return chute;
    }

    public void setChute(int chute) {
        this.chute = chute;
    }

    public int getSecreto() {
        return secreto;
    }

    public boolean isArrochado(){
        return lInferior+1 == lSuperior-1;
    }

    public boolean validar(int chute){
        return (chute > this.lInferior) && (chute < this.lSuperior);
    }

    public String jogarString(){
        String resultado="";

        if (validar(this.chute)){

            if(chute<secreto)
                lInferior=chute;
            if ((chute>secreto))
                lSuperior=chute;

            if(isArrochado()){
                resultado = "PARABÉNS VOCÊ ARROCHOU";
            }
            else{
                if(this.chute==this.secreto)
                    resultado = "Você descobriu o número secreto. Agora está fácil";
                else
                    resultado = "Seus limites estão arrochando.Tente novamente.";
            }
        }
        else{
            resultado = "Chute inválido.";
        }
        return resultado;
    }

    public boolean jogar(){

        if(validar(this.chute)){
            if(isArrochado()){
                return true;
            }
            else{
                if(chute<secreto)
                    lInferior=chute;
                if ((chute>secreto))
                    lSuperior=chute;
                return false;
            }


        }
        else {
            return false;
        }
    }

    public String getlInferior() {
        return String.valueOf(lInferior);
    }

    public String getlSuperior() {
        return String.valueOf(lSuperior);
    }
}
