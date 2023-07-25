package com.moniapps.palettewave.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moniapps.palettewave.ui.theme.PaletteWaveTheme

@Composable
fun FirstScreen() {
    Surface(
        modifier = Modifier
            .padding(16.dp)
    ) {

    }

}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FirstScreenPreview() {
    PaletteWaveTheme {
    FirstScreen()
    }
}