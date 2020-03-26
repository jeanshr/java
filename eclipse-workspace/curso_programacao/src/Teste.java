import java.io.*;

public class Teste {


    public static void main(String[] args) {

        //criando e modificando diretorios

        //File file = new File("/home/jecunha/Downloads/dir_testes");
        //file.mkdir();
        //file.delete();

        //criando e modificando arquivos
       File arquivo = new File("/home/jecunha/Downloads/arquivoTeste.txt");
            /*     try{
                    arquivo.createNewFile();

        }
                catch (IOException e){
                    e.getMessage();
                }

       */

        try {

            //alterando arquivo
            FileWriter Writer = new FileWriter(arquivo);
            BufferedWriter buffWriter = new BufferedWriter(Writer);

            buffWriter.write("escrevendo-teste");

            Writer.close();
            buffWriter.close();

            //Lendo arquivo
            FileReader leitor = new FileReader(arquivo);
            BufferedReader buff = new BufferedReader(leitor);
            String pulaLinhas = buff.readLine();

          while(pulaLinhas != null){
              System.out.println(pulaLinhas);
              pulaLinhas = buff.readLine();
          }
        }
        catch (IOException e){
            e.getMessage();
        }

    }
}

