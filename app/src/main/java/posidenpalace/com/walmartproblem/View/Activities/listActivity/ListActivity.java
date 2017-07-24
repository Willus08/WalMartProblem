package posidenpalace.com.walmartproblem.View.Activities.listActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import posidenpalace.com.walmartproblem.Model.WMItemsPOJO;
import posidenpalace.com.walmartproblem.R;
import posidenpalace.com.walmartproblem.View.Injection.listActivity.DaggerListActivityComponent;

public class ListActivity extends AppCompatActivity implements ListActivityContract.View{

    private static final String TAG = "test";
    @Inject ListActivityPresenter presenter;

    RecyclerView recy;
    RecyclerView.LayoutManager layout;
    RecyclerView.ItemAnimator animate;
    ListActivityAdapter adapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setUpDaggerComponent();
        presenter.addView(this);
        recy = (RecyclerView) findViewById(R.id.rvItemsList);
        layout= new LinearLayoutManager(this);
        animate = new DefaultItemAnimator();
        presenter.SetupAdapter("");
    }

    private void setUpDaggerComponent(){
        DaggerListActivityComponent.create().inject(this);
    }

    @Override
    public void showError(String error) {

    }


    @Override
    public void SetupRecycleView(List<WMItemsPOJO> items) {
        Log.d(TAG, "SetupRecycleView: " + items);
        adapt = new ListActivityAdapter(items);
        recy.setAdapter(adapt);
        recy.setItemAnimator(animate);
        recy.setLayoutManager(layout);

    }

    @Override
    public void giveMoreDetail(WMItemsPOJO item) {

    }
}
