package org.compose_projects.socialocal.profile.presentation.components.imageProfileComponent

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import org.compose_projects.socialocal.R

@Composable
fun ShowImageScaled(
    selectedImageUri: MutableState<Uri?>,
    show: Boolean,
    onDismissRequest: () -> Unit,
    context: Context,
    imageExists: Boolean,
    imageLoaded: Bitmap?,
    editImage: () -> Unit
) {

    if (show) {
        Dialog(onDismissRequest = { onDismissRequest() }) {
            Box(
                modifier = Modifier
                    .height(350.dp)
                    .width(300.dp)
                    .background(color = MaterialTheme.colorScheme.background)
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
                    Column {
                        ImageContent(selectedImageUri, context = context, imageExists, imageLoaded)

                        BottomContent() {
                            editImage()
                        }
                    }
                }
            }
        }
    }

}


@Composable
fun ImageContent(
    selectedImageUri: MutableState<Uri?>,
    context: Context, imageExists: Boolean,
    imageLoaded: Bitmap?,
) {
    var imageResource by remember { mutableIntStateOf(R.drawable.ic_launcher_background) }

    if (imageExists) {
        if (imageLoaded != null){
            Image(
                bitmap = imageLoaded.asImageBitmap(),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight(0.8F)
                    .fillMaxWidth(1F)
                    .clip(CircleShape),
                contentScale = ContentScale.FillBounds,
            )
        }

    } else {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight(0.8F)
                .fillMaxWidth(1F)
                .clip(CircleShape),
            contentScale = ContentScale.FillBounds,
        )
    }


}