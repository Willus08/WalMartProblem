package posidenpalace.com.walmartproblem.View.Activities.detailedListActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import posidenpalace.com.walmartproblem.Model.WMItemsPOJO;
import posidenpalace.com.walmartproblem.R;
import posidenpalace.com.walmartproblem.View.Injection.detailedActivityList.DaggerDetailedListActivityComponent;


public class DetailedListActivity extends AppCompatActivity implements DetailedListActivityContract.View {

    private static final String TAG = "test";
    @Inject DetailedListActivityPresenter presenter;
    RecyclerView recy;
    RecyclerView.LayoutManager layout;
    RecyclerView.ItemAnimator animate;
    DetailedListActivityAdapter adapt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_list);
        setUpDaggerComponent();
        presenter.addView(this);
        recy = (RecyclerView) findViewById(R.id.rvDetailedItemList);
        LinearLayoutManager line = new LinearLayoutManager(this);
        line.setOrientation(LinearLayoutManager.HORIZONTAL);
        layout = line;
        animate = new DefaultItemAnimator();
        presenter.ParseIntent(getIntent());



    }
    private void setUpDaggerComponent(){
        DaggerDetailedListActivityComponent.create().inject(this);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void SetupRecyclerView(List<WMItemsPOJO> itemsPOJOList, WMItemsPOJO item) {

        Log.d(TAG, "SetupRecyclerView: "+ itemsPOJOList.get(0).getItemName());
        Log.d(TAG, "SetupRecyclerView: " + itemsPOJOList);

        SnapHelper snap=new LinearSnapHelper();
        snap.attachToRecyclerView(recy);
        adapt = new DetailedListActivityAdapter(itemsPOJOList);
        Log.d(TAG, "SetupRecyclerView: "+ adapt);
        recy.setLayoutManager(layout);
        recy.setItemAnimator(animate);
        recy.setAdapter(adapt);
        layout.scrollToPosition(item.getPos());

    }

}
