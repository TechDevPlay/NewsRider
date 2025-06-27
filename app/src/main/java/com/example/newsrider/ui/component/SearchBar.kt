package com.example.newsrider.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newsrider.R
import com.example.newsrider.ui.theme.ThemeMainColor

@Composable
fun SearchBar() {
    var searchQuery by remember {
        mutableStateOf("")
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(28.dp))
            .background(Color(0XFFF8F8F8))
            .border(1.dp, Color.LightGray, RoundedCornerShape(28.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search Icon",
            modifier = Modifier
                .padding(start = 16.dp)
                .size(24.dp),
            tint = Color.Gray
        )
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            shape = RoundedCornerShape(30.dp),
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = ThemeMainColor,
                focusedIndicatorColor = ThemeMainColor,
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent
            ),
            label = { Text(text = "Search City...", color = Color.Gray) },
            singleLine = true,
            keyboardActions = KeyboardActions(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp)
        )
        IconButton(
            onClick = {},
            colors = IconButtonDefaults.iconButtonColors(containerColor = ThemeMainColor),
            modifier = Modifier.padding(end = 8.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.filter_list),
                contentDescription = "Filter Icon",
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

    }
}


