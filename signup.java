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
public class signup {
    public static String dbin;
    public static void registration(String username,String password, String roll,String name, String email,String phone) {
        // TODO Auto-generated method stub
        int k=1;
        URLConnection conn = connection.connect(k);
        if(conn!=null){
            try{
			 /*String username = "admin";
	         String password = "admin";
	         String roll="roll1";
	         String name="name";
	         String email="email";
	         String phone="1234567890";*/
                String data  = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8");
                data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                data += "&" + URLEncoder.encode("roll", "UTF-8") + "=" + URLEncoder.encode(roll, "UTF-8");
                data += "&" + URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8");
                data += "&" + URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8");
                data += "&" + URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(phone, "UTF-8");
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                wr.write( data );
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
                dbin=s;

            }
            catch(Exception e){
                Log.d("connerr", "Exception: " + e.getMessage());
            }
        }

    }

}

