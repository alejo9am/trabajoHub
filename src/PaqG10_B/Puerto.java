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

    public String toString(Puerto hub){
        StringBuilder s = new StringBuilder();
        for(int i=0;i<F;i++){
            for(int j=0;j<C;j++){
                if (hub.almacen[i][j].getId() == -1){
                    s.append("0       ");
                }
                else s.append("1       ");
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
            for(int col=2;col<(C-1);col++){
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
}
