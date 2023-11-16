package org.zaimy.bez.otkaza.komar.data

import org.zaimy.bez.otkaza.komar.domain.model.basedto.BaseDto
import retrofit2.http.GET

interface ApiServer {
    @GET ("526/db.json")
    suspend fun getDataDb () : BaseDto
}