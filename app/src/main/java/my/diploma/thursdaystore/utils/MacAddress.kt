package my.diploma.thursdaystore.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.wifi.WifiManager
import java.net.NetworkInterface
import java.util.*


enum class MacAddress {

    INSTANCE;

    fun get2(): String {
        try {
            val all: List<NetworkInterface> =
                Collections.list(NetworkInterface.getNetworkInterfaces())
            for (nif in all) {
                if (nif.name != "wlan0") continue
                val macBytes: ByteArray = nif.hardwareAddress ?: return ""
                val res1 = StringBuilder()
                for (b in macBytes) {
                    res1.append(String.format("%02X:", b))
                }
                if (res1.isNotEmpty()) {
                    res1.deleteCharAt(res1.length - 1)
                }
                return res1.toString()
            }
        } catch (ex: Exception) {
        }
        return "02:00:00:00:00:00"
    }

    @SuppressLint("HardwareIds")
    fun get1(context: Context): String {
        val manager = context.getSystemService(Context.WIFI_SERVICE) as WifiManager
        val info = manager.connectionInfo
        return info.macAddress.toUpperCase()
    }

    fun get(context:Context):String{
        var mac = get1(context)
        if (mac == "02:00:00:00:00:00") mac = get2()
    return mac
}

}