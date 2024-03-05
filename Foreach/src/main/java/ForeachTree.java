import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ForeachTree {
    public String makeForeachTree(File src, String indent) throws IOException{
        if (null == src || !src.exists()) {
            return "";
        }

        String ans = indent + src.getName() + ':' + NiceResize.resize(getFolderSize(src.toPath().toString())) + "\n";
        if (src.isDirectory()) {
            indent += "──";
            for (File sub : src.listFiles()) {
                ans += makeForeachTree(sub, indent);
            }
        }
        return ans;
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
