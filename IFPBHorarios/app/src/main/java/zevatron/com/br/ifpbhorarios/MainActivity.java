package zevatron.com.br.ifpbhorarios;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Select;

import java.util.List;

import zevatron.com.br.ifpbhorarios.model.Horario;
import zevatron.com.br.ifpbhorarios.model.SemanaEnum;

public class MainActivity extends AppCompatActivity {

    List<Horario> horarios;
    TextView tv;
    TableLayout tlM,tlT,tlN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle("("+getIntent().getStringExtra("periodo")+")" + getIntent().getStringExtra("curso"));


        tlM = (TableLayout) findViewById(R.id.tlM);
        tlT = (TableLayout) findViewById(R.id.tlT);
        tlN = (TableLayout) findViewById(R.id.tlN);




        horarios = Horario.getHorarios(getIntent().getStringExtra("curso"),getIntent().getStringExtra("periodo"));


        for (Horario h : horarios){

            if(h.getCodigoHorario().startsWith("M"))
                tlM.setVisibility(View.VISIBLE);
            else if(h.getCodigoHorario().startsWith("T"))
                tlT.setVisibility(View.VISIBLE);
            else
                tlN.setVisibility(View.VISIBLE);


            tv = (TextView) findViewById( getResources()
                    .getIdentifier("tv"+h.getCodigoHorario()
                            + SemanaEnum.valueOf(h.getDiaSemana()).getCodigo(),
                            "id",
                            getPackageName()));

            tv.setText(h.getDisciplina().substring(0,5)+"\n"+h.getDocente()+"\n"+h.getLocalizacao());
            tv.setTextSize(7);

        }

    }

}
