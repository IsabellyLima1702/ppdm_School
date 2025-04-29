package br.senai.sp.jandira.lionschool.calcs

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource

import br.senai.sp.jandira.lionschool.R
import br.senai.sp.jandira.lionschool.model.Lion
import br.senai.sp.jandira.lionschool.model.LionStatus
import kotlin.math.pow

@Composable
fun lionCalculate(weight: Int, height: Double): Lion {

    val lionResult = weight.div(height.pow(2))

    when {
        lionResult <= 77 ->
            return Lion(
                lion = Pair(stringResource(R.string.detail1), lionResult),
                lionColor = colorResource(R.color.light_green),
                lionStatus = LionStatus.SIOP
            )

        lionResult >= 86 ->
            return Lion(
                lion = Pair(stringResource(R.string.detail2), lionResult),
                lionColor = colorResource(R.color.light_green),
                lionStatus = LionStatus.INRI
            )
    }
}

