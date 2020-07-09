package application;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Fib extends Application {
	private static ArrayList<Long> recurTimeArray = new ArrayList<>();
	private static ArrayList<Long> iterTimeArray = new ArrayList<>();
	
	
	@Override	
	public void start(Stage window) {
		NumberAxis xAxis = new NumberAxis(1, 41, 1);
		NumberAxis yAxis = new NumberAxis();
		
		xAxis.setLabel("Number");
		yAxis.setLabel("Time/ns");
		
		LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
		lineChart.setTitle("Running time of fibonnacci algorithms");
		XYChart.Series recurData = new XYChart.Series();
		recurData.setName("Recursive");
		
		XYChart.Series iterData = new XYChart.Series();
		recurData.setName("Iterative");
		
		for(int i=0; i<40; i++) {
			recurData.getData().add(new XYChart.Data(i, recurTimeArray.get(i)));
			iterData.getData().add(new XYChart.Data(i, iterTimeArray.get(i)));
		}
		
		lineChart.getData().addAll(recurData, iterData);
		
		Scene scene = new Scene(lineChart);
		
		window.setScene(scene);
		window.show();
		
		
		
		
	}

	public static int fib_r(int x) {
		if (x <= 2)
			return 1;
		return fib_r(x - 1) + fib_r(x - 2);
	}

	public static int fib_i(int x) {
		int a = 1, b = 1, fib = 1, i = 2;
		while (i < x) {
			fib = a + b;
			a = b;
			b = fib;
			i += 1;
		}
		return fib;
	}

	public static void main(String[] args) {
		// int x = 40;
		// System.out.println("Fib of " + x + " = " + fib_r(x));
		// System.out.println("Fib of " + x + " = " + fib_i(x));
		
		
		for(int i=1; i<=40; i++) {
			long recurStartTime = System.nanoTime();
			int val1 = fib_r(i);
			long recurEndTime = System.nanoTime();
			
			recurTimeArray.add(recurEndTime-recurStartTime);
			
			long iterStartTime = System.nanoTime();
			int val2 = fib_i(i);
			long iterEndTime = System.nanoTime();
			
			iterTimeArray.add(iterEndTime-iterStartTime);	
		}
		for(int i=0; i<40; i++) {
			System.out.println(""+(i+1)+" recur: "+recurTimeArray.get(i)+"ns, iter: "+iterTimeArray.get(i)+"ns");
		}
		
		launch(args);
	}
}
