package quiz.kdc.neuromancers.kdc;


import android.app.ProgressDialog;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Password extends AppCompatActivity {
    EditText pass, repass;
    Button b;
    ProgressDialog progressDialog1;
    String s1, s2, s3, s4, s5, s6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        pass = (EditText) findViewById(R.id.password);
        repass = (EditText) findViewById(R.id.rpassword);
        b = (Button) findViewById(R.id.sp);
        progressDialog1 = new ProgressDialog(Password.this);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkConnected1()) {
                    if ((!pass.getText().toString().equals("")) && (!repass.getText().toString().equals(""))) {
                        if (pass.getText().toString().equals(repass.getText().toString())) {
                            if (pass.getText().toString().length() >= 8) {
                                Intent i1 = getIntent();
                                s1 = (String) i1.getExtras().getString("username");
                                s2 = (String) i1.getExtras().getString("name");
                                s3 = (String) i1.getExtras().getString("email");
                                s4 = (String) i1.getExtras().getString("phno");
                                s6 = i1.getExtras().getString("rollno");
                                s5 = pass.getText().toString();

                                progressDialog1.setMessage("Loading....");
                                progressDialog1.setIndeterminate(true);
                                progressDialog1.setCancelable(false);
                                progressDialog1.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                                progressDialog1.show();

                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        signup.registration(s1, s5, s6, s2, s3, s4);
                                        if(signup.dbin.contains("false"))
                                        {
                                            showtoast1();
                                        }
                                        if(signup.dbin.contains("true"))
                                        {
                                            showtoast2();
                                        }


                                    }

                                }).start();
                                Intent i = new Intent(Password.this, MainActivity.class);
                                startActivity(i);
                                progressDialog1.dismiss();
                                finish();
                            } else {
                                Toast.makeText(Password.this, "Password must be minimum 8 charecters", Toast.LENGTH_SHORT).show();
                            }
                            //Intent i = new Intent(Password.this, MainActivity.class);
                            //startActivity(i);
                        } else
                            Toast.makeText(Password.this, "Password did not match", Toast.LENGTH_SHORT).show();

                    } else
                        Toast.makeText(Password.this, "Every field should be filled", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Password.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_password, menu);
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

    public boolean isNetworkConnected1() {
        ConnectivityManager connectivityManager1 = (ConnectivityManager) this.getSystemService(this.CONNECTIVITY_SERVICE);
        return connectivityManager1.getActiveNetworkInfo() != null && connectivityManager1.getActiveNetworkInfo().isConnected();
    }

    public void showtoast1() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(Password.this, "User name already exists Register again", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void showtoast2()
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(Password.this, "Registered", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
