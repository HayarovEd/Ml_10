package org.zaimy.bez.otkaza.komar.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.zaim.metr.dokm.domzaem.data.VALUE_ONE
import com.zaim.metr.dokm.domzaem.presentation.RowButtons
import org.zaimy.bez.otkaza.komar.R
import org.zaimy.bez.otkaza.komar.domain.model.ElementOffer
import org.zaimy.bez.otkaza.komar.domain.model.StatusApplication.Offer
import org.zaimy.bez.otkaza.komar.domain.model.basedto.BaseState
import org.zaimy.bez.otkaza.komar.domain.model.basedto.Loan
import org.zaimy.bez.otkaza.komar.presentation.MainEvent.OnChangeStatusApplication
import org.zaimy.bez.otkaza.komar.ui.theme.baseBackground
import org.zaimy.bez.otkaza.komar.ui.theme.baseText
import org.zaimy.bez.otkaza.komar.ui.theme.green
import org.zaimy.bez.otkaza.komar.ui.theme.secondText
import org.zaimy.bez.otkaza.komar.ui.theme.shadow

@Composable
fun ItemLoan(
    modifier: Modifier = Modifier,
    loan: Loan,
    onEvent: (MainEvent) -> Unit,
    baseState: BaseState,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 50.dp,
                shape = RoundedCornerShape(40.dp),
                spotColor = shadow,
                ambientColor = shadow
            )
            //.border(width = 1.dp, color = borderColor, shape = RoundedCornerShape(16.dp))
            .clip(shape = RoundedCornerShape(40.dp))
            .background(color = baseBackground)
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {
        Text(
            color = baseText,
            fontStyle = FontStyle(R.font.roboto),
            fontSize = 20.sp,
            fontWeight = FontWeight(500),
            text = loan.name
        )
        Spacer(modifier = modifier.height(12.dp))
        AsyncImage(
            modifier = modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(20.dp))
                .shadow(
                    elevation = 20.dp,
                    spotColor = shadow,
                    ambientColor = shadow
                )
                .clickable {
                    onEvent(
                        OnChangeStatusApplication(
                            Offer(
                                currentBaseState = baseState,
                                ElementOffer(
                                    nameButton = loan.orderButtonText,
                                    name = loan.name,
                                    pathImage = loan.screen,
                                    rang = loan.score,
                                    description = loan.description,
                                    amount = loan.summPrefix + " " + loan.summMin + " " + loan.summMid + " " + loan.summMax + " " + loan.summPostfix,
                                    bet = loan.percentPrefix + " " + loan.percent + " " + loan.percentPostfix,
                                    term = loan.termPrefix + " " + loan.termMin + " " + loan.termMid + " " + loan.termMax + " " + loan.termPostfix,
                                    showMir = loan.showMir,
                                    showVisa = loan.showVisa,
                                    showMaster = loan.showMastercard,
                                    showQiwi = loan.showQiwi,
                                    showYandex = loan.showYandex,
                                    showCache = loan.showCash,
                                    showPercent = loan.hidePercentFields,
                                    showTerm = loan.hideTermFields,
                                    order = loan.order
                                )
                            )
                        )
                    )
                },
            model = loan.screen,
            contentScale = ContentScale.FillWidth,
            contentDescription = ""
        )
        Spacer(modifier = modifier.height(12.dp))
        Row(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = modifier.weight(1f)
            ) {
                Text(
                    color = secondText,
                    fontStyle = FontStyle(R.font.roboto),
                    fontSize = 15.sp,
                    fontWeight = FontWeight(400),
                    text = stringResource(id = R.string.methods),
                )
                Spacer(modifier = modifier.height(4.dp))
                RowCard(
                    showVisa = loan.showVisa,
                    showMaster = loan.showMastercard,
                    showYandex = loan.showYandex,
                    showMir = loan.showMir,
                    showQivi = loan.showQiwi,
                    showCache = loan.showCash
                )
            }
            Column(
                modifier = modifier.weight(1f)
            ) {
                Text(
                    color = secondText,
                    fontStyle = FontStyle(R.font.roboto),
                    fontSize = 15.sp,
                    fontWeight = FontWeight(400),
                    text = stringResource(id = R.string.rating),
                )
                Spacer(modifier = modifier.height(4.dp))
                Text(
                    color = baseText,
                    fontStyle = FontStyle(R.font.roboto),
                    fontSize = 15.sp,
                    fontWeight = FontWeight(400),
                    text = "${loan.score} / 5",
                )
            }
        }
        Spacer(modifier = modifier.height(12.dp))
        Row(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = modifier.weight(1f)
            ) {
                Text(
                    color = secondText,
                    fontStyle = FontStyle(R.font.roboto),
                    fontSize = 15.sp,
                    fontWeight = FontWeight(400),
                    text = stringResource(id = R.string.amount),
                )
                Spacer(modifier = modifier.height(4.dp))
                Text(
                    color = baseText,
                    fontStyle = FontStyle(R.font.roboto),
                    fontSize = 15.sp,
                    fontWeight = FontWeight(400),
                    text = loan.summPrefix + " " + loan.summMin + " " + loan.summMid + " " + loan.summMax + " " + loan.summPostfix,
                )
            }
            if (loan.hidePercentFields == VALUE_ONE) {
                Column(
                    modifier = modifier.weight(1f)
                ) {
                    Text(
                        color = secondText,
                        fontStyle = FontStyle(R.font.roboto),
                        fontSize = 15.sp,
                        fontWeight = FontWeight(400),
                        text = stringResource(id = R.string.bet),
                    )
                    Spacer(modifier = modifier.height(4.dp))
                    Text(
                        color = baseText,
                        fontStyle = FontStyle(R.font.roboto),
                        fontSize = 15.sp,
                        fontWeight = FontWeight(400),
                        text = loan.percentPrefix + " " + loan.percent + " " + loan.percentPostfix,
                    )
                }
            }
        }
        Spacer(modifier = modifier.height(12.dp))
        /*Row(
            modifier = modifier
                .fillMaxWidth()
        ) {
            RowData(
                modifier = modifier.weight(1f),
                title = stringResource(id = string.amount),
                content = loan.summPrefix +" " + loan.summMin +" " + loan.summMid +" " + loan.summMax +" " + loan.summPostfix
            )
            if (loan.hidePercentFields == VALUE_ONE) {
                Spacer(modifier = modifier.height(8.dp))
                RowData(
                    modifier = modifier.weight(1f),
                    title = stringResource(id = string.bet),
                    content = loan.percentPrefix +" " + loan.percent +" " + loan.percentPostfix
                )
            }
        }*/
        /*RowData(
            title = stringResource(id = string.amount),
            content = loan.summPrefix +" " + loan.summMin +" " + loan.summMid +" " + loan.summMax +" " + loan.summPostfix
        )
        if (loan.hidePercentFields == VALUE_ONE) {
            RowData(
                title = stringResource(id = string.bet),
                content = loan.percentPrefix +" " + loan.percent +" " + loan.percentPostfix
            )
        }
        if (loan.hideTermFields == VALUE_ONE) {
            RowData(
                title = stringResource(id = string.term),
                content = loan.termPrefix +" "+ loan.termMin +" " + loan.termMid +" " + loan.termMax +" " + loan.termPostfix
            )
        }*/
        /*Spacer(modifier = modifier.height(15.dp))
        RowCard(
            showVisa = loan.showVisa,
            showMaster = loan.showMastercard,
            showYandex = loan.showYandex,
            showMir = loan.showMir,
            showQivi = loan.showQiwi,
            showCache = loan.showCash
        )
        Spacer(modifier = modifier.height(15.dp))*/
        RowButtons(
            titleOffer = loan.orderButtonText,
            onEvent = onEvent,
            currentBaseState = baseState,
            name = loan.name,
            pathImage = loan.screen,
            rang = loan.score,
            description = loan.description,
            amount = loan.summPrefix +" " + loan.summMin +" " + loan.summMid +" " + loan.summMax +" " + loan.summPostfix,
            bet  = loan.percentPrefix +" " + loan.percent +" " + loan.percentPostfix,
            term = loan.termPrefix +" "+ loan.termMin +" " + loan.termMid +" " + loan.termMax +" " + loan.termPostfix,
            showMir = loan.showMir,
            showVisa = loan.showVisa,
            showMaster = loan.showMastercard,
            showQiwi = loan.showQiwi,
            showYandex = loan.showYandex,
            showCache = loan.showCash,
            showPercent = loan.hidePercentFields,
            showTerm = loan.hideTermFields,
            order = loan.order,
        )
    }
}
