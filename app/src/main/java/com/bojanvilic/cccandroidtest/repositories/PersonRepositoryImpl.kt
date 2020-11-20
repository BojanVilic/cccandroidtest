package com.bojanvilic.cccandroidtest.repositories

import android.app.Person
import android.content.Context
import androidx.lifecycle.LiveData
import com.bojanvilic.cccandroidtest.persistence.AppDatabase

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

    override fun getPersonById(id: String): LiveData<com.bojanvilic.cccandroidtest.models.Person> {
        return personDao.getPersonById(id)
    }

    override suspend fun insertPerson(person: com.bojanvilic.cccandroidtest.models.Person) {
        personDao.insertPerson(person)
    }
}