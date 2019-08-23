package firebase.sra.com.jobschedulerdemo.roomdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import firebase.sra.com.jobschedulerdemo.R;
import firebase.sra.com.jobschedulerdemo.roomdemo.room.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class GetDataFragment extends Fragment {


    public GetDataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_get_data, container, false);
        TextView textView=(TextView)view.findViewById(R.id.textData);

        List<User> users=MainActivityRoom.myAppDatabase.myDao().getAllUser();

        String string = "";
        for(User urs:users)
        {
            string+=urs.getName()+"\n\n";
            textView.setText(string);
        }
        return view;
    }

}
