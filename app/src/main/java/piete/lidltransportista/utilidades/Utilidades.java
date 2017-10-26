package piete.lidltransportista.utilidades;

/**
 * Created by Antonio on 07/10/2017.
 */
// NO TOCAR NADA MAS
public class Utilidades {


    public static final String TABLA_TIENDA="tienda";
    public static final String CampoNumeroTienda="numTienda";
    public static final String CampoNombreTienda="nombre";
    public static final String CampoMuelleFrio="muelleFrio";
    public static final String CampoFilaFrio="filaFrio";//NUEVO
    public static final String CampoMuelleFruta="muelleFruta";
    public static final String CampoFilaFruta="filaFruta";//NUEVO
    public static final String CampoMuelleSeco="muelleSeco";
    public static final String CampoFilaSeco="filaSeco";//NUEVO
    public static final String CampoDireccion="direccion";
    public static final String CampoTelefono="telefono";

    public static final String CREAR_TABLA_TIENDA="CREATE TABLE "+TABLA_TIENDA+"("+CampoNombreTienda+
            " TEXT,"+CampoNumeroTienda+" TEXT, "+CampoMuelleFrio+" TEXT, "+CampoFilaFrio+" TEXT, "+CampoMuelleFruta+" TEXT,"+CampoFilaFruta+" TEXT,"+
            CampoMuelleSeco+" TEXT,"+CampoFilaSeco+" TEXT,"+CampoDireccion+" TEXT,"+CampoTelefono+" TEXT)"; //MODIFICADO TODO


}
