package com.abx.contacto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    Button btn;
    DatePicker dp;
    int d,m,a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         btn= (Button) findViewById(R.id.btnSig);
         btn.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View v) {

                 dp    = (DatePicker)  findViewById(R.id.dpDatePicker);
                 Intent it= new Intent(MainActivity.this, ContactoConf.class);
                 it.putExtra(getResources().getString(R.string.nombre), ((EditText) findViewById(R.id.tieNombre)).getText().toString());
                 it.putExtra(getResources().getString(R.string.telefono), ((EditText) findViewById(R.id.tieTelefono)).getText().toString());
                 it.putExtra(getResources().getString(R.string.email), ((EditText) findViewById(R.id.tieEmail)).getText().toString());
                 it.putExtra(getResources().getString(R.string.descripcion), ((EditText) findViewById(R.id.tieDescripcion)).getText().toString());
                 it.putExtra(getResources().getString(R.string.dia), dp.getDayOfMonth());
                 it.putExtra(getResources().getString(R.string.mes), dp.getMonth());
                 it.putExtra(getResources().getString(R.string.año), dp.getYear());
                 startActivityForResult(it,1);

             }
         });






    }

    /**
     * Dispatch incoming result to the correct fragment.
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                String nombre = extras.getString(getString(R.string.nombre));
                d = extras.getInt("dia");
                m = extras.getInt("mes");
                a = extras.getInt("año");
                String telefono = extras.getString(getString(R.string.telefono));
                String email = extras.getString(getString(R.string.email));
                String desc = extras.getString(getString(R.string.descripcion));

                EditText tieNombre       = (EditText) findViewById(R.id.tieNombre);
                EditText tieTelefono     = (EditText) findViewById(R.id.tieTelefono);
                EditText tieEmail        = (EditText) findViewById(R.id.tieEmail);
                EditText tieDesc         = (EditText) findViewById(R.id.tieDescripcion);
                dp                       = (DatePicker) findViewById(R.id.dpDatePicker);
                tieNombre.setText(nombre, TextView.BufferType.EDITABLE);
                dp.updateDate(a,m,d);
                tieTelefono.setText(telefono, TextView.BufferType.EDITABLE);
                tieEmail.setText(email,TextView.BufferType.EDITABLE);
                tieDesc.setText(desc,TextView.BufferType.EDITABLE);
            }
        }


    }

}
