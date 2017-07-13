package zevatron.com.br.intent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button browser,discar,ligar,enviarEmail,sms,compartilharTexto,visualizarPonto,visualizarRota,videoYoutube,foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botoes();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){
            if(requestCode == 1){
                Bundle extras = data.getExtras();
                Bitmap  imageBmp = (Bitmap)extras.get("data");
                Intent it = new Intent(MainActivity.this,VisualisaFotoActivity.class);
                it.putExtra("data",imageBmp);
                startActivity(it);
            }

        }

    }

    private void botoes() {
        this.browser = (Button)findViewById(R.id.bt_Browser);
        this.browser.setOnClickListener(new BotaoClickListener());

        this.discar = (Button)findViewById(R.id.bt_Discar);
        this.discar.setOnClickListener(new BotaoClickListener());

        this.ligar = (Button)findViewById(R.id.bt_Ligar);
        this.ligar.setOnClickListener(new BotaoClickListener());

        this.enviarEmail = (Button)findViewById(R.id.bt_Email);
        this.enviarEmail.setOnClickListener(new BotaoClickListener());

        this.sms = (Button)findViewById(R.id.bt_Sms);
        this.sms.setOnClickListener(new BotaoClickListener());

        this.compartilharTexto = (Button)findViewById(R.id.bt_CompTexto);
        this.compartilharTexto.setOnClickListener(new BotaoClickListener());

        this.visualizarPonto = (Button)findViewById(R.id.bt_VisPonto);
        this.visualizarPonto.setOnClickListener(new BotaoClickListener());

        this.visualizarRota  = (Button) findViewById(R.id.bt_VisRota);
        this.visualizarRota.setOnClickListener(new BotaoClickListener());

        this.videoYoutube = (Button) findViewById(R.id.bt_Youtube);
        this.videoYoutube.setOnClickListener(new BotaoClickListener());

        this.foto = (Button)findViewById(R.id.bt_Foto);
        this.foto.setOnClickListener(new BotaoClickListener());
    }

    private class BotaoClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
//            Intent it = new Intent(MainActivity.this,FilhaActivity.class);

            if(v.equals(MainActivity.this.browser)){
                Log.i("FOFO","Browser");
                Uri uri = Uri.parse("http://ifpb-2017-1.github.io/seminario");
                Intent it = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(it);
            }else if(v.equals(MainActivity.this.discar)){
                Log.i("FOFO","Discar");
                Uri uri =Uri.parse("tel:988581940");
                Intent it = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(it);
            }else if(v.equals(MainActivity.this.ligar)){
                Log.i("FOFO","Ligar");
                Uri uri =Uri.parse("tel:988581940");
                Intent it = new Intent(Intent.ACTION_CALL,uri);
                int permissao = ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE);
                if(permissao == PackageManager.PERMISSION_GRANTED)
                    startActivity(it);
            }else if(v.equals(MainActivity.this.enviarEmail)){
                Log.i("FOFO","EnviarEmail");
                Uri uri = Uri.parse("mailto:zevatron@zevatron.com.br");
                Intent it = new Intent(Intent.ACTION_SENDTO,uri);
                it.putExtra(Intent.EXTRA_SUBJECT,"digite aqui o assunto");
                it.putExtra(Intent.EXTRA_TEXT,"aqui é o texto da mensagem");
                startActivity(Intent.createChooser(it,"Enviar e-mail..."));

            }else if(v.equals(MainActivity.this.sms)){
                Log.i("FOFO","SMS");
                Uri uri = Uri.parse("sms:65981573272");
                Intent it = new Intent(Intent.ACTION_SENDTO,uri);
                it.putExtra("sms_body","Texto do SMS");
                startActivity(it);

            }else if(v.equals(MainActivity.this.compartilharTexto)){
                Log.i("FOFO","CompartilharTexto");
                Intent it = new Intent(Intent.ACTION_SEND);
                it.setType("text/plain");
                it.putExtra(Intent.EXTRA_TEXT,"mensagem compartilhar");
                startActivity(Intent.createChooser(it,"Compartilhar"));

            }else if(v.equals(MainActivity.this.visualizarPonto)){
                Log.i("FOFO","VisualizarPonto");
                Uri uri = Uri.parse("geo:0,0?q=IFPB, João Pessoa-PB");
                Intent it = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(it);

            }else if(v.equals(MainActivity.this.visualizarRota)){
                Log.i("FOFO","VisualizarRota");
                String origem = "7.1181783,-34.8730402";
                String destino = "-7.1619359,-34.8327554";
                String patch = "http://maps.google.com/maps?f=&addr=%s+&addr=%s";
                Uri uri = Uri.parse(String.format(patch,origem,destino));
                Intent it = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(it);

            }else if(v.equals(MainActivity.this.videoYoutube)){
                Log.i("FOFO","vídeoYoutube");
                Uri uri = Uri.parse("vnd.youtube://B08iLAtS3AQ");
                Intent it = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(it);

            }else{
                Log.i("FOFO","Foto");
                Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(it,1);
//                Intent it = new Intent(MainActivity.this,VisualisaFotoActivity.class);
//                it.putExtra("data",imageBmp);

            }

        }
    }


}
