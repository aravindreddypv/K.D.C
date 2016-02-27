package quiz.kdc.neuromancers.kdc;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Rules extends ActionBarActivity {
    Button button;
    boolean dp=false;
    ActionBarDrawerToggle drawerToggle;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        drawerLayout= (DrawerLayout) findViewById(R.id.drawerlayout);
        drawerToggle=new ActionBarDrawerToggle(Rules.this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });


        drawerLayout.setDrawerListener(drawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        drawerToggle.setDrawerIndicatorEnabled(true);
        Intent i=getIntent();
        if(i!=null) {

            String user = i.getExtras().getString("username");
            BlankFragment blankFragment = (BlankFragment) getSupportFragmentManager().findFragmentById(R.id.navigationdrawer);
            blankFragment.method(user);
        }
        button= (Button) findViewById(R.id.startquiz);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ques_req.question[0] != null) {
                    Intent i = new Intent(Rules.this, Quiz.class);
                    startActivity(i);
                }
                else {
                    Intent i = new Intent(Rules.this, Submited.class);
                    startActivity(i);
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rules, menu);
        return true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if(drawerToggle.onOptionsItemSelected(item))
        {
            return  true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(dp)
        {
            super.onBackPressed();
        }
        this.dp=true;
        Toast.makeText(this,"Press again to exit .",Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dp=false;
            }
        },2000);

    }
}
