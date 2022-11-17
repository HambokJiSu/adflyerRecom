package com.example.adflyerrecom.ui.recom_food;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.adflyerrecom.databinding.FragmentRecomFoodBinding;

public class RecomfoodFragment extends Fragment {

    private FragmentRecomFoodBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RecomfoodViewModel homeViewModel =
                new ViewModelProvider(this).get(RecomfoodViewModel.class);

        binding = FragmentRecomFoodBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        WebView webView = (WebView)binding.webView;
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowFileAccessFromFileURLs(true);
        webSettings.setDomStorageEnabled(true);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url == null || url.startsWith("http://") || url.startsWith("https://")) {
                    return false;
                }

                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    view.getContext().startActivity(intent);
                    return true;
                } catch (Exception e) {
                    Log.i(TAG, "shouldOverrideUrlLoading Exception:" + e);
                    return true;
                }
            }
        });
        webView.setWebChromeClient(new WebChromeClient(){
                                       public boolean onConsoleMessage(ConsoleMessage message){
                                           Log.d("====WebViewLog====", "message:" + message.message());
                                           Log.d("====WebViewLog====", "linenumber:" + message.lineNumber());
                                           Log.d("====WebViewLog====", "sourceId:" + message.sourceId());
                                           return true;
                                       }
                                   }
        );
        webView.loadUrl("file:///android_asset/www/quizzes1.html");

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}