
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.fitnessnation.R
import com.example.fitnessnation.activitites.BottomNavigationActivity

class Broadcast: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context,"HEREEE",Toast.LENGTH_LONG).show()
        val builder : NotificationCompat.Builder = NotificationCompat.Builder(context!!, "notify").setContentTitle("Alarm").setContentText("You have an alarm set at this hour").setSmallIcon(R.drawable.ic_launcher_background)
        val notificationManager: NotificationManagerCompat = NotificationManagerCompat.from(context)
        notificationManager.notify(200, builder.build())

    }
}