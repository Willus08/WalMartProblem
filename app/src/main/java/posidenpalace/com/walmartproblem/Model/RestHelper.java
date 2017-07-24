package posidenpalace.com.walmartproblem.Model;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Android on 7/23/2017.
 */

public class RestHelper {
    //http://api.walmartlabs.com/v1/items/12417832?apiKey=crbtm43abzjfqvhaxxns4u7c&lsPublisherId={Your LinkShare Publisher Id}&format=json
    public static final String BASE_URL = "http://api.walmartlabs.com/";
    public static final String KEY= "crbtm43abzjfqvhaxxns4u7c";
    public static Retrofit create() {


        Retrofit retro = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retro;
    }
    public static Call<MultiItem> multiItemCall(String item){
        Retrofit retrofit = create();
        Services services = retrofit.create(Services.class);
        return services.getMultiItems(item,KEY,null);

    }
    public static Call<MultiItem> multiItemSearchCall(String item){
        Retrofit retrofit = create();
        Services services = retrofit.create(Services.class);
        return services.thisType(KEY,"tv");

    }



    interface Services {
        @GET("v1/items?")
        Call<MultiItem> getMultiItems(@Query("ids=") String item, @Query("apiKey=") String key, @Query("PublisherId=") String publisher);

        @GET("/v1/search?&format=json")
        Call<MultiItem> thisType(@Query("apiKey") String key, @Query("query") String type);
    }
}
