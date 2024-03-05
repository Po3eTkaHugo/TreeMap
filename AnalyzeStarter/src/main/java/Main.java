import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException  {
        SimpleGUI app = new SimpleGUI();
        app.setVisible(true);
        String path = "D:/VISTAR/TreeSizeCount";
        File parent = new File(path);

       // app.makeForeachTree(parent, "");
    }
}
