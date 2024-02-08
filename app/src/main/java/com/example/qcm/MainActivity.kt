package com.example.qcm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.qcm.ui.theme.QCMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QCMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    navigation()
                }
            }
        }
    }
}

@Composable
fun Button(
    theme: String,
    txt_boutton: String,
    onElementClick : (String)->Unit){
    var boutonsVisibles by remember { mutableStateOf(true) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (boutonsVisibles) {
            Button(
                onClick = { onElementClick(theme) },
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
            ) {
                Text(text = txt_boutton)
            }
        }
    }
}

@Composable
fun ButtonRep(
    theme: String,
    txt_boutton: String,
    onElementClick : (String)->Unit){
    var boutonsVisibles by remember { mutableStateOf(true) }

        if (boutonsVisibles) {
            androidx.compose.material3.Button(
                onClick = { onElementClick(theme) },
                modifier = Modifier
                    .padding(0.dp)
                    .height(200.dp)
                    .width(175.dp)
            ) {
                Text(text = txt_boutton)
            }
        }
}

@Composable
fun Reponse(val1: String, val2: String, val3: String, val4: String): Int {
    val reponse = remember { mutableStateOf(0) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            ButtonRep(val1 , val1) {
                reponse.value = 1
            }
            ButtonRep(val2 , val2) {
                reponse.value = 2
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            ButtonRep(val3 , val3) {
                reponse.value = 3
            }
            ButtonRep(val4 , val4) {
                reponse.value = 4
            }
        }
    }
    return reponse.value
}

data class Response(val text: String, val id: Int)

@Composable
fun Response_Button(response: Response, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .height(250.dp)
            .width(175.dp)
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = response.text
            )
        }
    }
}