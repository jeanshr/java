import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LogAnalyzer {
    String Path = "/home/jecunha/workspace/github/java/eclipse-workspace/Files/";
    int countReadbleFiles = 0;

    //Validated directory data, list all of it. Count readble files that is ".txt" files and return the count of it.
    public void ReadDirectoryFiles() {
        File FilesInFolder = new File(Path);
        File[] listOfFiles = FilesInFolder.listFiles();

        for (File file : listOfFiles) {
            //loading my list with all directories of  listOfFiles list, to use in ReadAllFilesOption method;
            GetAllFilesInDirectory.add(file.toString());
            if (file.isFile()) {
                if (file.getName().contains(".txt")) {
                    countReadbleFiles++;
                }
                System.out.println(countReadbleFiles + ". " + file.getName());
            }
        }
        System.out.println("=========================================");
        System.out.println(countReadbleFiles + " text files detected.");
        System.out.println("=========================================");
    }
    //List that returns all of directories listed on ReadDirectoryFiles method
    List<String>  GetAllFilesInDirectory = new ArrayList<String>();

    //User can choose to search some data in all files returned in the directory
    public void ReadAllFilesOption() throws FileNotFoundException {
        String fileName = null;
        for(String getFileNameFromDirectories : GetAllFilesInDirectory) {
            fileName = getFileNameFromDirectories;

            //call method that is responsible to get words splited
            SearchForSpecificWords();
            String searchStr = null;
            for (int i = 0; i < vet.length; i++) {
                searchStr = vet[i];
                Scanner scan = new Scanner(new File(fileName));
                while (scan.hasNext()) {
                    String line = scan.nextLine().toLowerCase().toString(); //tem casos que o nome está concatenado com algo, exemplo .JEAN, vai ter q pesquisar usando like %Jean%, ou *Jean*
                    if (line.contains(searchStr)) {
                        System.out.println(line);//gravar no novo arquivo - metodo ReturnSelectedData()
                    }
                }
            }
        }
    }

    //User can choose what files wanna open to get data information
    public void ReadSpecificFilesOption(){}

    //Get the specific words typed delimited by ; and split then
    String[] vet;

    //User can choose to search data using specific words, like "java";"logs";data", or
    public void SearchForSpecificWords(){
        String Teste = "jean;rafa;vini;CLAUDIO"; //está trazendo claudio apenas 1x quando tem 3
        vet = Teste.split(";");
    }

    //Using any words and logs default format, like "[logs-java-lang~]", for example
    public void SearchForLogsDefaultFormat(){}

    //Create a new file with required data
    public void ReturnSelectedData(){}

}
