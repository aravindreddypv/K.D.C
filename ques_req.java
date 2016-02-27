package quiz.kdc.neuromancers.kdc;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by aravind on 8/30/2015.

 import android.util.Log;

 import org.json.JSONArray;
 import org.json.JSONObject;
 import java.io.BufferedReader;
 import java.io.InputStreamReader;
 import java.io.OutputStreamWriter;
 import java.net.URLConnection;
 import java.net.URLEncoder;

 /**
 * Created by aravind on 8/22/2015.
 */
public class ques_req {
    static  String[] question,opn1,opn2,opn3,opn4,corropn;
    static  String s;
    public static void senddata(String username){
        // TODO Auto-generated method stub
        int k=2;

        URLConnection conn = connection.connect(k);
        if(conn!=null){
            question=new String[5];
            opn1=new String[5];
            opn2=new String[5];
            opn3=new String[5];
            opn4=new String[5];
            corropn=new String[5];
            try{
                String data  = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8");
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                wr.write( data );
                wr.flush();

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line = null;


                // Read Server Response
                while((line = reader.readLine()) != null)
                {
                    sb.append(line);
                    break;
                }
                String value=sb.toString();
                s=value;
                Log.d("shiva7", value);
                JSONArray arr=new JSONArray(value);
                for(int i=0;i<arr.length();i++){
                    JSONObject eachset=arr.getJSONObject(i);
                    question[i]=eachset.getString("question");
                    opn1[i]=eachset.getString("opn1");
                    opn2[i]=eachset.getString("opn2");
                    opn3[i]=eachset.getString("opn3");
                    opn4[i]=eachset.getString("opn4");
                    corropn[i]=eachset.getString("corropn");

                }


            }
            catch(Exception e){
                Log.d("connerr","Exception: " + e.getMessage());

            }


        }

    }


}

