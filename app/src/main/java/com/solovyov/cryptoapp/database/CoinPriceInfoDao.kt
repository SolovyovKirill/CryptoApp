package com.solovyov.cryptoapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.solovyov.cryptoapp.pojo.CoinPriceInfo

@Dao
interface CoinPriceInfoDao {

    @Query("SELECT*FROM full_price_list ORDER BY lastUpdate")
    fun getPriceList() : LiveData<List<CoinPriceInfo>>

    @Query("SELECT*FROM FULL_PRICE_LIST WHERE fromSymbol == :fSym LIMIT 1")
    fun getPriceInfoAboutCoin(fSym: String) : LiveData<CoinPriceInfo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insetPriceList(priceList: List<CoinPriceInfo>)

}