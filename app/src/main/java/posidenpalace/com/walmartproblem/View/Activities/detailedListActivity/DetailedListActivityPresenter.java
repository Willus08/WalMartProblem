package posidenpalace.com.walmartproblem.View.Activities.detailedListActivity;

import android.content.Intent;
import android.util.Log;

import java.util.List;

import posidenpalace.com.walmartproblem.Model.WMItemsPOJO;

/**
 * Created by Android on 7/22/2017.
 */

public class DetailedListActivityPresenter implements DetailedListActivityContract.Presenter {

    private static final String TAG = "test";
    DetailedListActivityContract.View view;
    @Override
    public void addView(DetailedListActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    @Override
    public void ParseIntent(Intent intent) {

        List<WMItemsPOJO> list = intent.getParcelableArrayListExtra("list");
        Log.d(TAG, "ParseIntent: "+ list.get(0).getItemName());
        Log.d(TAG, "ParseIntent: "+ list);
        WMItemsPOJO item = intent.getParcelableExtra("item");
        Log.d(TAG, "ParseIntent: "+item.getItemName());
        view.SetupRecyclerView(list,item);
    }
}
