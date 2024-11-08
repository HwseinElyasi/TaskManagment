package hwsein.developer.example.taskapplication.CustomView

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import hwsein.developer.example.taskapplication.R
import hwsein.developer.example.taskapplication.databinding.CustomButtonBinding

class CustomButton(
    contextInstance : Context ,
    attr : AttributeSet
) : FrameLayout(contextInstance , attr) {

    val binding = CustomButtonBinding.inflate(LayoutInflater.from(contextInstance))

    init {

        addView(binding.root)
        initialize(attr)

    }

    private fun initialize(attribute : AttributeSet){

        val typeArray = context.obtainStyledAttributes(attribute , R.styleable.CustomButton)
        val text = typeArray.getString(R.styleable.CustomButton_text)
        binding.cusBtn.text = text

        val background = typeArray.getDrawable(R.styleable.CustomButton_android_background)
        background.let {

            binding.cusBtn.background = it

        }

        val textColor = typeArray.getColor(R.styleable.CustomButton_android_textColor , Color.BLACK )
        binding.cusBtn.setTextColor(textColor)

        typeArray.recycle()



    }

    fun getVIew() = binding.cusBtn


}