/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupepoject;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class GroupePoject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int num1,num2,sum=0;

        Scanner sc = new Scanner(System.in);

        num1 = sc.nextInt();
        num2 = sc.nextInt();

        sum = num1 + num2;

        System.out.println("The sum of"+num1+" and "+num2+" is: "+sum);
        
        System.out.println(" the new project");
        System.out.println("my name is elienock");
        JOptionPane.showMessageDialog(null, "yours ");
        
    }
    
}
