package org.zaimy.bez.otkaza.komar.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import org.zaimy.bez.otkaza.komar.R
import org.zaimy.bez.otkaza.komar.domain.model.basedto.BaseDto
import org.zaimy.bez.otkaza.komar.domain.model.basedto.BaseState
import org.zaimy.bez.otkaza.komar.domain.model.basedto.BaseState.Loans
import org.zaimy.bez.otkaza.komar.ui.theme.baseBackground
import org.zaimy.bez.otkaza.komar.ui.theme.blue


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConnectScreen(
    modifier: Modifier = Modifier,
    db: BaseDto,
    baseState: BaseState,
    onEvent: (MainEvent) -> Unit,
    loanLazyState: LazyListState,
) {
    val title = when (baseState) {
        Loans -> stringResource(id = R.string.loans)
    }
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = modifier
                            .fillMaxWidth(),
                    ) {
                        Text(
                            modifier = modifier
                                .fillMaxWidth(),
                            color = baseBackground,
                            fontStyle = FontStyle(R.font.montserrat),
                            fontSize = 28.sp,
                            fontWeight = FontWeight(700),
                            text = title,
                            textAlign = TextAlign.Start
                        )
                        /*IconButton(onClick = onClickRules) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.info),
                                tint = black,
                                contentDescription = "")
                        }*/
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = blue
                )
            )
        }
    ) { valuePaddings ->
        when (baseState) {
            Loans -> {
                Loans(
                    valuePaddings = valuePaddings,
                    loans = db.loans,
                    onEvent = onEvent,
                    baseState = baseState,
                    loanLazyState = loanLazyState
                )
            }
        }
    }
}
