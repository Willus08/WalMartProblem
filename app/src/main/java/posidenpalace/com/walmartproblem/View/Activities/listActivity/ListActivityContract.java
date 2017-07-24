package posidenpalace.com.walmartproblem.View.Activities.listActivity;

import java.util.List;

import posidenpalace.com.walmartproblem.Model.WMItemsPOJO;
import posidenpalace.com.walmartproblem.View.BasePresenter;
import posidenpalace.com.walmartproblem.View.BaseView;


public interface ListActivityContract {
    interface View extends BaseView{
        void SetupRecycleView(List<WMItemsPOJO> items);
        void giveMoreDetail(WMItemsPOJO item);
    }
    interface Presenter extends BasePresenter<View>{
        void SetupAdapter(String item);

    }
}
