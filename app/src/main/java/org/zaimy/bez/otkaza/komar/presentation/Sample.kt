package org.zaimy.bez.otkaza.komar.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import org.zaimy.bez.otkaza.komar.domain.model.StatusApplication.Connect
import org.zaimy.bez.otkaza.komar.domain.model.StatusApplication.Info
import org.zaimy.bez.otkaza.komar.domain.model.StatusApplication.Loading
import org.zaimy.bez.otkaza.komar.domain.model.StatusApplication.Mock
import org.zaimy.bez.otkaza.komar.domain.model.StatusApplication.NoConnect
import org.zaimy.bez.otkaza.komar.domain.model.StatusApplication.Offer
import org.zaimy.bez.otkaza.komar.domain.model.StatusApplication.Splash
import org.zaimy.bez.otkaza.komar.domain.model.StatusApplication.Web

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun Sample(
    viewModel: MainViewModel = hiltViewModel(),
) {

    val state = viewModel.state.collectAsState()

    val loanLazyState = rememberLazyListState()
    when (val currentState = state.value.statusApplication) {
        is Connect -> {
            ConnectScreen(
                baseState = currentState.baseState,
                db = state.value.dbData!!,
                loanLazyState = loanLazyState,
                onEvent = viewModel::onEvent
            )
        }

        Loading -> {
            LoadingScreen()
        }

        is Mock -> {
            NoInternetScreen(onEvent = viewModel::onEvent)
        }

        is Info -> {
        }

        is Offer -> {
            OfferScreen(
                elementOffer = (state.value.statusApplication as Offer).elementOffer,
                baseState = (state.value.statusApplication as Offer).currentBaseState,
                onEvent = viewModel::onEvent,
            )
        }

        is Web -> {
            WebViewScreen(
                url = currentState.url,
                offerName = currentState.offerName,
                onEvent = viewModel::onEvent,
            )
        }

        NoConnect -> {
            NoInternetScreen(onEvent = viewModel::onEvent)
        }

        Splash -> {
            SplashScreen()
        }
    }

}