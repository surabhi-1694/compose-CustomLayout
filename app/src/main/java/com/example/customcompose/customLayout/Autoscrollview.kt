package com.example.customcompose.customLayout

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import java.nio.file.WatchEvent
import java.util.Timer
import kotlin.concurrent.scheduleAtFixedRate

@Composable
fun Autoscrollview(innerPadding: PaddingValues) {
    var scrollSpeed = 1L
    val scrollTimer = Timer("scrollTimer", true)
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding)
            .background(color = Color.Gray)) {

            Column(modifier = Modifier.scale(scaleX = -1f, scaleY = 1f).height(300.dp).background(color = Color.Blue)
                .verticalScroll(state = scrollState, enabled = true)) {
                Text(text = "Lorem Ipsum is simply dummy " +
                        "text of the printing ,Lorem Ipsum is " +
                        "simply dummy text of the printing ,Lorem Ipsum is simply dummy text of the printing ,Lorem Ipsum is simply dummy text of the printing ,Lorem Ipsum is simply dummy text of the printing ,Lorem Ipsum is simply dummy text of the printing ,Lorem Ipsum is simply dummy text of the printing ,Lorem Ipsum is simply dummy text of the printing ,Lorem Ipsum is simply dummy text of the printing ,Lorem Ipsum is simply dummy text of the printing ,Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since 1966, when designers at Letraset and James Mosley, the librarian at St Bride Printing Library, took a 1914 Cicero translation and scrambled it to make dummy text for Letraset's Body Type sheets. It has survived not only many decades, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised thanks to these sheets and more recently with desktop publishing software including versions of Lorem Ipsum.",
                    fontSize = 20.sp,color = Color.White)
            }

            Spacer(modifier = Modifier.fillMaxWidth().width(15.dp))
            Button(modifier = Modifier.background(color = Color.Red), onClick = {

//                val speed = ((50 - (progress * maxScrollSpeed / 50)) / 2f).toLong()
                val speed = ((50 - (1 * 50 / 50)) / 2f).toLong()
                scrollSpeed = if (speed > 0) speed else scrollSpeed
                Log.e("SCroolSpeed_ ", scrollSpeed.toString())
                    scrollTimer.scheduleAtFixedRate(0, scrollSpeed) {
                        coroutineScope.launch {
                        scrollState.scrollBy(1f)
                    }
                }
            }) {
                Text(text = "Start Scrolling")
            }



        }
}