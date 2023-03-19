package PaqG10_B;

public class Hub {
    final int F = 10;
    final int C = 12;
    public Contenedor[][] matriz = new Contenedor[F][C];

    public Hub(){
        for(int i=0;i<F;i++){
            for(int j=0;j<C;j++){
                Contenedor c = new Contenedor();
                matriz[i][j]=c;
            }
        }
    }

    public String toString(Hub almacen){
        StringBuilder s = new StringBuilder();
        for(int i=0;i<F;i++){
            for(int j=0;j<C;j++){
                if (almacen.matriz[i][j].id == -1){
                    s.append("0       ");
                }
                else s.append("1       ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public boolean apilar(Contenedor c, Hub almacen){
        if(c.prioridad == 1){
            for(int i=(F-1);i>=0;i--){
                if(almacen.matriz[i][0].id == -1){
                    almacen.matriz[i][0]=c;
                    return true;
                }
            }
            return false;
        }
        else if(c.prioridad == 2){
            for(int i=(F-1);i>=0;i--){
                if(almacen.matriz[i][1].id == -1){
                    almacen.matriz[i][1]=c;
                    return true;
                }
            }
            return false;
        }
        else{
            for(int col=2;col<(C-1);col++){
                for(int fil=(F-1);fil>=0;fil--){
                    if(almacen.matriz[fil][col].id == -1){
                        almacen.matriz[fil][col]=c;
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
