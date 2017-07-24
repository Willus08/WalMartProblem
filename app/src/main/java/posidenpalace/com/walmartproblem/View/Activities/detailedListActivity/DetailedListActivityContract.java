package posidenpalace.com.walmartproblem.View.Activities.detailedListActivity;

import android.content.Intent;

import java.util.List;

import posidenpalace.com.walmartproblem.Model.WMItemsPOJO;
import posidenpalace.com.walmartproblem.View.BasePresenter;
import posidenpalace.com.walmartproblem.View.BaseView;



public interface DetailedListActivityContract {
    interface View extends BaseView{
        void SetupRecyclerView(List<WMItemsPOJO> itemsPOJOList, WMItemsPOJO item);

    }
    interface Presenter extends BasePresenter<View>{

        void ParseIntent(Intent intent);

    }
}
