package com.example.mvvm

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                    MainScreen()
        }
    }
}
@Composable
fun MainScreen(viewModel: MainViewModel = MainViewModel()){
    val newNameStateContent = viewModel.textFieldState.observeAsState("")
    Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally) {
        GreetingMessage(newNameStateContent.value) { newName -> viewModel.onTextChanged(newName) }
    }
}
@Composable
fun GreetingMessage(textFieldValue: String,
                 textFieldValueUpdate: (newName: String) -> Unit) {
    TextField(value = textFieldValue, onValueChange = textFieldValueUpdate)
    Button(onClick = {}  ) {
        Text(textFieldValue)
    }
}
@Composable
fun Greeting(name : String) {
        Text(text = "Hello $name")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

        MainScreen()

}