package text.miya.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= (TextView) findViewById(R.id.tv_ll);
        TvService tvService = RetrofitWrapper.getInstance().create(TvService.class);
        Call<TvInfo> call = tvService.getTvInfoList();
        call.enqueue(new Callback<TvInfo>() {
            @Override
            public void onResponse(Response<TvInfo> response, Retrofit retrofit) {
                textView.setText(response.body().data.articleListVOList.get(0).mediaJson);
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
