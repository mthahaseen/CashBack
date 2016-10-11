package sa.frssan.cashback.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.client.android.CaptureActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sa.frssan.cashback.R;
import sa.frssan.cashback.common.UtilFunctions;
import sa.frssan.cashback.customview.FooterView;

public class CashBackActivity extends AppCompatActivity {

    @BindView(R.id.footerView) FooterView footerView;
    @BindView(R.id.txtQRCodeScanner) TextView txtQRCodeScan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_back);
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
                UtilFunctions.signOutFromApp(CashBackActivity.this);
                finish();
            }
        });
        Animation animShakeImage = AnimationUtils.loadAnimation(CashBackActivity.this, R.anim.horizontal_shake);
        txtQRCodeScan.startAnimation(animShakeImage);
    }

    @OnClick(R.id.txtQRCodeScanner)
    public void qrCode(View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(getApplicationContext(),CaptureActivity.class);
                intent.setAction("com.google.zxing.client.android.SCAN");
                intent.putExtra("SAVE_HISTORY", false);
                startActivityForResult(intent, 0);
            }else{
                Log.v("Permission","Permission is not granted");
                ActivityCompat.requestPermissions(CashBackActivity.this, new String[]{Manifest.permission.CAMERA}, 1);
            }
        } else {
            Intent intent = new Intent(getApplicationContext(),CaptureActivity.class);
            intent.setAction("com.google.zxing.client.android.SCAN");
            intent.putExtra("SAVE_HISTORY", false);
            startActivityForResult(intent, 0);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0]== PackageManager.PERMISSION_GRANTED ){
            Log.v("CAMERA", "Permission: " + permissions[0] + "was " + grantResults[0]);
            Intent intent = new Intent(getApplicationContext(),CaptureActivity.class);
            intent.setAction("com.google.zxing.client.android.SCAN");
            intent.putExtra("SAVE_HISTORY", false);
            startActivityForResult(intent, 0);
        }else{
            Toast.makeText(CashBackActivity.this, "The app was not allowed to open camera in your device to scan QR Code. Hence consider granting this permission.", Toast.LENGTH_LONG).show();
            onBackPressed();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String contents = data.getStringExtra("SCAN_RESULT");
                Toast.makeText(CashBackActivity.this, contents, Toast.LENGTH_LONG).show();
            } else if (resultCode == RESULT_CANCELED) {
                Log.d("QR_SCAN", "RESULT_CANCELED");
            }
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(CashBackActivity.this, MainActivity.class));
        finish();
    }
}
