package firebase.sra.com.jobschedulerdemo.roomdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import firebase.sra.com.jobschedulerdemo.R;
import firebase.sra.com.jobschedulerdemo.roomdemo.room.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class InsertDataFragment extends Fragment {


    public InsertDataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_insert_data, container, false);
        final EditText editText=(EditText)view.findViewById(R.id.editName);
        ((Button) view.findViewById(R.id.save)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             MainActivityRoom.myAppDatabase.myDao().addUser(new User(editText.getText().toString()));
                Toast.makeText(getActivity(), "Added", Toast.LENGTH_SHORT).show();
            }
        });



        return view;
    }

}
