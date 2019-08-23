package firebase.sra.com.jobschedulerdemo.roomdemo.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by dirolabs on 9/15/2018.
 */
@Database(entities = User.class, version = 1)
public abstract class MyAppDatabase extends RoomDatabase {

    public abstract MyDao myDao();
}
