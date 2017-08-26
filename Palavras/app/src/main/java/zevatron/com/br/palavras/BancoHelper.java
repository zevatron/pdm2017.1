package zevatron.com.br.palavras;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by zevatron on 15/07/17.
 */

public class BancoHelper extends SQLiteOpenHelper {

    public static final String BANCO = "bd_palavra";
    public static final String TABELA = "palavra";
    public static final String COLUNA_ID = "codigo";
    public static final String COLUNA_CONTEUDO = "conteudo";
    public static final String COLUNA_DATAHORA = "datahora";
    public static final int VERSAO = 5;

    public BancoHelper(Context context) {
        super(context, BANCO, null, VERSAO);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS palavra(codigo INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, conteudo VARCHAR, datahora DATETIME);");
        Log.i("APP_PALAVRAS","OnCreate");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("APP_PALAVRAS","onUpgrade");
        db.execSQL("DROP TABLE IF EXISTS "+TABELA);
        onCreate(db);
    }
}
