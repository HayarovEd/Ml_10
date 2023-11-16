package org.zaimy.bez.otkaza.komar.domain

import org.zaimy.bez.otkaza.komar.data.Resource
import org.zaimy.bez.otkaza.komar.domain.model.basedto.BaseDto

interface RepositoryServer {
    suspend fun getDataDb() : Resource<BaseDto>
}