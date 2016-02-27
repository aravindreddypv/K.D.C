package quiz.kdc.neuromancers.kdc;


import android.os.Bundle;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class prob4 extends Fragment {

    TextView question;
    static  RadioGroup rg;
    View view;
    RadioButton r1,r2,r3,r4;

    public prob4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_prob4, container, false);
        question= (TextView) view.findViewById(R.id.aa);
        question.setText(ques_req.question[3]);
        rg= (RadioGroup) view.findViewById(R.id.radiogroup4);
        r1= (RadioButton) view.findViewById(R.id.rb1);
        r2= (RadioButton) view.findViewById(R.id.rb2);
        r3= (RadioButton) view.findViewById(R.id.rb3);
        r4= (RadioButton) view.findViewById(R.id.rb4);
        r1.setText(ques_req.opn1[3]);
        r2.setText(ques_req.opn2[3]);
        r3.setText(ques_req.opn3[3]);
        r4.setText(ques_req.opn4[3]);

        return  view;
    }
    public  static  int getnumber() {
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

}
