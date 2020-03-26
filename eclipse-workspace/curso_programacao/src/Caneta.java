public class Caneta {

    String Modelo;
    String Cor;
    float Ponta;
    int Carga;
    boolean Tampada;

    void status(){
        System.out.println("Modelo: " + this.Modelo);
        System.out.println("Carga: " + this.Carga);
        System.out.println("Uma caneta: " + this.Cor);
        System.out.println("Está tampada?: " + this.Tampada);
    }

    void rabiscar(){
    if(this.Tampada == true){
        System.out.println("ERRO!, tampada!");
    }
    else{
        System.out.println("Rabiscando...!");
    }
    }
    void tampar(){
        this.Tampada = true;
    }

    void destampar(){
    this.Tampada = false;
    }
}
