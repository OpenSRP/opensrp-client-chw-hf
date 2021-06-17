package org.smartregister.chw.hf.presenter;

import org.jetbrains.annotations.NotNull;
import org.smartregister.chw.hf.R;
import org.smartregister.chw.hiv.contract.BaseHivRegisterFragmentContract;
import org.smartregister.chw.hiv.presenter.BaseHivIndexContactsRegisterFragmentPresenter;
import org.smartregister.chw.hiv.util.Constants.Tables;
import org.smartregister.chw.hiv.util.DBConstants;

public class HivIndexContactsContactsRegisterFragmentPresenter extends BaseHivIndexContactsRegisterFragmentPresenter {

    public HivIndexContactsContactsRegisterFragmentPresenter(BaseHivRegisterFragmentContract.View view, BaseHivRegisterFragmentContract.Model model, String viewConfigurationIdentifier) {
        super(view, model, viewConfigurationIdentifier);
    }

    @Override
    @NotNull
    public String getMainCondition() {
        return " " + Tables.HIV_INDEX + "." + DBConstants.Key.IS_CLOSED + " = '0' ";

    }

    @Override
    @NotNull
    public String getDueFilterCondition() {
        return "";
    }

    @Override
    public void processViewConfigurations() {
        super.processViewConfigurations();
        if (getConfig().getSearchBarText() != null && getView() != null) {
            getView().updateSearchBarHint(getView().getContext().getString(R.string.search_name_or_id));
        }


        if (getConfig().getFilterFields() != null && getView() != null) {
            getView().updateSearchBarHint(getView().getContext().getString(R.string.search_name_or_id));
        }
    }

    @Override
    public String getMainTable() {
        return Tables.HIV_INDEX;
    }
}
