package com.sohail.simplecontactstore.recyler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sohail.simplecontactstore.R
import com.sohail.simplecontactstore.database.model.Name

class MyAdapter(private val names : ArrayList<Name>) : RecyclerView.Adapter<MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameTextView.text = "name = ${names[position].name}"
        holder.numberTextView.text = "number = ${names[position].number}"
        holder.ageTextView.text = "age = ${names[position].age}"
        holder.uploadedTextView.text = "uploaded online = ${names[position].uploaded}"
    }

    override fun getItemCount(): Int {
        return names.size
    }
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
    val numberTextView: TextView = itemView.findViewById(R.id.numberTextView)
    val ageTextView: TextView = itemView.findViewById(R.id.ageTextView)
    val uploadedTextView: TextView = itemView.findViewById(R.id.uploadedTextView)


}