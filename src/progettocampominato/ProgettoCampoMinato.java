/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettocampominato;

/**
 *
 * @author Studenti1
 */
public class ProgettoCampoMinato {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Finestra f = new Finestra();
        f.setSize(500,530);
        f.setLocation(300,300);
        f.setTitle("Campo Minato");
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);   
        
    }
    
}
