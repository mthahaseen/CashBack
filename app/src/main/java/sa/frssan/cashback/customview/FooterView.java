package sa.frssan.cashback.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import sa.frssan.cashback.R;

/**
 * Created by Thahaseen on 10/11/2016.
 */
public class FooterView extends RelativeLayout {

    @BindView(R.id.imgBack) ImageView imgBack;
    @BindView(R.id.btnSignOut) Button btnSignOut;

    public FooterView(Context context){
        super(context);
        init();
    }

    public FooterView(Context context, AttributeSet attrs){
        super(context, attrs);
        init();
    }

    public FooterView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        View view = inflate(getContext(), R.layout.footer_view, this);
        ButterKnife.bind(view);
    }
}
