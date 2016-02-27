package quiz.kdc.neuromancers.kdc;

/**
 * Created by aravind on 8/30/2015.
 */
import android.os.AsyncTask;

/**
 * Created by aravind on 8/23/2015.
 */
public class Back extends AsyncTask<String,Void,Boolean> {
    @Override
    protected Boolean doInBackground(String... params) {
        return Login1.get_details(params[0], params[1]);

    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }
}

