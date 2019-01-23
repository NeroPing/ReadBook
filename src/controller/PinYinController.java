package controller;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class PinYinController {

  public static void main(String[] args) {
    ActiveXComponent sap = new ActiveXComponent("Sapi.SpVoice");

    Dispatch sapo = sap.getObject();

    // 音量 0-100
    sap.setProperty("Volume", new Variant(100));
    // 语音朗读速度 -10 到 +10
    sap.setProperty("Rate", new Variant(2));

    File file = new File("test.txt");
    if (file.exists()) {
      InputStreamReader reader = null;
      BufferedReader in = null;
      try {
        reader = new InputStreamReader(new FileInputStream(file));
        in = new BufferedReader(reader);
        while (true) {
          String str = in.readLine();
          if (str == null) {
            break;
          }
          // 执行朗读
          Dispatch.call(sapo, "Speak", new Variant(str));
        }
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        sapo.safeRelease();
        sap.safeRelease();
        try {
          in.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
