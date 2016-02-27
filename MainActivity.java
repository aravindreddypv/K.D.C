package quiz.kdc.neuromancers.kdc;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    String[] q,o1,o2,o3,o4,co;
    Button b;
    TextView b2;
    Boolean b1=false;
    ProgressDialog progressDialog;
    TextView tv;
    EditText e1, e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //toolbar= (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        tv = (TextView) findViewById(R.id.register);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Register.class);
                startActivity(i);
            }
        });
        e1 = (EditText) findViewById(R.id.username);
        e2 = (EditText) findViewById(R.id.password);
        b = (Button) findViewById(R.id.st);
        b2= (TextView) findViewById(R.id.fp);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Contact.class);
                startActivity(i);
            }
        });
        progressDialog=new ProgressDialog(MainActivity.this);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkConnected()) {
                    //progressDialog.setTitle("Wait");
                    progressDialog.setMessage("Loading....");
                    progressDialog.setIndeterminate(true);
                    progressDialog.setCancelable(false);
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    progressDialog.show();
                    //  Login1 login1=new Login1();
                    //login1.get_details(e1.getText().toString(),e2.getText().toString());
                    //boolean b = Login1.get_details(e1.getText().toString(), e2.getText().toString());
                    //Back ba=new Back();
                    //Boolean b1= ba.doInBackground(e1.getText().toString(), e2.getText().toString());
                    //Login1.getdetails(e1.getText().toString(), e2.getText().toString());
                    if ((!e1.getText().toString().equals("")) && (!e2.getText().toString().equals(""))) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                b1 = Login1.get_details(e1.getText().toString(), e2.getText().toString());
                                Log.d("shiva2", Boolean.toString(b1));

                                if (b1) {
                                    ques_req.senddata(e1.getText().toString());

                                    prob5.getusername(e1.getText().toString());
                                    Intent i = new Intent(MainActivity.this, Rules.class);
                                    i.putExtra("username", e1.getText().toString());
                                    startActivity(i);
                                    finish();
                                    progressDialog.dismiss();
                                    finish();

                                } else {
                                    progressDialog.dismiss();


                                    //toast();
                                    showtoast();
                                    //Toast.makeText(MainActivity.this,"Wrong Credentials",Toast.LENGTH_SHORT).show();

                                }
                            }
                        }).start();

                    } else {
                        Toast.makeText(MainActivity.this, "User name / Password should not be empty", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                }
                else
                    Toast.makeText(MainActivity.this,"No Internet Connection",Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }


    public void showtoast()
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,"Wrong credentials",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public  boolean isNetworkConnected()
    {
        ConnectivityManager connectivityManager= (ConnectivityManager) this.getSystemService(this.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo()!=null &&connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
