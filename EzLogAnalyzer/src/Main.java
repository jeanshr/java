import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        LogAnalyzer anl = new LogAnalyzer();
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a dir with txt files: ");
        String filesPath = scan.nextLine();
        anl.setPath(filesPath);
        anl.setLogDataFile(filesPath);
        anl.clearConsole();
        System.out.println("\n");
        anl.readDirectoryFiles();
        anl.clearConsole();
        System.out.println("\n");
        System.out.println("Enter words you'r looking for. Ex: word1;word2: ");
        String getWordsToSearch = scan.nextLine();
        anl.setWordsToSearchClass(getWordsToSearch);
        anl.searchForSpecificWords();
        anl.clearConsole();
        System.out.println("\n");
        System.out.println("Do you wanna read:" + "\n" + "(1) - all listed files or" + "\n" + "(2) - a specific one? ");
        int chooseWhatFilesRead = scan.nextInt();
        anl.setChooseWhatFilesRead(chooseWhatFilesRead);
        if (anl.getChooseWhatFilesRead() == 1)
        { anl.readAllFilesOption(); }
        if (anl.getChooseWhatFilesRead() == 2){
            anl.showFilesWithIdsIncluded();
            System.out.println("\n");
            System.out.println("Inform file ID: ");
            int readFileByID = scan.nextInt();
            anl.setReadFileByID(readFileByID);
            anl.readSpecificFilesOption();
        }
        else{System.out.println("Invalid option.");}
    }
}
