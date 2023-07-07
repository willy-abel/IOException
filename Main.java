import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class Main {
    public static String readFile(File file) throws IOException {
        try (FileReader fr = new FileReader(file)) {
            char[] chars = new char[(int) file.length()];

            int offset = 0;
            while (offset < chars.length) {
                int result = fr.read(chars, offset, chars.length - offset);
                if (result == -1) {
                    break;
                }
                offset += result;
            }
            return new String(chars);
        }
    }

    public static void main(String[] args) {
        File file = new File("doc.txt");

        String content = null;
        try {
            content = readFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(content);
    }
}