import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileValidator {

    String pathOrigem = null;
    String pathDestino = null; //"/home/jecunha/Downloads/downteste.txt" -- "/home/jecunha/workspace/github/java/eclipse-workspace/Files/ListIDs.txt";
    Boolean validationMain = false;
    int contaOrigem, contaDestino, idOrigem, idDestino;

    public String setPathOrigem(String pathOrigem) {
        return this.pathOrigem = pathOrigem;
    }
    public String setPathDestino(String pathDestino) {
        return this.pathDestino = pathDestino;
    }

    List<String> list = new ArrayList<>();

    //Verifica se o arquivo existe e possui dados
    public boolean validaArquivo(boolean vld) {
        try {
            FileReader fReader = new FileReader(setPathOrigem(pathOrigem));
            BufferedReader bReader = new BufferedReader(fReader);
            String vldLinhas = bReader.readLine();
            this.validationMain = vld;

            if (vldLinhas != null) {
                vld = true;
            } else {
                vld = false;
            }
            fReader.close();
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return vld;
    }

    public void armazenaIDs(List<String> ListaIDs) {
        try {
            FileReader fReader = new FileReader(pathOrigem);
            BufferedReader bReader = new BufferedReader(fReader);
            String vldLinhas = bReader.readLine();

            this.list = ListaIDs;

            while (vldLinhas != null) {
                list.add(vldLinhas);
                vldLinhas = bReader.readLine();
            }
        }
        //fReader.close();
        catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    public void criaNovoArquivo() {
        try {
            if(pathDestino != null) {
                File Script = new File(pathDestino); // append File(pathDestino, true)
                String extensionNameForFile = ".SCRIPT";

                File newFileForScript = new File(pathDestino.concat(extensionNameForFile)); //"/home/jecunha/Downloads/downteste.txt"
                FileWriter fWriter = new FileWriter(newFileForScript);

                for (String x : list) {
                    fWriter.write("update test set id_cliente = " + x + " where test = teste , \n");
                }
                fWriter.close();
            }
            else{
                System.out.println("Path de destino null ou inexistente");
            }
        }
        catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

}