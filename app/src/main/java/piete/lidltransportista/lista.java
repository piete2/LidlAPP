package piete.lidltransportista;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

import piete.lidltransportista.entidades.Tienda;
import piete.lidltransportista.utilidades.Utilidades;

public class lista extends AppCompatActivity {

    ListView listaTiendas;
    ArrayList<String> listaInfo;
    ArrayList<Tienda> listaTien; //listaUsuarios

    ConexionSQLiteHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bdTiendas",null,1);
        listaTiendas=(ListView) findViewById(R.id.lista);


        consultarListaTiendas();
        Collections.sort(listaInfo);
        ArrayAdapter adaptador= new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInfo);
        listaTiendas.setAdapter(adaptador);


    }


    private void consultarListaTiendas() {
        SQLiteDatabase db=conn.getReadableDatabase();
        Tienda tienda=null;
        listaTien = new ArrayList<Tienda>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_TIENDA,null);

        while (cursor.moveToNext()){
            tienda=new Tienda();
            //tienda.setNumTienda(cursor.getInt(0));
            tienda.setNombre(cursor.getString(0));
            tienda.setNumTienda(cursor.getString(1));
            tienda.setMuelleFrio(cursor.getString(2));
            tienda.setFilaFrio(cursor.getString(3));
            tienda.setMuelleFruta(cursor.getString(4));
            tienda.setFilaFruta(cursor.getString(5));
            tienda.setMuelleSeco(cursor.getString(6));
            tienda.setFilaSeco(cursor.getString(7));
            tienda.setDireccion(cursor.getString(8));
            tienda.setTelefono(cursor.getString(9));
            listaTien.add(tienda);

        }
        obtenerLista();

    }

    private void obtenerLista() {
        listaInfo=new ArrayList<String>();
        for(int i=0;i<listaTien.size();i++){
            listaInfo.add("Nombre: "+listaTien.get(i).getNombre()+"\n Nº Tienda: "+listaTien.get(i).getNumTienda()+"\n Muelle Frio: "+listaTien.get(i).getMuelleFrio()+"    Fila: "+listaTien.get(i).getFilaFrio()+"\n Muelle Fruta: "+listaTien.get(i).getMuelleFruta()+"   Fila: "+listaTien.get(i).getFilaFruta()+"\n Muelle Seco: "+listaTien.get(i).getMuelleSeco()+"   Fila: "+listaTien.get(i).getFilaSeco()+"\n Dirección: "+listaTien.get(i).getDireccion()+"\n Telf: "+listaTien.get(i).getTelefono());

        }
    }
}
