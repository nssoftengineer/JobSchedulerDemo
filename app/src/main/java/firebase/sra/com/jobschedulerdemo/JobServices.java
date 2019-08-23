package firebase.sra.com.jobschedulerdemo;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.util.Log;

/**
 * Created by neeraj on 9/14/2018.
 */

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class JobServices extends JobService {
    private boolean jobCanceled = false;
    private static final String TAG = "JobServices";

    @Override
    public boolean onStartJob(final JobParameters params) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                    for (int i = 0; i < 20; i++) {
                        if(jobCanceled)
                            return;
                        Log.d(TAG, "Job Started: " + i);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                jobFinished(params,false);
                Log.d(TAG, "Job Finished:");
            }
        }).start();


        return true;
    }


    @Override
    public boolean onStopJob(JobParameters params) {
        Log.d(TAG, "Job canceled before done: ");
        jobCanceled = true;
        return true;
    }
}
