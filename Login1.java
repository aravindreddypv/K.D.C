package quiz.kdc.neuromancers.kdc;

/**
 * Created by aravind on 8/30/2015.
 */
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by aravind on 8/22/2015.
 */
public class Login1 {

    public static boolean get_details(String username,String password) {
        // TODO Auto-generated method stub
        boolean b=false;
        int k = 0;
        URLConnection conn = connection.connect(k);
        if(conn==null)
            Log.d("ar","Connection error");

        if (conn != null) {
            try {
                // String username = "username";
                //String password = "password";
                Log.d("shiva","connected to internet");
                String data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8");
                data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());Log.d("shivaa", "add score ");
                // b=true;
                wr.write(data);
                wr.flush();

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line = null;


                // Read Server Response
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                    break;
                }


                String s = sb.toString();
                Log.d("shiva1",s);


                if (s.contains("true")) {
                    b=true;

                } else
                    b=false;
                Log.d("shiva4",Boolean.toString(b));

            } catch (Exception e) {
                Log.d("connerr", "Exception: " + e.getMessage());

            }
            return b;

        }
        else
            return false;
    }

}
