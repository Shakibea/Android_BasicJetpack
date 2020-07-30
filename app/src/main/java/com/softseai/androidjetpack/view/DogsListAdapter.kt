package com.softseai.androidjetpack.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.softseai.androidjetpack.R
import com.softseai.androidjetpack.databinding.DogsListItemBinding
import com.softseai.androidjetpack.model.DogBreed
import com.softseai.androidjetpack.util.getProgressDrawable
import com.softseai.androidjetpack.util.loadImage
import kotlinx.android.synthetic.main.dogs_list_item.view.*

class DogsListAdapter(private val dogsList: ArrayList<DogBreed>) :
    RecyclerView.Adapter<DogsListAdapter.DogViewHolder>(), DogClickListener {

    //Working for API
    fun updateDogList(newDogList: List<DogBreed>) {
        dogsList.clear()
        dogsList.addAll(newDogList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
//        val view = inflater.inflate(R.layout.dogs_list_item, parent, false)
        val view = DataBindingUtil.inflate<DogsListItemBinding>(inflater, R.layout.dogs_list_item, parent, false)
        return DogViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
//        holder.view.name.text = dogsList[position].dogBreed
//        holder.view.lifespan.text = dogsList[position].lifeSpan
//        holder.view.setOnClickListener {
//            val action = ListFragmentDirections.actionDetailsFragment()
//            action.dogUuid = dogsList[position].uuid
//            Navigation.findNavController(it)
//                .navigate(action)
//        }
//        holder.view.image.loadImage(
//            dogsList[position].imageUrl,
//            getProgressDrawable(holder.view.image.context)
//        )

        holder.view.dog = dogsList[position]
        holder.view.listener = this

    }

    override fun getItemCount() = dogsList.size

//    inner class DogViewHolder(val view: View) : RecyclerView.ViewHolder(view)
    inner class DogViewHolder(val view: DogsListItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onDogClicked(v: View) {
        val uuid = v.dogId.text.toString().toInt()
        val action = ListFragmentDirections.actionDetailsFragment()
            action.dogUuid = uuid
            Navigation.findNavController(v).navigate(action)
    }
}