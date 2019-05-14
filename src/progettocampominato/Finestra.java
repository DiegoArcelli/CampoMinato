package progettocampominato;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Finestra extends JFrame implements ActionListener {

    Container c;
    JPanel p,info,info1,info2;
    JButton b[][] = new JButton[15][15];
    GridLayout gl = new GridLayout(15,15);
    Campo mat;
    JLabel vite,punti;
    int boost,score;
    
    
    public Finestra(){
        boost=1;
        score=0;
        
        int cont=0;
        mat = new Campo();
        mat.generaCampo();
        c = this.getContentPane();
        vite = new JLabel("Vite: 3");
        punti = new JLabel("Punteggio: 0");
        p = new JPanel();
        info = new JPanel();
        info1 = new JPanel();
        info2 = new JPanel();
        info1.add(vite);
        info2.add(punti);
        info.add(info1,BorderLayout.WEST);
        info.add(info2,BorderLayout.EAST);
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                b[i][j] = new JButton();
                //b[i][j].setFont(new Font("Helvetica",Font.PLAIN,5));
                p.add(b[i][j]);
                b[i][j].addActionListener(this);
                b[i][j].setActionCommand(Integer.toString(i) + " " + Integer.toString(j));                
            }
        }
        p.setLayout(gl);
        c.add(p,BorderLayout.CENTER);
        c.add(info,BorderLayout.PAGE_START);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        
        int i=0,j=0;
        for(int x=0;x<e.getActionCommand().length();x++){
            if(e.getActionCommand().charAt(x) == ' '){
                i = Integer.parseInt(e.getActionCommand().substring(0,x));
                j = Integer.parseInt(e.getActionCommand().substring(x+1,e.getActionCommand().length()));
            }
        }
        if(mat.getCella(i,j)==0){
            for(int x=i-1;x<i+2;x++){
                for(int y=j-1;y<j+2;y++){
                    if(x>=0 && y>=0 && x<=14 && y<=14){
                        if(mat.getCella(x,y)==0){
                            //b[x][y].setIcon(new ImageIcon("./ics.png"));
                            b[x][y].setText(Integer.toString(mat.contaBombeAdiacenti(x, y)));
                        }
                    }
                }
            }
            mat.controllaCelleAdiacenti(i, j);
            score+=mat.calcolaPunteggio()*boost;
            punti.setText("Punteggio: " + score);
            boost++;
        } else if(mat.getCella(i,j)==1) {
            boost=1;
            b[i][j].setIcon(new ImageIcon("./bomba.png"));
            mat.decrementaVita();
            vite.setText("Vite: " + mat.getVita());
            mat.setBomba(i, j);
            if(mat.getVita()==0){
                JOptionPane.showMessageDialog(null,"Punteggio: " + score,"Game Over",JOptionPane. INFORMATION_MESSAGE);
                mat.generaCampo();
                for(int x=0;x<15;x++){
                    for(int y=0;y<15;y++){
                        b[x][y].setText(null);
                        b[x][y].setIcon(null);
                        score=0;
                        mat.ricaricaVita();
                        vite.setText("Vite: " + mat.getVita());
                        punti.setText("Punteggio: " + score);
                    }
                }
            }
            
        }
        
        
    }
    
        
    
}
