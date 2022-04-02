package sheridancollege.chhapari.chandanchhaparia_assignment2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Country")
data class Entity(

    @PrimaryKey(autoGenerate = true)
    var id: Long,

    @ColumnInfo(name = "countryName")
    var countryName: String,

    @ColumnInfo(name = "goldMedals")
    var goldMedals: Int,

    @ColumnInfo(name = "silverMedals")
    var silverMedals: Int,

    @ColumnInfo(name = "bronzeMedals")
    var bronzeMedals: Int,


)
