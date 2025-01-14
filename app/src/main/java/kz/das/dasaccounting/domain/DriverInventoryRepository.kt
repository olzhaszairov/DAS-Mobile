package kz.das.dasaccounting.domain

import androidx.lifecycle.LiveData
import kz.das.dasaccounting.domain.data.drivers.FligelProduct
import kz.das.dasaccounting.domain.data.drivers.TransportInventory
import kz.das.dasaccounting.domain.data.history.HistoryTransfer

interface DriverInventoryRepository {

//    suspend fun initAwaitAcceptInventory()
//
//    suspend fun initAwaitSendInventory()
//
//    suspend fun initAwaitReceiveFligerData()

    fun getUnsentInventories(): List<TransportInventory>

    fun getUnAcceptedInventories(): List<TransportInventory>

    fun getFligelData(): List<FligelProduct>

    suspend fun removeFligelData(fligelProduct: FligelProduct)

    suspend fun removeUnsentInventory(transportInventory: TransportInventory)

    suspend fun removeUnAcceptedInventory(transportInventory: TransportInventory)

    suspend fun getDriverTransports(): List<TransportInventory>

    suspend fun acceptInventory(transportInventory: TransportInventory, comment: String, fileIds: ArrayList<Int>?): Any

    suspend fun sendInventory(transportInventory: TransportInventory): Any

    suspend fun receiveFligelData(fligelProduct: FligelProduct, fileIds: ArrayList<Int>?): Any

    suspend fun saveAwaitReceiveFligelData(fligelProduct: FligelProduct)

    suspend fun saveAwaitAcceptInventory(transportInventory: TransportInventory, comment: String, fileIds: ArrayList<Int>)

    suspend fun saveAwaitSentInventory(transportInventory: TransportInventory)

    suspend fun removeItem(transportInventory: TransportInventory)

    suspend fun addItem(transportInventory: TransportInventory)

    fun getTransportsLocally(): LiveData<List<TransportInventory>>

    fun getDriverSentMaterialsLocally(): LiveData<List<HistoryTransfer>>

    fun getDriverAcceptedMaterialsLocally(): LiveData<List<HistoryTransfer>>

    fun getHistoryDriverAcceptedMaterialsLocally(): LiveData<List<HistoryTransfer>>

    fun getHistoryDriverSentMaterialsLocally(): LiveData<List<HistoryTransfer>>

    fun getAwaitFligelDataLocally(): LiveData<List<FligelProduct>>

    fun getHistoryDriverAcceptedFligelLocally(): LiveData<List<HistoryTransfer>>

    fun initDeleteData()

    fun containsAwaitRequests(): Boolean

}