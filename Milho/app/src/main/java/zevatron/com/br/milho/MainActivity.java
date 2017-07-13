package zevatron.com.br.milho;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int FORMULARIO = 1, FORMULARIO_EDITAR = 2;
    private Cadastro cadastro;
    private ListView lvGastos;
    private TextView tvListaVazia;
    private GastoAdapter adapter;
    private List<Gasto> listaGastos;

    public MainActivity() {
        cadastro = Cadastro.getInstance();
        for(int i=0 ; i<5 ; i++){
            Gasto g = new Gasto("Milho"+i, i, i);
            cadastro.add(g);
            Log.i("MILHO", g.getDescricao() +" - "+g.getData().getTime());
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        getViews();
//        setListViewParams();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                                .setAction("Action", new BotaoListener()).show();
//
//                    }
//                });
                new BotaoListener());

        this.lvGastos = (ListView) findViewById(R.id.lvMainGastos);

//        ArrayAdapter<Gasto> adapter = new ArrayAdapter<Gasto>(this, android.R.layout.simple_list_item_1, this.cadastro.getGastos());
        GastoAdapter adapter = new GastoAdapter(this,this.cadastro);
        this.lvGastos.setAdapter(adapter);

        this.lvGastos.setOnItemClickListener(new ListaClickListener());
        this.lvGastos.setOnItemLongClickListener(new ListaLongClick());

    }

    public void atualizaLista(){
        Collections.sort(this.cadastro.getGastos());
        ((BaseAdapter)this.lvGastos.getAdapter()).notifyDataSetChanged();
    }

//    private void getViews() {
//        this.lvGastos = (ListView)findViewById(R.id.lvMainGastos);
//        this.lvGastos.setEmptyView(findViewById(R.id.tvMainEmptyItem));
//        this.popularLista();
//    }

//    private void popularLista() {
//        List<Gasto> tempGastos = cadastro.getGastos();
//        if(this.listaGastos==null)
//            this.listaGastos = new ArrayList<Gasto>();
//        this.listaGastos.clear();
//        this.listaGastos.addAll(tempGastos);
//
//        if (this.adapter==null){
//            Log.i("MILHO", "Temp: "+tempGastos);
//            Log.i("MILHO", "LisGastos: "+this.listaGastos);
//            this.adapter = new GastoAdapter(MainActivity.this,this.listaGastos);
//            this.lvGastos.setAdapter(adapter);
//        }else{
//            this.adapter.refreshList(tempGastos);
//        }
//    }

    private class BotaoListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent it = new Intent(MainActivity.this,FormularioActivity.class);
            startActivityForResult(it,FORMULARIO);

        }
    }

    private class ListaClickListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Gasto g = MainActivity.this.cadastro.get(position);
            Intent it = new Intent(MainActivity.this,FormularioActivity.class);
            it.putExtra("gasto",g);
            it.putExtra("posicao",position);
            startActivityForResult(it,FORMULARIO_EDITAR);
        }
    }

    private class ListaLongClick implements AdapterView.OnItemLongClickListener{

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
//            String s = String.format("Total: R$ %.2f",MainActivity.this.cadastro.get(position).getTotal());
//            Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
            alertDialog.setTitle("ALERTA");
            alertDialog.setMessage("Tem certeza que deseja excluir "+MainActivity.this.cadastro.get(position).getDescricao()+"?");
            alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    MainActivity.this.cadastro.remove(position);
                    MainActivity.this.atualizaLista();
                }
            });
            alertDialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alertDialog.create().show();
            return true;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if(requestCode==FORMULARIO){
                Bundle extras = data.getExtras();
//                Gasto gasto = (Gasto) extras.get("gasto");
//                Bitmap foto = (Bitmap) extras.get("foto");
                Gasto gasto = (Gasto) data.getSerializableExtra("gasto");
//                gasto.setFoto(foto);
                cadastro.add(gasto);
                Log.i("MILHO", gasto.getDescricao() +" - "+gasto.getData().getTime());
            }
            else if(requestCode == FORMULARIO_EDITAR){

                int deletar = data.getIntExtra("deletar",-1);
                Log.i("MILHO", String.valueOf(deletar));

                if(deletar>=0) {
                    cadastro.remove(deletar);
                }else{
                    Gasto gastoAlterado = (Gasto) data.getSerializableExtra("gasto");
                    Bundle extras = data.getExtras();
//                    Bitmap foto = (Bitmap) extras.get("foto");
                    int pos = data.getIntExtra("posicao", -1);
                    Log.i("MILHO",String.valueOf(pos));
                    Gasto gastoOriginal = MainActivity.this.cadastro.get(pos);
                    gastoOriginal.setDescricao(gastoAlterado.getDescricao());
                    gastoOriginal.setQuantidade(gastoAlterado.getQuantidade());
                    gastoOriginal.setValor(gastoAlterado.getValor());
                    gastoOriginal.setFoto(gastoAlterado.getFoto());
                }
            }
            atualizaLista();
        }
//        for(Gasto g : cadastro.getGastos()) {
//            Log.i("MILHO", g.getDescricao()+" - " + g.getQuantidade());
//        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_orcamento) {
            String s = String.format("Total: R$ %.2f",this.cadastro.getTotal());
            Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
        }else if(id == R.id.action_sobre){
            Toast.makeText(this,"José Ricardo",Toast.LENGTH_LONG).show();
        }else if(id == R.id.action_zerar){
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setTitle("ALERTA");
            alertDialog.setMessage("Tem certeza que deseja apagar todos os DADOS?");
            alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    MainActivity.this.cadastro.clear();
                    MainActivity.this.atualizaLista();
                }
            });
            alertDialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alertDialog.create().show();

        }

        return super.onOptionsItemSelected(item);
    }
}
