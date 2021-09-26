package com.example.pantaucovid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.pantaucovid.model.CovidGlobal;
import com.example.pantaucovid.model.CovidIndo;
import com.example.pantaucovid.model.CovidSulut;
import com.example.pantaucovid.retrofit.ApiServiceGlobal;
import com.example.pantaucovid.retrofit.ApiServiceIndo;
import com.example.pantaucovid.retrofit.ApiServiceSulut;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    // Ini adalah project aplikasi untuk mata kuliah TIK3171 - PENGEMBANGAN APLIKASI MOBILE
    // yang diampu oleh Mner SHERWIN REINALDO U ALDO SOMPIE ST, MT dan Mner XAVERIUS B.N. NAJOAN ST, MT
    // Project ini dibuat oleh Fransiscus Xaverius Senduk (NIM 19021106039)
    private int unicode = 0x1F49D;

    private final String TAG = "MainActivity";
    private Locale localeID = new Locale("in","ID");
    private TextView tanggal, posGlobal, posIndo, semIndo, menIndo, posSulut, semSulut, menSulut, credits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        tanggal = findViewById(R.id.textViewTglData);
        posGlobal = findViewById(R.id.textViewPosGlobalData);
        posIndo = findViewById(R.id.textViewPosIndoData);
        semIndo = findViewById(R.id.textViewSemIndoData);
        menIndo = findViewById(R.id.textViewMenIndoData);
        posSulut = findViewById(R.id.textViewPosSulutData);
        semSulut = findViewById(R.id.textViewSemSulutData);
        menSulut = findViewById(R.id.textViewMenSulutData);
        credits = findViewById(R.id.textView);

        String em = new String(Character.toChars(unicode));
        credits.setText("Made with " + em + " by Fransiscus Xaverius Senduk - 19021106039");

        getDataFromApi();

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL, localeID).format(calendar.getTime());

        tanggal.setText(currentDate);
    }

    private void getDataFromApi() {
        ApiServiceGlobal.endpoint().getData().enqueue(new Callback<CovidGlobal>() {
            @Override
            public void onResponse(Call<CovidGlobal> call, Response<CovidGlobal> response) {
                if (response.isSuccessful()) {
                    CovidGlobal results = response.body();
                    showResultGlobal(results);
                }
            }

            @Override
            public void onFailure(Call<CovidGlobal> call, Throwable t) {

            }
        });

        ApiServiceIndo.endpoint().getData().enqueue(new Callback<List<CovidIndo>>() {
            @Override
            public void onResponse(Call<List<CovidIndo>> call, Response<List<CovidIndo>> response) {
                //Log.d(TAG, results.toString());
                if (response.isSuccessful()) {
                    List<CovidIndo> results = response.body();
                    showResultIndo(results);
                }
            }

            @Override
            public void onFailure(Call<List<CovidIndo>> call, Throwable t) {
                Log.d( TAG, t.toString());
            }
        });

        ApiServiceSulut.endpoint().getData().enqueue(new Callback<List<CovidSulut>>() {
            @Override
            public void onResponse(Call<List<CovidSulut>> call, Response<List<CovidSulut>> response) {
                if (response.isSuccessful()) {
                    List<CovidSulut> results = response.body();
                    showResultSulut(results);
                }
            }

            @Override
            public void onFailure(Call<List<CovidSulut>> call, Throwable t) {
                Log.d( TAG, t.toString());
            }
        });
    }

    private void showResultGlobal(CovidGlobal covidData) {
        Log.d(TAG, covidData.getValue());
        posGlobal.setText(covidData.getValue());
    }

    private void showResultIndo(List<CovidIndo> covidData) {
        CovidIndo results = covidData.get(0);
        Log.d(TAG, results.getPositif());
        posIndo.setText(results.getPositif());
        semIndo.setText(results.getSembuh());
        menIndo.setText(results.getMeninggal());
    }

    private void showResultSulut(List<CovidSulut> covidData) {
        CovidSulut results = covidData.get(16);
        posSulut.setText(results.getAttributes().getKasus_Posi());
        semSulut.setText(results.getAttributes().getKasus_Semb());
        menSulut.setText(results.getAttributes().getKasus_Meni());
    }
}