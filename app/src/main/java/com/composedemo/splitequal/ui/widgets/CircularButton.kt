package com.composedemo.splitequal.ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun CircularButton(
    imageVector: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    size: Dp = 35.dp,
    backGroundColor: Color = Color.White,
) {
    Card(
        modifier = modifier
            .size(size = size)
            .clickable {
                onClick()
            },
        backgroundColor = backGroundColor,
        shape = CircleShape
    ) {
        Box(contentAlignment = Alignment.Center) {
            Icon(imageVector = imageVector, contentDescription = "Sample")
        }
    }
}

@Preview
@Composable
fun PreviewCircularButton() {
    CircularButton(imageVector = Icons.Default.Remove, onClick = {

    })
}