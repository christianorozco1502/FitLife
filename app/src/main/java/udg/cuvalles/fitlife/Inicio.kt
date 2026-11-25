package udg.cuvalles.fitlife

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Inicio(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "FitLife",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF409526)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "¡Bienvenido!",
            fontSize = 25.sp
        )

        Text("Encuentra tu gimnasio ideal")

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = {
                navController.navigate("gimnasios")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF409526)
            )
        ) {
            Text("Ver gimnasios")
        }

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedButton(
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Favoritos")
        }

        OutlinedButton(
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Perfil")
        }

        Spacer(modifier = Modifier.weight(1f))

        TextButton(
            onClick = { navController.popBackStack() }
        ) {
            Text("Cerrar sesión")
        }
    }
}