package org.compose_projects.socialocal.ui.components.bottom_chat

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import md_theme_dark_onPrimary
import md_theme_dark_secondaryContainer
import md_theme_light_outline
import md_theme_light_primaryContainer
import md_theme_light_secondaryContainer
import org.compose_projects.socialocal.R
import org.compose_projects.socialocal.ui.components.textField.SLTextField
import org.compose_projects.socialocal.ui.components.textField.styles.SLTextFieldColors
import org.compose_projects.socialocal.ui.components.textField.styles.SLTextFieldSizes

@Composable
fun SLBottomChat(
    useDarkTheme: Boolean = isSystemInDarkTheme()
) {
    var textChat by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 3.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        Row(modifier = Modifier.padding(start = 5.dp, end = 5.dp)) {
            SLTextField(
                value = textChat,
                onValueChange = { textChat = it },
                colors = if (useDarkTheme) SLTextFieldColors.defaultStyleDark else SLTextFieldColors.defaultStyleLight,
                sizes = SLTextFieldSizes.bottom_chat,
                trailingIcon = {
                    Row {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.attach_file_ic),
                                contentDescription = null,
                                tint = Color.White.copy(alpha = 0.9F)
                            )
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.photo_camera_ic),
                                contentDescription = null,
                                tint = Color.White.copy(alpha = 0.9F)
                            )
                        }
                    }
                }
            )

            Spacer(modifier = Modifier.width(6.dp))

            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .clip(CircleShape)
                    .background(color = if (!useDarkTheme) md_theme_light_secondaryContainer.copy(0.65F) else md_theme_dark_secondaryContainer)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.round_mic_ic),
                    contentDescription = null,
                    tint = Color.White.copy(alpha = 0.9F)
                )
            }
        }

    }
}