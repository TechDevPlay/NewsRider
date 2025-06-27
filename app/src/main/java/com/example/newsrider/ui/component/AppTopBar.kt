package com.example.newsrider.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newsrider.R
import com.example.newsrider.ui.theme.ThemeMainColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(tint:Color,color:TopAppBarColors,onBackPressed:()->Unit, iconFirst:Painter, iconSecond:Painter) {
    TopAppBar(
        title = {},
        colors = color,
        navigationIcon = {
                Icon(
                   imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
                    contentDescription = "Filter Icon",
                    tint = tint,
                    modifier=Modifier.clickable { onBackPressed() }.size(40.dp)
                )
        },
        actions = {
            IconButton(
                onClick = {},
                colors = IconButtonDefaults.iconButtonColors(containerColor = ThemeMainColor),
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Icon(
                    painter = iconFirst,
                    contentDescription = "Filter Icon",
                    tint = Color.White,
                )
            }
            IconButton(
                onClick = {},
                colors = IconButtonDefaults.iconButtonColors(containerColor = ThemeMainColor),
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Icon(
                    painter = iconSecond,
                    contentDescription = "Filter Icon",
                    tint = Color.White
                )
            }
        }
    )
}

