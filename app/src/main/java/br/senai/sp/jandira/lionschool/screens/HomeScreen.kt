package br.senai.sp.jandira.lionschool.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.lionschool.R

@Composable
fun HomeScreen(modifier: Modifier){

    var nameState = remember {
        mutableStateOf("")
    }

    var isErrorState = remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current
    val  userFile = context
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
                .padding(top = 90.dp),
            horizontalAlignment = Alignment.CenterHorizontally,


        ){
            Card (
                modifier = Modifier
                    .padding(start = 35.dp)
            ){
                Image(
                    painter = painterResource(
                        R.drawable.logo
                    ),
                    contentDescription = stringResource(
                        R.string.app_name
                    ),
                    modifier = Modifier
                        .padding(top = 80.dp)
                        .size(120.dp)
                )
            }

            Text(
                text = stringResource(
                    R.string.app_name,
                    modifier
                        .padding(end = 20.dp)
                ),
                color = Color(0xFF3246A9),
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold
            )
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp),

                colors = CardDefaults
                    .cardColors(
                        containerColor = Color.White
                    )
            ){
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.End
                ){
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Text(
                            text = stringResource(
                                R.string.find
                            ),
                            modifier = Modifier
                                .padding(start = 25.dp, top = 50.dp),
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF3F51B5)
                        )
                        Card(
                            modifier = Modifier
                                .height(17.dp)
                                .width(189.dp)
                                .padding(start = 125.dp, end = 2.dp, top = 10.dp),



                            shape = RoundedCornerShape(
                                16.dp
                            ),
                            colors = CardDefaults
                                .cardColors(
                                    containerColor = Color(0xFFF5AD30)
                                )


                        ){}

                        Text(
                            text = stringResource(
                                R.string.description
                            ),
                            modifier = Modifier
                                .padding(top = 40.dp),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color(0xFF9B9B99)
                        )
                        Button(
                            modifier = Modifier
                                .width(310.dp)
                                .padding( top = 180.dp)
                                .border(2.dp,
                                    color = Color(0xFF3F51B5),
                                    RoundedCornerShape(13.dp)),
                            onClick = {},
                            shape = RoundedCornerShape(13.dp),

                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFF5AD30)
                            )

                        ) {
                            Text(
                                text = stringResource(
                                    R.string.button
                                ),
                                fontSize = 17.sp,
                                color = Color(0xFF3F51B5)

                            )
                        }

                    }
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Image(
                                painter = painterResource(
                                    R.drawable.youtube
                                ),
                                contentDescription = stringResource(
                                    R.string.image
                                ),
                                modifier = Modifier
                                    .padding(top = 30.dp)
                                    .height(35.dp)
                                    .width(130.dp)

                            )
                        }
                        Column(
                            modifier = Modifier,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Image(
                                painter = painterResource(
                                    R.drawable.twitter
                                ),
                                contentDescription = stringResource(
                                    R.string.image
                                ),
                                modifier = Modifier
                                    .padding(top = 30.dp)
                                    .height(35.dp)
                                    .width(130.dp)

                            )
                        }
                        Column(
                            modifier = Modifier,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Image(
                                painter = painterResource(
                                    R.drawable.instagram
                                ),
                                contentDescription = stringResource(
                                    R.string.image
                                ),
                                modifier = Modifier
                                    .padding(top = 30.dp)
                                    .height(35.dp)
                                    .width(130.dp)

                            )
                        }
                        Column(
                            modifier = Modifier,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Image(
                                painter = painterResource(
                                    R.drawable.facebook
                                ),
                                contentDescription = stringResource(
                                    R.string.image
                                ),
                                modifier = Modifier
                                    .padding(top = 30.dp)
                                    .height(35.dp)
                                    .width(130.dp)

                            )
                        }
                    }
                }

            }
        }
    }
}
@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(modifier = Modifier)

}