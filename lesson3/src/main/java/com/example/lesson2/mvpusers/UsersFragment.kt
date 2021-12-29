package com.example.lesson2.mvpusers

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.lesson2.App

import com.example.lesson2.R
import com.example.lesson2.data.GitHubUser
import com.example.lesson2.recycler.UsersAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import com.example.lesson2.databinding.ViewUsersBinding

class UsersFragment: MvpAppCompatFragment(R.layout.view_users), UsersView, UsersAdapter.OnUserClickListener {

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter().apply {
            App.instance.component.inject(this)
        }
    }

    private val usersAdapter = UsersAdapter(this)
    private lateinit var viewBinging: ViewUsersBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinging = ViewUsersBinding.bind(view)
        viewBinging.usersRecycler.adapter = usersAdapter
    }

    override fun showUsers(users: List<GitHubUser>) {
        usersAdapter.submitList(users)
    }

    override fun onUserPicked(user: GitHubUser) =
        presenter.goToNextScreen(user.login!!)

    companion object {
        fun newInstance(): Fragment = UsersFragment()
    }
}