package edu.hanu.a1_1901040240;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //show the app icon on the title bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_statusbar_book);

        //initialize UI components from the layout file using their respective IDs
        TextView textTitle = findViewById(R.id.textTitle);
        ScrollView hiraTable = findViewById(R.id.hira_table);
        Button hiraBtn = findViewById(R.id.hiraSwitch_btn);
        ScrollView kataTable = findViewById(R.id.kata_table);
        Button kataBtn = findViewById(R.id.kataSwitch_btn);

        //set visibility for Katakana alphabet to hide on start app
        kataTable.setVisibility(View.GONE);

        //set listeners for the Hiragana button to switch Hiragana alphabet
        hiraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchAlphabets(textTitle, hiraTable, kataTable, hiraBtn, kataBtn, true);
            }
        });
        //set listeners for the Katakana button to switch Katakana alphabet
        kataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchAlphabets(textTitle, hiraTable, kataTable, hiraBtn, kataBtn, false);
            }
        });
    }

    //switches between Hiragana and Katakana alphabets
    private void switchAlphabets(TextView textTitle, ScrollView hiraTable, ScrollView kataTable, Button hiraBtn, Button kataBtn, boolean isHiragana) {
        // Set animation for title text
        textTitle.animate().alpha(0f).setDuration(500).withEndAction(new Runnable() {
            @Override
            public void run() {
                textTitle.animate().alpha(1f);
                textTitle.setText(isHiragana ? "Hiragana" : "Katakana");
            }
        });

        //Hiragana is selected
        if (isHiragana) {
            //show Hiragana alphabet
            hiraTable.animate().alpha(0f).setDuration(500).withEndAction(new Runnable() {
                @Override
                public void run() {
                    hiraTable.setVisibility(View.VISIBLE);
                    hiraTable.animate().alpha(1f);
                }
            });
            //hide Katakana alphabet
            kataTable.animate().alpha(1f).setDuration(500).withEndAction(new Runnable() {
                @Override
                public void run() {
                    kataTable.animate().alpha(0f);
                    kataTable.setVisibility(View.GONE);
                }
            });
            // highlight Hiragana button
            hiraBtn.setBackgroundResource(R.drawable.status_in);
            kataBtn.setBackgroundResource(R.drawable.status_out);
        } else { //Katakana is selected
            //show Katakana alphabet
            kataTable.animate().alpha(0f).setDuration(500).withEndAction(new Runnable() {
                @Override
                public void run() {
                    kataTable.setVisibility(View.VISIBLE);
                    kataTable.animate().alpha(1f);
                }
            });
            //hide Hiragana alphabet
            hiraTable.animate().alpha(1f).setDuration(500).withEndAction(new Runnable() {
                @Override
                public void run() {
                    hiraTable.animate().alpha(0f);
                    hiraTable.setVisibility(View.GONE);
                }
            });
            // Highlight Katakana button
            kataBtn.setBackgroundResource(R.drawable.status_in);
            hiraBtn.setBackgroundResource(R.drawable.status_out);
        }
    }

    //handles playing audio file for given audio resource ID
    private MediaPlayer mediaPlayer;
    public void handleEventOnClickButton(View view, int audioId) {
        //MediaPlayer has already been created
        if (mediaPlayer != null) {
            // Reset the MediaPlayer to its uninitialized state
            mediaPlayer.reset();
        }
        // Create new MediaPlayer using the current context and given audio resource ID
        mediaPlayer = MediaPlayer.create(this, audioId);
        mediaPlayer.start();
    }

    //handle the click events of empty buttons
    public void handleEventOnClickBtnEmpty(View view) {
    }

    //handle the click events of buttons for each vowel, respectively.
    public void handleEventOnClickBtnA(View view) {
        handleEventOnClickButton(view, R.raw.a_audiofile);
    }

    public void handleEventOnClickBtnI(View view) {
        handleEventOnClickButton(view, R.raw.i_audiofile);
    }

    public void handleEventOnClickBtnU(View view) {
        handleEventOnClickButton(view, R.raw.u_audiofile);
    }

    public void handleEventOnClickBtnE(View view) {
        handleEventOnClickButton(view, R.raw.e_audiofile);
    }

    public void handleEventOnClickBtnO(View view) {
        handleEventOnClickButton(view, R.raw.o_audiofile);
    }

    public void handleEventOnClickBtnKa(View view) {
        handleEventOnClickButton(view, R.raw.ka_audiofile);
    }

    public void handleEventOnClickBtnKi(View view) {
        handleEventOnClickButton(view, R.raw.ki_audiofile);
    }

    public void handleEventOnClickBtnKu(View view) {
        handleEventOnClickButton(view, R.raw.ku_audiofile);
    }

    public void handleEventOnClickBtnKe(View view) {
        handleEventOnClickButton(view, R.raw.ke_audiofile);
    }

    public void handleEventOnClickBtnKo(View view) {
        handleEventOnClickButton(view, R.raw.ko_audiofile);
    }

    public void handleEventOnClickBtnSa(View view) {
        handleEventOnClickButton(view, R.raw.sa_audiofile);
    }

    public void handleEventOnClickBtnShi(View view) {
        handleEventOnClickButton(view, R.raw.shi_audiofile);
    }

    public void handleEventOnClickBtnSu(View view) {
        handleEventOnClickButton(view, R.raw.su_audiofile);
    }

    public void handleEventOnClickBtnSe(View view) {
        handleEventOnClickButton(view, R.raw.se_audiofile);
    }

    public void handleEventOnClickBtnSo(View view) {
        handleEventOnClickButton(view, R.raw.so_audiofile);
    }

    public void handleEventOnClickBtnTa(View view) {
        handleEventOnClickButton(view, R.raw.ta_audiofile);
    }

    public void handleEventOnClickBtnChi(View view) {
        handleEventOnClickButton(view, R.raw.chi_audiofile);
    }

    public void handleEventOnClickBtnTsu(View view) {
        handleEventOnClickButton(view, R.raw.tsu_audiofile);
    }

    public void handleEventOnClickBtnTe(View view) {
        handleEventOnClickButton(view, R.raw.te_audiofile);
    }

    public void handleEventOnClickBtnTo(View view) {
        handleEventOnClickButton(view, R.raw.to_audiofile);
    }

    public void handleEventOnClickBtnNa(View view) {
        handleEventOnClickButton(view, R.raw.na_audiofile);
    }

    public void handleEventOnClickBtnNi(View view) {
        handleEventOnClickButton(view, R.raw.ni_audiofile);
    }

    public void handleEventOnClickBtnNu(View view) {
        handleEventOnClickButton(view, R.raw.nu_audiofile);
    }

    public void handleEventOnClickBtnNe(View view) {
        handleEventOnClickButton(view, R.raw.ne_audiofile);
    }

    public void handleEventOnClickBtnNo(View view) {
        handleEventOnClickButton(view, R.raw.no_audiofile);
    }

    public void handleEventOnClickBtnHa(View view) {
        handleEventOnClickButton(view, R.raw.ha_audiofile);
    }

    public void handleEventOnClickBtnHi(View view) {
        handleEventOnClickButton(view, R.raw.hi_audiofile);
    }

    public void handleEventOnClickBtnFu(View view) {
        handleEventOnClickButton(view, R.raw.fu_audiofile);
    }

    public void handleEventOnClickBtnHe(View view) {
        handleEventOnClickButton(view, R.raw.he_audiofile);
    }

    public void handleEventOnClickBtnHo(View view) {
        handleEventOnClickButton(view, R.raw.ho_audiofile);
    }

    public void handleEventOnClickBtnMa(View view) {
        handleEventOnClickButton(view, R.raw.ma_audiofile);
    }

    public void handleEventOnClickBtnMi(View view) {
        handleEventOnClickButton(view, R.raw.mi_audiofile);
    }

    public void handleEventOnClickBtnMu(View view) {
        handleEventOnClickButton(view, R.raw.mu_audiofile);
    }

    public void handleEventOnClickBtnMe(View view) {
        handleEventOnClickButton(view, R.raw.me_audiofile);
    }

    public void handleEventOnClickBtnMo(View view) {
        handleEventOnClickButton(view, R.raw.mo_audiofile);
    }

    public void handleEventOnClickBtnYa(View view) {
        handleEventOnClickButton(view, R.raw.ya_audiofile);
    }

    public void handleEventOnClickBtnYu(View view) {
        handleEventOnClickButton(view, R.raw.yu_audiofile);
    }

    public void handleEventOnClickBtnYo(View view) {
        handleEventOnClickButton(view, R.raw.yo_audiofile);
    }

    public void handleEventOnClickBtnRa(View view) {
        handleEventOnClickButton(view, R.raw.ra_audiofile);
    }

    public void handleEventOnClickBtnRi(View view) {
        handleEventOnClickButton(view, R.raw.ri_audiofile);
    }

    public void handleEventOnClickBtnRu(View view) {
        handleEventOnClickButton(view, R.raw.ru_audiofile);
    }

    public void handleEventOnClickBtnRe(View view) {
        handleEventOnClickButton(view, R.raw.re_audiofile);
    }

    public void handleEventOnClickBtnRo(View view) {
        handleEventOnClickButton(view, R.raw.ro_audiofile);
    }

    public void handleEventOnClickBtnWa(View view) {
        handleEventOnClickButton(view, R.raw.wa_audiofile);
    }

    public void handleEventOnClickBtnWo(View view) {
        handleEventOnClickButton(view, R.raw.wo_audiofile);
    }

    public void handleEventOnClickBtnN(View view) {
        handleEventOnClickButton(view, R.raw.n_audiofile);
    }
}
