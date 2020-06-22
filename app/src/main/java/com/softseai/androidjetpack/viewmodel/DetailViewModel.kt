package com.softseai.androidjetpack.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.softseai.androidjetpack.model.DogBreed
import com.softseai.androidjetpack.model.DogDatabase
import kotlinx.coroutines.launch

class DetailViewModel(application: Application) : BaseViewModel(application) {
    val dogLiveData = MutableLiveData<DogBreed>()

    fun fetch(id: Int) {
        launch {
            val getDog = DogDatabase(getApplication()).dogDao().getDog(id)
            dogLiveData.value = getDog
        }
    }
}