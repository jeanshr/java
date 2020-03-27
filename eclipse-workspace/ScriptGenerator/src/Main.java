import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        FileValidator vld = new FileValidator();
        System.out.println("Informe o diretório completo do arquivo: ");
        String pathName = scan.nextLine();
        vld.pathOrigem = pathName;
        vld.setPathOrigem(pathName);
        vld.setPathDestino(pathName);
        //se o arquivo for estiver vazio, para a execução, se nao cria o arquivo
        boolean validation = vld.validationMain;
        if(vld.validaArquivo(validation) == false){
            System.out.println("Arquivo ou diretório inconsistente");
        }
        else {
            List<String> recebeParam = new ArrayList<>();
            vld.armazenaIDs(recebeParam);
            vld.criaNovoArquivo();
        }
    }
}
