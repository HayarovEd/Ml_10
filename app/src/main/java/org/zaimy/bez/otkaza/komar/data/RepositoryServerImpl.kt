package org.zaimy.bez.otkaza.komar.data

import android.util.Log
import org.zaimy.bez.otkaza.komar.domain.RepositoryServer
import javax.inject.Inject
import org.zaimy.bez.otkaza.komar.domain.model.basedto.BaseDto
import org.zaimy.bez.otkaza.komar.data.Resource.Error
import org.zaimy.bez.otkaza.komar.data.Resource.Success

class RepositoryServerImpl @Inject constructor(
    private val apiServer: ApiServer
) : RepositoryServer {
    override suspend fun getDataDb(): Resource<BaseDto> {
        return try {
            val folder = apiServer.getDataDb()
            Log.d("DATADB", "dATA DB:${folder.loans.first().id}")
            Success(
                data = folder
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Error(e.message ?: "An unknown error")
        }
    }
}