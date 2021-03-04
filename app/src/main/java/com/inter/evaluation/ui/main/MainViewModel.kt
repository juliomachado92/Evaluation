package com.inter.evaluation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.inter.evaluation.data.User
import com.inter.evaluation.data.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject internal constructor(
    userRepository: UserRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val users : LiveData<List<User>> =
        userRepository.getUsers().asLiveData()


}