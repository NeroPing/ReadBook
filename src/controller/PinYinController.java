package controller;
import net.sourceforge.pinyin4j.PinyinHelper;


import java.io.IOException;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;


public class PinYinController {
    public static void main(String[] args){
        char cStr = '我';
        String[] cStrHY = PinyinHelper.toHanyuPinyinStringArray(cStr);
        for (String s : cStrHY) {
            System.out.println("pinyin  " + s);

        }


        ActiveXComponent sap = new ActiveXComponent("Sapi.SpVoice");

        Dispatch sapo = sap.getObject();
        try {

            // 音量 0-100
            sap.setProperty("Volume", new Variant(100));
            // 语音朗读速度 -10 到 +10
            sap.setProperty("Rate", new Variant(2));


            // 执行朗读
            Dispatch.call(sapo, "Speak", new Variant("汪**，你是个大傻逼"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sapo.safeRelease();
            sap.safeRelease();
        }
    }
}
