import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogAnalyzer {
    String Path = null; ///home/jecunha/workspace/github/java/TestFiles/tests/
    String LogDataFile = null;
    String getWordsToSearchClass = null;
    int countReadbleFiles = 0;
    SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy"); //dd-MM-mm-ss
    Date date = new Date();

    //Get files id from countReadbleFiles var. Record that to use on method ReadSpecificFilesOption()
    List<String> GetFilesID = new ArrayList<String>();

    //Validate directory data, list all of it. Count readble files that is ".txt" files and return the count of it.
    public void ReadDirectoryFiles() {
        File FilesInFolder = new File(Path);
        File[] listOfFiles = FilesInFolder.listFiles();

        for (File file : listOfFiles) {
            //loading my list with all directories of  listOfFiles list, to use in ReadAllFilesOption method;
            GetAllFilesInDirectory.add(file.toString());
            if (file.isFile() && file.getName().contains(".txt")) {
                countReadbleFiles++;
                String fullNameWithID = countReadbleFiles + file.toString();
                GetFilesID.add(fullNameWithID.toString());
                System.out.println(countReadbleFiles + ". " + file.getName());
            }
        }
        System.out.println("=========================================");
        System.out.println("    " + countReadbleFiles + "  text file(s) detected.");
        System.out.println("=========================================");
    }

    //List that returns all of directories listed on ReadDirectoryFiles method
    List<String>  GetAllFilesInDirectory = new ArrayList<String>();
    //List to load strings found and use in method ReturnSelectedDataInFile
    List<String>  LoadConsolidatedLogFile = new ArrayList<String>();


    //User can choose to search some data in all files returned in the directory or selected files on method ReadSpecificFilesOption()
    public void ReadAllFilesOption() throws IOException {
        String fileName = null;
        for(String getFileNameFromDirectories : GetAllFilesInDirectory) {
            if(getFileNameFromDirectories.contains(".txt")) {
                fileName = getFileNameFromDirectories;

                //calling method that is responsible to get words splitted
                SearchForSpecificWords();
                //String searchStr = null;
                for (int i = 0; i < vet.length; i++) {
                    String searchStr = vet[i];
                    Scanner scan = new Scanner(new File(fileName));
                    while (scan.hasNext()) {
                        String line = scan.nextLine().toLowerCase().toString();
                        if (line.contains(searchStr)) {
                            LoadConsolidatedLogFile.add(line);
                        }
                    }
                }
            }
        }
        //calling method that creates a new file consolidating all strings found
        ReturnSelectedDataInFile();
    }

    //User can choose what files wanna open to get data information
    public void ReadSpecificFilesOption() throws IOException {
        ReadDirectoryFiles();
        String getChosenOption = "1"; //file id = 1 selected
        for(String x : GetFilesID){
            if(x.startsWith(getChosenOption)) {
                System.out.println("Reading " + x + " file");
                //calling method that is responsible to get words splitted
                SearchForSpecificWords();
                String searchStr = null;
                for (int i = 0; i < vet.length; i++) {
                    searchStr = vet[i];
                    String IgnoreFirstCharacter = "";
                    IgnoreFirstCharacter = x.replaceFirst(getChosenOption, "");
                    Scanner scan = new Scanner(new File(IgnoreFirstCharacter));
                    while (scan.hasNext()) {
                        String line = scan.nextLine().toLowerCase().toString(); //tem casos que o nome está concatenado com algo, exemplo .JEAN, vai ter q pesquisar usando like %Jean%, ou *Jean*
                        if (line.contains(searchStr)) {
                            LoadConsolidatedLogFile.add(line);
                        }
                    }
                }
                //calling method that creates a new file consolidating all strings found
                ReturnSelectedDataInFile();
            }
        }

    }

    //Get the specific words typed delimited by ; and split then in SearchForSpecificWords() method
    String[] vet;

    //User can choose to search data using specific words, like "java";"logs";data", or
    public void SearchForSpecificWords(){
        vet = getWordsToSearchClass.split(";");
    }

    //Using any words and logs default format, like "[logs-java-lang~]", for example
    public void SearchForLogsDefaultFormat(){}

    //Load a new list with all data found in ReadAllFilesOption
    List<String> GetReturnedDataForLogFile = new ArrayList<String>(LoadConsolidatedLogFile);

    //Create a new file with required data
    public void ReturnSelectedDataInFile() throws IOException{
        if (LogDataFile != null) {
            Random random = new Random();
            int randomNumber = random.nextInt(100);
            randomNumber += 1;
            String GettingNewFileForLog = "consolidated-logs-" + dateFormat.format(date) + "-" + randomNumber +".log";
            File newFileForLog = new File(LogDataFile.concat(GettingNewFileForLog));
            GetReturnedDataForLogFile.addAll(LoadConsolidatedLogFile);
            FileWriter fWriter = new FileWriter(newFileForLog);
            fWriter.write("========== " + date.toString() + " ==========" + "\n\n");
            fWriter.write(GetReturnedDataForLogFile.toString());
            fWriter.close();
            System.out.println("File has been created in: " + newFileForLog);
        }
    }

}
