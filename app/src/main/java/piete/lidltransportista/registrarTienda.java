package piete.lidltransportista;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import piete.lidltransportista.utilidades.Utilidades;

public class registrarTienda extends AppCompatActivity {
EditText nombre_tienda,numero_tienda,muelle_frio,muelle_fruta
        ,muelle_seco,direccion,telf,filaFrio,filaFruta,filaSeco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_tienda);

        nombre_tienda=(EditText) findViewById(R.id.nombreTienda);
        numero_tienda=(EditText) findViewById(R.id.numeroTienda);
        muelle_frio=(EditText) findViewById(R.id.muelleFrio);
        filaFrio=(EditText) findViewById(R.id.FilaMuelleFrio);//NUEVO
        muelle_fruta=(EditText) findViewById(R.id.muelleFruta);
        filaFruta=(EditText) findViewById(R.id.FilaMuelleFruta);//NUEVO
        muelle_seco=(EditText) findViewById(R.id.muelleseco);
        filaSeco=(EditText) findViewById(R.id.FilaMuelleSeco);//NUEVO
        direccion=(EditText) findViewById(R.id.direccionTienda);
        telf=(EditText) findViewById(R.id.numTelfTienda);


    }

    public void onClick(View view){

       switch (view.getId()){
           case R.id.anadirTienda:
               registTienda();
               break;
           case R.id.atras:
               atras();
               break;

       }
        }

    private void atras() {
        Intent nueva_ventana= new Intent(registrarTienda.this, MainActivity.class);
        startActivity(nueva_ventana);
    }

    private void registTienda() {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bdTiendas",null,1);
        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Utilidades.CampoNombreTienda ,nombre_tienda.getText().toString());
        values.put(Utilidades.CampoNumeroTienda,numero_tienda.getText().toString());
        values.put(Utilidades.CampoMuelleFrio,muelle_frio.getText().toString());
        values.put(Utilidades.CampoFilaFrio,filaFrio.getText().toString());//NUEVO
        values.put(Utilidades.CampoMuelleFruta,muelle_fruta.getText().toString());
        values.put(Utilidades.CampoFilaFruta,filaFruta.getText().toString());//NUEVO
        values.put(Utilidades.CampoMuelleSeco,muelle_seco.getText().toString());
        values.put(Utilidades.CampoFilaSeco,filaSeco.getText().toString());//NUEVO
        values.put(Utilidades.CampoDireccion,direccion.getText().toString());
        values.put(Utilidades.CampoTelefono,telf.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_TIENDA,Utilidades.CampoNombreTienda,values);
        Toast.makeText(getApplicationContext(),"Tienda: "+idResultante+" agregada",Toast.LENGTH_SHORT).show();
    }



}
