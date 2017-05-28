package com.example.ferhat.parklotist;

/**
 * Created by ferhat on 5/27/2017.
 */

public class GitGud {
    /*public class WidgetPref {

    public static final String PREFS_NAME = "PARKLOT";

    public final static String KEY_TWO="com.example.ferhat.parklotist.key_two";
    public final static String KEY_ONE="com.example.ferhat.parklotist.key_one";
    public final static String KEY_TEXT="com.example.ferhat.parklotist.key_text";
    public final static String KEY_COLOR="com.example.ferhat.parklotist.key_color";
    public static int counter=1;


    public static SharedPreferences WidgetPref(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        return pref;
    }



    public static void setPrefFirstCount(Context context,String key, int value){
        value++;
        value=value%4;
        if(value==0){
            value=1;
        }
        if(key!=null){
            SharedPreferences.Editor editor= WidgetPref(context).edit();
            editor.remove(key);
            editor.putInt(key,value);
            editor.commit();
        }
    }

    public static void setPrefSecondCount(Context context,String key,int value){
        value++;
        value=value%10;
        if(value==0){
            value=1;
        }
        if(key!=null){
            SharedPreferences.Editor editor= WidgetPref(context).edit();
            editor.remove(key);
            editor.putInt(key,value);
            editor.commit();
        }
    }

    public static void setPrefTextCount(Context context,String key,String value){
        char c=value.charAt(0);
        c++;
        if(Character.toString(c).equals("I")){
            c='A';
        }

        value=Character.toString(c);

        if(key!=null){
            SharedPreferences.Editor editor= WidgetPref(context).edit();
            editor.remove(key);
            editor.putString(key,value);
            editor.commit();
        }
    }

    public static void setPrefColorCount(Context context,String key, int value){
        counter++;
        counter=counter%5;
        if (counter==0){
            counter=1;
        }
        switch (counter){
            case 1://yellow
                value= Color.parseColor("#fff700");
                break;
            case 2://gray
                value=Color.parseColor("#FF848484");
                break;
            case 3://red
                value=Color.parseColor("#ff0004");
                break;
            case 4://blue
                value=Color.parseColor("#040ca6");
                break;
        }

        if(key!=null){
            SharedPreferences.Editor editor= WidgetPref(context).edit();
            editor.remove(key);
            editor.putInt(key,value);
            editor.commit();
        }
    }

    public static int getPrefFirstCount(Context context,String key){
        SharedPreferences pref= WidgetPref(context);
        int value=1;
            if(pref.contains(key)){
                value=pref.getInt(key,0);
            }else{
                value=1;
            }
        return value;
    }

    public static int getPrefSecondCount(Context context,String key){
        SharedPreferences pref= WidgetPref(context);
        int value=1;
        if(pref.contains(key)){
            value=pref.getInt(key,0);
        }else{
            value=1;
        }
        return value;
    }

    public static String getPrefTextCount(Context context,String key){
        SharedPreferences pref= WidgetPref(context);
        String value = "";
        if(pref.contains(key)){
            value=pref.getString(key,"");
        }else{
            value="A";
        }
        return value;
    }

    public static int getPrefColorCount(Context context,String key){
        SharedPreferences pref= WidgetPref(context);
        int value=0;
        if(pref.contains(key)){
            value=pref.getInt(key,0);
        }else{//yellow
            value=Color.parseColor("#fff700");
        }
        return value;
    }

}*/


/*public class ParkLot extends AppWidgetProvider {


    private static final String MyOnClick1 = "myOnClickTag1";
    private static final String MyOnClick2 = "myOnClickTag2";
    private static final String MyOnClick3 = "myOnClickTag3";
    private static final String MyOnClick4 = "myOnClickTag4";



    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {



        ComponentName thisWidget = new ComponentName(context, ParkLot.class);
        int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);

        for (int widgetId : allWidgetIds) {

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

            int firstValue=WidgetPref.getPrefFirstCount(context,WidgetPref.KEY_ONE);
            WidgetPref.setPrefFirstCount(context,WidgetPref.KEY_ONE,firstValue);
            firstValue=WidgetPref.getPrefFirstCount(context,WidgetPref.KEY_ONE);

            RemoteViews views=new RemoteViews(context.getPackageName(),R.layout.activity_park_lot);
            views.setTextViewText(R.id.first_variable,""+firstValue);

            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            ComponentName thisAppWidget = new ComponentName(context.getPackageName(), ParkLot.class.getName());

            appWidgetManager.updateAppWidget(thisAppWidget,views);


        } else if (MyOnClick2.equals(intent.getAction())) {

            String textValue=WidgetPref.getPrefTextCount(context,WidgetPref.KEY_TEXT);
            WidgetPref.setPrefTextCount(context,WidgetPref.KEY_TEXT,textValue);
            textValue=WidgetPref.getPrefTextCount(context,WidgetPref.KEY_TEXT);

            RemoteViews views=new RemoteViews(context.getPackageName(),R.layout.activity_park_lot);
            views.setTextViewText(R.id.text_segment,textValue);

            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            ComponentName thisAppWidget = new ComponentName(context.getPackageName(), ParkLot.class.getName());

            appWidgetManager.updateAppWidget(thisAppWidget,views);


        } else if (MyOnClick3.equals(intent.getAction())) {

            int secondValue=WidgetPref.getPrefSecondCount(context,WidgetPref.KEY_TWO);
            WidgetPref.setPrefSecondCount(context,WidgetPref.KEY_TWO,secondValue);
            secondValue=WidgetPref.getPrefSecondCount(context,WidgetPref.KEY_TWO);

            RemoteViews views=new RemoteViews(context.getPackageName(),R.layout.activity_park_lot);
            views.setTextViewText(R.id.second_variable,""+secondValue);

            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            ComponentName thisAppWidget = new ComponentName(context.getPackageName(), ParkLot.class.getName());

            appWidgetManager.updateAppWidget(thisAppWidget,views);


        } else if (MyOnClick4.equals(intent.getAction())) {

            int colorValue=WidgetPref.getPrefColorCount(context,WidgetPref.KEY_COLOR);
            WidgetPref.setPrefColorCount(context,WidgetPref.KEY_COLOR,colorValue);
            colorValue=WidgetPref.getPrefColorCount(context,WidgetPref.KEY_COLOR);

            RemoteViews views=new RemoteViews(context.getPackageName(),R.layout.activity_park_lot);
            views.setTextColor(R.id.first_variable,colorValue);
            views.setTextColor(R.id.second_variable,colorValue);
            views.setTextColor(R.id.text_segment,colorValue);


            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            ComponentName thisAppWidget = new ComponentName(context.getPackageName(), ParkLot.class.getName());

            appWidgetManager.updateAppWidget(thisAppWidget,views);


        }
    }

    public RemoteViews buildUpdate(Context context,int widgetId,WidgetPref pref){

        RemoteViews remoteView=new RemoteViews(context.getPackageName(),R.layout.activity_park_lot);

        int firstValue=WidgetPref.getPrefFirstCount(context,WidgetPref.KEY_ONE);
        int secondValue=WidgetPref.getPrefSecondCount(context,WidgetPref.KEY_TWO);
        String textValue=WidgetPref.getPrefTextCount(context,WidgetPref.KEY_TEXT);
        int colorValue=WidgetPref.getPrefColorCount(context,WidgetPref.KEY_COLOR);

        remoteView.setTextViewText(R.id.first_variable,""+firstValue);
        remoteView.setTextViewText(R.id.second_variable,""+secondValue);
        remoteView.setTextViewText(R.id.text_segment,textValue);
        //remoteView.setTextViewText(R.id.color_variable,"Color");
        remoteView.setImageViewResource(R.id.color_variable,colorValue);

        remoteView.setTextColor(R.id.first_variable,colorValue);
        remoteView.setTextColor(R.id.second_variable,colorValue);
        remoteView.setTextColor(R.id.text_segment,colorValue);

        remoteView.setOnClickPendingIntent(R.id.first_variable, getPendingSelfIntent(context, MyOnClick1));
        remoteView.setOnClickPendingIntent(R.id.text_segment, getPendingSelfIntent(context, MyOnClick2));
        remoteView.setOnClickPendingIntent(R.id.second_variable, getPendingSelfIntent(context, MyOnClick3));
        remoteView.setOnClickPendingIntent(R.id.color_variable,getPendingSelfIntent(context,MyOnClick4));

        return remoteView;
    }




}*/




}
