package piete.lidltransportista;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import piete.lidltransportista.utilidades.Utilidades;

public class Consultar extends AppCompatActivity {
    EditText nombre_tienda,numero_tienda,muelle_frio,muelle_fruta
            ,muelle_seco,direccion,telf,filaFrio,filaFruta,filaSeco;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bdTiendas",null,1);

        nombre_tienda=(EditText) findViewById(R.id.nombreB);
        numero_tienda=(EditText) findViewById(R.id.Numero_tiendaB);
        muelle_frio=(EditText) findViewById(R.id.muelleFrioB);
        filaFrio=(EditText) findViewById(R.id.filaFrioC);//NUEVO
        muelle_fruta=(EditText) findViewById(R.id.muelleFrutaB);
        filaFruta=(EditText) findViewById(R.id.filaFrutaC);//NUEVO
        muelle_seco=(EditText) findViewById(R.id.muelleSecoB);
        filaSeco=(EditText) findViewById(R.id.filaSecoC);//NUEVO
        direccion=(EditText) findViewById(R.id.direccionB);
        telf=(EditText) findViewById(R.id.telfB);
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.buscarnombre:
                consultarNombre();
                break;
            case R.id.buscarnumero:
                consultarNumero();
                break;
            case R.id.actualizar:
                actualizar();
                break;
            case R.id.eliminar:
                eliminar();
                break;
        }
    }

    private void eliminar() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={nombre_tienda.getText().toString()};
        db.delete(Utilidades.TABLA_TIENDA,Utilidades.CampoNombreTienda+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Eliminado correctamente",Toast.LENGTH_SHORT).show();
        db.close();
        limpiar();
    }

    private void actualizar() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={nombre_tienda.getText().toString()};
        ContentValues values=new ContentValues();
        values.put(Utilidades.CampoNumeroTienda,numero_tienda.getText().toString());
        values.put(Utilidades.CampoNombreTienda ,nombre_tienda.getText().toString());
        values.put(Utilidades.CampoMuelleFrio,muelle_frio.getText().toString());
        values.put(Utilidades.CampoFilaFrio,filaFrio.getText().toString());//NUEVO
        values.put(Utilidades.CampoMuelleFruta,muelle_fruta.getText().toString());
        values.put(Utilidades.CampoFilaFruta,filaFruta.getText().toString());//NUEVO
        values.put(Utilidades.CampoMuelleSeco,muelle_seco.getText().toString());
        values.put(Utilidades.CampoFilaSeco,filaSeco.getText().toString());//NUEVO
        values.put(Utilidades.CampoDireccion,direccion.getText().toString());
        values.put(Utilidades.CampoTelefono,telf.getText().toString());

        db.update(Utilidades.TABLA_TIENDA,values,Utilidades.CampoNombreTienda+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Actualizado correctamente",Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void consultarNumero() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={numero_tienda.getText().toString()};
        String[] campos={Utilidades.CampoNombreTienda,Utilidades.CampoNumeroTienda,Utilidades.CampoMuelleFrio,Utilidades.CampoFilaFrio,Utilidades.CampoMuelleFruta,Utilidades.CampoFilaFruta, Utilidades.CampoMuelleSeco,Utilidades.CampoFilaSeco,Utilidades.CampoDireccion,Utilidades.CampoTelefono};
        try {
            Cursor cursor=db.query(Utilidades.TABLA_TIENDA,campos,Utilidades.CampoNumeroTienda+"=?",parametros,null,null,null);
            cursor.moveToFirst();
//NOMBRE, NUMERO, MUELLEFRIO, FILAFRIO, MUELLEFRUTA, FILAFRUTA, MUELLESECO, FILASECO, DIREC, TELF
            nombre_tienda.setText(cursor.getString(0));
            numero_tienda.setText(cursor.getString(1));
            muelle_frio.setText(cursor.getString(2));
            filaFrio.setText(cursor.getString(3));
            muelle_fruta.setText(cursor.getString(4));
            filaFruta.setText(cursor.getString(5));
            muelle_seco.setText(cursor.getString(6));
            filaSeco.setText(cursor.getString(7));
            direccion.setText(cursor.getString(8));
            telf.setText(cursor.getString(9));
            cursor.close();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Imposible",Toast.LENGTH_SHORT).show();
            limpiar();

        }
    }

    private void consultarNombre() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={nombre_tienda.getText().toString()};
        String[] campos={Utilidades.CampoNombreTienda,Utilidades.CampoNumeroTienda,Utilidades.CampoMuelleFrio,Utilidades.CampoFilaFrio,Utilidades.CampoMuelleFruta,Utilidades.CampoFilaFruta, Utilidades.CampoMuelleSeco,Utilidades.CampoFilaSeco,Utilidades.CampoDireccion,Utilidades.CampoTelefono};

        try {
            Cursor cursor=db.query(Utilidades.TABLA_TIENDA,campos,Utilidades.CampoNombreTienda+"=?",parametros,null,null,null);
            cursor.moveToFirst();

            nombre_tienda.setText(cursor.getString(0));
            numero_tienda.setText(cursor.getString(1));
            muelle_frio.setText(cursor.getString(2));
            filaFrio.setText(cursor.getString(3));
            muelle_fruta.setText(cursor.getString(4));
            filaFruta.setText(cursor.getString(5));
            muelle_seco.setText(cursor.getString(6));
            filaSeco.setText(cursor.getString(7));
            direccion.setText(cursor.getString(8));
            telf.setText(cursor.getString(9));
            cursor.close();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Imposible",Toast.LENGTH_SHORT).show();
            limpiar();

        }


    }

    private void limpiar() {
        nombre_tienda.setText("");
        numero_tienda.setText("");
        muelle_frio.setText("");
        muelle_fruta.setText("");
        muelle_seco.setText("");
        direccion.setText("");
        telf.setText("");
        filaFrio.setText("");
        filaFruta.setText("");
        filaSeco.setText("");
    }

}
