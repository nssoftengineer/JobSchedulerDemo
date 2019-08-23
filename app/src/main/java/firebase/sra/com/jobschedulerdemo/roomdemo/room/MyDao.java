package firebase.sra.com.jobschedulerdemo.roomdemo.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by neeraj on 9/15/2018.
 */
@Dao
public interface MyDao {

    @Insert
    public void addUser(User user);

    @Update
    public void updateUser(User user);

    @Query("select * from users")
    public List<User> getAllUser();
}
