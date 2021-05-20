import java.util.HashMap;
import java.util.Map;

public class WordSet {
    Map<String, String> dic = new HashMap();

    public WordSet(){
        dic.put("java", "자바");
        dic.put("apple", "사과");
        dic.put("dog", "개");
        dic.put("cat", "고양이");
        dic.put("lion", "사자");
        dic.put("tiger", "호랑이");
        dic.put("ant", "개미");
        dic.put("tree", "나무");
        dic.put("fire", "불");
        dic.put("water", "물");
    }
}
