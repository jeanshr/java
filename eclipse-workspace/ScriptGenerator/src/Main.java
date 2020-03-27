import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        FileValidator vld = new FileValidator();
        //System.out.println("Directory: ");
        //String pathName = scan.nextLine();
        //vld.pathOrigem = pathName;
        String pathName = "/home/jecunha/workspace/github/java/eclipse-workspace/Files/ListIDs.txt";
        vld.setPathOrigem(pathName);//"/home/jecunha/workspace/github/java/eclipse-workspace/Files/ListIDs.txt"; // ListIDs , Vazio, ListaComplexa
        vld.setPathDestino(pathName);
        //se o arquivo for estiver vazio, para a execução, se nao cria o arquivo
         boolean validation = vld.validationMain;
        if(vld.validaArquivo(validation) == false){
            System.out.println("NOTOK");
        }
        else {
            List<String> test = new ArrayList<>();
            vld.armazenaIDs(test);
            vld.criaNovoArquivo();
        }
    }
}
