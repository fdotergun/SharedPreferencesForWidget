package com.example.ferhat.parklotist;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;
import android.widget.Toast;




public class ParkLot extends AppWidgetProvider {


    private static final String MyOnClick1 = "myOnClickTag1";
    private static final String MyOnClick2 = "myOnClickTag2";




    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {



        ComponentName thisWidget = new ComponentName(context, ParkLot.class);
        int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);

        for (int widgetId : allWidgetIds) {

            //Creating pref constructor
            //I created buildUpdate so it contains everything and keeps the data with sharedPref
            WidgetPref pref=new WidgetPref();
            RemoteViews remoteViews=buildUpdate(context,widgetId,pref);


            appWidgetManager.updateAppWidget(widgetId, remoteViews);
        }
    }

    protected PendingIntent getPendingSelfIntent(Context context, String action) {
        Intent intent = new Intent(context, getClass());
        intent.setAction(action);
        return PendingIntent.getBroadcast(context, 0, intent, 0);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);

        if (MyOnClick1.equals(intent.getAction())) {

            //call your getters and setters to a constructor here!!

            RemoteViews views=new RemoteViews(context.getPackageName(),R.layout.activity_park_lot);
            //Set your changes with View


            //Update your Widget
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            ComponentName thisAppWidget = new ComponentName(context.getPackageName(), ParkLot.class.getName());
            appWidgetManager.updateAppWidget(thisAppWidget,views);


        } else if (MyOnClick2.equals(intent.getAction())) {

            //call your getters and then setters to a constructor here!!
            //Similar to buildUpdate

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.activity_park_lot);
            //Set your changes with View


            //Update your Widget
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            ComponentName thisAppWidget = new ComponentName(context.getPackageName(), ParkLot.class.getName());
            appWidgetManager.updateAppWidget(thisAppWidget, views);


        }
    }

    public RemoteViews buildUpdate(Context context,int widgetId,WidgetPref pref){

        RemoteViews remoteView=new RemoteViews(context.getPackageName(),R.layout.activity_park_lot);


        //first you need to Call your getters from WidgetPref
        int firstValue=WidgetPref.getPrefFirstCount(context,WidgetPref.KEY_ONE);
        int secondValue=WidgetPref.getPrefSecondCount(context,WidgetPref.KEY_TWO);


        remoteView.setTextViewText(R.id.first_variable,""+firstValue);
        remoteView.setTextViewText(R.id.second_variable,""+secondValue);


        remoteView.setOnClickPendingIntent(R.id.first_variable, getPendingSelfIntent(context, MyOnClick1));
        remoteView.setOnClickPendingIntent(R.id.second_variable, getPendingSelfIntent(context, MyOnClick2));


        return remoteView;
    }




}
