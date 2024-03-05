import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;

public class ForeachTree {
    public String makeForeachTree(File src, String indent) throws IOException{
        if (null == src || !src.exists()) {
            return "";
        }

        double size = getFolderSize(src.toPath().toString());
        String shortSize = " " + size + " B";
        DecimalFormat dSize = new DecimalFormat("0.#");
        if (size / 1024 >= 1) {
            size /= 1024;
            shortSize = " " + dSize.format(size) + " KB";
        }
        if (size / 1024 >= 1) {
            size /= 1024;
            shortSize = " " + dSize.format(size) + " MB";
        }

        String ans = indent + src.getName() + ':' + shortSize + "\n";
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
