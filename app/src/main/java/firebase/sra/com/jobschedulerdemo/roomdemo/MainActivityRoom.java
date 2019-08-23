package firebase.sra.com.jobschedulerdemo.roomdemo;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import firebase.sra.com.jobschedulerdemo.R;
import firebase.sra.com.jobschedulerdemo.roomdemo.room.MyAppDatabase;

public class MainActivityRoom extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_room);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fragmentManager= getSupportFragmentManager();
        myAppDatabase= Room.databaseBuilder(this,MyAppDatabase.class,"user_id").allowMainThreadQueries().build();
        if(findViewById(R.id.loadFragment)!=null)
        {
            if(savedInstanceState!=null)
            {
                return;
            }

            fragmentManager.beginTransaction().add(R.id.loadFragment,new MainFragment()).commit();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
