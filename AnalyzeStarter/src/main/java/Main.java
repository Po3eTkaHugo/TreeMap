import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException  {
        ForeachTree scan = new ForeachTree();
        String path = "D:/VISTAR/TreeSizeCount";
        File parent = new File(path);

        scan.makeForeachTree(parent, "");
    }
}
