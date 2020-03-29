import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderForIDs {
    //Pega o arquivo valida se tem conteudo, e armazena os dados.

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.printf("Informe o diretório do arquivo: \n");
        String diretorio  = scan.nextLine();

        System.out.printf("\nIDs:\n");

        try {
            FileReader Reader = new FileReader(diretorio);
            BufferedReader lerArq = new BufferedReader(Reader);

            String linha = lerArq.readLine();

            while (linha != null) {
                System.out.printf("%s\n", linha);

                linha = lerArq.readLine(); // lê da segunda até a última linha
            }

            Reader.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

        System.out.println();

    }
}