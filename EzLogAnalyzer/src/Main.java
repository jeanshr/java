import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        LogAnalyzer analyzer = new LogAnalyzer();
        String Path = "/home/jecunha/workspace/github/java/eclipse-workspace/Files/";
        analyzer.ReadDirectoryFiles();
        analyzer.ReadAllFilesOption();
        analyzer.ReadAllFilesOption();
        analyzer.ReturnSelectedDataInFile();
    }
}
