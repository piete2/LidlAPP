package piete.lidltransportista.entidades;

/**
 * Created by Antonio on 07/10/2017.
 */

public class Tienda {
    private String numTienda;
    private String nombre;
    private String muelleFrio;
    private String filaFrio;//NUEVO
    private String muelleFruta;

    public String getFilaFrio() {
        return filaFrio;
    }

    public void setFilaFrio(String filaFrio) {
        this.filaFrio = filaFrio;
    }

    public String getFilaFruta() {
        return filaFruta;
    }

    public void setFilaFruta(String filaFruta) {
        this.filaFruta = filaFruta;
    }

    public String getFilaSeco() {
        return filaSeco;
    }

    public void setFilaSeco(String filaSeco) {
        this.filaSeco = filaSeco;
    }

    private String filaFruta;//NUEVO
    private String muelleSeco;
    private String filaSeco;//NUEVO
    private String direccion;
    private String telefono;

    public String getNumTienda() {
        return numTienda;
    }

    public void setNumTienda(String numTienda) {
        this.numTienda = numTienda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMuelleFrio() {
        return muelleFrio;
    }

    public void setMuelleFrio(String muelleFrio) {
        this.muelleFrio = muelleFrio;
    }

    public String getMuelleFruta() {
        return muelleFruta;
    }

    public void setMuelleFruta(String muelleFruta) {
        this.muelleFruta = muelleFruta;
    }

    public String getMuelleSeco() {
        return muelleSeco;
    }

    public void setMuelleSeco(String muelleSeco) {
        this.muelleSeco = muelleSeco;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Tienda() {
        this.numTienda = numTienda;
        this.nombre = nombre;
        this.muelleFrio = muelleFrio;
        this.filaFrio=filaFrio;
        this.muelleFruta = muelleFruta;
        this.filaFruta=filaFruta;
        this.muelleSeco = muelleSeco;
        this.filaSeco=filaSeco;
        this.direccion = direccion;
        this.telefono = telefono;
    }
}
