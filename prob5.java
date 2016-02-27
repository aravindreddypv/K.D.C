package quiz.kdc.neuromancers.kdc;


import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class prob5 extends Fragment {
    int count=0;
    TextView question;
    static RadioGroup rg;
    View view;
    Button b;
    int a[]=new int[5];
    String[] cp;
    static String username;
    RadioButton r1,r2,r3,r4;
    public prob5() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_prob5, container, false);
        question= (TextView) view.findViewById(R.id.aa);
        question.setText(ques_req.question[4]);
        rg= (RadioGroup) view.findViewById(R.id.radiogroup5);
        r1= (RadioButton) view.findViewById(R.id.rb1);
        r2= (RadioButton) view.findViewById(R.id.rb2);
        r3= (RadioButton) view.findViewById(R.id.rb3);
        r4= (RadioButton) view.findViewById(R.id.rb4);
        r1.setText(ques_req.opn1[4]);
        r2.setText(ques_req.opn2[4]);
        r3.setText(ques_req.opn3[4]);
        r4.setText(ques_req.opn4[4]);

        b= (Button) view.findViewById(R.id.st);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkConnected()) {
                    // prob1 p1=new prob1();
                    a[0] = prob1.getnumber();
                    Log.d("shivaa", Integer.toString(a[0]));
                    //prob2 p2=new prob2();
                    a[1] = prob2.getnumber();
                    Log.d("shivaa", Integer.toString(a[1]));
                    //prob3 p3=new prob3();
                    a[2] = prob3.getnumber();
                    Log.d("shivaa", Integer.toString(a[2]));
                    //prob4 p4=new prob4();
                    a[3] = prob4.getnumber();
                    Log.d("shivaa", Integer.toString(a[3]));

                    // prob1 p1=new prob1();
                    a[4] = prob5.getnumber();
                    Log.d("shivaa", Integer.toString(a[4]));
                    cp = ques_req.corropn;
                    if (a[0] == Integer.parseInt(cp[0])) {
                        count = count + 5;

                    } else if (a[0] == 0) {

                    } else {
                        count = count - 1;
                    }
                    if (a[1] == Integer.parseInt(cp[1])) {
                        count = count + 5;
                    } else if (a[1] == 0) {

                    } else {
                        count = count - 1;
                    }
                    if (a[2] == Integer.parseInt(cp[2])) {
                        count = count + 5;
                    } else if (a[2] == 0) {

                    } else {
                        count = count - 1;
                    }
                    if (a[3] == Integer.parseInt(cp[3])) {
                        count = count + 5;
                    } else if (a[3] == 0) {

                    } else {
                        count = count - 1;
                    }
                    if (a[4] == Integer.parseInt(cp[4])) {
                        count = count + 5;
                    } else if (a[4] == 0) {

                    } else {
                        count = count - 1;
                    }
                    //Toast.makeText(getActivity(), Integer.toString(count), Toast.LENGTH_SHORT).show();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            addscore.getscore(count, username);
                        }
                    }).start();
                    getActivity().finish();
                    Intent i = new Intent(getActivity(), Submited.class);
                    startActivity(i);
                    ques_req.question[0] = null;
                }
                else
                {
                    Toast.makeText(getActivity(),"No Internet connection ",Toast.LENGTH_SHORT).show();
                }
            }
        });



        return  view;
    }
    public static   int getnumber() {
        int bi = rg.getCheckedRadioButtonId();
        if (bi == R.id.rb1) {
            return 1;
        } else if (bi == R.id.rb2) {
            return 2;
        } else if (bi == R.id.rb3) {
            return 3;
        } else if (bi == R.id.rb4) {
            return 4;
        }
        return 0;

    }
    public static void getusername(String s)
    {
        username=s;
    }

    public  boolean isNetworkConnected()
    {
        ConnectivityManager connectivityManager= (ConnectivityManager) getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo()!=null &&connectivityManager.getActiveNetworkInfo().isConnected();
    }

}
