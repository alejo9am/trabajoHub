package PaqG10_B;

public class Contenedor{
    private int id;
    private int peso;
    private String pais;
    private boolean aduana;
    private int prioridad;
    private String descripcion;
    private String origen;
    private String destino;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }

    public boolean isAduana() {
        return aduana;
    }
    public void setAduana(boolean aduana) {
        this.aduana = aduana;
    }

    public int getPrioridad() {
        return prioridad;
    }
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getOrigen() {
        return origen;
    }
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Contenedor(){
        this.id=-1;
        this.peso=0;
        this.pais="";
        this.aduana=false;
        this.prioridad=0;
        this.descripcion="";
        this.origen="";
        this.destino="";
    }

}