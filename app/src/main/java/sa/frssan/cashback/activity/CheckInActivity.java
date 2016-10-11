package sa.frssan.cashback.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import sa.frssan.cashback.R;

public class CheckInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSignIn)
    public void signIn(View view) {
        startActivity(new Intent(CheckInActivity.this, SignInActivity.class));
        finish();
    }

    @OnClick(R.id.btnSignUp)
    public void signUp(View view) {
        startActivity(new Intent(CheckInActivity.this, SignUpActivity.class));
        finish();
    }
}
