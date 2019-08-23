package firebase.sra.com.jobschedulerdemo.roomdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import firebase.sra.com.jobschedulerdemo.MainActivity;
import firebase.sra.com.jobschedulerdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_main, container, false);
        ((Button) view.findViewById(R.id.addData)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();
            }
        });
        ((Button) view.findViewById(R.id.viewData)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showData();
            }
        });
        return view;
    }

    public void addData()
    {
        MainActivityRoom.fragmentManager.beginTransaction().replace(R.id.loadFragment,new InsertDataFragment()).addToBackStack(null).commit();
    }

    public void showData()
    {
        MainActivityRoom.fragmentManager.beginTransaction().replace(R.id.loadFragment,new GetDataFragment()).addToBackStack(null).commit();
    }

}
