import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        LogAnalyzer analyzer = new LogAnalyzer();
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a dir with txt files: ");
        String FilesPath = scan.nextLine();
        analyzer.Path = FilesPath;
        analyzer.LogDataFile = FilesPath;
        analyzer.ReadDirectoryFiles();
        System.out.println("\n");
        System.out.println("Enter words you'r looking for. Ex: word1;word2: ");
        String getWordsToSearch = scan.nextLine();
        analyzer.getWordsToSearchClass = getWordsToSearch;
        analyzer.SearchForSpecificWords();
        analyzer.ReadAllFilesOption();;
        //analyzer.ReadSpecificFilesOption();
    }
}
