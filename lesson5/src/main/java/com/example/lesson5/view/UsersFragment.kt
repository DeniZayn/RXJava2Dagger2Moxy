package com.example.lesson5.view

import android.annotation.SuppressLint
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson5.App.Navigation.router
import com.example.lesson5.R
import com.example.lesson5.databinding.FragmentUsersBinding
import com.example.lesson5.model.repo.GithubUsersRepoFactory
import com.example.lesson5.presenter.BackButtonListener
import com.example.lesson5.presenter.UsersPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(R.layout.fragment_users), UsersView, BackButtonListener {

    companion object {
        fun newInstance() = UsersFragment()
    }

    private val binding: FragmentUsersBinding by viewBinding()
    private val presenter by moxyPresenter {
        UsersPresenter(
            GithubUsersRepoFactory.create(),
            router)
    }
    private var adapter: UsersRVAdapter? = null

    override fun init() {
        adapter = UsersRVAdapter(presenter.usersListPresenter)
        binding.rvUsers.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun showToast(message: String) {
        Toast.makeText(requireActivity(), message, Toast.LENGTH_LONG).show()
    }

    override fun backPressed() = presenter.backPressed()
}