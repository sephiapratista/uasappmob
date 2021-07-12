package sephiapratista.example.sephiapratista.repository

import androidx.lifecycle.LiveData
import sephiapratista.example.sephiapratista.data.JadwalDAO
import sephiapratista.example.sephiapratista.model.Jadwal

class JadwalRepo(private val jadwalDAO: JadwalDAO){

    val bacaSemuaData: LiveData<List<Jadwal>> = jadwalDAO.bacaSemuaData()

    suspend fun tambahJadwal(jadwal: Jadwal){
     jadwalDAO.tambahJadwal(jadwal)
    }

    suspend fun updateJadwal(jadwal: Jadwal){
        jadwalDAO.updateJadwal(jadwal)
    }

    suspend fun hapusjadwal(jadwal: Jadwal){
        jadwalDAO.hapusJadwal(jadwal)
    }

    suspend fun hapusSemuaJadwal(){
        jadwalDAO.hapusSemua()
    }
}