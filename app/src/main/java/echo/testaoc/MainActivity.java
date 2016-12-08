package echo.testaoc;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout activityMain;
    ImageView ivYang;
    Button btTranslate;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        activityMain = (LinearLayout) findViewById(R.id.activity_main);
        findViewById(R.id.bt_0).setOnClickListener(this);
        final Button bt2 = (Button) findViewById(R.id.bt_1);
//        Drawable rightYang = getResources().getDrawable(R.mipmap.yang);
//        rightYang.setBounds(0, 0, 100, 100);
//        bt2.setCompoundDrawables(null, null, rightYang, null);
        
        bt2.setOnClickListener(this);
        findViewById(R.id.bt_2).setOnClickListener(this);
        findViewById(R.id.bt_3).setOnClickListener(this);
        btTranslate = (Button) findViewById(R.id.bt_4);
        btTranslate.setOnClickListener(this);
        findViewById(R.id.bt_5).setOnClickListener(this);
        findViewById(R.id.bt_6).setOnClickListener(this);
        ivYang = (ImageView) findViewById(R.id.iv_yang);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_0:
                makeCustomAnimation();
                break;
            case R.id.bt_1:
                makeScaleUpAnimation(ivYang);
                break;
            case R.id.bt_2:
                makeClipRevealAnimation(ivYang);
                break;
            case R.id.bt_3:
                makeSceneTransitionAnimation(ivYang);
                break;
            case R.id.bt_4:
                makeSceneTransitionAnimation();
                break;
            case R.id.bt_5:
                makeThumbnailScaleUpAnimation(view, BitmapFactory.decodeResource(getResources(), R.mipmap.yang));
                break;
            case R.id.bt_6:
                makeSceneTransitionAnimation2();
                break;
        }
    }

    private void makeCustomAnimation() {
//        final ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(mContext, R.anim.act_fade_in_anim, R.anim.act_fade_out_anim);
        final ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(mContext, 0, 0);
        ActivityCompat.startActivity(mContext, new Intent(mContext, SecondActivity.class), activityOptionsCompat.toBundle());
    }
    private void makeScaleUpAnimation(View v) {
        final ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeScaleUpAnimation(v, v.getWidth()/2, v.getHeight()/2, 0, 0);
        ActivityCompat.startActivity(mContext, new Intent(mContext, SecondActivity.class), activityOptionsCompat.toBundle());
    }
    private void makeClipRevealAnimation (View v) {
        final ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeClipRevealAnimation(v, v.getWidth()/2, v.getHeight()/2, 0, 0);
        ActivityCompat.startActivity(mContext, new Intent(mContext, SecondActivity.class), activityOptionsCompat.toBundle());
    }
    private void makeThumbnailScaleUpAnimation (View v, Bitmap bitmap) {
        final ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeThumbnailScaleUpAnimation(v, bitmap, v.getWidth(), v.getHeight());
        ActivityCompat.startActivity(mContext, new Intent(mContext, SecondActivity.class), activityOptionsCompat.toBundle());
    }
    
    private void makeSceneTransitionAnimation (View v) {
        final ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, v, getString(R.string.transition));
        ActivityCompat.startActivity(mContext, new Intent(mContext, SecondActivity.class), activityOptionsCompat.toBundle());
    }
    
    private void makeSceneTransitionAnimation () {
        final Pair<View, String> ivPair = Pair.create((View)ivYang, getString(R.string.transition));
        final Pair<View, String> btPir = Pair.create((View)btTranslate, getString(R.string.text));
        
        final ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, ivPair, btPir);
        ActivityCompat.startActivity(mContext, new Intent(mContext, SecondActivity.class), activityOptionsCompat.toBundle());
    }
    
    
    private void makeSceneTransitionAnimation2 () {
        final ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
        ActivityCompat.startActivity(mContext, new Intent(mContext, SecondActivity.class), activityOptionsCompat.toBundle());
    }
}
