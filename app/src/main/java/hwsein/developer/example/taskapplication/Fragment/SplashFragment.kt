package hwsein.developer.example.taskapplication.Fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hwsein.developer.example.taskapplication.databinding.SplashFragmentBinding
import hwsein.developer.example.taskapplication.ext.Utils

class SplashFragment(
    private val utils: Utils
) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = SplashFragmentBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        Handler(Looper.getMainLooper()).postDelayed({

            utils.setFragment(HomeFragment())

        } , 5000)

    }



}