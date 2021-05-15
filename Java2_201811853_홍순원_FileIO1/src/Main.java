import java.io.IOException;
import CopyFile.ByteStream;
import CopyFile.CharacterStream;

public class Main {
    public static void main(String[] args) throws IOException {
        //과제 1 : try-with-resource사용 및 " "제거한 output.txt 생성
        ByteStream byteStream = new ByteStream();
        byteStream.copyFile("input.txt");

        //과제 2 : try-with-resource 사용 및 파일명을 입력 받아 output.txt를 생성
        CharacterStream characterStream = new CharacterStream();
        characterStream.copyFile();
    }
}
