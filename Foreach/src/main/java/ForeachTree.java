import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ForeachTree {
    public void printName(File src) throws IOException{
        if (null == src || !src.exists()) {
            return ;
        }

        System.out.println(src.getAbsolutePath() + ": " + getFolderSize(src.toPath().toString()));
        if (src.isDirectory()) {
            for (File sub : src.listFiles()) {
                printName(sub);
            }
        }
    }

    public long getFolderSize(String path) throws IOException {
        Path folder = Paths.get(path);
        return Files.walk(folder)
                .map(Path::toFile)
                .filter(File::isFile)
                .mapToLong(File::length)
                .sum();
    }
}
