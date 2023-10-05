/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAPA_NEGOCIO;
/*** @author Jorge */

public class FRACCION {
    //1.ATRIBUTOS 
    int Nume; // aqui tambien incluye el signo  ya que va casado con nume
    int Deno; 
    //CONSTRUCTOR -> instancia la clase 
    
    // y tiene que ser el nombre de la clase 
    public FRACCION(){ //sin parametros de entrada 
        this.Nume = 0 ;//0
        this.Deno = 1;
        //8830
    }
    //CONSTRUCTOR CON PARAMETROS DE ENTRADA 
    public FRACCION(int numeradorr,int denominadorr , char signoo){
        
        this.Deno = denominadorr;
        if (signoo== '+') {
            this.Nume=+numeradorr; 
        }else{
            this.Nume= -numeradorr ;
        }
        
    }
    //3 paso . SETTER's (void) - procedimiento 
    
    //SET  -- carga e inserta / son void 
    public void setNum(int numerador){
        if (this.Nume >= 0) {
            this.Nume= numerador;
            //this.Nume=+Math.abs( numerador);
        }else{
             this.Nume = -numerador;
              //this.Nume=-Math.abs( numerador);
        }
    }
       public void setDeno(int denominador){
        if (denominador !=0) {
           this.Deno = denominador; 
            //   this.Deno= Math.abs(denominador);
        }//else{
    }
            // System.out.println("setDeno : error el denominado es 0");
           // System.exit(0);
        //}
    //analizar ek setsigno 
    public void setSigno(char signo){
        //como el signo va cazado con numeradoir , es ahy dondee tengo 
        //q ingresar signo
        if (signo == '+') {
            this.Nume= +Math.abs(Nume);//usar valor absoluto ,
            //
        }else{
            this.Nume=-Math.abs(Nume);
        }
    }
    // 4 paso ,, getters - son funciones 
    //GET - devolver y son funciones 
    //get numerador 
    public int getNume(){
        return Math.abs(Nume) ;
    }
    // Getdenominador 
    public int getDeno(){
        return this.Deno;
    }
    //getsigno 
    public char getSigno(){
        if (this.Nume >= 0) {
            return '+';
        }else{
            return '-';
        }
    }
    //TOSTRING 

    /*
    @Override
    public String toString() {
      //  return "FRACCION{" + "Nume=" + Nume + ", Deno=" + Deno + '}';
        return getSigno()+" " +getNume()+ "/"+getDeno() ;
    }
    */

    public String ToString(){
        String C = "_";
        //C = " "+getNume()+ "\n" +getSigno() + "  -- "+"\n" +" "+ getDeno();
        //return C;
        C=  getSigno()+" " +getNume()+ "/"+getDeno() ;
        return C ;
    }
    //
    
    //OPERACIONES 
    //1º SUMA --forma del auxi
    public void suma2(FRACCION A , FRACCION B ){
        this.Deno = A.getDeno() * B.getDeno();
        this.Nume= (Deno /A.getDeno()*A.Nume)+(Deno/B.getDeno()*B.Nume)  ; 
        Simplificar();
    }
    
    //version 2 de suma -mi forma
     public void suma(FRACCION A , FRACCION B ){
        this.Deno = A.getDeno() * B.getDeno();
        this.Nume= (A.Nume*B.getDeno())+(A.getDeno()* B.Nume) ; 
        Simplificar();
    }
    //2º RESTA 
      public void resta(FRACCION A , FRACCION B ){
        this.Deno = A.getDeno() * B.getDeno();
        this.Nume= (Deno /A.getDeno()*A.Nume)-(Deno/B.getDeno()*B.Nume)  ; 
        Simplificar();
    }
    //3º MULTIPLICACION
       public void multiplicacion(FRACCION A , FRACCION B ){
        this.Deno = A.getDeno() * B.getDeno();
        this.Nume= A.getNume() * B.getNume() ; 
        Simplificar();
    }
       
    // 4º DIVISION 
       public void division(FRACCION A , FRACCION B ){
           /*this.Nume = (A.getNume()*B.getDeno());
           this.Deno = (A.getDeno() * B.getNume() );*/
              this.Nume = (A.Nume*B.Deno);
           this.Deno = (A.Deno * B.Nume );
           Simplificar();
       }
       //5 ºSIMPLIFICAR ---aprender
       //(aprender a debugear 1 : 10 : 00)
       public void Simplificar(){
           int x = MCD() ;
          this.Nume = Nume/x ;
           this.Deno = Deno/x;
       }
       public int MCD(){
            int u = Math.abs(Nume);
            int v =Math.abs(Deno);
           if (v ==0) {
               return u ; 
           }else{
               int r; 
               while (v!= 0 ){
                   r = u % v ;
                   u=v ;
                   v=r;
               }
               return u ;
           }
       }
                  
       
    //LLAMADAS
    public static void main(String[] args) {
        //INSTANCIUAR LA CLASE 
        FRACCION A = new FRACCION(2 ,5,'-');  //trabajasin  parametrs de entrada
        
        System.out.println(A.ToString());
        //------------------------------------------------------------
        //con valores que el usuario lo pase 
        FRACCION B = new FRACCION(45,10 , '+'); //con parametros de entrada 
        /*
        FRACCION B = new FRACCION()
        B.setDeno(5) ;
        B.nume();
        B:setsigno('+')
        */
        //System.out.println(B.toString());
        FRACCION C = new FRACCION();
        C.suma(A, B);
        System.out.println(B.ToString());
        
        System.out.println(C.ToString());
        
        //
    }

    
    
}
