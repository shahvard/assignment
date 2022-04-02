package sheridancollege.chhapari.chandanchhaparia_assignment2


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Entity::class], version = 1)
abstract class CDatabase : RoomDatabase() {
    abstract fun Dao():Dao
    companion object {
        @Volatile
        private var INSTANCE: CDatabase? = null
        fun getInstance(context: Context): CDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    CDatabase::class.java,
                    "country.db")
                    .build()
            }
            return INSTANCE as CDatabase
        }
    }
}

