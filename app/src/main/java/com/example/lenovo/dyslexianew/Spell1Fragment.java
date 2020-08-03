package com.example.lenovo.dyslexianew;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Locale;


public class Spell1Fragment extends Fragment implements
        TextToSpeech.OnInitListener  {
    View view;
    private Button btnSpeak1;
    private TextToSpeech tts;
    private ToggleButton tb;
    private ToggleButton tb2;
    private ToggleButton tb3;
    private ToggleButton tb4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_spell1, container, false);
    btnSpeak1=view.findViewById(R.id.btnSpeak1);
        tb = view.findViewById(R.id.o1);
        tb2=view.findViewById(R.id.o2);
        tb3= view.findViewById(R.id.o3);
        tb4=view.findViewById(R.id.o4);
        tb.setOnClickListener(new View.OnClickListener() { //diectly creating onclick
            @Override
            public void onClick(View view) {
                if (tb.isChecked()) {
                    Toast.makeText(getActivity(), "right answer", Toast.LENGTH_LONG).show();

                }
            }

        });

        tb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tb2.isChecked()){
                    Toast.makeText(getActivity(), "wrong answer", Toast.LENGTH_SHORT).show();

                }
            }
        });

        tb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tb3.isChecked()){
                    Toast.makeText(getActivity(), "wrong answer", Toast.LENGTH_SHORT).show();

                }
            }
        });
        tb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tb4.isChecked()){
                    Toast.makeText(getActivity(), "wrong answer", Toast.LENGTH_SHORT).show();

                }
            }
        });


        tts=new TextToSpeech(getContext(),this);


        btnSpeak1 = view.findViewById(R.id.btnSpeak1);


        // button on click event
        btnSpeak1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Toast.makeText(getActivity(), "Question 1:", Toast.LENGTH_SHORT).show();
                speakOut();
            }

        });

        return view;
    }
    @Override
    public void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.UK);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else btnSpeak1.setEnabled(true);

        } else {
            Log.e("TTS", "Initialization Failed!");
        }

    }

    private void speakOut() {
        String txtText = "whose";
        String text = txtText.toString();

        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }


}
