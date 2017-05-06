package khacquyetdang.android.com.phrases;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private int[] btnIds = {
            R.id.helloBtn,
            R.id.doYouSpeekBtn,
            R.id.goodEveningBtn,
            R.id.howAreYouBtn,
            R.id.iliveinBtn,
            R.id.mynameisBtn,
            R.id.pleaseBtn,
            R.id.welcomeBtn
    };

    private Map<Integer, Integer> mappedBtnRaw = new HashMap<Integer, Integer>();
    private MediaPlayer mediaPlayer;


    private void onBtnClick(View view) {
        int rawSound = 0;
        switch (view.getId()) {
            case R.id.helloBtn:
                rawSound = R.raw.hello;
                break;
            case R.id.goodEveningBtn:
                rawSound = R.raw.goodevening;
                break;
            case R.id.doYouSpeekBtn:
                rawSound = R.raw.doyouspeakenglish;
                break;
            case R.id.howAreYouBtn:
                rawSound = R.raw.howareyou;
                break;
            case R.id.iliveinBtn:
                rawSound = R.raw.ilivein;
                break;
            case R.id.mynameisBtn:
                rawSound = R.raw.mynameis;
                break;
            case R.id.pleaseBtn:
                rawSound = R.raw.please;
                break;
            case R.id.welcomeBtn:
                rawSound = R.raw.welcome;
                break;
        }
        if (mediaPlayer != null)
        {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        mediaPlayer = MediaPlayer.create(this, rawSound);
        mediaPlayer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int btnId : btnIds) {
            Button btn = (Button) findViewById(btnId);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBtnClick(view);
                }
            });
        }

    }
}
