import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileValidator {

    String pathOrigem;
    String pathDestino = "/home/jecunha/Downloads/downteste.txt";
    Boolean validationMain = false;

    List<String> list = new ArrayList<>();

    //Verifica se o arquivo existe e possui dados
    public boolean validaArquivo(boolean vld) {
        try {
            FileReader fReader = new FileReader(pathOrigem);
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
            File Script = new File(pathDestino); // append File(pathDestino, true)
            FileWriter fWriter = new FileWriter(Script);
            for(String x : list) {
                fWriter.write("update test set id_cliente = " + x + " where test = teste , \n");
            }
            fWriter.close();
        }
        catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

}