package com.bojanvilic.cccandroidtest.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import com.bojanvilic.cccandroidtest.models.Estimate
import com.bojanvilic.cccandroidtest.persistence.AppDatabase
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

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

    override fun getEstimateById(): LiveData<Estimate> {
        return LiveDataReactiveStreams.fromPublisher(
            estimateDao
                .getEstimateById()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map {
                    it
                }
        )
    }

    override suspend fun insertEstimate(estimate: Estimate) {
        estimateDao.insertEstimate(estimate)
    }
}