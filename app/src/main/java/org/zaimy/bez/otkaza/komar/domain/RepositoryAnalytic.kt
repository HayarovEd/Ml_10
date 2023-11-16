package org.zaimy.bez.otkaza.komar.domain

import org.zaimy.bez.otkaza.komar.data.Resource
import org.zaimy.bez.otkaza.komar.domain.model.Sub1
import org.zaimy.bez.otkaza.komar.domain.model.Sub2
import org.zaimy.bez.otkaza.komar.domain.model.Sub3
import org.zaimy.bez.otkaza.komar.domain.model.Sub5


interface RepositoryAnalytic {
    suspend fun getSub1 (
        applicationToken: String,
        userId: String,
        myTrackerId: String,
        appMetricaId: String,
        appsflyer: String,
        firebaseToken: String
    ): Resource<Sub1>

    suspend fun getSub2 (
        applicationToken: String,
        userId: String,
        appsflyer: String,
        myTracker: String,
    ): Resource<Sub2>

    suspend fun getSub3 (
        applicationToken: String,
        userId: String,
        myTrackerId: String,
        appMetricaId: String,
        appsflyer: String,
        firebaseToken: String,
    ): Resource<Sub3>

    suspend fun getSub5 (
        applicationToken: String,
        userId: String,
        gaid:String
    ): Resource<Sub5>
}