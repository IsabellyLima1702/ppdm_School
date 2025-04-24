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

    //Colocar o arquivo em modo de edição
    val editor = userFile.edit()


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

                        .size(70.dp)
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

            ){}
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
                    .background(color = Color(0xFFF1EEEE)),

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search
                ),

                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "",
                        tint = Color(0xFF938F8D)
                    )
                },
                shape = RoundedCornerShape(10.dp),
                label = {
                    Text(
                        modifier = Modifier
                            .padding(start = 35.dp),
                        color = Color(0xFF938F8D),
                        fontSize = 19.sp,
                        text = stringResource(R.string.search)
                    )
                }
            )

        }
        Card(
            shape = RoundedCornerShape(
                15.dp
            ),
            modifier = Modifier
                .padding(bottom = 20.dp, top = 20.dp)
        ) {
            Row (
                modifier = Modifier
                    .background(
                        color = Color(0xFFF6C792)
                    )
                    .padding(6.dp)
            ){
                Column (
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){

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
