package br.senai.sp.jandira.lionschool.screens

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschool.R
import br.senai.sp.jandira.lionschool.calcs.lionCalculate
import java.util.Locale

@Composable
fun Courses(modifier: Modifier) {

    var nameState = remember {
        mutableStateOf("")
    }

    var isErrorState = remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current
    val userFile = context
        //Mode_Private deixa o seu programa privado para que outros programas nao acessem os dados do seu
        .getSharedPreferences("UserFile", Context.MODE_PRIVATE)

    val userWeight = userFile.getInt("user_weight", 0)
    val userHeight = userFile.getFloat("user_height", 0.0F)
    val userAge = userFile.getInt("user_age", 0)

    val lion = lionCalculate(
        userWeight,
        userHeight.toDouble().div(100)
    )


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    ){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 80.dp, start = 15.dp),

        ){
            Row {
                Image(
                    painter = painterResource(
                        R.drawable.logo
                    ),
                    contentDescription = stringResource(
                        R.string.app_name
                    ),
                    modifier = Modifier
                        .size(70.dp),

                )
                Text(
                    text = stringResource(
                        R.string.name
                    ),
                    modifier = Modifier
                        .padding(top = 7.dp, end = 20.dp),
                    color = Color(0xFF2A3CA5),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Card(
                modifier = Modifier
                    .height(11.2.dp)
                    .width(355.dp)
                    .padding(top = 10.dp, start = 8.dp),



                shape = RoundedCornerShape(
                    15.dp
                ),
                colors = CardDefaults
                    .cardColors(
                        containerColor = Color(0xFFF5AD30)
                    )

            ){

            }
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 8.dp, end = 22.dp)
                    .background(color = Color.Blue),
                verticalArrangement = Arrangement.Center,
            ){
                Text(
                    text = stringResource(
                        R.string.image
                    ),
                    modifier = Modifier,
                    color = Color.Black
                )
            }
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 160.dp),
                shape = RoundedCornerShape(
                    topStart = 35.dp,
                    topEnd = 35.dp
                ),
                colors = CardDefaults
                    .cardColors(
                        containerColor = Color.White
                    )
            ){
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){

                    Card (
                        modifier = Modifier
                            .size(160.dp),
                        shape = CircleShape,
                        border = BorderStroke(
                            width = 4.dp,
                            color = lion.lionColor
                        )
                    ){
                         Text(
                             text = String.format(
                                 Locale.getDefault(),
                                 "%.1f",
                                 lion.lion.second
                             ),
                             fontSize = 50.sp,
                             color = Color.Black,
                             fontWeight = FontWeight.Bold,
                             modifier = Modifier
                                 .padding(top = 50.dp, start = 30.dp)
                         )
                    }
                    Text(
                        text = lion.lion.first,
                        modifier = Modifier
                            .padding(top = 23.dp),
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Card (
                        shape = RoundedCornerShape(
                            15.dp
                        ),
                        modifier = Modifier
                            .padding(bottom = 20.dp, top = 20.dp)
                    ){}
                }
            }

        }

    }

}
@Preview(showSystemUi = true)
@Composable
private fun CoursesScreenPreview() {
    Courses(modifier = Modifier)

}
