package enriqueamaya.com.lockscreenweather;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;

/**
 * Created by enriq on 5/15/2017.
 */

public class MainPrefs extends PreferenceFragment {
    static final int ACTIVATION_REQUEST = 8; //identifica el id de la petición, debugging
    DevicePolicyManager mDPM; //Este y el siguiente son como shortcuts
    ComponentName mDeviceAdmin;
    boolean mAdminActive; //Variable que nos dice si el permiso de Admin está activa o no

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs_general);
    }
}
