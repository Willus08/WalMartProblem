package posidenpalace.com.walmartproblem.View.Injection.detailedActivityList;

import dagger.Component;
import posidenpalace.com.walmartproblem.View.Activities.detailedListActivity.DetailedListActivity;

@Component(modules = DetailedListActivityModule.class)
public interface DetailedListActivityComponent {
    void inject(DetailedListActivity detailedListActivity);
}
