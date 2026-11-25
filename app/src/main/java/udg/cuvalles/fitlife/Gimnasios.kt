package udg.cuvalles.fitlife

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import android.net.Uri

data class Gimnasio(
    val nombre: String,
    val precio: String,
    val horario: String
)

@Composable
fun Gimnasios(navController: NavController) {

    val gimnasios = listOf(
        Gimnasio("Power Gym", "$450 al mes", "6:00 am - 10:00 pm"),
        Gimnasio("Fit Center", "$350 al mes", "7:00 am - 9:00 pm"),
        Gimnasio("Zona Fitness", "$400 al mes", "6:00 am - 9:00 pm"),
        Gimnasio("Energy Gym", "$500 al mes", "5:00 am - 10:00 pm")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Gimnasios",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF409526)
        )

        Text("Encuentra tu gimnasio ideal")

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {

            items(gimnasios) { gimnasio ->

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
                            text = gimnasio.nombre,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text("Precio: ${gimnasio.precio}")

                        Text("Horario: ${gimnasio.horario}")

                        Spacer(modifier = Modifier.height(10.dp))

                        Button(
                            onClick = {
                                val nombre = Uri.encode(gimnasio.nombre)
                                val precio = Uri.encode(gimnasio.precio)
                                val horario = Uri.encode(gimnasio.horario)

                                navController.navigate("detalle/$nombre/$precio/$horario")
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF409526)
                            )
                        ) {
                            Text("Ver detalles")
                        }
                    }
                }
            }
        }

        TextButton(
            onClick = { navController.popBackStack() }
        ) {
            Text("Regresar")
        }
    }
}
