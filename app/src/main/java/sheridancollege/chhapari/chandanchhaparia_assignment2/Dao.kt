package sheridancollege.chhapari.chandanchhaparia_assignment2

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Dao {
    @Query("SELECT * FROM country")
    fun getAll(): List<Entity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(student: Entity)

    @Query("SELECT * FROM country ORDER BY countryName")
    fun getOrderByName():List<Entity>

    @Query("SELECT * FROM country ORDER BY goldMedals")
    fun getOrderByGoldMedals(): List<Entity>

    @Query("SELECT * FROM country ORDER BY (SELECT goldMedals+silverMedals+bronzeMedals FROM country)")
    fun getOrderByTotalMedals():List<Entity>
}