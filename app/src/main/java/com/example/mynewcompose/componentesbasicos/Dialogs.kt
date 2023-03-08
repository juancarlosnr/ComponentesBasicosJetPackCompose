package com.example.mynewcompose

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.mynewcompose.componentesbasicos.MyRadioButtonList

/*
    Dialog: Elemento que nos permite mostrar diferentes dialogos en la pantalla, podemos hacer con dialog dialogos simples, aunque los podemos
    complicar y con AlertDialog algo más complejos, que siempre nos pedirá un boton
 */

//Dialogo Confirmación
@Composable
fun MyConfirmationDialog(
    show: Boolean,
    onDismiss: () -> Unit
) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss }) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(percent = 6))
            ) {
                MyTitleDialog(text = "Phone ringtone", modifier = Modifier.padding(24.dp))
                Divider(Modifier.fillMaxWidth(), Color.LightGray)
                var status by rememberSaveable{ mutableStateOf("") }
                MyRadioButtonList(name =status , onItemSelected = {status = it})
                Divider(Modifier.fillMaxWidth(), Color.LightGray)
                Row(Modifier.align(Alignment.End).padding(8.dp)) {
                    TextButton(onClick = {  }) {
                        Text(text = "Cancel")
                    }
                    TextButton(onClick = {  }) {
                        Text(text = "OK")
                    }
                }
            }
        }

    }
}

//Dialogo Personalizado Avanzado
@Composable
fun MyCustomDialog(
    show: Boolean,
    onDismiss: () -> Unit
) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss }) {
            Column(
                Modifier
                    .background(Color.White, shape = RoundedCornerShape(percent = 6))
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                MyTitleDialog(text = "Set backup account")
                AccountItem(email = "ejemplo1gmail.com", drawable = R.drawable.avatar)
                AccountItem(email = "ejemplo2gmail.com", drawable = R.drawable.avatar)
                AccountItem(email = "Añadir nueva cuenta", drawable = R.drawable.add)

            }
        }
    }
}


//Dialogo Personalizado
@Composable
fun MySimpleCustomDialog(
    show: Boolean,
    onDismiss: () -> Unit
) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            ),
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()

            ) {
                Text(text = "Esto es un ejemplo")
                Text(text = "Esto es un ejemplo")
                Text(text = "Esto es un ejemplo")

            }
        }
    }

}

//Alert Dialog
@Composable
fun MyAlertDialog(
    show: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit
) {
    if (show) {
        AlertDialog(onDismissRequest = { onDismiss() },
            title = { Text(text = "Titulo") },
            text = { Text(text = "Hola, soy una descripción super guay :(") },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "ConfirmButton")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "DismissButton")
                }
            })
    }
}

//Elementos a a utilizar en el dialógo personalizado
@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(text = email, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun MyTitleDialog(text: String, modifier:Modifier = Modifier.padding(bottom = 12.dp)) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
    )
}

