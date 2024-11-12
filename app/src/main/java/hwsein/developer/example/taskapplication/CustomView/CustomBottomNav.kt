package hwsein.developer.example.taskapplication.CustomView

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import hwsein.developer.example.taskapplication.R
import hwsein.developer.example.taskapplication.databinding.CustomBottomBinding
import hwsein.developer.example.taskapplication.ext.ActiveItem
import hwsein.developer.example.taskapplication.ext.SetView

class CustomBottomNav(
    contextInstance: Context,
    attr: AttributeSet
) : FrameLayout(contextInstance, attr) {

    val binding = CustomBottomBinding.inflate(LayoutInflater.from(contextInstance))

    init {

        addView(binding.root)

    }


    fun onClickHandler(activeItem: ActiveItem){

        binding.viewHome.setOnClickListener {

            activeItem.activeView(SetView.HOME)
            activeHome()

        }

        binding.viewAbout.setOnClickListener {

            activeItem.activeView(SetView.ABOUT)
            activeAbout()

        }

        binding.imageDocument.setOnClickListener {

            activeItem.activeView(SetView.DOCUMENT)
            activeDocument()

        }



        }

        private fun activeHome(){

            binding.imageHome.setImageResource(R.drawable.home_color)
            binding.imageAbout.setImageResource(R.drawable.about_no_color)
            binding.imageDocument.setImageResource(R.drawable.document_no_color)

        }

        private fun activeDocument(){

            binding.imageDocument.setImageResource(R.drawable.document_color)
            binding.imageAbout.setImageResource(R.drawable.about_no_color)
            binding.imageHome.setImageResource(R.drawable.home_no_color)

        }

        private fun activeAbout(){

            binding.imageAbout.setImageResource(R.drawable.about_color)
            binding.imageHome.setImageResource(R.drawable.home_no_color)
            binding.imageDocument.setImageResource(R.drawable.document_no_color)

        }


}