package com.apps.xavipc.pruebasmaterialdesign;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class OtrasPruebas extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otras_pruebas);

        findViewById(R.id.btn_hablar_blp).setOnClickListener(this);
        findViewById(R.id.btn_compartir).setOnClickListener(this);
        findViewById(R.id.btn_abrir_pag).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_hablar_blp:
                Intent intent1 = new Intent(Intent.ACTION_DIAL);
                intent1.setData(Uri.parse("tel:" + "4949421909"));
                if (intent1.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent1);
                }
                break;

            case R.id.btn_abrir_pag:
                String url = "http://www.blplapalma.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                break;

            case R.id.btn_compartir:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "http://www.techrepublic.com");
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Check out this site!");
                startActivity(Intent.createChooser(intent, "Share"));

                break;
        }
    }
}
