package progettocampominato;


public class Campo {
    
    int mat[][];
    int vita=3;
    
    public Campo(){
        mat = new int[15][15];
    }
    
    public void generaCampo(){
        
        int cella;
        
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                cella = (int) (Math.random() * 6);
                if(cella == 4){
                    mat[i][j]=1;
                } else {
                    mat[i][j]=0;
                }
                System.out.print(mat[i][j] + " ");
            }
            System.out.print("\n");
        }
           
    }
    
    public int getCella(int i, int j){
        return mat[i][j];
    }
    
    public void controllaCelleAdiacenti(int i, int j){
        for(int x=i-1;x<i+2;x++){
            for(int y=j-1;y<j+2;y++){
                if(x>=0 && y>=0 && x<=14 && y<=14){
                    if(mat[x][y]==0){
                        mat[x][y]=2;
                    }
                    
                }
            }
        }
    }
    
    public int contaBombeAdiacenti(int i, int j){
        int count=0;
        for(int x=i-1;x<i+2;x++){
            for(int y=j-1;y<j+2;y++){
                if(x>=0 && y>=0 && x<=14 && y<=14){
                    if(mat[x][y]==1){
                        count++;
                    }
                }
            }
        }
        return count;
    }    
    
    public int calcolaPunteggio(){
        int punti=0;
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                if(mat[i][j]==2){
                    punti+=5;
                }
            }
        }
        return punti;
    }
    
    public void decrementaVita(){
        vita--;
    }
    
    public int getVita(){
        return vita;
    }
    
    public void ricaricaVita(){
        vita=3;
    }
    
    public void setBomba(int i, int j){
        mat[i][j]=3;
    }
    
}
