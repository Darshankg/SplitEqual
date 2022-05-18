package com.composedemo.splitequal.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.composedemo.splitequal.R
import com.composedemo.splitequal.ui.extensions.addNumber
import com.composedemo.splitequal.ui.extensions.perPersonAmount
import com.composedemo.splitequal.ui.extensions.subtractNumber
import com.composedemo.splitequal.ui.navigation.Destinations
import com.composedemo.splitequal.ui.widgets.CenterTextAppBar
import com.composedemo.splitequal.ui.widgets.CircularButton
import com.composedemo.splitequal.ui.widgets.OutLinedInputField

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CenterTextAppBar(text = stringResource(id = R.string.home_screen_title))
        },
    ) {
        HomeScreenContent(navController)
    }
}


@Composable
fun HomeScreenContent(navController: NavController) {
    var billAmountState by remember {
        mutableStateOf("0")
    }

    var numberOfPersonsState by remember {
        mutableStateOf("1")
    }
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(10.dp)) {
            TopContent(billAmountState.perPersonAmount(numberOfPersonsState))

            Spacer(modifier = Modifier.height(10.dp))

            MainContent(
                billAmountState,
                numberOfPersonsState,
                onBillAmountChange = {
                    billAmountState = it
                },
                onPersonAdded = {
                    numberOfPersonsState = numberOfPersonsState.addNumber()
                },
                onPersonRemoved = {
                    numberOfPersonsState = numberOfPersonsState.subtractNumber()
                },
                navController = navController
            )
        }
    }
}

@Preview
@Composable
fun TopContent(amount: Int = 0) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        elevation = 5.dp,
        backgroundColor = Color.White
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.home_screen_amount_per_person),
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "$ $amount",
                style = MaterialTheme.typography.body2
            )
        }
    }
}

@Composable
fun MainContent(
    billAmount: String,
    numberOfPerson: String,
    onBillAmountChange: (String) -> Unit,
    onPersonAdded: () -> Unit,
    onPersonRemoved: () -> Unit,
    navController: NavController
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        border = BorderStroke(
            width = 2.dp,
            color = Color.Black
        ),
        elevation = 5.dp
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            OutLinedInputField(modifier = Modifier.fillMaxWidth(),
                inputValue = billAmount,
                label = "Enter Bill Amount",
                onInputChanged = {
                    onBillAmountChange(it)
                })

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Number Of Persons",
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.size(50.dp))
                CircularButton(imageVector = Icons.Default.Remove, onClick = {
                    onPersonRemoved()
                })
                Spacer(modifier = Modifier.size(15.dp))
                Text(text = numberOfPerson, style = MaterialTheme.typography.body2)
                Spacer(modifier = Modifier.size(15.dp))
                CircularButton(imageVector = Icons.Default.Add, onClick = {
                    onPersonAdded()
                })
            }

            Spacer(modifier = Modifier.size(50.dp))


            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Button(
                    modifier = Modifier.background(Color.White),
                    onClick = {
                        navController.navigate(Destinations.ThankYouScreen.name)
                    },
                ) {
                    Text(text = "Done", style = MaterialTheme.typography.body1)
                }
            }
        }
    }
}