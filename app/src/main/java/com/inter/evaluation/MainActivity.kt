package com.inter.evaluation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.inter.evaluation.databinding.MainActivityBinding
import com.inter.evaluation.ui.main.MainFragment
import dagger.hilt.android.AndroidEntryPoint
import androidx.databinding.DataBindingUtil.setContentView
import com.inter.evaluation.ui.main.MainViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //@Inject lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView<MainActivityBinding>(this, R.layout.main_activity)

        //Atualizar Banco



    }
}