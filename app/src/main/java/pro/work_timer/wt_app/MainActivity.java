package pro.work_timer.wt_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    //для открытия ссылок в приложении
    private class WebViewer extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    private InternetConnection internetConnection;
    private WebView webView1;
    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        internetConnection = new InternetConnection(getApplicationContext());
        webView1 = findViewById(R.id.webView1);
        //подключение JavaScript
        webView1.getSettings().setJavaScriptEnabled(true);
        //открытие ссылок в приложении
        webView1.setWebViewClient(new WebViewClient());
        //устанавка Zoom control
        webView1.getSettings().setBuiltInZoomControls(false);
        str = "https://work-timer.pro/";
        //если интернет соединение есть
        if (internetConnection.funConnectCondition()) {
            Toast.makeText(this, "welcome!",
                    Toast.LENGTH_SHORT).show();
            //загрузка веб-страницы
            webView1.loadUrl(str);
        }
        //если интернет соединение нет
        else {
            Toast.makeText(this, "We need an internet connection",
                    Toast.LENGTH_SHORT).show();
        }
    }

    //Go Back назад
    public void button1Click(View view) {
        webView1.goBack();
    }

    //Reload обновить
    public void button2Click(View view) {
        webView1.reload();
    }

    //Go Forward вперед
    public void button3Click(View view) {
        webView1.goForward();
    }

    //кнопка НАЗАД на устройстве переходит к предыдущей странице в браузере
    @Override
    public void onBackPressed() {
        if (webView1.canGoBack()) {
            webView1.goBack();
        } else {
            super.onBackPressed();
        }
    }
}