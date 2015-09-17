package rocks.bma.valkyrieuk.myfirstapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class DummyResultActivity extends Activity {

    @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_dummy_result);
       findViewById(R.id.finishButton).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               returnResult();
           }
       });
   }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dummy_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void returnResult(){
        Intent resultIntent = new Intent();
        resultIntent.putExtra("DummyData", "SomeData");
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
