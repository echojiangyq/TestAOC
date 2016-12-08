package echo.testaoc;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Window;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Transition slide_right = TransitionInflater.from(this).inflateTransition(android.R.transition.slide_right);
            getWindow().setEnterTransition(slide_right);
        }
        setContentView(R.layout.activity_second);
    }
    
    
    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        ActivityCompat.finishAfterTransition(this);
        overridePendingTransition(0, 0);  
    }
}
