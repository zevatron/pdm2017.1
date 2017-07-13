package zevatron.com.br.milho;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class FormularioActivity extends AppCompatActivity {

    Button btSalvar, btCancelar, btExcluir, btFoto;
    EditText etDescricao;
    EditText etQtd;
    EditText edValor;
    ImageView ivFotoGasto;
    Gasto gasto ;
    Bitmap imageBmp;
    private int posicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        Log.i("MILHO", "Olá cadastro");

        etDescricao = (EditText) findViewById(R.id.etDescricao);
        etQtd = (EditText) findViewById(R.id.etQuantidade);
        edValor = (EditText) findViewById(R.id.etValor);
        btSalvar = (Button) findViewById(R.id.btSalvar);
        btCancelar = (Button) findViewById(R.id.btCancelar);
        btExcluir = (Button) findViewById(R.id.btExcluir);
        btFoto = (Button) findViewById(R.id.btFoto);
        ivFotoGasto = (ImageView) findViewById(R.id.ivFoto);

        btSalvar.setOnClickListener(new BotaoListener());
        btCancelar.setOnClickListener(new BotaoListener());
        btExcluir.setOnClickListener(new BotaoListener());
        btFoto.setOnClickListener(new BotaoListener());

        try {
            Gasto g = (Gasto)getIntent().getSerializableExtra("gasto");
            this.posicao = getIntent().getIntExtra("posicao",-1);
            Log.i("MILHO","F-"+posicao);
            this.etDescricao.setText(g.getDescricao());
            this.etQtd.setText(Integer.toString(g.getQuantidade()));
            this.edValor.setText(Float.toString(g.getValor()));
            this.btExcluir.setVisibility(View.VISIBLE);
//            this.ivFotoGasto.setImageBitmap(g.getFoto());
        }catch (Exception e){

        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){
            if(requestCode==1){
                Bundle extras = data.getExtras();
                imageBmp = (Bitmap)extras.get("data");
//                imageBmp = data.getSerializableExtra("data");
                ivFotoGasto.setImageBitmap(imageBmp);

            }
        }
    }

    private class BotaoListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            if(v.equals(FormularioActivity.this.btSalvar)){

                gasto = new Gasto(etDescricao.getText().toString(),
                        Integer.parseInt(etQtd.getText().toString()),
                        Float.parseFloat(edValor.getText().toString()));
                gasto.setFoto(ivFotoGasto.getDrawable());
                Log.i("MILHO", gasto.toString());
                Intent it = new Intent();
                it.putExtra("gasto", gasto);
                it.putExtra("posicao",posicao);
                it.putExtra("foto",imageBmp);
                setResult(RESULT_OK, it);
                finish();

            }else if(v.equals(FormularioActivity.this.btCancelar)){
                setResult(RESULT_CANCELED);
                finish();
            }else if(v.equals(FormularioActivity.this.btFoto)){
                Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(it,1);
            }else{
                //excluir
                Intent it = new Intent();
                it.putExtra("deletar",posicao);
                setResult(RESULT_OK,it);
                finish();
            }


        }
    }
}
