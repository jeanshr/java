import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogAnalyzer {
    private String path = null;
    private String logDataFile = null;
    private String wordsToSearchClass = null;
    private int chooseWhatFilesRead;
    private int readFileByID;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy"); //dd-MM-mm-ss
    private final Date date = new Date();

    //lists and vets
    //Get files id from countReadbleFiles var. Record that to use on method ReadSpecificFilesOption()
    List<String> getFilesID = new ArrayList<String>();
    //List that returns all of directories listed on ReadDirectoryFiles method
    List<String> getAllFilesInDirectory = new ArrayList<String>();
    //List to load strings found and use in method ReturnSelectedDataInFile
    List<String> loadConsolidatedLogFile = new ArrayList<String>();
    //Load a new list with all data found in ReadAllFilesOption
    List<String> getReturnedDataForLogFile = new ArrayList<String>(loadConsolidatedLogFile);
    //Get the specific words typed delimited by ; and split then in SearchForSpecificWords() method
    String[] vet;

    //getters and setters
    public String getPath(){ return this.path; }
    public String getLogDataFile(){ return this.logDataFile; }
    public String getWordsToSearchClass(){
        return this.wordsToSearchClass;
    }
    public int getChooseWhatFilesRead(){ return this.chooseWhatFilesRead; }
    public int getReadFileByID(){ return this.readFileByID; }
    public void setPath(String mainPath){
        path = mainPath;
    }
    public void setLogDataFile(String LogFile){ logDataFile = LogFile; }
    public void setWordsToSearchClass(String InputWords){ wordsToSearchClass = InputWords; }
    public void setChooseWhatFilesRead(int setChooseWhatFilesRead){ chooseWhatFilesRead = setChooseWhatFilesRead; }
    public void setReadFileByID(int setReadFileByID){ readFileByID = setReadFileByID; }

    //Validate directory data, list all of it. Count readble files that is ".txt" files and return the count of it.
    public void readDirectoryFiles() {
        int countReadbleFiles = 0;
        File filesInFolder = new File(getPath());
        File[] listOfFiles = filesInFolder.listFiles();

        for (File file : listOfFiles) {
            //loading my list with all directories of  listOfFiles list, to use in ReadAllFilesOption method;
            getAllFilesInDirectory.add(file.toString());
            if (file.isFile() && file.getName().contains(".txt")) {
                countReadbleFiles++;
                String fullNameWithID = countReadbleFiles + file.toString();
                getFilesID.add(fullNameWithID.toString());
                System.out.println(countReadbleFiles + ". " + file.getName());
            }
        }
        System.out.println("=========================================");
        System.out.println("    " + countReadbleFiles + "  text file(s) detected.");
        System.out.println("=========================================");
    }

    //User can choose to search some data in all files returned in the directory or selected files on method ReadSpecificFilesOption()
    public void readAllFilesOption() throws IOException {
        String fileName = null;
        for(String getFileNameFromDirectories : getAllFilesInDirectory) {
            if(getFileNameFromDirectories.contains(".txt")) {
                fileName = getFileNameFromDirectories;

                //calling method that is responsible to get words splitted
                searchForSpecificWords();
                //String searchStr = null;
                for (int i = 0; i < vet.length; i++) {
                    String searchStr = vet[i];
                    Scanner scan = new Scanner(new File(fileName));
                    while (scan.hasNext()) {
                        String line = scan.nextLine().toLowerCase().toString();
                        if (line.contains(searchStr)) {
                            loadConsolidatedLogFile.add(line);
                        }
                    }
                }
            }
        }
        //calling method that creates a new file consolidating all strings found
        returnSelectedDataInFile();
    }

    //User can choose what files wanna open to get data information
    public void readSpecificFilesOption() throws IOException {
        for(String x : getFilesID){
            if(x.startsWith(String.valueOf(getReadFileByID()))){
                System.out.println("Reading " + x + " file");
                //calling method that is responsible to get words splitted
                searchForSpecificWords();
                String searchStr = null;
                for (int i = 0; i < vet.length; i++) {
                    searchStr = vet[i];
                    String ignoreFirstCharacter = "";
                    ignoreFirstCharacter = x.replaceFirst(String.valueOf(getReadFileByID()), "");
                    Scanner scan = new Scanner(new File(ignoreFirstCharacter));
                    while (scan.hasNext()) {
                        String line = scan.nextLine().toLowerCase().toString();
                        if (line.contains(searchStr)) {
                            loadConsolidatedLogFile.add(line);
                        }
                    }
                }
            }
        }
        //calling method that creates a new file consolidating all strings found
        returnSelectedDataInFile();

    }

    //User can choose to search data using specific words, like "java";"logs";data", or
    public void searchForSpecificWords(){
        vet = getWordsToSearchClass().split(";");
    }

    //Using any words and logs default format, like "[logs-java-lang~]", for example
    public void SearchForLogsDefaultFormat(){}

    //Create a new file with required data
    public void returnSelectedDataInFile() throws IOException{
        if (getLogDataFile() != null) {
            Random random = new Random();
            int randomNumber = random.nextInt(100);
            randomNumber += 1;
            String gettingNewFileForLog = "consolidated-logs-" + dateFormat.format(date) + "-" + randomNumber +".log";
            File newFileForLog = new File(getLogDataFile().concat(gettingNewFileForLog));
            FileWriter fWriter = new FileWriter(newFileForLog);
            fWriter.write("========== " + date.toString() + " ==========" + "\n\n");
            for(String x : loadConsolidatedLogFile) {
                fWriter.write(x.toString().concat("\n"));
                fWriter.write("----------------------------------------" + "\n");
            }
            fWriter.close();
            System.out.println("File has been created in: " + newFileForLog);
        }
    }
    //get files with id included formatted to use on return of method readSpecificFilesOption()
    public void showFilesWithIdsIncluded(){
        int count = 0;
        File filesInFolder = new File(getPath());
        File[] listOfFiles = filesInFolder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().contains(".txt")) {
                count++;
                String fullNameWithID = count + file.toString();
                System.out.println("=========================================");
                System.out.println(count + ". " + file.getName());
                System.out.println("=========================================");
            }
        }
    }

    //clear console after submitte some option
    public final void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            e.getMessage();
        }
    }

}
