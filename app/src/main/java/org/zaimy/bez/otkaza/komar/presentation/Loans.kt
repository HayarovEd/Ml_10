
package org.zaimy.bez.otkaza.komar.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.zaimy.bez.otkaza.komar.R
import org.zaimy.bez.otkaza.komar.domain.model.basedto.BaseState
import org.zaimy.bez.otkaza.komar.domain.model.basedto.Loan
import org.zaimy.bez.otkaza.komar.ui.theme.baseBackground

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Loans(
    modifier: Modifier = Modifier,
    valuePaddings: PaddingValues,
    loans: List<Loan>,
    onEvent: (MainEvent) -> Unit,
    baseState: BaseState,
    loanLazyState: LazyListState,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(valuePaddings)
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
                .fillMaxSize()
                .background(color = baseBackground)
                .padding(horizontal = 11.dp, vertical = 20.dp),
        ) {
            LazyColumn(
                modifier = modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                state = loanLazyState
            ) {
                items(loans) { loan ->
                    ItemLoan(
                        loan = loan,
                        onEvent = onEvent,
                        baseState = baseState,
                    )
                }
            }
        }
    }
}
