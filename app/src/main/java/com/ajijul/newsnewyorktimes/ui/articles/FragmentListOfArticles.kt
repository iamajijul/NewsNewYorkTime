package com.ajijul.newsnewyorktimes.ui.articles

import android.content.ActivityNotFoundException
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ajijul.newsnewyorktimes.R
import com.ajijul.newsnewyorktimes.base.BaseFragment
import com.ajijul.newsnewyorktimes.network.ResponseWrapper
import com.ajijul.newsnewyorktimes.ui.adapters.ArticleAdapter
import fr.dasilvacampos.network.monitoring.Event
import fr.dasilvacampos.network.monitoring.NetworkConnectivityListener
import kotlinx.android.synthetic.main.fragment_list_of_article.*
import timber.log.Timber


class FragmentListOfArticles : BaseFragment(R.layout.fragment_list_of_article),
    NetworkConnectivityListener {

    lateinit var articleAdapter: ArticleAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpOurRecyclerView()
    }


    private fun observerOfflineData() {

        viewModel.observeArticlesOffline().observe(viewLifecycleOwner, Observer {
            it?.let {
                articleAdapter.differList.submitList(it)
            }
        })
    }

    private fun observerNetworkData() {
        viewModel.observeArticlesOnline().observe(viewLifecycleOwner, Observer {
            when (it) {
                is ResponseWrapper.Success -> {
                    handleProgress(false)
                    it.data?.let {
                        articleAdapter.differList.submitList(it.results)
                    }
                    messageHandlerImp.showSnackSuccess(mainView, R.string.successMessage, true)
                }
                is ResponseWrapper.Error -> {
                    handleProgress(false)
                    messageHandlerImp.showSnackErrorWithAction(
                        mainView,
                        R.string.retry_text,
                        R.string.errorMessage
                    ) {
                        viewModel.retryToFetchedArticle(true)
                    }

                }
                is ResponseWrapper.Loading -> {
                    handleProgress(true)
                }
            }
        })
    }

    private fun setUpOurRecyclerView() {
        articleAdapter = ArticleAdapter()
        articleAdapter.setOnClickListener {
            chromeBrowserIntent.setData(Uri.parse(it.url))
            try {
                requireContext().startActivity(chromeBrowserIntent)
            } catch (ex: ActivityNotFoundException) {
                messageHandlerImp.showSnackErrorWithAction(mainView,R.string.ok,R.string.noAppFound){}
            }
        }
        rvArticles.apply {
            adapter = articleAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

    }

    private fun handleProgress(isShow: Boolean) {
        if (isShow) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    override fun networkConnectivityChanged(event: Event) {
        when (event) {
            is Event.ConnectivityEvent -> if (event.isConnected) {
                observerNetworkData()
            } else {
                messageHandlerImp.showSnackErrorWithAction(
                    mainView,
                    R.string.ok,
                    R.string.offlineMesssage
                ) {
                    viewModel.retryToFetchedArticle(true)
                }
                observerOfflineData()
            }
        }
    }
}