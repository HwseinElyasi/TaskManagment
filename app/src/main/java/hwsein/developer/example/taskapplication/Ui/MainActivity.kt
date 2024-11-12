package hwsein.developer.example.taskapplication.Ui

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import hwsein.developer.example.taskapplication.MVP.Model.ModelMainActivity
import hwsein.developer.example.taskapplication.MVP.Presenter.PresenterMainActivity
import hwsein.developer.example.taskapplication.MVP.View.ViewMainActivity
import hwsein.developer.example.taskapplication.R
import hwsein.developer.example.taskapplication.ext.Utils

class MainActivity : AppCompatActivity() , Utils {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val view = ViewMainActivity(this , this)
        setContentView(view.binding.root)

        fullScreen()

        val presenter = PresenterMainActivity(view , ModelMainActivity(this))
        presenter.onCreate()

    }

    override fun setFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction()
            .replace(R.id.Fragment_container, fragment)
            .commit()

    }

    private fun fullScreen(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
            window.insetsController?.apply {
                hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
                systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_IMMERSIVE
                            or View.SYSTEM_UI_FLAG_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    )
            @Suppress("DEPRECATION")
            window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val attr = window.attributes
            attr.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
            window.attributes = attr
        }

    }

}