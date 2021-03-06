package org.smartregister.chw.hf.listener;

import android.app.Activity;
import android.view.View;

import org.jetbrains.annotations.Contract;
import org.smartregister.chw.hf.activity.ReferralTaskViewActivity;
import org.smartregister.commonregistry.CommonPersonObjectClient;
import org.smartregister.domain.Task;

/**
 * Created by wizard on 06/08/19.
 */
public class ReferralRecyclerClickListener implements View.OnClickListener {
    private Task task;
    private CommonPersonObjectClient commonPersonObjectClient;
    private Activity activity;
    private String startingActivity;

    @Override
    public void onClick(View view) {
        ReferralTaskViewActivity.startReferralTaskViewActivity(getActivity(), getCommonPersonObjectClient(), getTask(), getStartingActivity());
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Contract(pure = true)
    private CommonPersonObjectClient getCommonPersonObjectClient() {
        return commonPersonObjectClient;
    }

    public void setCommonPersonObjectClient(CommonPersonObjectClient commonPersonObjectClient) {
        this.commonPersonObjectClient = commonPersonObjectClient;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Contract(pure = true)
    private String getStartingActivity() {
        return startingActivity;
    }

    public void setStartingActivity(String startingActivity) {
        this.startingActivity = startingActivity;
    }
}
