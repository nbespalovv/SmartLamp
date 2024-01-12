package com.example.smartlamp.presenter.sample

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Spinner
import android.widget.Switch
import android.widget.ToggleButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.smartlamp.R
import com.example.smartlamp.UiState
import com.example.smartlamp.databinding.FragmentSampleBinding
import com.example.smartlamp.di.ViewModelFactory
import com.example.smartlamp.di.appComponent
import javax.inject.Inject

class SampleFragment : Fragment(R.layout.fragment_sample) {

    val binding: FragmentSampleBinding by viewBinding()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: SampleViewModel by viewModels { viewModelFactory }

    private val adapter = SampleAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val switch = binding.root.findViewById<Switch>(R.id.switchButton)
        switch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                viewModel.turnOnLamp()
            } else {
                viewModel.turnOffLamp()
            }
        }

        val colorSpinner = binding.root.findViewById<Spinner>(R.id.colorSpinner)
        setupColorSpinner(colorSpinner)
    }

    private fun onDataReceived(useCaseResult: UiState<List<String>>?) {
        when(useCaseResult) {
            is UiState.Success -> {
                val result = useCaseResult.value
                binding.sampleProgress.visibility = View.GONE
                binding.errorImage.visibility = View.GONE
                binding.errorTitle.visibility = View.GONE
                binding.errorSubtitle.visibility = View.GONE
            }
            is UiState.Failure -> {
                binding.sampleProgress.visibility = View.GONE
                binding.errorImage.visibility = View.VISIBLE
                binding.errorTitle.visibility = View.VISIBLE
                binding.errorSubtitle.visibility = View.VISIBLE
                binding.errorSubtitle.text = useCaseResult.message
            }
            is UiState.Loading -> {
                binding.sampleProgress.visibility = View.VISIBLE
                binding.errorImage.visibility = View.GONE
                binding.errorTitle.visibility = View.GONE
                binding.errorSubtitle.visibility = View.GONE
            }
            else -> {}
        }
    }



    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)

    }
}