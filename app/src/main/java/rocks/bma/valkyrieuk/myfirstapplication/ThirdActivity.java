package rocks.bma.valkyrieuk.myfirstapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class ThirdActivity extends Activity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thrid);
        Button b = (Button)findViewById(R.id.button3);
        Intent callingIntent = getIntent();
        Log.v("TAG", "Passed " + callingIntent.getStringExtra("name"));
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ThirdActivity.this, MainActivity.class);
                startActivity(i);

            }
        });
        listView = (ListView)findViewById(R.id.listView);
        setListView();
    }

    private void setListView(){
        final ArrayList<Person> data = new ArrayList<>();
        for (int i =0; i < 1000; i++){
            Person p = new Person();
            p.setName("Bradley #"+i);
            p.setAddress(i+" Harrison Way");
            data.add(p);
        }
        ArrayAdapter<Person> adapter = new ArrayAdapter<Person>(this, R.layout.custom_list, R.id.detailTV, data){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                View v = convertView;
                TagHolder tagHolder = null;
                if (v == null){
                    LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    v = vi.inflate(R.layout.custom_list, null);
                    tagHolder = new TagHolder();
                    tagHolder.detailTV = (TextView) v.findViewById(R.id.detailTV);
                    v.setTag(tagHolder);
                } else {
                    tagHolder = (TagHolder) v.getTag();
                } try {
                    Person p = getItem(position);
                }
                return v;
            }
        };
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.v("TAG", "Got " + data.get(position));
                Intent i = new Intent(ThirdActivity.this, DetailActivity.class);
                i.putExtra("person", data.get(position).toString());
                startActivity(i);
            }
        });
    }
    class TagHolder {
        TextView detailTV;

        public TextView getDetailTV() {
            return detailTV;
        }

        public void setDetailTV(TextView detailTV) {
            this.detailTV = detailTV;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_thrid, menu);
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
}
