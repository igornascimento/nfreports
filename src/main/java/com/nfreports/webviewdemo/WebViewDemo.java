package com.nfreports.webviewdemo;

import com.nfreports.javafx.webview.Java2JavascriptUtils;
import com.nfreports.webviewdemo.backend.CalculatorService;
import com.nfreports.webviewdemo.backend.FruitsService;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewDemo extends Application {

	private final String PAGE = "/views/mainStage.html";

	@Override
	public void start(Stage primaryStage) {
		createWebView(primaryStage, PAGE);
	}

	private void createWebView(Stage primaryStage, String page) {
		
		// create the JavaFX webview
		final WebView webView = new WebView();

		// connect the FruitsService instance as "fruitsService" 
		// javascript variable
		Java2JavascriptUtils.connectBackendObject(
				webView.getEngine(),
				"fruitsService", new FruitsService());
		
		// connect the CalculatorService instance as "calculatorService" 
		// javascript variable		
		Java2JavascriptUtils.connectBackendObject(
				webView.getEngine(),
				"calculatorService", new CalculatorService());
		
		// show "alert" Javascript messages in stdout (useful to debug)	
		webView.getEngine().setOnAlert(new EventHandler<WebEvent<String>>(){
			@Override
			public void handle(WebEvent<String> arg0) {
				System.err.println("alertwb1: " + arg0.getData());
			}
		});
		
		// load index.html
		webView.getEngine().load(
				getClass().getResource(page).
				toExternalForm());

		primaryStage.setScene(new Scene(webView));
		primaryStage.setTitle("WebView with Java backend");
		primaryStage.setMaximized(true);
		primaryStage.show();
	}
	
	public static void main(String[] args) {		
		System.setProperty("prism.lcdtext", "false"); // enhance fonts		
		launch(args);
	}
}
