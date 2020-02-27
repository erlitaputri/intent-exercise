package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    private TextView fullnameText;
    private TextView emailText;
    private TextView passwordText;
    private TextView confirmpasswordText;
    private TextView homepageText;
    private TextView aboutText;
    private Button btnHomepage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        fullnameText = findViewById(R.id.text_fullname);
        emailText= findViewById(R.id.text_email);
        passwordText = findViewById(R.id.text_password);
        confirmpasswordText = findViewById(R.id.text_confirm_password);
        homepageText = findViewById(R.id.text_homepage);
        aboutText = findViewById(R.id.text_about);
        btnHomepage = findViewById(R.id.button_homepage);

        Bundle extras = getIntent().getExtras();

        String fullname = extras.getString(RegisterActivity.FULLNAME_KEY);
        String email = extras.getString(RegisterActivity.EMAIL_KEY);
        String password = extras.getString(RegisterActivity.PASSWORD_KEY);
        String confirmpassword = extras.getString(RegisterActivity.CONFIRMPASSWORD_KEY);
        String homepage = extras.getString(RegisterActivity.HOMEPAGE_KEY);
        String about = extras.getString(RegisterActivity.ABOUT_KEY);

        if (extras != null) {
            // TODO: display value here
            fullnameText.setText(fullname);
            emailText.setText(email);
            passwordText.setText(password);
            confirmpasswordText.setText(confirmpassword);
            homepageText.setText(homepage);
            aboutText.setText(about);
        }

    }

    public void handleHomePage(View view) {
        btnHomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://"+homepageText.getText().toString();
                Intent Browser = new Intent(Intent.ACTION_VIEW);
                Browser.setData(Uri.parse(url));
                startActivity(Browser);
            }
        });
    }
}
