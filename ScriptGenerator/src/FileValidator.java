import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileValidator {

    String pathOrigem = null;
    String pathDestino = null;
    Boolean validationMain = false;

    public String setPathOrigem(String pathOrigem) {
        return this.pathOrigem = pathOrigem;
    }
    public String setPathDestino(String pathDestino) {
        return this.pathDestino = pathDestino;
    }

    List<String> list = new ArrayList<String>();

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
                if(vldLinhas.contains(";")){
                    list.add(vldLinhas);
                    vldLinhas = bReader.readLine();
                }
                else {
                    System.out.println("arquivo no formato incorreto;");
                }
            }
        }
        catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    public void criaNovoArquivo() {
        try {
            if(pathDestino != null) {
                File Script = new File(pathDestino);
                String extensionNameForFile = ".SCRIPT";

                File newFileForScript = new File(pathDestino.concat(extensionNameForFile));
                FileWriter fWriter = new FileWriter(newFileForScript); //cria novo arquivo para nao alterar o original

                for (String x : list) {
                    String[] vet = x.split(";");
                    //Não necessário um for devido ao arquivo ser sempre de formato padrão, sempre 4 campos
                    fWriter.write("UPDATE tableTest SET contaVend = " + vet[0] +
                            ", contaCompr = " + vet[1]+
                            " WHERE idVend = " + vet[2]+
                            ", idCompr = " + vet[3]+"\n");
                }
                fWriter.close();
                System.out.println("Arquivo gerado com sucesso em: " + newFileForScript.toString());
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