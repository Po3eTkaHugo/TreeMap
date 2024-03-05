import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException  {
        VirtualScreen scan = new VirtualScreen();
        String path = "D:/VISTAR/TreeSizeCount";
        File parent = new File(path);

        scan.makeForeachTree(parent, "");
    }
}
