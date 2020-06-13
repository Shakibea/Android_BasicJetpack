package com.softseai.androidjetpack.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.softseai.androidjetpack.model.DogBreed

class DetailViewModel : ViewModel() {
    val dogLiveData = MutableLiveData<DogBreed>()

    fun fetch() {
        val dog = DogBreed("1", "Black Dog", "13year", "BreedGroup", "BreedFor", "Temperanment", "")

        dogLiveData.value = dog
    }
}