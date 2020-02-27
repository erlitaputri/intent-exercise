package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    //Variabel key
    public static final String FULLNAME_KEY = "fullname";
    public static final String EMAIL_KEY = "email";
    public static final String PASSWORD_KEY = "password";
    public static final String CONFIRMPASSWORD_KEY = "confirmpassword";
    public static final String HOMEPAGE_KEY = "homepage";
    public static final String ABOUT_KEY = "about";

    //Variabel
    private static final String TAG = RegisterActivity.class.getCanonicalName();
    private static final int GALLERY_REQUEST_CODE = 1;

    private EditText fullnameInput;
    private EditText emailInput;
    private EditText passwordInput;
    private EditText confirmpasswordInput;
    private EditText homepageInput;
    private EditText aboutInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullnameInput = findViewById(R.id.layout_fullname);
        emailInput = findViewById(R.id.layout_email);
        passwordInput = findViewById(R.id.layout_password);
        confirmpasswordInput = findViewById(R.id.layout_confirm_password);
        homepageInput = findViewById(R.id.layout_homepage);
        aboutInput = findViewById(R.id.layout_about);
    }

    public void handleOk(View view) {
        if (fullnameInput.getText().toString().length() == 0) {
            fullnameInput.setError("masukkan nama ");
        } else if(emailInput.getText().toString().length() == 0){
            emailInput.setError("masukkan email");
        } else if(passwordInput.getText().toString().length() == 0 ){
            passwordInput.setError("msukkan password");
        } else if(confirmpasswordInput.getText().toString().length() == 0){
            confirmpasswordInput.setError("masukkan confirm password");
        }else if(homepageInput.getText().toString().length() == 0){
            homepageInput.setError("masukkan homepage");
        } else if(aboutInput.getText().toString().length() == 0){
            aboutInput.setError("masukkan about");
        }
        else {
            String password = passwordInput.getText().toString();

            if (password.equals(confirmpasswordInput.getText().toString())) {
                Intent intent = new Intent(this, ProfileActivity.class);

                String about = aboutInput.getText().toString();
                intent.putExtra(ABOUT_KEY, about);

                String fullname = fullnameInput.getText().toString();
                intent.putExtra(FULLNAME_KEY, fullname);

                String email = emailInput.getText().toString();
                intent.putExtra(EMAIL_KEY, email);

                String homepage = homepageInput.getText().toString();
                intent.putExtra(HOMEPAGE_KEY, homepage);

                startActivity(intent);
            } else {
                confirmpasswordInput.setError("Password harus diisi sama!");
            }
        }



    }
}
