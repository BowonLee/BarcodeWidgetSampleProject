package bowon.lee.barcodewigetapplication.ui.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import bowon.lee.barcodewigetapplication.MainActivity
import bowon.lee.barcodewigetapplication.R

class BarcodeWidgetProvider : AppWidgetProvider(){
    override fun onUpdate(
        context: Context?,
        appWidgetManager: AppWidgetManager?,
        appWidgetIds: IntArray?
    ) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)

        // 해당 위젯을 클릭했을 때 특정 페이지로 이동시켜준다.
        val pendingIntent: PendingIntent = Intent(context, BarcodeActivity::class.java)
            .let { intent ->
                PendingIntent.getActivity(context, 0, intent, 0)
            }

        val views: RemoteViews = RemoteViews(
            context?.packageName,
            R.layout.barcode_widet
        ).apply {
            setOnClickPendingIntent(R.id.barcode_text, pendingIntent)
        }

        appWidgetManager?.updateAppWidget(appWidgetIds, views)
    }



}