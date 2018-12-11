package controller;
import net.sourceforge.pinyin4j.PinyinHelper;

public class PinYinController {
    public static void main(String[] args){
        char cStr = '我';
        String[] cStrHY = PinyinHelper.toHanyuPinyinStringArray(cStr);
        for (String s : cStrHY) {
            System.out.println("pinyin  " + s);

        }
    }
}
