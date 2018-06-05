package com.abx.contacto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class ContactoConf extends AppCompatActivity {
        int d,m,a;
    Button regresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto_conf);

        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString(getString(R.string.nombre));
        d = extras.getInt("dia");
        m = extras.getInt("mes");
        a = extras.getInt("año");
        String telefono = extras.getString(getString(R.string.telefono));
        String email = extras.getString(getString(R.string.email));
        String desc = extras.getString(getString(R.string.descripcion));

        TextView tvConN  = (TextView) findViewById(R.id.tvConfNom);
        TextView tvConfC = (TextView) findViewById(R.id.tvConfCal);
        TextView tvConfT = (TextView) findViewById(R.id.tvConfTel);
        TextView tvConfE = (TextView) findViewById(R.id.tvConfEm);
        TextView tvConfD = (TextView) findViewById(R.id.tvConfDe);

        tvConN.setText(nombre);
        tvConfC.setText(((Object)d).toString()+
                        "/"+((Object)(m+1)).toString()+
                        "/"+((Object)a).toString());
        tvConfT.setText(telefono);
        tvConfE.setText(email);
        tvConfD.setText(desc);


        regresar = (Button) findViewById(R.id.btnReg);

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it= new Intent(ContactoConf.this, MainActivity.class);
                it.putExtra(getResources().getString(R.string.nombre), ((TextView) findViewById(R.id.tvConfNom)).getText());
                it.putExtra(getResources().getString(R.string.telefono), ((TextView) findViewById(R.id.tvConfTel)).getText());
                it.putExtra(getResources().getString(R.string.email), ((TextView) findViewById(R.id.tvConfEm)).getText());
                it.putExtra(getResources().getString(R.string.descripcion), ((TextView) findViewById(R.id.tvConfDe)).getText());
                it.putExtra(getResources().getString(R.string.dia), d);
                it.putExtra(getResources().getString(R.string.mes), m);
                it.putExtra(getResources().getString(R.string.año), a);
                setResult(RESULT_OK,it);
                finish();
            }
        });

    }
}
