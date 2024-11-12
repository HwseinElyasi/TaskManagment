package hwsein.developer.example.taskapplication.MVP.Model

import hwsein.developer.example.taskapplication.Fragment.AboutFragment
import hwsein.developer.example.taskapplication.Fragment.HomeFragment
import hwsein.developer.example.taskapplication.Fragment.SplashFragment
import hwsein.developer.example.taskapplication.Fragment.DutiesFragment
import hwsein.developer.example.taskapplication.ext.ActiveItem
import hwsein.developer.example.taskapplication.ext.SetView
import hwsein.developer.example.taskapplication.ext.Utils

class ModelMainActivity(
    private val utils: Utils
) {

    fun setSplashFragment() = SplashFragment(utils)

    fun activeItemInBottomNav() =  object : ActiveItem {

        override fun activeView(activeItem: SetView) {

            val fragment = when (activeItem){
                SetView.HOME -> HomeFragment()
                SetView.ABOUT -> AboutFragment()
                SetView.DOCUMENT -> DutiesFragment()
                SetView.SEARCH -> HomeFragment()
            }

            utils.setFragment(fragment)

        }

    }

}