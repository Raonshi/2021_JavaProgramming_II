import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionReader {
    public static void main(String[] arg) throws Exception{
        //URL객체 생성
        URL site = new URL("http://www.naver.com");
        //URL객체를 통해 서버 연결
        URLConnection url = site.openConnection();

        //읽기 버퍼 생성
        //서버 연결 객체의 스트림을 읽어온다.
        BufferedReader in = new BufferedReader(new InputStreamReader(url.getInputStream()));
        String inLine;

        //inLine에 url의 1줄씩 저장한 뒤 출력
        while((inLine = in.readLine()) != null)
        {
            System.out.println(inLine);
        }
        in.close();
    }
}
