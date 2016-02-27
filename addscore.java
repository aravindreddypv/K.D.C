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
public class addscore {

    public static void getscore(int score,String username) {

        // TODO Auto-generated method stub
        Log.d("shivaaaa",Integer.toString(score));

        String marks=Integer.toString(score);
        int k=3;
        URLConnection conn = connection.connect(k);
        if(conn!=null){
            try{
                String data  = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8");Log.d("shivaa", "add score started");
                data  += "&" + URLEncoder.encode("marks", "UTF-8") + "=" + URLEncoder.encode(marks, "UTF-8");Log.d("shivaa", "add score ");
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());Log.d("shivaa", "add score f");
                wr.write(data);Log.d("shivaa", "add score flushed");
                wr.flush();Log.d("shivaa", "add score flushed");


                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line = null;


                // Read Server Response
                while((line = reader.readLine()) != null)
                {
                    sb.append(line);
                    break;
                }String s=sb.toString();
                Log.d("shivaa",s);
            }
            catch(Exception e){
                Log.d("connerr", "Exception: " + e.getMessage());
            }
        }
    }


}
