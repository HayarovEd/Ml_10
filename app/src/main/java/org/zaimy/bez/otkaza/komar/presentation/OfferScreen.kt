package org.zaimy.bez.otkaza.komar.presentation

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import coil.compose.AsyncImage
import com.zaim.metr.dokm.domzaem.data.VALUE_ONE
import org.zaimy.bez.otkaza.komar.R
import org.zaimy.bez.otkaza.komar.domain.model.ElementOffer
import org.zaimy.bez.otkaza.komar.domain.model.StatusApplication
import org.zaimy.bez.otkaza.komar.domain.model.basedto.BaseState
import org.zaimy.bez.otkaza.komar.ui.theme.baseBackground
import org.zaimy.bez.otkaza.komar.ui.theme.baseText
import org.zaimy.bez.otkaza.komar.ui.theme.blue
import org.zaimy.bez.otkaza.komar.ui.theme.green
import org.zaimy.bez.otkaza.komar.ui.theme.secondText
import org.zaimy.bez.otkaza.komar.ui.theme.shadow

@SuppressLint("ResourceAsColor")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OfferScreen(
    modifier: Modifier = Modifier,
    elementOffer: ElementOffer,
    baseState: BaseState,
    onEvent: (MainEvent) -> Unit,
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = blue
                ),
                title = {
                    Column(
                        modifier = modifier
                            .fillMaxWidth()
                    ) {
                        Row(
                            modifier = modifier
                                .clickable {
                                    onEvent(
                                        MainEvent.OnChangeStatusApplication(
                                            StatusApplication.Connect(baseState)
                                        )
                                    )
                                },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_undo_40),
                                tint = baseBackground,
                                contentDescription = ""
                            )
                            Spacer(modifier = modifier.width(15.dp))
                            Text(
                                color = baseBackground,
                                fontStyle = FontStyle(R.font.montserrat),
                                fontSize = 22.sp,
                                fontWeight = FontWeight(700),
                                text = elementOffer.name
                            )
                        }
                    }
                }
            )
        },
        /*bottomBar = {
            BottomAppBar(
                containerColor = baseBackground
            ) {
                Button(
                    modifier = modifier
                        .fillMaxWidth()
                        .shadow(
                            elevation = 5.dp,
                            shape = RoundedCornerShape(10.dp),
                            spotColor = baseText,
                            ambientColor = baseText
                        ),
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(
                        vertical = 17.dp
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = yellow,
                        contentColor = baseBackground,
                    ),
                    onClick = {
                        onEvent(
                            OnGoToWeb(
                                urlOffer = elementOffer.order,
                                nameOffer = elementOffer.name
                            )
                        )
                    }
                ) {
                    Text(
                        text = stringResource(id = string.checkout),
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.roboto)),
                            fontWeight = FontWeight(600),
                        )
                    )
                }
                Spacer(modifier = modifier.height(15.dp))
            }
        }*/
    ) { paddingValues ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(color = baseBackground)
        ) {
            Image(
                modifier = modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.TopCenter),
                painter = painterResource(id = R.drawable.top_back_2),
                contentDescription = "",
                contentScale = ContentScale.FillWidth
            )
            Column(
                modifier = modifier
                    .padding(horizontal = 11.dp, vertical = 20.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(40.dp))
                    .shadow(
                        elevation = 50.dp,
                        spotColor = shadow,
                        ambientColor = shadow
                    )
                    .background(color = baseBackground)
                    .padding(20.dp)
                    .verticalScroll(rememberScrollState()),
            ) {
                Text(
                    color = baseText,
                    fontStyle = FontStyle(R.font.roboto),
                    fontSize = 20.sp,
                    fontWeight = FontWeight(500),
                    text = elementOffer.name
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
                        ),
                    model = elementOffer.pathImage,
                    contentScale = ContentScale.FillWidth,
                    contentDescription = ""
                )
                Spacer(modifier = modifier.height(12.dp))
                AndroidView(
                    modifier = modifier
                        .fillMaxWidth()
                        .background(color = baseBackground),
                    factory = { context -> TextView(context) },
                    update = {
                        it.setTextColor(R.color.white)
                        it.text = HtmlCompat.fromHtml(
                            elementOffer.description,
                            HtmlCompat.FROM_HTML_MODE_COMPACT
                        )
                    }
                )
                //Spacer(modifier = modifier.height(12.dp))
                /*RowCard(
                    showVisa = elementOffer.showVisa,
                    showMaster = elementOffer.showMaster,
                    showYandex = elementOffer.showYandex,
                    showMir = elementOffer.showMir,
                    showQivi = elementOffer.showQiwi,
                    showCache = elementOffer.showCache
                )*/
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
                            showVisa = elementOffer.showVisa,
                            showMaster = elementOffer.showMaster,
                            showYandex = elementOffer.showYandex,
                            showMir = elementOffer.showMir,
                            showQivi = elementOffer.showQiwi,
                            showCache = elementOffer.showCache
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
                            text = "${elementOffer.rang} / 5",
                        )
                    }

                        /* RowData(
                             modifier = modifier.weight(1f),
                             title = stringResource(id = string.amount),
                             content = elementOffer.amount
                         )
                         if (elementOffer.showPercent == VALUE_ONE) {
                             Spacer(modifier = modifier.height(8.dp))
                             RowData(
                                 modifier = modifier.weight(1f),
                                 title = stringResource(id = string.bet),
                                 content = elementOffer.bet
                             )
                         }*/
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
                            text = elementOffer.amount,
                        )
                    }
                    if (elementOffer.showPercent == VALUE_ONE) {
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
                                text = elementOffer.bet,
                            )
                        }
                    }
                    /*if (elementOffer.showTerm == VALUE_ONE) {
                        Spacer(modifier = modifier.height(8.dp))
                        RowData(
                            title = stringResource(id = string.term),
                            content = elementOffer.term
                        )
                    }*/
                }
                Spacer(modifier = modifier.height(12.dp))
                Button(
                    modifier = modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    contentPadding = PaddingValues(
                        vertical = 20.dp
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = green,
                        contentColor = baseBackground,
                    ),
                    onClick = {
                        onEvent(
                            MainEvent.OnGoToWeb(
                                urlOffer = elementOffer.order,
                                nameOffer = elementOffer.name
                            )
                        )
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.checkout),
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.roboto)),
                            fontWeight = FontWeight(500),
                        )
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun SampleOfferScreen() {
    OfferScreen(
        elementOffer =
        ElementOffer(
            name = "Digido",
            order = "",
            pathImage = "",
            rang = "5",
            description = "dddd",
            amount = "until 50",
            bet = "10%",
            term = "40 age",
            showMir = "1",
            showVisa = "1",
            showMaster = "1",
            showQiwi = "1",
            showYandex = "1",
            showCache = "1",
            nameButton = "fill",
            showPercent = "1",
            showTerm = "0"
        ),
        baseState = BaseState.Loans,
        onEvent = {}
    )
}