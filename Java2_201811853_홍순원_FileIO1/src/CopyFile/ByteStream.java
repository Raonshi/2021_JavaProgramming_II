package CopyFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStream {

    public void copyFile(String fileName) throws IOException {
        String path = System.getProperty("user.dir") + "/" + fileName;

        try(FileInputStream in = new FileInputStream(path);
            FileOutputStream out = new FileOutputStream("output_made_by_byteStream.txt")){
            int c;
            while((c = in.read()) != -1){
                char ch = (char)c;
                if(c == ' ') {
                    continue;
                }
                out.write(c);
            }//end of while
        }//end of try
    }
}
