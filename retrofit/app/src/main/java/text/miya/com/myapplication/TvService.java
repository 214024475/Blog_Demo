package text.miya.com.myapplication;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

import static android.R.attr.y;

/**
 * Created by csl on 2017/8/21.
 */

public interface TvService {
    @GET("/api/article/get_list")
    Call<TvInfo> getTvInfoList();
}
