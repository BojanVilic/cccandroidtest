package com.bojanvilic.cccandroidtest.persistence

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bojanvilic.cccandroidtest.models.Person
import io.reactivex.Flowable

@Dao
interface PersonDao {

    @Query("SELECT * FROM person_table")
    fun getPersonById() : Flowable<Person>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPerson(person: Person)

}