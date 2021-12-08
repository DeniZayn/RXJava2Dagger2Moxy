package com.example.rxjava2dagger2moxy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.os.PersistableBundle
import android.widget.Button
import com.example.rxjava2dagger2moxy.R.layout.activity_main
import com.example.rxjava2dagger2moxy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(activity_main), MainView {

    private lateinit var vb: ActivityMainBinding
    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)

        vb.btnCounter1.setOnClickListener {
            presenter.counterClick(ButtonTypeEnum.FIRST_BUTTON)
        }
        vb.btnCounter2.setOnClickListener {
            presenter.counterClick(ButtonTypeEnum.SECOND_BUTTON)
        }
        vb.btnCounter3.setOnClickListener {
            presenter.counterClick(ButtonTypeEnum.THIRD_BUTTON)
        }
        presenter.setInitialValue()
}

    override fun setButtonText(model: ButtonUiModel) {
       when(model.index) {
           ButtonTypeEnum.FIRST_BUTTON -> vb.btnCounter1.text= model.value
           ButtonTypeEnum.SECOND_BUTTON -> vb.btnCounter2.text= model.value
           ButtonTypeEnum.THIRD_BUTTON -> vb.btnCounter3.text= model.value

       }
    }
}