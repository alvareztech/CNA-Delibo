package tech.alvarez.delibo.util;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

public class Util {

    public static String leerJSON(Context context) {
        String json = null;
        try {
            InputStream inputStream = context.getAssets().open("comida.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
