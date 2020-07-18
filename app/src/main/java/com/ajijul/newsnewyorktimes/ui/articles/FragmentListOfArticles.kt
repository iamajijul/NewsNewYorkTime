package com.ajijul.newsnewyorktimes.ui.articles

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ajijul.newsnewyorktimes.R
import com.ajijul.newsnewyorktimes.base.BaseFragment
import com.ajijul.newsnewyorktimes.network.ResponseWrapper
import com.ajijul.newsnewyorktimes.ui.adapters.ArticleAdapter
import kotlinx.android.synthetic.main.fragment_list_of_article.*

class FragmentListOfArticles : BaseFragment(R.layout.fragment_list_of_article) {

    lateinit var articleAdapter : ArticleAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpOurRecyclerView()
        observeOurData()
    }
    private fun observeOurData(){
        viewModel.observeArticles().observe(viewLifecycleOwner, Observer {
            when (it) {
                is ResponseWrapper.Success -> {
                    handleProgress(false)
                    it.data?.let {
                        articleAdapter.differList.submitList(it.results)
                    }
                    messageHandlerImp.showSnackSuccess(mainView,R.string.successMessage,true)
                }
                is ResponseWrapper.Error -> {
                    handleProgress(false)
                    messageHandlerImp.showSnackErrorWithAction(mainView,R.string.errorMessage){
                        viewModel.getLatestArticles()
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
}