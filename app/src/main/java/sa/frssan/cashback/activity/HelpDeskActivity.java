
package sa.frssan.cashback.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import sa.frssan.cashback.R;
import sa.frssan.cashback.common.UtilFunctions;
import sa.frssan.cashback.customview.FooterView;
import sa.frssan.cashback.customview.HeaderView;

public class HelpDeskActivity extends AppCompatActivity {

    @BindView(R.id.footerView)
    FooterView footerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_desk);
        ButterKnife.bind(this);
        ImageView imgBack = (ImageView) footerView.findViewById(R.id.imgBack);
        Button btnSignOut = (Button) footerView.findViewById(R.id.btnSignOut);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UtilFunctions.signOutFromApp(HelpDeskActivity.this);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(HelpDeskActivity.this, MainActivity.class));
        finish();
    }
}
