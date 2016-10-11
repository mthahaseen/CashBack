package sa.frssan.cashback.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import sa.frssan.cashback.R;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnAccountDetails)
    public void accountDetails(View view) {
        Toast.makeText(SignUpActivity.this, getString(R.string.account_details), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btnPersonalInformation)
    public void personalInformation(View view) {
        Toast.makeText(SignUpActivity.this, getString(R.string.personal_info), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn2StepVerification)
    public void twoStepVerification(View view) {
        Toast.makeText(SignUpActivity.this, getString(R.string.two_step_verification), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(SignUpActivity.this, CheckInActivity.class));
        finish();
    }
}
