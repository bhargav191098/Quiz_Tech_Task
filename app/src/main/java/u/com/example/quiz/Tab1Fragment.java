package u.com.example.quiz;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class Tab1Fragment extends Fragment {
    private static final String TAG = "Tab1Fragment";


    private Button btnTEST;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment,container,false);
        SharedPreferences mypref123 = this.getActivity().getSharedPreferences("P1",0);
        SharedPreferences.Editor editor1 = mypref123.edit();
        int first = mypref123.getInt("fc",0);
        int second = mypref123.getInt("sc",0);
        int third = mypref123.getInt("tc",0);
        String nfirst = mypref123.getString("nfc","no_player");
        String nsecond = mypref123.getString("nsc","no_player");
        String nthird = mypref123.getString("ntc","no_player");
        TextView fplace = (TextView)view.findViewById(R.id.first);
        TextView splace = (TextView)view.findViewById(R.id.second);
        TextView tplace = (TextView)view.findViewById(R.id.third);
        fplace.setText("1."+nfirst+" "+first);
        splace.setText("2."+nsecond+" "+second);
        tplace.setText("3."+nthird+" "+third);

        return view;
    }
}
