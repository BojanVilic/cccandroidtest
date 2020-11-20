package com.bojanvilic.cccandroidtest.ui

import androidx.lifecycle.LiveData
import com.bojanvilic.cccandroidtest.models.Estimate
import com.bojanvilic.cccandroidtest.models.Person

interface IViewContract {
    interface View {

    }

    interface ViewModel{
        fun getPersonById() : LiveData<Person>
        fun insertPerson(person: Person)
        fun getEstimateById() : LiveData<Estimate>
        fun insertEstimate(estimate: Estimate)
    }
}