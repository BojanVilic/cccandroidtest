package com.bojanvilic.cccandroidtest.repositories

import androidx.lifecycle.LiveData
import com.bojanvilic.cccandroidtest.models.Person

interface IPersonRepository {
    fun getPersonById(id: String) : LiveData<Person>
    suspend fun insertPerson(person: Person)
}