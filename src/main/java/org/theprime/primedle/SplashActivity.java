package org.theprime.primedle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.adsmedia.adsmodul.OpenAds;
import com.adsmedia.adsmodul.utils.AdsConfig;

import org.theprime.primedle.config.AdsData;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        AdsData.getIDAds();
        OpenAds.LoadOpenAds(AdsConfig.Open_App_ID);
        OpenAds.AppOpenAdManager.showAdIfAvailable(SplashActivity.this, () -> new CountDownTimer(3000, 1000) {
            @Override
            public void onFinish() {

                Intent intent = new Intent(SplashActivity.this, Gurgle.class);
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("image/png"); // Specify the MIME type, e.g., image/png
                intent.putExtra(Intent.EXTRA_STREAM, ""); // imageUri should be a valid Uri pointing to the image
                startActivity(intent);
                finish();
            }

            @Override
            public void onTick(long millisUntilFinished) {
            }
        }.start());

    }
}