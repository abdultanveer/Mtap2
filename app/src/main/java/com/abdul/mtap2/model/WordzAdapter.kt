package com.abdul.mtap2.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.abdul.mtap2.R

class WordzAdapter(var words: Array<String>) : ListAdapter<Word1, WordzAdapter.WordVH>(
    WORDS_COMPARATOR
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordVH {
        return WordVH.create(parent)
    }

    override fun onBindViewHolder(holder: WordVH, position: Int) {
        val current = getItem(position)
        //holder.bind(current.word)
        holder.bind(words[position])
    }


    class WordVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val wordItemView: TextView = itemView.findViewById(R.id.tvRvItem)
        fun bind(word: String) {
            wordItemView.text = word
        }

        companion object {
            fun create(parent: ViewGroup): WordVH {
                val view: View =
                    LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
                return WordVH(view)
            }
        }

    }
        companion object {
            private val WORDS_COMPARATOR = object : DiffUtil.ItemCallback<Word1>() {
                override fun areItemsTheSame(oldItem: Word1, newItem: Word1): Boolean {
                    return oldItem === newItem
                }

                override fun areContentsTheSame(oldItem: Word1, newItem: Word1): Boolean {
                    return oldItem.word == newItem.word
                }
            }
        }
    }


/*
    //RecyclerView.Adapter<WordzAdapter.WordVH>() {


 class WordVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val wordItemView: TextView = itemView.findViewById(R.id.tvRvItem)
        fun bind(word: String) {
            wordItemView.text = word
        }

        companion object {
            fun create(parent: ViewGroup): WordVH {
                val view: View =
                    LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
                return WordVH(view)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordVH {
        return  WordVH.create(parent)
    }

    override fun onBindViewHolder(holder: WordVH, position: Int) {
        holder.bind(words[position])
    }

    override fun getItemCount(): Int {
        return words.size
    }
}
   */


