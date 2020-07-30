package com.softseai.androidjetpack.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation

import com.softseai.androidjetpack.R
import com.softseai.androidjetpack.databinding.FragmentDetailsBinding
import com.softseai.androidjetpack.model.DogBreed
import com.softseai.androidjetpack.util.getProgressDrawable
import com.softseai.androidjetpack.util.loadImage
import com.softseai.androidjetpack.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.dogs_list_item.view.*
import kotlinx.android.synthetic.main.fragment_details.*
import kotlinx.android.synthetic.main.fragment_details.view.*

/**
 * A simple [Fragment] subclass.
 */
class DetailsFragment : Fragment() {

    private var dogUuid = 0

    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding: FragmentDetailsBinding

    private val dogsListAdapter = DogsListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
//        return inflater.inflate(R.layout.fragment_details, container, fa
    ): View? {
//        // Inflate the layout for this fragmentlse)
        dataBinding = DataBindingUtil.inflate<FragmentDetailsBinding>(inflater, R.layout.fragment_details, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            dogUuid = DetailsFragmentArgs.fromBundle(it).dogUuid
        }

        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        viewModel.fetch(dogUuid)


        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.dogLiveData.observe(this, Observer { dog ->
            dog?.let {
                dataBinding.dog = dog
//                dog_name.text = dog.dogBreed
//                dog_lifespan.text = dog.lifeSpan
//                dog_purpose.text = dog.breedFor
//                dog_temperament.text = dog.temperament
//                context?.let {
//                    dog_image.loadImage(
//                        dog.imageUrl,
//                        getProgressDrawable(it)
//                    )
//                }
            }
        })
    }

}
