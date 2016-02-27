package quiz.kdc.neuromancers.kdc;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;


public class Spalshscreen extends ActionBarActivity {
    ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalshscreen);
        getSupportActionBar().hide();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //ViewGroup.LayoutParams layoutParams=new ViewGroup.LayoutParams(im.getWidth(),im.getHeight());

                Intent i = new Intent(Spalshscreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 2000);

/*       Thread logoTimer = new Thread() {

            public void run() {
                try {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            RotateAnimation rotateAnimation = new RotateAnimation(0f, 360f, 82f, 82f);
                            rotateAnimation.setInterpolator(new LinearInterpolator());
                            rotateAnimation.setRepeatCount(Animation.INFINITE);
                            rotateAnimation.setDuration(1000);
                            im.startAnimation(rotateAnimation);

                        }
                    });
                    sleep(2000);

                    /*Looper.prepare();
                    ProgressDialog progressDialog  = new ProgressDialog(Spalshscreen.this);
                    progressDialog.setMessage("Wait..");

                    progressDialog.setCancelable(false);
                    progressDialog.show();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    Intent splashIntent = new Intent(Spalshscreen.this,MainActivity.class);
                    startActivity(splashIntent);
                    finish();
                }
            }

        };
        logoTimer.start();

    }*/
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_spalshscreen, menu);
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
