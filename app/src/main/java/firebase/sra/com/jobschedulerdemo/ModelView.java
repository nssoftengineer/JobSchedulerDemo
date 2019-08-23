package firebase.sra.com.jobschedulerdemo;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.view.View;

import java.util.Observable;

/**
 * Created by neeraj on 9/14/2018.
 */

public class ModelView extends Observable {

    private ModelData modelData;
    private Context context;

    public ModelView(ModelData modelData) {
        this.modelData = modelData;
    }

    public ModelView(Context context) {
        this.context = context;
    }

    public int getModelData() {
        return modelData.getPrintData();
    }



    public void onClickFab(View view) {


        ComponentName componentName = new ComponentName(context, JobServices.class);
        JobInfo info = new JobInfo.Builder(123, componentName)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setRequiresCharging(true)
                .setPersisted(true)
                .setPeriodic(15 * 60 * 1000)
                .build();

        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
        jobScheduler.schedule(info);
    }


}
