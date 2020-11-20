package com.bojanvilic.cccandroidtest.repositories

import androidx.lifecycle.LiveData
import com.bojanvilic.cccandroidtest.models.Estimate
import io.reactivex.Flowable

interface IEstimateRepository {
    fun getEstimateById() : LiveData<Estimate>
    suspend fun insertEstimate(estimate: Estimate)
}