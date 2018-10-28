package me.tuple.androidtutorials

import android.app.Application
import android.util.Log
import timber.log.Timber
import com.github.promeg.xlog_android.lib.XLogConfig
import android.widget.TextView
import com.promegu.xlog.base.XLogMethod
import me.tuple.androidtutorials.logger.TestClass


class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }else{
            Timber.plant(CrashlyticsTree())
        }

        val xLogMethods: MutableList<XLogMethod> = ArrayList()
        xLogMethods.add(XLogMethod(TestClass::class.java, "getFullName"))

        XLogConfig.config(XLogConfig.newConfigBuilder(this)
                .logMethods(xLogMethods)
                .build())
   }

    inner class CrashlyticsTree : Timber.Tree() {

        override fun log(priority: Int,tag: String?,message: String, t: Throwable?) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO) {
                return
            }
            //Send to crash analytics here
        }
    }
}