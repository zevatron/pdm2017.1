package zevatron.com.br.ifpbhorarios;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context,"Atualizando dados... :)",Toast.LENGTH_SHORT).show();
    }
}
