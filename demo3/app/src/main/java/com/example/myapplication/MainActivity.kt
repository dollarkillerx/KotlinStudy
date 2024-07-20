package com.example.myapplication

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
//    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // 获取 WebView 实例
        val webView: WebView = findViewById(R.id.webview)

        // 设置 WebView 的属性
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true // 启用 JavaScript
        webSettings.domStorageEnabled = true // 启用 DOM 存储

        // 设置 WebView 客户端
        webView.webViewClient = WebViewClient()

        // 加载你想要显示的网站
        webView.loadUrl("http://app-dev.haakcakes.com")

        // 设置窗口插图监听
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}
