package org.zaimy.bez.otkaza.komar.presentation

import org.zaimy.bez.otkaza.komar.domain.model.StatusApplication
import org.zaimy.bez.otkaza.komar.domain.model.basedto.BaseState


sealed class MainEvent {
    object Reconnect: MainEvent()

    class OnChangeStatusApplication(val statusApplication: StatusApplication): MainEvent()
    class OnChangeBaseState(val baseState: BaseState): MainEvent()

    class OnGoToWeb(
        val urlOffer: String,
        val nameOffer: String
        ): MainEvent()
}
