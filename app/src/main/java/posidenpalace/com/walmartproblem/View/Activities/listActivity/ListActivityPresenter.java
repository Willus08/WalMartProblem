package posidenpalace.com.walmartproblem.View.Activities.listActivity;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import posidenpalace.com.walmartproblem.Model.MultiItem;
import posidenpalace.com.walmartproblem.Model.RestHelper;
import posidenpalace.com.walmartproblem.Model.WMItemsPOJO;
import retrofit2.Call;
import retrofit2.Response;


public class ListActivityPresenter implements ListActivityContract.Presenter {
    private static final String TAG = "Testing";
    List<WMItemsPOJO> itemsPojo = new ArrayList<>();
    ListActivityContract.View view;

    @Override
    public void addView(ListActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    @Override
    public void SetupAdapter(String item) {
        retrofit2.Call<MultiItem> multiItemCall = RestHelper.multiItemSearchCall("");
        multiItemCall.enqueue(new retrofit2.Callback<MultiItem>() {
            @Override
            public void onResponse(Call<MultiItem> call, Response<MultiItem> response) {
                for (int i = 0; i < response.body().getItems().size(); i++) {

                    Log.d(TAG, "onResponse: " + response.body().getItems().get(i).getName()+
                            response.body().getItems().get(i).getThumbnailImage()+
                            response.body().getItems().get(i).getLargeImage()+
                            response.body().getItems().get(i).getProductUrl()+
                            response.body().getItems().get(i).getCustomerRating()+
                            response.body().getItems().get(i).getStock()+
                            response.body().getItems().get(i).getSalePrice()+
                            response.body().getItems().get(i).getShortDescription());
                    itemsPojo.add(new WMItemsPOJO(
                            response.body().getItems().get(i).getName(),
                            response.body().getItems().get(i).getThumbnailImage(),
                            response.body().getItems().get(i).getLargeImage(),
                            response.body().getItems().get(i).getProductUrl(),
                            response.body().getItems().get(i).getCustomerRating(),
                            response.body().getItems().get(i).getStock(),
                            response.body().getItems().get(i).getSalePrice(),
                            response.body().getItems().get(i).getShortDescription()));
                }
                view.SetupRecycleView(itemsPojo);

            }

            @Override
            public void onFailure(Call<MultiItem> call, Throwable t) {

            }
        });
    }

}
