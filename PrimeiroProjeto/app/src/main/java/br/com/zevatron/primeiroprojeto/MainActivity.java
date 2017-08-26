package br.com.zevatron.primeiroprojeto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView texto;
    private Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.texto = (TextView) findViewById(R.id.tvMainTitulo);
        this.botao = (Button) findViewById(R.id.btMainDataHora);

        this.botao.setOnClickListener(new BotaoListener());

    }
    private class BotaoListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            MainActivity.this.texto.setText("Cruel");
        }
    }
}


