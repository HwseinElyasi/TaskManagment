package hwsein.developer.example.taskapplication.MVP.Presenter

import hwsein.developer.example.taskapplication.MVP.Model.ModelMainActivity
import hwsein.developer.example.taskapplication.MVP.View.ViewMainActivity

class PresenterMainActivity(
    private val view : ViewMainActivity ,
    private val model : ModelMainActivity
) {

    fun onCreate(){

        setSplash()
        setItemInBottomNav()
        clickIconInEdtSearch()

    }

    private fun setSplash(){

        view.setStartInAppFragment(model.setSplashFragment())

    }

    private fun setItemInBottomNav(){

        view.clickInBottomNavItem(model.activeItemInBottomNav())

    }

    private fun clickIconInEdtSearch(){

        view.clickCloseIconAndSearchInRecycler()

    }



}