package quiz.kdc.neuromancers.kdc;

/**
 * Created by aravind on 8/30/2015.
 */

import android.util.Log;

import java.net.URL;
import java.net.URLConnection;
/**
 * Created by aravind on 8/22/2015.
 */

public class connection {




    public static URLConnection connect(int k){
        // TODO Auto-generated method stub
        URLConnection con= null;
        try{
            String link=null;
            if(k==0)
                link="http://vineethdatabase.site40.net/login.php";
            if(k==1)
                link="http://vineethdatabase.site40.net/signup.php";
            if(k==2)
                link="http://vineethdatabase.site40.net/ques_req.php";
            if(k==3){
                link="http://vineethdatabase.site40.net/scoreadd.php";Log.d("shivaa", "add score ");}
            URL url = new URL(link);
            URLConnection conn = url.openConnection();

            conn.setDoOutput(true);
            con=conn;

        }
        catch(Exception e){
            Log.d("connerr", "Exception: " + e.getMessage());
        }
        return con;


    }
}



