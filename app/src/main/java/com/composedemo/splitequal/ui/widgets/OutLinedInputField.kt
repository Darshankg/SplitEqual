package com.composedemo.splitequal.ui.widgets

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Money
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun OutLinedInputField(
    modifier: Modifier = Modifier,
    inputValue: String,
    label: String,
    onInputChanged: (String) -> Unit,
    imeAction: ImeAction = ImeAction.Next,
    keyboardType: KeyboardType = KeyboardType.Number
) {
    OutlinedTextField(
        modifier = modifier.padding(3.dp),
        value = inputValue,
        onValueChange = { value ->
            onInputChanged(value)
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Money, contentDescription = "Leading Icon")
        },
        keyboardOptions = KeyboardOptions().copy(
            imeAction = imeAction,
            keyboardType = keyboardType,
        ),
        label = {
            Text(text = label)
        },
        singleLine = true
    )
}