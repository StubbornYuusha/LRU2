package lru2;

import java.util.Scanner;

public class Generador_de_Instrucciones extends Memoria{
  
    private int min=0;
    private int max=0;
    public int ed=0, pag=0, mpag=0;
    public String p, mp;
    private Traductor m = new Traductor();
    
    
    public void proceso(int ram, int mv, int tp, int cb1, int cb2, int cb3){
        int n,k=1024, k1=1, k2=1, k3=1;
        int bitpag, bitmar;
        for(int i=0; i<cb1 ; i++){
           k1= k1*k;
        }
        for(int i=0; i<cb2 ; i++){
           k2= k2*k;
        }
        for(int i=0; i<cb3 ; i++){
           k3= k3*k;
        }
        tp = tp*k3;
        ed= mv*k2; //espacio de direcciones
        pag= ed/tp; //total  de pag
        mpag= (ram*k2)/tp; //marcos de pagina
        
        p = m.dec_bin(pag-1); 
        mp = m.dec_bin(mpag-1); 
        
        bitpag= p.length(); //bits para las pag
        bitmar= mp.length(); //bits para los marcos de pag   
    }
    
    public String manual(int man){
       String r = m.dec_bin(man);
       System.out.println("Binario de"+man+"es"+r);  
       return r;
    }
    
    
    public String aleatorio(){
        int numero = (int)(Math.random()*ed);
        Scanner sn =new Scanner(System.in);
        System.out.println("El maximo:");  
        this.max=numero; //32k -- espacio de direcionamiento 
        this.max=max-1;
        System.out.println("el minimo es: "+min);  
        System.out.println("El rango es: ("+max+","+min+")"); 
        String l = m.dec_bin(max); //manda el binario a la clase MMU para su demas proceso
        System.out.println("Binario de"+max+"es"+l);  
        return l;
    }
}
