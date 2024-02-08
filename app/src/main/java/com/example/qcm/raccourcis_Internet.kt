package com.example.qcm

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.navigation.NavHostController
import com.example.qcm.ui.theme.QCMTheme
import kotlin.math.absoluteValue

@Composable
fun raccourcis_Internet(navController: NavHostController) {
    var btnVisibles by remember { mutableStateOf(true) }
    var repChoisie by remember { mutableStateOf(0) }
    val reponses = listOf(
        Response("Ctrl+N",1),
        Response("Ctrl+P",2),
        Response("Ctrl+W",3),
        Response("Alt+F4",4)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Quel raccourci clavier ouvre une nouvelle fenêtre de navigateur dans la plupart des navigateurs Web ?",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (btnVisibles) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Response_Button(reponses[0]) {
                        repChoisie = reponses[0].id
                        btnVisibles = false
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Response_Button(reponses[1]) {
                        repChoisie = reponses[1].id
                        btnVisibles = false
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Response_Button(reponses[2]) {
                        repChoisie = reponses[2].id
                        btnVisibles = false
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Response_Button(reponses[3]) {
                        repChoisie = reponses[3].id
                        btnVisibles = false
                    }
                }
            }
        } else {
            if(repChoisie==1) {
                Text("Bonne réponse !")
            }
            if (repChoisie==2) {
                Text("Movaise réponse !\nCe raccourcis ouvre une page d'impression")
            }
            if(repChoisie==3) {
                Text("Bonne réponse !\nCe raccourcis ferme l'onglet actif")
            }
            if (repChoisie==4) {
                Text("Movaise réponse !\nCe raccourcis kill le programme actif")
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 10.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button("Internet", "Accueil",onElementClick = {navController.navigate("premierePage")})
    }
}

@Preview
@Composable
fun PreviewRaccourcisInternet() {
    QCMTheme() {

    }
}