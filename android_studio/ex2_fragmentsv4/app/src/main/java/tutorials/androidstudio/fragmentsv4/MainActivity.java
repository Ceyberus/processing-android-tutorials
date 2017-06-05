package tutorials.androidstudio.fragmentsv4;


import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.support.v7.app.AppCompatActivity;

import processing.android.PFragment;
import processing.android.ViewIdGenerator;
import processing.core.PApplet;

public class MainActivity extends AppCompatActivity {
  private PApplet sketch;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    FrameLayout frame = new FrameLayout(this);
    frame.setId(ViewIdGenerator.getUniqueId());
    setContentView(frame, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                     ViewGroup.LayoutParams.MATCH_PARENT));

    sketch = new Sketch();
    PFragment fragment = new PFragment(sketch);
    fragment.setView(frame, this);
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
    if (sketch != null) {
      sketch.onRequestPermissionsResult(
      requestCode, permissions, grantResults);
    }
  }
}
