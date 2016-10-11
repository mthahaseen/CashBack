package sa.frssan.cashback.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sa.frssan.cashback.R;
import sa.frssan.cashback.common.AppConstants;

public class SignInActivity extends AppCompatActivity {

    @BindView(R.id.edUsername) EditText edUsername;
    @BindView(R.id.edPassword) EditText edPassword;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
    }

    @OnClick(R.id.btnSubmit)
    public void submit(View view) {
        if(validateData()){
            if(edUsername.getText().toString().trim().equals("admin") && edPassword.getText().toString().trim().equals("admin")){
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("signIn", 1);
                editor.apply();
                Toast.makeText(SignInActivity.this, AppConstants.MSG_SUCCESS, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SignInActivity.this, MainActivity.class));
                finish();
            }else{
                Toast.makeText(SignInActivity.this, AppConstants.MSG_INVALID_USERNAME_PASSWORD, Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean validateData(){
        boolean result = true;
        if(edUsername.getText().toString().trim().isEmpty()){
            edUsername.setError(AppConstants.MSG_REQUIRED);
            result = false;
        }else if(edPassword.getText().toString().trim().isEmpty()){
            edPassword.setError(AppConstants.MSG_REQUIRED);
            result = false;
        }
        return result;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(SignInActivity.this, CheckInActivity.class));
        finish();
    }
}
