package PaqG10_B;

public class Puerto {
    final int F = 10;
    final int C = 12;
    public Contenedor[][] almacen = new Contenedor[F][C];

    public Puerto(){
        for(int i=0;i<F;i++){
            for(int j=0;j<C;j++){
                Contenedor c = new Contenedor();
                almacen[i][j]=c;
            }
        }
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        for(int i=0;i<F;i++){
            for(int j=0;j<C;j++){
                if (this.almacen[i][j].getId() == -1){
                    s.append("0       ");
                }
                else s.append("X       ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public boolean apilar(Contenedor c, Puerto hub){
        if(c.getPrioridad() == 1){
            for(int i=(F-1);i>=0;i--){
                if(hub.almacen[i][0].getId() == -1){
                    hub.almacen[i][0]=c;
                    return true;
                }
            }
            return false;
        }
        else if(c.getPrioridad() == 2){
            for(int i=(F-1);i>=0;i--){
                if(hub.almacen[i][1].getId() == -1){
                    hub.almacen[i][1]=c;
                    return true;
                }
            }
            return false;
        }
        else{
            for(int col=2;col<C;col++){
                for(int fil=(F-1);fil>=0;fil--){
                    if(hub.almacen[fil][col].getId() == -1){
                        hub.almacen[fil][col]=c;
                        return true;
                    }
                }
            }
            return false;
        }
    }
    public boolean desapilar(int col, Puerto hub) {
        for (int fila = 0; fila <= F-1; fila++) {  //cruzamos por todas las filas de la columna seleccionada
            if (hub.almacen[fila][col].getId() != -1) { //comprobamos si la fila contiene o no un contenedor
                hub.almacen[fila][col].setId(-1);   //cuando encontramos un contenedor en la columna lo eliminamos.
                return true;
            }
        }
         return false;
    }
    public int cantCont(String Pais, Puerto hub){
        int suma =0;
        for(int i=0;i<F;i++){   //cruzamos por las filas
            for(int j=0;j<C;j++){   //cruzamos por las columnas
                if(hub.almacen[i][j].getPais().equals(Pais)){ //comprobamos y sumamos los cantenedores segun su pais
                    suma = suma + 1;
                }
            }
        }
        return suma;
    }
}
