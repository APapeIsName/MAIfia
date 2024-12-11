package com.android.maifia

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.android.maifia.ui.theme.MAifiaTheme

class MainActivity : ComponentActivity() {
    private val viewModel : MainViewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MAifiaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LobbyScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun LobbyScreen(
    modifier: Modifier,
    viewmodel: MainViewmodel = MainViewmodel()
) {
//    var state by remember { mutableFloatStateOf(0f) }
    val state by viewmodel.uiState.collectAsStateWithLifecycle()
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "로비")
        Spacer(modifier = Modifier.height(8.dp))
        LobbyMenuItem(itemName = "게임 시작", onClick = { Log.d("LobbyScreen", "게임 시작") })
        LobbyMenuItem(itemName = "게임 종료", onClick = { Log.d("LobbyScreen", "게임 종료") })
    }
}

@Composable
fun LobbyMenuItem(
    itemName: String,
    onClick: () -> Unit = {}
) {
    TextButton(onClick = onClick) {
        Text(text = itemName)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MAifiaTheme {
        LobbyScreen(modifier = Modifier)
    }
}