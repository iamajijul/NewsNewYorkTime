package com.ajijul.newsnewyorktimes.base

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.ajijul.newsnewyorktimes.helper.MessageHandlerImp
import com.ajijul.newsnewyorktimes.ui.articles.ArticleViewModel
import dagger.hilt.android.AndroidEntryPoint
import fr.dasilvacampos.network.monitoring.Event
import fr.dasilvacampos.network.monitoring.NetworkConnectivityListener
import javax.inject.Inject

@AndroidEntryPoint
open class BaseFragment constructor(layoutId : Int) : Fragment(layoutId)
     {

    protected val viewModel by activityViewModels<ArticleViewModel>()
    @Inject
    lateinit var messageHandlerImp: MessageHandlerImp

    protected val mainView: View by lazy {
        requireView()

    }

}