package zevatron.com.br.usacanivete;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btNome,btCompartilhamento,btDiscagem,btWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btNome = (Button) findViewById(R.id.btNome);
        this.btCompartilhamento = (Button) findViewById(R.id.btCompartilhamento);
        this.btDiscagem= (Button) findViewById(R.id.btDiscagem);
        this.btWeb = (Button) findViewById(R.id.btWeb);

        btNome.setOnClickListener(new ClickBotao());
        btWeb.setOnClickListener(new ClickBotao());
        btCompartilhamento.setOnClickListener(new ClickBotao());
        btWeb.setOnClickListener(new ClickBotao());



    }

    private class ClickBotao implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if(v.equals(btCompartilhamento)){
                Intent it = new Intent(Intent.ACTION_SEND);
                it.setType("text/plain");
                it.putExtra(Intent.EXTRA_TEXT,"Texto para compartilhar...");
                startActivity(it);

            }else if(v.equals(btDiscagem)){
                Uri uri = Uri.parse("tel:988581940");
                Intent it = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(it);


            }else if(v.equals(btNome)){
                Intent it = new Intent("VISUALIZA_NOME");
                it.putExtra("NOME","O nome!!!");
                startActivity(it);
            }else{
                Uri uri = Uri.parse("http://github.zevatron.com.br");
                Intent it = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(it);

            }
        }
    }
}
