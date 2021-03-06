package org.smartregister.chw.hf.sync.helper;

import org.smartregister.CoreLibrary;
import org.smartregister.chw.core.utils.CoreConstants;
import org.smartregister.chw.hf.BuildConfig;
import org.smartregister.location.helper.LocationHelper;
import org.smartregister.repository.TaskRepository;
import org.smartregister.sync.helper.TaskServiceHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class HfTaskServiceHelper extends TaskServiceHelper {

    protected static HfTaskServiceHelper instance;

    public HfTaskServiceHelper(TaskRepository taskRepository) {
        super(taskRepository);
    }

    public static HfTaskServiceHelper getInstance() {
        if (instance == null) {
            instance = new HfTaskServiceHelper(CoreLibrary.getInstance().context().getTaskRepository());
        }
        return instance;
    }

    @Override
    protected List<String> getLocationIds() {
        LocationHelper locationHelper = LocationHelper.getInstance();
        ArrayList<String> allowedLevels = new ArrayList<>(Arrays.asList(BuildConfig.FACILITY_LEVEL));
        List<String> locations = new ArrayList<>();
        if (locationHelper != null) {
            List<String> locationIds = locationHelper.generateDefaultLocationHierarchy(allowedLevels);
            if (locationIds != null) {
                for (String locationName : locationIds) {
                    locations.add(locationHelper.getOpenMrsLocationId(locationName));
                }
            }
        }
        return locations;
    }

    @Override
    protected Set<String> getPlanDefinitionIds() {
        return Collections.singleton(CoreConstants.REFERRAL_PLAN_ID);
    }
}
