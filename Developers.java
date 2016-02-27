package quiz.kdc.neuromancers.kdc;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Developers extends /*AppCompat*/Activity {
    String[] titles={"P.V.Aravind Reddy","M.V.Shiva Reddy","P.Vineeth Reddy","Venugopal","Rupesh"};
    String[] Description={"Java code and UI Design","Server and Database","Database","Database","Backgrounds"};
    int[] images={R.drawable.my,R.drawable.shiv,R.drawable.v,R.drawable.bgbg,R.drawable.rupu};
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);
        listView= (ListView) findViewById(R.id.listview);
        //getSupportActionBar().hide();
        CustomListAdapter customListAdapter=new CustomListAdapter(this,titles,Description,images);
        listView.setAdapter(customListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Intent i=new Intent();
                    i.setAction(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("https://www.facebook.com/aravindpv.reddy"));
                    startActivity(i);
                }
                if(position==1)
                {
                    Intent i=new Intent();
                    i.setAction(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("https://www.facebook.com/aravindpv.reddy"));
                    startActivity(i);
                }
                if(position==2)
                {
                    Intent i=new Intent();
                    i.setAction(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("https://www.facebook.com/aravindpv.reddy"));
                    startActivity(i);
                }
                if(position==3)
                {
                    Intent i=new Intent();
                    i.setAction(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("https://www.facebook.com/aravindpv.reddy"));
                    startActivity(i);
                }
                if(position==4)
                {
                    Intent i=new Intent();
                    i.setAction(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("https://www.facebook.com/aravindpv.reddy"));
                    startActivity(i);
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_developers, menu);
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
