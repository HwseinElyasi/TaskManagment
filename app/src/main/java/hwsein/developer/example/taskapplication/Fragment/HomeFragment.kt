package hwsein.developer.example.taskapplication.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hwsein.developer.example.taskapplication.MVP.Model.ModelHomeFragment
import hwsein.developer.example.taskapplication.MVP.Presenter.PresenterHomeFragment
import hwsein.developer.example.taskapplication.MVP.View.ViewHomeFragment
import hwsein.developer.example.taskapplication.ext.Utils

class HomeFragment : Fragment() , Utils  {

    private lateinit var presenter : PresenterHomeFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

         val view = ViewHomeFragment(context)
        presenter = PresenterHomeFragment(view , ModelHomeFragment(this , context))
        presenter.onCreate()

        return view.binding.root
    }

    override fun onDestroy() {

        presenter.onDestroy()
        super.onDestroy()


    }

}