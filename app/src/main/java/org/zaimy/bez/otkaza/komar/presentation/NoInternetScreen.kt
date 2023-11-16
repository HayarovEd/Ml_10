package org.zaimy.bez.otkaza.komar.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.zaimy.bez.otkaza.komar.R
import org.zaimy.bez.otkaza.komar.presentation.MainEvent.Reconnect
import org.zaimy.bez.otkaza.komar.ui.theme.baseBackground
import org.zaimy.bez.otkaza.komar.ui.theme.blue
import org.zaimy.bez.otkaza.komar.ui.theme.thirdText

@Composable
fun NoInternetScreen(
    modifier: Modifier = Modifier,
    onEvent: (MainEvent) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = baseBackground)
            .padding(vertical = 19.dp, horizontal = 30.dp)
    ) {
        Image(
            modifier = modifier
                .align(alignment = Alignment.TopCenter)
                .size(86.dp),
            painter = painterResource(
                id = R.drawable.logo_no_fon
            ),
            contentDescription = ""
        )
        Column(
            modifier = modifier.align(alignment = Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = modifier.size(200.dp),
                painter = painterResource(
                    id = R.drawable.no_connection
                ),
                contentDescription = ""
            )
            Spacer(modifier = modifier.height(50.dp))
            Text(
                modifier = modifier.fillMaxWidth(),
                text = stringResource(id = R.string.not_connect),
                fontSize = 24.sp,
                fontWeight = FontWeight(700),
                fontStyle = FontStyle(R.font.montserrat),
                color = blue,
                textAlign = TextAlign.Start
            )
            Spacer(modifier = modifier.height(22.dp))
            Text(
                modifier = modifier.fillMaxWidth(),
                text = stringResource(id = R.string.try_internet),
                fontSize = 18.sp,
                fontWeight = FontWeight(400),
                fontStyle = FontStyle(R.font.roboto),
                color = thirdText,
                textAlign = TextAlign.Start
            )
            Spacer(modifier = modifier.height(22.dp))
            Button(
                modifier = modifier
                    .fillMaxWidth()
                /*.shadow(
                    elevation = 5.dp,
                    shape = RoundedCornerShape(10.dp),
                    spotColor = baseText,
                    ambientColor = baseText
                )*/,
                shape = RoundedCornerShape(20.dp),
                contentPadding = PaddingValues(
                    vertical = 26.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = blue,
                    contentColor = baseBackground,
                ),
                onClick = { onEvent(Reconnect) }
            ) {
                Text(
                    text = stringResource(id = R.string.reconnect),
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.roboto)),
                        fontWeight = FontWeight(400),
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun SampleNoInternetScreen() {
    NoInternetScreen(onEvent = {})
}
