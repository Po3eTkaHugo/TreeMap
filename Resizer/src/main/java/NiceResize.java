import java.text.DecimalFormat;

public class NiceResize {
    public static String resize(double size) {
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
        if (size / 1024 >= 1) {
            size /= 1024;
            shortSize = " " + dSize.format(size) + " GB";
        }

        return shortSize;
    }
}
