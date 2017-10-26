package piete.lidltransportista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bdTiendas",null,1);

    }

    public void onClick(View view){

        switch (view.getId()){
            case R.id.main_list:
                abrirListar();

                break;
            case R.id.main_añadir:
               abrirAnadirTienda();
                break;
            case R.id.compartir:
                compartir();
                break;
        }
        //Intent nueva_ventana = new Intent(MainActivity.this, registrarTienda.class);

    }

    private void compartir() {
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,"Disfruta de la app 'LIDL TRANSPORTISTAS' desde https://goo.gl/q6sz3m");
        startActivity(Intent.createChooser(intent,"Compartir con..."));



    }

    private void abrirAnadirTienda() {
        Intent nueva_ventana= new Intent(MainActivity.this, registrarTienda.class);
        startActivity(nueva_ventana);
    }

    private void abrirListar() {
        Intent nueva_ventana= new Intent(MainActivity.this, lista.class);
        startActivity(nueva_ventana);
    }

    public void consulta(View view){
        Intent nueva_ventana = new Intent(MainActivity.this, Consultar.class);
        startActivity(nueva_ventana);
    }
}
