package com.mobexs.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mopub.common.MoPub;

import ly.persona.sdk.CampaignAd;
import ly.persona.sdk.Personaly;
import ly.persona.sdk.listener.AdListener;
import ly.persona.sdk.model.Gender;

public class MainActivity extends AppCompatActivity {

    public static final String APP_ID = "594a9abb08c3382000ebf091";
    public static String rewardedPlacementId = "7c9b490f02cf9b3059dacc75c81c1085";
    public static String interstitialPlacementId = "89293494-afc0-4d40-a854-11c02d67e74b";
    public static String offersAppId = "0e2b4c6eaedc44729b3348b33abeda8d";
    public static String popupOfferPlacementId = "ec8dc58af9755a043cbe1b846870f6c8";
    public static String appWallPlacementId = "58c654dce72cbf1000c735b5";
    public static String nativePlacementId = "71901ee7-2ad2-469c-b139-ae0385a7c86d";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Personaly.CONFIG
                .setGender(Gender.MALE)
                .setDateOfBirth("1989/07/12")
                .setDateOfBirth(1989, 8, 12)
                .setAge(19);

        Personaly.setAutoCaching(false);

        Personaly.init(this, APP_ID, new Personaly.InitCallback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });

//        MoPub

        Button loadButton = (Button) findViewById(R.id.load_button);
        Button showButton = (Button) findViewById(R.id.show_button);

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CampaignAd.get(interstitialPlacementId)
                        .setListener(new AdListener(){
                            @Override
                            public void onAdLoaded() {
                                CampaignAd.get(interstitialPlacementId).show();
                            }

                            @Override
                            public void onAdFailed(Throwable throwable) {
                                super.onAdFailed(throwable);
                            }
                        })
                        .load();
            }
        });

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CampaignAd.get(interstitialPlacementId).show();
            }
        });
    }
}
