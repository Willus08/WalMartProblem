package posidenpalace.com.walmartproblem.View.Injection.listActivity;

import dagger.Component;
import posidenpalace.com.walmartproblem.View.Activities.listActivity.ListActivity;

@Component(modules = ListActivityModule.class)
public interface ListActivityComponent {
    void inject(ListActivity listActivity);
}
