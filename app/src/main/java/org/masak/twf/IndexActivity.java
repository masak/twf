package org.masak.twf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class IndexActivity extends Activity {
    public static final String ARTICLE_ID = "org.masak.articleId";

    private OnItemClickListener articleClickHandler = new OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            Intent intent = new Intent(IndexActivity.this, ArticleActivity.class);
            intent.putExtra(ARTICLE_ID, position + 1);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] articles = new String[300];
        for (int i = 0; i < 300; i++) {
            articles[i] = "" + (i + 1);
        }

        setContentView(R.layout.activity_index);
        GridView gridView = (GridView) findViewById(R.id.articlesView);
        int layout = android.R.layout.simple_list_item_1;
        gridView.setAdapter(new ArrayAdapter<>(this, layout, articles));
        gridView.setOnItemClickListener(articleClickHandler);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_index, menu);
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