package hwsein.developer.example.taskapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import hwsein.developer.example.taskapplication.Fragment.SplashFragment
import hwsein.developer.example.taskapplication.MVP.Model.ModelMainActivity
import hwsein.developer.example.taskapplication.MVP.Presenter.PresenterMainActivity
import hwsein.developer.example.taskapplication.MVP.View.ViewMainActivity
import hwsein.developer.example.taskapplication.databinding.ActivityMainBinding
import hwsein.developer.example.taskapplication.ext.Utils

class MainActivity : AppCompatActivity() , Utils {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val view = ViewMainActivity(this , this)
        setContentView(view.binding.root)

        val presenter = PresenterMainActivity(view , ModelMainActivity(this))
        presenter.onCreate()

    }

    override fun setFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction()
            .replace(R.id.Fragment_container , fragment)
            .commit()

    }

}