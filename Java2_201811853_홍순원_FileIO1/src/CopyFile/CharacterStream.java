package CopyFile;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharacterStream {

    public void copyFile() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("원본 파일명(확장자 포함)을 입력하세요 : ");
        String input = scanner.next();

        String path = System.getProperty("user.dir") + "/" + input;

        try(FileReader reader = new FileReader(path);
            FileWriter writer = new FileWriter("output_made_by_characterStream.txt")){
            int c;
            while((c = reader.read()) != -1){
                writer.write(c);
            }
        }
    }
}
