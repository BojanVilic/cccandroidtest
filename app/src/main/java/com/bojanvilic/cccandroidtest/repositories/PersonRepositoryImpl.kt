package com.bojanvilic.cccandroidtest.repositories

import android.app.Person
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import com.bojanvilic.cccandroidtest.persistence.AppDatabase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PersonRepositoryImpl(context: Context) : IPersonRepository {

    private val personDao = AppDatabase.getDatabase(context).personDao();

    companion object {
        var instance: PersonRepositoryImpl? = null
        fun getInstance(context: Context) : PersonRepositoryImpl {
            if(instance == null) {
                instance = PersonRepositoryImpl(context)
            }
            return instance as PersonRepositoryImpl
        }
    }

    override fun getPersonById(): LiveData<com.bojanvilic.cccandroidtest.models.Person> {
        return LiveDataReactiveStreams.fromPublisher(
            personDao
                .getPersonById()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map {
                    it
                }
        )
    }

    override suspend fun insertPerson(person: com.bojanvilic.cccandroidtest.models.Person) {
        personDao.insertPerson(person)
    }
}