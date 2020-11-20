package com.bojanvilic.cccandroidtest.persistence

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bojanvilic.cccandroidtest.models.Estimate
import io.reactivex.Flowable

@Dao
interface EstimateDao {

    @Query("SELECT * FROM estimate_table")
    fun getEstimateById() : Flowable<Estimate>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEstimate(estimate: Estimate)

}