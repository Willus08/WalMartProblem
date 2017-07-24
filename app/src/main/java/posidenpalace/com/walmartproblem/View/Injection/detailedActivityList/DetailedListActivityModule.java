package posidenpalace.com.walmartproblem.View.Injection.detailedActivityList;

import dagger.Module;
import dagger.Provides;
import posidenpalace.com.walmartproblem.View.Activities.detailedListActivity.DetailedListActivityPresenter;

@Module
public class DetailedListActivityModule {
    @Provides
    public DetailedListActivityPresenter provideDetailedListPresenter(){
        return  new DetailedListActivityPresenter();
    }
}
