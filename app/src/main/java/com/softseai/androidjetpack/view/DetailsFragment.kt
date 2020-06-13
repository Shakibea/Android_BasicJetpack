package com.softseai.androidjetpack.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation

import com.softseai.androidjetpack.R
import com.softseai.androidjetpack.model.DogBreed
import com.softseai.androidjetpack.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_details.*
import kotlinx.android.synthetic.main.fragment_details.view.*

/**
 * A simple [Fragment] subclass.
 */
class DetailsFragment : Fragment() {

    private var dogUuid = 0

    private lateinit var viewModel: DetailViewModel
    private val dogsListAdapter = DogsListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        viewModel.fetch()

        arguments?.let {
            dogUuid = DetailsFragmentArgs.fromBundle(it).dogUuid
        }

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.dogLiveData.observe(this, Observer { dog ->
            dog?.let {
                dog_name.text = dog.dogBreed
                dog_lifespan.text = dog.lifeSpan
                dog_purpose.text = dog.breedFor
                dog_temperament.text = dog.temperament
            }
        })
    }

}
