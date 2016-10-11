package sa.frssan.cashback.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import sa.frssan.cashback.R;

/**
 * Created by Thahaseen on 10/11/2016.
 */
public class HeaderView extends LinearLayout {

    public HeaderView(Context context){
        super(context);
        init();
    }

    public HeaderView(Context context, AttributeSet attrs){
        super(context, attrs);
        init();
    }

    public HeaderView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        inflate(getContext(),R.layout.header_view, this);
    }
}

