package sephiapratista.example.sephiapratista.data

import androidx.lifecycle.LiveData
import androidx.room.*
import sephiapratista.example.sephiapratista.model.Jadwal

@Dao
interface JadwalDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun tambahJadwal(jadwal: Jadwal)

    @Query("SELECT * FROM jadwal_kuliah ORDER BY id ASC")
    fun bacaSemuaData(): LiveData<List<Jadwal>>

    @Update
    suspend fun updateJadwal(jadwal: Jadwal)

    @Delete
    suspend fun hapusJadwal(jadwal: Jadwal)

    @Query("DELETE FROM jadwal_kuliah")
    suspend fun hapusSemua()
}