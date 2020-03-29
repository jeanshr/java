import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LogAnalyzer {
    String Path = "/home/jecunha/workspace/github/java/eclipse-workspace/Files/tests/";
    String LogDataFile = Path;
    int countReadbleFiles = 0;
    SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy"); //dd-MM-mm-ss
    Date date = new Date();

    //Validate directory data, list all of it. Count readble files that is ".txt" files and return the count of it.
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
    List<String>  LoadConsolidatedLogFile = new ArrayList<String>();


    //User can choose to search some data in all files returned in the directory or selected files on method ReadSpecificFilesOption()
    public void ReadAllFilesOption() throws IOException {
        String fileName = null;
        for(String getFileNameFromDirectories : GetAllFilesInDirectory) {
            fileName = getFileNameFromDirectories;

            //calling method that is responsible to get words splitted
            SearchForSpecificWords();
            String searchStr = null;
            for (int i = 0; i < vet.length; i++) {
                searchStr = vet[i];
                Scanner scan = new Scanner(new File(fileName));
                while (scan.hasNext()) {
                    String line = scan.nextLine().toLowerCase().toString(); //tem casos que o nome está concatenado com algo, exemplo .JEAN, vai ter q pesquisar usando like %Jean%, ou *Jean*
                    if (line.contains(searchStr)) {
                        LoadConsolidatedLogFile.add(line);
                    }
                }
            }
        }
        //calling method that creates a new file consolidating all strings found
        ReturnSelectedDataInFile();
    }

    //User can choose what files wanna open to get data information
    public void ReadSpecificFilesOption(){}

    //Get the specific words typed delimited by ; and split then in SearchForSpecificWords() method
    String[] vet;

    //User can choose to search data using specific words, like "java";"logs";data", or
    public void SearchForSpecificWords(){
        String Teste = "jean;rafa;vini;CLAUDIO"; //está trazendo claudio apenas 1x quando tem 3 - será substituído por input do usuario
        vet = Teste.split(";");
    }

    //Using any words and logs default format, like "[logs-java-lang~]", for example
    public void SearchForLogsDefaultFormat(){}

    //Load a new list with all data found in ReadAllFilesOption
    List<String> GetReturnedDataForLogFile = new ArrayList<String>(LoadConsolidatedLogFile);

    //Create a new file with required data
    public void ReturnSelectedDataInFile() throws IOException{
        if (LogDataFile != null) {
            String GettingNewFileForLog = "consolidated-logs-" + dateFormat.format(date) + "-" + countReadbleFiles +".txt";
            File newFileForLog = new File(LogDataFile.concat(GettingNewFileForLog));
            GetReturnedDataForLogFile.addAll(LoadConsolidatedLogFile);
            FileWriter fWriter = new FileWriter(newFileForLog);
            fWriter.write(GetReturnedDataForLogFile.toString());
            fWriter.close();
            System.out.println("File has been created in: " + newFileForLog);
        }
    }

}
