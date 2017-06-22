package dev.tornaco.ffmpegtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.github.hiteshsondhi88.libffmpeg.FFmpeg;
import com.github.hiteshsondhi88.libffmpeg.LoadBinaryResponseHandler;
import com.github.hiteshsondhi88.libffmpeg.exceptions.FFmpegCommandAlreadyRunningException;
import com.github.hiteshsondhi88.libffmpeg.exceptions.FFmpegNotSupportedException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            FFmpeg.getInstance(this)
                    .loadBinary(new LoadBinaryResponseHandler());
            String version = FFmpeg.getInstance(this)
                    .getDeviceFFmpegVersion();
            TextView textView = (TextView) findViewById(R.id.text);
            textView.setText(version);
        } catch (FFmpegCommandAlreadyRunningException e) {
            e.printStackTrace();
        } catch (FFmpegNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
