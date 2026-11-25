
package udg.cuvalles.fitlife

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "login"
                ) {

                    composable("login") {
                        Login(navController)
                    }

                    composable("gimnasios") {
                        Gimnasios(navController)
                    }
                    composable("detalle/{nombre}/{precio}/{horario}") { entrada ->

                        val nombre = entrada.arguments?.getString("nombre") ?: ""
                        val precio = entrada.arguments?.getString("precio") ?: ""
                        val horario = entrada.arguments?.getString("horario") ?: ""

                        DetalleGimnasio(
                            navController,
                            nombre,
                            precio,
                            horario
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Login(navController: NavController) {

    var correo by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "FitLife",
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF409526)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Iniciar sesión",
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(50.dp))

        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Correo electrónico") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = contrasena,
            onValueChange = { contrasena = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(25.dp))

        Button(
            onClick = {
                navController.navigate("inicio")
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF409526)
            )
        ) {
            Text("Iniciar sesión")
        }
    }
}