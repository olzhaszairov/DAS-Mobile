package kz.das.dasaccounting.data.entities.history

import androidx.room.Entity
import androidx.room.PrimaryKey
import kz.das.dasaccounting.domain.data.history.HistoryTransportInventory
import java.io.Serializable

@Entity(tableName = "history_transport_inventory")
data class HistoryTransportInventoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val dateTime: String? = null,
    val uuid: String,
    val name: String? = null,
    val stateNumber: String? = null,
    val tsType: String? = null,
    val longitude: String? = null,
    val latitude: String? = null,
    val quantity: String? = null,
    val fullName: String? = null,
    val molUUID: String? = null,
    val status: String? = null
): Serializable

fun HistoryTransportInventoryEntity.toDomain(): HistoryTransportInventory {
    return HistoryTransportInventory(
        id = this.id,
        dateTime = this.dateTime,
        uuid = this.uuid,
        name = this.name,
        stateNumber = this.stateNumber,
        tsType = this.tsType,
        longitude = this.longitude,
        latitude = this.latitude,
        quantity = this.quantity,
        fullName = this.fullName,
        molUUID = this.molUUID,
        status = this.status
    )
}