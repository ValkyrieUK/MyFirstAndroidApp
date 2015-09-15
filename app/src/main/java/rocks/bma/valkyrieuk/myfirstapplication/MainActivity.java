package rocks.bma.valkyrieuk.myfirstapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText myET;
    private Switch mySwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView helloTV = (TextView) findViewById(R.id.textView);
        helloTV.setText("Bradley Allen");
        myET = (EditText)findViewById(R.id.editText);
        Button b = (Button)findViewById(R.id.button);
        final Switch mySwitch = (Switch)findViewById(R.id.switch1);
        mySwitch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                helloTV.setText(mySwitch.isChecked().toString());
                Toast.makeText(MainActivity.this, "Switched", Toast.LENGTH_LONG).show();
                Log.v("TAG", "Switched");
            }
        });

        b.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v){
                Intent i = new Intent(MainActivity.this, ThirdActivity.class);
                i.putExtra("name", "Bradley");
                startActivity(i);
                return true;
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helloTV.setText(myET.getText());
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_LONG).show();
                Log.v("TAG", "Clicked");
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("TAG", "onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("TAG", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("TAG", "onResume");
    }
}
