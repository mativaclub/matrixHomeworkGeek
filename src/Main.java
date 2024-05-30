import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        final File folderSource = new File("./src/testDirectory");
        final File folderDestination = new File("./src/backup");
        if (!folderDestination.exists()) {
            folderDestination.mkdir();
        }
        copyFilesToFolder(folderSource, folderDestination);

    }

    public static void copyFilesToFolder(final File folderSource, final File folderDestination) throws IOException {
        for (final File file : folderSource.listFiles()) {
            String nameOfFile = folderDestination.getAbsolutePath() + "/" + file.getName();
            if (file.isDirectory()) {
                File newDestination = new File(nameOfFile);
                newDestination.mkdir();
//                copyFilesToFolder(file, newDestination);
            } else {
                Files.copy(file.toPath(), Path.of(nameOfFile));
            }
        }
    }


}