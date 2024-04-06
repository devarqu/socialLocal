package org.compose_projects.socialocal.profile.presentation.components.imageProfileComponent

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.compose_projects.socialocal.R

@Composable
fun BottomAppBarContent(editImage: () -> Unit) {
    val context = LocalContext.current
    val selectedImageUri = remember { mutableStateOf<Uri?>(null) }

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BottomAppBarOption(icon = Icons.Default.Delete, text = "Borrar") {

        }

        BottomAppBarOption(icon = Icons.Default.Edit, text = "Editar") {
            editImage()
        }

        BottomAppBarOption(icon = Icons.Default.Check, text = "Guardar") {

        }
    }

}



@Composable
fun BottomAppBarOption(icon: ImageVector, text: String, onClick: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.clickable {
        onClick()
    }) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            modifier = Modifier.size(25.dp),
            tint = MaterialTheme.colorScheme.background
        )
        Text(
            text = text, style = TextStyle(
                color = MaterialTheme.colorScheme.background,
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.cocogoose_pro_letterpress_regular_trial))
            )
        )
    }
}