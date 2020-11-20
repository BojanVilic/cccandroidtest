package com.bojanvilic.cccandroidtest.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import com.bojanvilic.cccandroidtest.models.Estimate
import com.bojanvilic.cccandroidtest.persistence.AppDatabase

class EstimateRepositoryImpl(private val context: Context) : IEstimateRepository {

    private val estimateDao = AppDatabase.getDatabase(context).estimateDao();

    companion object {
        var instance: EstimateRepositoryImpl? = null
        fun getInstance(context: Context) : EstimateRepositoryImpl {
            if(instance == null) {
                instance = EstimateRepositoryImpl(context)
            }
            return instance as EstimateRepositoryImpl
        }
    }

    override fun getEstimateById(id: String): LiveData<Estimate> {
        return estimateDao.getEstimateById(id)
    }

    override suspend fun insertEstimate(estimate: Estimate) {
        estimateDao.insertEstimate(estimate)
    }
}