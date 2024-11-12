package hwsein.developer.example.taskapplication.MVP.View

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import hwsein.developer.example.taskapplication.R
import hwsein.developer.example.taskapplication.databinding.ActivityMainBinding
import hwsein.developer.example.taskapplication.ext.ActiveItem
import hwsein.developer.example.taskapplication.ext.Utils

class ViewMainActivity(
    private val contextInstance: Context,
    private val utils: Utils,
) {

    val binding = ActivityMainBinding.inflate(LayoutInflater.from(contextInstance))

    fun clickCloseIconAndSearchInRecycler() {

        binding.imgClose.setOnClickListener {

            binding.bottomNav.binding.root.visibility = View.VISIBLE

        }

    }


    fun setStartInAppFragment(fragment: Fragment) {

        val handler = Handler(Looper.getMainLooper())

        binding.bottomNav.visibility = View.INVISIBLE

        handler.postDelayed({

            binding.bottomNav.visibility = View.VISIBLE

        }, 6000)

        handler.postDelayed({

            binding.edtSearch.visibility = View.VISIBLE
            binding.imgClose.visibility = View.VISIBLE

        }, 7000)

        utils.setFragment(fragment)

    }

    fun clickInBottomNavItem(activeItem: ActiveItem) {

        binding.bottomNav.onClickHandler(activeItem)

    }

}