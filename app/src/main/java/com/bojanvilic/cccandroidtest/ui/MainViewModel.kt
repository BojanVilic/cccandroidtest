package com.bojanvilic.cccandroidtest.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bojanvilic.cccandroidtest.models.Estimate
import com.bojanvilic.cccandroidtest.models.Person
import com.bojanvilic.cccandroidtest.repositories.EstimateRepositoryImpl
import com.bojanvilic.cccandroidtest.repositories.PersonRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application), IViewContract.ViewModel  {

    private val personRepository = PersonRepositoryImpl.getInstance(application)
    private val estimateRepository = EstimateRepositoryImpl.getInstance(application)

    override fun getPersonById(id: String): LiveData<Person> {
        return personRepository.getPersonById(id)
    }

    override fun insertPerson(person: Person) {
        viewModelScope.launch(Dispatchers.IO){
            personRepository.insertPerson(person)
        }
    }

    override fun getEstimateById(id: String): LiveData<Estimate> {
        return estimateRepository.getEstimateById(id)
    }

    override fun insertEstimate(estimate: Estimate) {
        viewModelScope.launch(Dispatchers.IO){
            estimateRepository.insertEstimate(estimate)
        }
    }
}