package com.softseai.androidjetpack.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.softseai.androidjetpack.R
import com.softseai.androidjetpack.model.DogBreed
import com.softseai.androidjetpack.util.getProgressDrawable
import com.softseai.androidjetpack.util.loadImage
import kotlinx.android.synthetic.main.dogs_list_item.view.*

class DogsListAdapter(val dogsList: ArrayList<DogBreed>) :
    RecyclerView.Adapter<DogsListAdapter.DogViewHolder>() {

    //Working for API
    fun updateDogList(newDogList: List<DogBreed>) {
        dogsList.clear()
        dogsList.addAll(newDogList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.dogs_list_item, parent, false)
        return DogViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.view.name.text = dogsList[position].dogBreed
        holder.view.lifespan.text = dogsList[position].lifeSpan
        holder.view.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(ListFragmentDirections.actionDetailsFragment())
        }
        holder.view.image.loadImage(dogsList[position].imageUrl, getProgressDrawable(holder.view.image.context))
    }

    override fun getItemCount() = dogsList.size

    inner class DogViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}