package org.zaimy.bez.otkaza.komar.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.zaimy.bez.otkaza.komar.R
import org.zaimy.bez.otkaza.komar.ui.theme.baseBackground

@Preview
@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = baseBackground)
    ) {
        Image(
            modifier = modifier
                .size(300.dp)
                .align(alignment = Alignment.Center),
            painter = painterResource(id = R.drawable.logo_no_fon),
            contentDescription = "",
        )
    }
}