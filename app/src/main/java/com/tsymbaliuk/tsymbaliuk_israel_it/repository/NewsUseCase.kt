package com.tsymbaliuk.tsymbaliuk_israel_it.repository

interface NewsUseCase {

    fun getCovidNews()

    fun getTopUaNews()

    fun getAllTopics()

    fun getNewsByTopic()

    fun getNewsBySource()

    fun getAllSources()

}