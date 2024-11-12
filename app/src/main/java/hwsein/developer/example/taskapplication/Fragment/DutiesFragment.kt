package hwsein.developer.example.taskapplication.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hwsein.developer.example.taskapplication.MVP.Model.ModelHomeFragment
import hwsein.developer.example.taskapplication.MVP.Presenter.PresenterDutiesFragment
import hwsein.developer.example.taskapplication.MVP.View.ViewDutiesFragment

class DutiesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = ViewDutiesFragment(context)

        val presenter = PresenterDutiesFragment(view , ModelHomeFragment(context))
        presenter.onCreate()

        return view.binding.root
    }


}