package quiz.kdc.neuromancers.kdc;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends ActionBarActivity {
    EditText username,name,email,phno,roll;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username= (EditText) findViewById(R.id.un);
        name= (EditText) findViewById(R.id.n);
        email= (EditText) findViewById(R.id.ei);
        phno= (EditText) findViewById(R.id.pn);
        b= (Button) findViewById(R.id.regi1);
        roll= (EditText) findViewById(R.id.rn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((!username.getText().toString().equals(""))&&(!name.getText().toString().equals("")) && (!email.getText().toString().equals("")) &&(!phno.getText().toString().equals("")) && (!roll.getText().toString().equals("")))
                {
                    if(phno.getText().toString().length()!=10)
                    {
                        Toast.makeText(Register.this,"Enter a valid phone number",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if (email.getText().toString().contains("@gmail.com")|| email.getText().toString().contains("@iitbbs.ac.in")) {
                            Intent i;
                            i = new Intent(Register.this, Password.class);
                            Log.d("aravindreddy", "Intent created");
                            i.putExtra("username", username.getText().toString());
                            i.putExtra("name", name.getText().toString());
                            i.putExtra("email", email.getText().toString());
                            i.putExtra("phno", phno.getText().toString());
                            i.putExtra("rollno", roll.getText().toString());
                            startActivity(i);
                            Log.d("aravindreddy", "Activity created");
                            finish();
                        }
                        else
                        {
                            Toast.makeText(Register.this,"Invalid Email-id",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                else {
                    Toast.makeText(Register.this,"Every field should be filled",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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
}
