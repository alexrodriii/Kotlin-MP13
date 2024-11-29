package com.example.firstkotlinfindbyname

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstkotlinfindbyname.ui.theme.FirstKotlinFindByNameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstKotlinFindByNameTheme {
                MyApp()
            }
        }
    }
}
@Preview
@Composable
fun MyAppPreview() {
    FirstKotlinFindByNameTheme {
        MyApp()
    }
}
@Composable
fun OnBoardingScreen(onContinueClicked: () -> Unit, message: String) {
    Button(onClick = onContinueClicked) {
        Text(text = message)
    }
}

@Composable
fun MyApp() {
    var nextScreen = rememberSaveable { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxHeight(fraction = 1f)) {
        Row(modifier = Modifier.fillMaxHeight(fraction = 0.2f)) {
            OnBoardingScreen(
                onContinueClicked = { nextScreen.value = "Login" },
                message = "Login"
            )
            OnBoardingScreen(
                onContinueClicked = { nextScreen.value = "List" },
                message = "List"
            )
            OnBoardingScreen(
                onContinueClicked = { nextScreen.value = "Find" },
                message = "Find"
            )
        }
        when (nextScreen.value) {
            "Home" -> {

                println("Navigating to home screen")
                HomeScreen()
            }

            "Login" -> {
                println("Navigating to home screen")
                LoginScreen()
            }

            "Find" -> {
                println("Navigating to find screen")
                FindScreen(onBackClicked = { nextScreen.value = "" })

            }
        }
    }
}
@Composable
fun HomeScreen() {
    FirstKotlinFindByNameTheme {
        HomeScreen()
    }
}
@Composable
fun LoginScreen() {
    FirstKotlinFindByNameTheme {
        LoginScreen()
    }
}

@Composable
fun FindScreen(onBackClicked: () -> Unit) {
    var nurseName = rememberSaveable { mutableStateOf("") }
    var result = rememberSaveable { mutableStateOf("") }
    val nurses = arrayOf("Alex","Noemi","Dafne")

    Column(modifier = Modifier.fillMaxHeight(fraction = 1f))
    {
        Text(text = "Find Screen", color = Color.Green)
        androidx.compose.material3.TextField(
            value =  nurseName.value,
            onValueChange = {  nurseName.value = it },
            label = {
                Text("Enter a Nurse Name")
            }
        )
        Button( onClick =  {
                result.value = if (nurses.any { it.equals(nurseName.value, ) }) {
                        "Nurse found!"
                }
                else {
                    "Not Found"
                    }},
            )
        {
            Text("Find the Nurse")
        }
        Text(text = result.value, color = Color.Green)
        }
    }

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(modifier = Modifier) {

    }
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
    Text(text = "Exemple test", color = Color.Yellow)
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstKotlinFindByNameTheme {
        Greeting("Android")
    }
}


