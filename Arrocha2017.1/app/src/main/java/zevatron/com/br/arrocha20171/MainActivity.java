package zevatron.com.br.arrocha20171;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Arrocha arrocha;
    private Button botao;
    private TextView li,ls,status;
    private EditText chute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrocha = new Arrocha();
        li = (TextView)findViewById(R.id.tvLI);
        ls = (TextView)findViewById(R.id.tvLS);
        botao =(Button)findViewById(R.id.button);
        chute = (EditText)findViewById(R.id.etChute);
        status = (TextView)findViewById(R.id.tvStatus);

        atualizaTela();

        Log.i("ARROCHA",arrocha.getSecreto()+"");


        this.botao.setOnClickListener(new BotaoListener());
    }

    private void atualizaTela() {
        li.setText(arrocha.getlInferior());
        ls.setText(arrocha.getlSuperior());
        chute.setText(null);
    }

    private class BotaoListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            try {
                MainActivity.this.arrocha.setChute(Integer.parseInt(String.valueOf(MainActivity.this.chute.getText())) );
            }catch(RuntimeException r) {
                new RuntimeException("Chute não pode ser vazio.");
            }
//            if(MainActivity.this.arrocha.jogar()){
//                MainActivity.this.status.setText("Parabéns vc ganhou.");
//            }
//            else {
//                MainActivity.this.atualizaTela();
//            }
            MainActivity.this.status.setText(MainActivity.this.arrocha.jogarString());
            MainActivity.this.atualizaTela();

        }
    }

}
