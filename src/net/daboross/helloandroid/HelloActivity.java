package net.daboross.helloandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HelloActivity extends Activity {

    public final static String INTENT_TEXT = "net.daboross.helloandroid.TEXT";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_layout);
        final EditText editText = (EditText) findViewById(R.id.mainTextArea);
        final TextView textView = (TextView) findViewById(R.id.mainTextView);
        final Button button = (Button) findViewById(R.id.mainButton);
        final Button answerButton = (Button) findViewById(R.id.answerButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                CharSequence oldText = textView.getText();
                textView.setText(editText.getText());
                editText.setText(oldText);
            }
        });
        answerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                CharSequence text = editText.getText();
                Intent intent = new Intent(HelloActivity.this, AnswerActivity.class);
                intent.putExtra(INTENT_TEXT, text);
                startActivity(intent);
            }
        });
    }
}
