import java.util.ArrayList;
import java.util.Scanner;  // Import the Scanner class

/*
chiedere la parola segreta 
-scanner
-buffered

-chiedere la frase in chiaro
-cifrare la frase
-stampare la frase cifrata


*/


class Main {
  public static void main(String[] args) {
    //SALUTO! 
     ArrayList<Vigenere> quadranti = new ArrayList<Vigenere>();

    System.out.println("Cifriamo il nostro testo e trasformiamolo in un testo segreto!");
    Scanner scanner = new Scanner(System.in);  
    System.out.println("Inserisci  il verme");

    String verme = scanner.nextLine().toUpperCase(); 


    System.out.println("Inserisci  la parola in chiaro");

    String parola_in_chiaro = scanner.nextLine().toUpperCase(); 

    
    Matrice matrix=new Matrice(verme);
    
    Vigenere quadrante_1=new Vigenere(0,12,0,12,matrix);
     quadranti.add(quadrante_1);
    
    Vigenere quadrante_2=new Vigenere(0,12,12,26,matrix);
     quadranti.add(quadrante_2);
    
    Vigenere quadrante_3=new Vigenere(12,26,0,12,matrix);
     quadranti.add(quadrante_3);
    
    Vigenere quadrante_4=new Vigenere(12,26,12,26,matrix);
    quadranti.add(quadrante_4);

    
    for(Vigenere v:quadranti){
     Thread t= new Thread(v);
     t.start();
     try {
       t.join();
     }catch (InterruptedException ex) {
         System.err.println("Errore metodo join");
     }
    }  
    
      
    matrix.stampa();

    String fraseCriptata=matrix.cifra(parola_in_chiaro);
    System.out.println("La frase criptata è "+fraseCriptata);
    scanner.close();

  }
}