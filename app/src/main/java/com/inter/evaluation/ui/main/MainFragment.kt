package com.inter.evaluation.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import com.inter.evaluation.R
import com.inter.evaluation.adapters.UserAdapter
import com.inter.evaluation.databinding.MainFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.fragment.app.viewModels

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        binding = MainFragmentBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = UserAdapter()
        binding.userList.adapter = adapter

        subscribeUi(adapter)
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun subscribeUi(adapter: UserAdapter) {
        viewModel.users.observe(viewLifecycleOwner) { users ->
            adapter.submitList(users)
            binding.loading!!.visibility = View.GONE
        }
    }
}