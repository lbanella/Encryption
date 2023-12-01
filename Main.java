import java.util.ArrayList;
class Main {
  public static void main(String[] args) {
    //SALUTO! 
     ArrayList<Vigenere> quadranti = new ArrayList<Vigenere>();

    System.out.println("Cifriamo il nostro testo e trasformiamolo in un testo segreto!");
    Matrice s=new Matrice("TPSIT");
    
    Vigenere quadrante_1=new Vigenere(0,13,0,13,s);
     quadranti.add(quadrante_1);
    
    Vigenere quadrante_2=new Vigenere(0,13,13,26,s);
     quadranti.add(quadrante_2);
    
    Vigenere quadrante_3=new Vigenere(13,26,0,13,s);
     quadranti.add(quadrante_3);
    
    Vigenere quadrante_4=new Vigenere(13,26,13,26,s);
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
    
      
   s.stampa();
  }
}