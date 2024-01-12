package com.example.smartlamp.presenter.sample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartlamp.UiState
import com.example.smartlamp.domain.GetCurrentColorUseCase
import com.example.smartlamp.domain.GetPossibleColorsUseCase
import com.example.smartlamp.domain.SetColorUseCase
import com.example.smartlamp.domain.TurnOffUseCase
import com.example.smartlamp.domain.TurnOnUseCase
import com.example.smartlamp.toUiState
import kotlinx.coroutines.launch
import javax.inject.Inject

class SampleViewModel @Inject constructor(
    private val turnOnUseCase: TurnOnUseCase,
    private val turnOffUseCase: TurnOffUseCase,
    private val setColorUseCase: SetColorUseCase,
    private val getPossibleColorsUseCase: GetPossibleColorsUseCase,
): ViewModel() {

    private val _colors = MutableLiveData<UiState<List<String>?>>()
    val colors: LiveData<UiState<List<String>?>>
        get() = _colors

    private val _currentColor = MutableLiveData<UiState<String?>>()
    val currentColor: LiveData<UiState<String?>>
        get() = _currentColor


    fun turnOnLamp() {
        viewModelScope.launch {
            turnOnUseCase()
        }
    }

    fun turnOffLamp() {
        viewModelScope.launch {
            turnOffUseCase()
        }
    }


    fun setColor(color: String) {
        viewModelScope.launch {
            _colors.value = UiState.Loading
            val result = setColorUseCase(color)
            _colors.value = result.toUiState()
        }
    }

    fun loadPossibleColors() {
        viewModelScope.launch {
            _colors.value = UiState.Loading
            val result = getPossibleColorsUseCase()
            _colors.value = result.toUiState()
        }
    }
}