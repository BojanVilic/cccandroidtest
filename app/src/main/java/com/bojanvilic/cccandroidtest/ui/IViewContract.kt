package com.bojanvilic.cccandroidtest.ui

import androidx.lifecycle.LiveData
import com.bojanvilic.cccandroidtest.models.Estimate
import com.bojanvilic.cccandroidtest.models.Person

interface IViewContract {
    interface View {

    }

    interface ViewModel{
        fun getPersonById(id: String) : LiveData<Person>
        fun insertPerson(person: Person)
        fun getEstimateById(id: String) : LiveData<Estimate>
        fun insertEstimate(estimate: Estimate)
    }
}