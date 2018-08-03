package pro.work_timer.wt_app;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class InternetConnection {
 private Context context;
 public InternetConnection(Context context) {
  this.context = context;
 }
 public boolean funConnectCondition() {
  ConnectivityManager connectivityManager =
   (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE
   );
  if(connectivityManager != null) {
   NetworkInfo[] ara = connectivityManager.getAllNetworkInfo();
   if(ara != null) {
    for (int i=0; i<ara.length; i++) {
     if(ara[i].getState() == NetworkInfo.State.CONNECTED) {
      return true;
     }
    }
   }
  }
  return false;
 }
}