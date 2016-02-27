package quiz.kdc.neuromancers.kdc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    DrawerLayout mdrawerlayout;
    int count=0;
    String[] s={"Rules","Quiz","Developers","Sign Out"};
    ActionBarDrawerToggle actionBarDrawerToggle;
    ListView listView;
    View view;
    String s1;
    TextView ed;
    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_blank, container, false);
        listView = (ListView) view.findViewById(R.id.list);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,s );
        ed= (TextView) view.findViewById(R.id.tv1);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    count++;
                    Activity activity = getActivity();
                    Intent i = new Intent(getActivity(), Rules.class);
                    i.putExtra("username", s1);
                    startActivity(i);
                    if (count != 0) {
                        activity.finish();
                        count = 0;
                    }
                } else if (position == 1) {
                    {
                        //Log.d("shiva8",ques_req.question[0]);
                        if (ques_req.question[0] != null) {
                            Intent i = new Intent(getActivity(), Quiz.class);
                            startActivity(i);

                        } else {
                            Intent i = new Intent(getActivity(), Submited.class);
                            startActivity(i);

                        }
                    }

                } else if (position == 3) {
                    Activity activity1 = getActivity();
                    activity1.finish();
                    Intent i = new Intent(getActivity(), MainActivity.class);
                    startActivity(i);
                } else if (position == 2) {

                    Intent i = new Intent(getActivity(), Developers.class);
                    startActivity(i);
                }

            }
        });
        return view;
    }
    public void method(String s)
    {
        s1=s;
        ed.setText(s);
    }



}
