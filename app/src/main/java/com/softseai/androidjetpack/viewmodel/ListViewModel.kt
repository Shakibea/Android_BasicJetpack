package com.softseai.androidjetpack.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.softseai.androidjetpack.model.DogBreed

class ListViewModel : ViewModel() {
    val dogs = MutableLiveData<List<DogBreed>>()
    val dogLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        val dogList = arrayListOf<DogBreed>(
            DogBreed("1", "Black Dog", "13year", "BreedGroup", "BreedFor", "Temperanment", ""),
            DogBreed("2", "White Dog", "10year", "BreedGroup", "BreedFor", "Temperanment", ""),
            DogBreed("3", "Brown Dog", "12year", "BreedGroup", "BreedFor", "Temperanment", "")
        )

        dogs.value = dogList
        dogLoadError.value = false
        loading.value = false
    }

}