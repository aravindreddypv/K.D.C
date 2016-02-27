package quiz.kdc.neuromancers.kdc;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Quiz extends ActionBarActivity implements ActionBar.TabListener {
    ActionBar actionBar;
    ViewPager viewPager;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        viewPager= (ViewPager) findViewById(R.id.vp);
        Slide s=new Slide(getSupportFragmentManager(),viewPager);

        viewPager.setAdapter(s);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                getSupportActionBar().setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        actionBar=getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

 /*       ActionBar.Tab tab1=actionBar.newTab();

        tab1.setText("problem1");
        tab1.setTabListener(this);
        actionBar.addTab(tab1);


        ActionBar.Tab tab2=actionBar.newTab();

        tab2.setText("problem2");
        tab2.setTabListener(this);
        actionBar.addTab(tab2);


        ActionBar.Tab tab3=actionBar.newTab();

        tab3.setText("problem3");
        tab3.setTabListener(this);
        actionBar.addTab(tab3);

        ActionBar.Tab tab4=actionBar.newTab();

        tab4.setText("problem4");
        tab4.setTabListener(this);
        actionBar.addTab(tab4);

        ActionBar.Tab tab5=actionBar.newTab();

        tab5.setText("problem5");
        tab5.setTabListener(this);
        actionBar.addTab(tab5);

*/        actionBar.addTab(actionBar.newTab().setText("problem1").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("problem2").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("problem3").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("problem4").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("problem5").setTabListener(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
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

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

}
