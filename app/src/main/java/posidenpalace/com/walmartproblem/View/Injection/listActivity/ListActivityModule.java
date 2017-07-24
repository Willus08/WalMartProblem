package posidenpalace.com.walmartproblem.View.Injection.listActivity;

import dagger.Module;
import dagger.Provides;
import posidenpalace.com.walmartproblem.View.Activities.listActivity.ListActivityPresenter;

@Module
public class ListActivityModule {
    @Provides
    public ListActivityPresenter provideListActivityPresenter(){
        return new ListActivityPresenter();
    }
}
