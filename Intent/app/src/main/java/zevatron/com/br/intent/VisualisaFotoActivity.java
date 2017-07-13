package zevatron.com.br.intent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class VisualisaFotoActivity extends AppCompatActivity {

    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualisa_foto);

        this.iv = (ImageView)findViewById(R.id.ivFoto);

        Intent it = this.getIntent();
        Bundle extras = it.getExtras();
        Bitmap  imageBmp = (Bitmap)extras.get("data");
//
        this.iv.setImageBitmap(imageBmp);



    }
}
