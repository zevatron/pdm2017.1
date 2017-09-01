package zevatron.com.br.ifpbhorarios;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import zevatron.com.br.ifpbhorarios.model.Escolha;
import zevatron.com.br.ifpbhorarios.model.Horario;

public class HomeActivity extends AppCompatActivity {

    ListView lvCursos;
    List<Horario> cursos;
    List<String> cursosString;
    Set<String> cursosHashSet;
    List<Escolha> escolha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        escolha = Escolha.findAll();
        if(escolha.size()>0){
            Intent it = new Intent(HomeActivity.this,MainActivity.class);
            it.putExtra("curso",escolha.get(0).getCurso());
            it.putExtra("periodo",escolha.get(0).getPeriodo());
            startActivity(it);
        }

        lvCursos = (ListView) findViewById(R.id.lvCursos);

        cursos = Horario.getCursos();
        cursosHashSet = new HashSet<>();

        for(Horario h : cursos){
            cursosHashSet.add(h.getCurso());
        }
        cursosString = new ArrayList<>(cursosHashSet);
        Collections.sort(cursosString);



        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, cursosString);
        lvCursos.setAdapter(adapter);

        lvCursos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                List<Horario> periodos = Horario.getPeriodos(cursosString.get(position));
                final String[] periodosString = new String[periodos.size()];
                for (int i = 0 ; i< periodos.size() ; i++){
                    periodosString[i] = periodos.get(i).getPeriodo();
                }

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(HomeActivity.this);
                alertDialog.setTitle("Escolha o período");
                alertDialog.setItems(periodosString, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent it = new Intent(HomeActivity.this, MainActivity.class);
                        it.putExtra("curso",cursosString.get(position));
                        it.putExtra("periodo",periodosString[which]);
                        startActivity(it);

                    }
                });
                alertDialog.setNegativeButton("Cancelar",null);
                alertDialog.create().show();


            }
        });

    }
}
