package com.example.learnkotlin.data

import com.example.learnkotlin.R
import com.example.learnkotlin.R.drawable
import com.example.learnkotlin.R.string

class Datasource {
    fun load_topics(): List<KotlinTopics>{
        return listOf<KotlinTopics>(
            KotlinTopics(string.data_types, drawable.kotlin_datatypes),
            KotlinTopics(string.control_flow, drawable.kotlin_controlflow),
            KotlinTopics(string.oop_kotlin, drawable.kotlin_oop),
            KotlinTopics(R.string.kotlin_function_text, R.drawable.kotlin_functions)
        )
    }
}