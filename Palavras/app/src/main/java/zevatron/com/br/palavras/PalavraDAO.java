package zevatron.com.br.palavras;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by zevatron on 15/07/17.
 */

public class PalavraDAO {

    private SQLiteDatabase banco;
    private String[] colunas = {BancoHelper.COLUNA_ID,BancoHelper.COLUNA_CONTEUDO,BancoHelper.COLUNA_DATAHORA};

    public PalavraDAO(Context contex){
        this.banco = new BancoHelper(contex).getWritableDatabase();

    }

    public Palavra get(int id){
//        String selection = BancoHelper.COLUNA_ID + " = ?";
//        String[] argumento = {""+(id+1)};
//        Cursor c = this.banco.query(BancoHelper.TABELA,colunas,selection,argumento,null,null,null);
//        Palavra p;
//        if(c.getCount()>0){
//            p = new Palavra();
//            c.moveToFirst();
//            p.setId(c.getInt(c.getColumnIndex("codigo")));
//            p.setDataHoraLong(c.getLong(c.getColumnIndex("datahora")));
//            p.setConteudo(c.getString(c.getColumnIndex("conteudo")));
//            return p;
//        }else{
//            return null;
//        }
        return get().get(id);
    }

    public void insert(Palavra nova){
        ContentValues cv = new ContentValues();
        cv.put(BancoHelper.COLUNA_CONTEUDO,nova.getConteudo());
        cv.put(BancoHelper.COLUNA_DATAHORA,nova.getDataHoraLong());
        this.banco.insert(BancoHelper.TABELA,null,cv);
    }

    public void delete(Palavra excluir){
        String selection = BancoHelper.COLUNA_ID + " = ?";
        String[] argumento = {""+excluir.getId()};
        this.banco.delete(BancoHelper.TABELA,selection,argumento);
    }
    public void editar(Palavra original,Palavra nova){
        String selection = BancoHelper.COLUNA_ID + " = ?";
        ContentValues cv = new ContentValues();
        String where = BancoHelper.COLUNA_ID+" = ?";
        String[] argumento = {""+original.getId()};
        cv.put(BancoHelper.COLUNA_CONTEUDO,nova.getConteudo());
        cv.put(BancoHelper.COLUNA_DATAHORA,nova.getDataHora());
        this.banco.update(BancoHelper.TABELA,cv,where,argumento);
    }

    public List<Palavra> get(){
        List<Palavra> lista = new ArrayList<Palavra>();
        Cursor c = this.banco.query(BancoHelper.TABELA,colunas,null,null,null,null,null);
        Palavra p;

        if(c.getCount()>0){
            c.moveToFirst();
            do{
                p = new Palavra();
                p.setConteudo(c.getString(c.getColumnIndex("conteudo")));
                p.setDataHoraLong(c.getLong(c.getColumnIndex("datahora")));
                p.setId(c.getInt(c.getColumnIndex("codigo")));

                lista.add(p);

            }while (c.moveToNext());
        }

        return lista;
    }
    public int size(){
        Cursor c = this.banco.query(BancoHelper.TABELA,colunas,null,null,null,null,null);
        return c.getCount();
    }
}
