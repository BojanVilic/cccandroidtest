package com.bojanvilic.cccandroidtest.repositories

import androidx.lifecycle.LiveData
import com.bojanvilic.cccandroidtest.models.Estimate

interface IEstimateRepository {
    fun getEstimateById(id: String) : LiveData<Estimate>
    suspend fun insertEstimate(estimate: Estimate)
}