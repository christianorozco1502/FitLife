package udg.cuvalles.fitlife

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DetalleGimnasio(
    navController: NavController,
    nombre: String,
    precio: String,
    horario: String
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = nombre,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF409526)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFA2E87F)
            )
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "Información",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(15.dp))

                Text("Precio: $precio")

                Spacer(modifier = Modifier.height(10.dp))

                Text("Horario: $horario")
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "Servicios",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text("• Área de pesas")
        Text("• Área de cardio")
        Text("• Entrenadores")
        Text("• Regaderas")

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "Valoración",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "★★★★☆ 4.0",
            fontSize = 25.sp,
            color = Color(0xFFFFB300)
        )

        Text("Buenas instalaciones y ambiente agradable.")

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF409526)
            )
        ) {
            Text("Regresar")
        }
    }
}
