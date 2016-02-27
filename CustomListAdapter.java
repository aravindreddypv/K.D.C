package quiz.kdc.neuromancers.kdc;

/**
 * Created by aravind on 8/30/2015.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by aravind on 8/21/2015.
 */
public class CustomListAdapter extends ArrayAdapter {
    Context c;
    int[] imgs;
    String[] tl;
    String[] t2;
    public CustomListAdapter(Context context,String[] title,String[] Descrip,int[] images) {
        super(context,R.layout.row,R.id.title,title);
        this.c=context;
        this.imgs=images;
        this.tl=title;
        this.t2=Descrip;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.row,parent,false);
        ImageView imageView= (ImageView) view.findViewById(R.id.imagetitle);
        TextView textView= (TextView) view.findViewById(R.id.title);
        TextView textView1=(TextView)view.findViewById(R.id.description);
        imageView.setImageResource(imgs[position]);
        textView.setText(tl[position]);
        textView1.setText(t2[position]);

        return view;
    }


}
