package com.isep.projectjavawallet.controllers.market;

import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.AlphaVantageException;
import com.crazzyghost.alphavantage.Config;
import com.crazzyghost.alphavantage.parameters.Interval;
import com.crazzyghost.alphavantage.parameters.OutputSize;
import com.crazzyghost.alphavantage.timeseries.response.TimeSeriesResponse;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class MarketController {
    private Label welcomeText;

    protected void onSearchButtonClicked(){
        Config cfg = Config.builder()
                .key("SMJ44JXNNQM94SUDI")
                .timeOut(10)
                .build();
        AlphaVantage.api().init(cfg);

        AlphaVantage.api()
                .timeSeries()
                .intraday()
                .forSymbol("IBM")
                .interval(Interval.FIVE_MIN)
                .outputSize(OutputSize.FULL)
                .onSuccess(e -> {
                    Platform.runLater(()-> handleSuccess((TimeSeriesResponse) e));
                })
                .onFailure(e -> {
                    Platform.runLater(()-> handleFailure(e));
                })
                .fetch();
    }

    private void handleFailure(AlphaVantageException error) {
        System.out.println("Function failed");
    }

    private void handleSuccess(TimeSeriesResponse response) {
        String text = String.valueOf(response.getStockUnits().get(1).getHigh());
        welcomeText.setText(text);
    }

}
