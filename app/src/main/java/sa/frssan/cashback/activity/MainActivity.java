package sa.frssan.cashback.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sa.frssan.cashback.R;
import sa.frssan.cashback.common.UtilFunctions;
import sa.frssan.cashback.customview.FooterView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.footerView) FooterView footerView;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        if(preferences.getInt("signIn",0) == 0){
            startActivity(new Intent(MainActivity.this, SplashActivity.class));
            finish();
        }else {
            ImageView imgBack = (ImageView) footerView.findViewById(R.id.imgBack);
            Button btnSignOut = (Button) footerView.findViewById(R.id.btnSignOut);
            imgBack.setVisibility(View.GONE);
            btnSignOut.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    UtilFunctions.signOutFromApp(MainActivity.this);
                    startActivity(new Intent(MainActivity.this, SplashActivity.class));
                    finish();
                }
            });
        }
    }

    @OnClick(R.id.new_bill)
    public void newBill(View view) {
        startActivity(new Intent(MainActivity.this, NewBillActivity.class));
        finish();
    }

    @OnClick(R.id.cash_back)
    public void cashBack(View view) {
        startActivity(new Intent(MainActivity.this, CashBackActivity.class));
        finish();
    }

    @OnClick(R.id.trans_history)
    public void transHistory(View view) {
        startActivity(new Intent(MainActivity.this, TransactionHistoryActivity.class));
        finish();
    }

    @OnClick(R.id.help_desk)
    public void helpDesk(View view) {
        startActivity(new Intent(MainActivity.this, HelpDeskActivity.class));
        finish();
    }
}
