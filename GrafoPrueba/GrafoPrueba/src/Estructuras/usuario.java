package Estructuras;

public class usuario {
    private String nombre,correo,contrasena,lugarDondeVive,carnet;
    private ListaSimple listaAmigos;

    public usuario(String nombre, String correo, String contrasena, String lugarDondeVive) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.lugarDondeVive = lugarDondeVive;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public ListaSimple getListaAmigos() {
        return listaAmigos;
    }

    public void setListaAmigos(ListaSimple listaAmigos) {
        this.listaAmigos = listaAmigos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getLugarDondeVive() {
        return lugarDondeVive;
    }

    public void setLugarDondeVive(String lugarDondeVive) {
        this.lugarDondeVive = lugarDondeVive;
    }
}