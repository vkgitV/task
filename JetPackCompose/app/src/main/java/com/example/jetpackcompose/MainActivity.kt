package com.example.jetpackcompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cmpose.SampleData
import com.example.jetpackcompose.ui.theme.JetPackComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeTheme() {
                // A surface container using the 'background' color from the theme //material design
                Surface(
                    modifier = Modifier.fillMaxSize(),
//                   color = MaterialTheme.colorScheme.background
                ) {

                    Conversation(messages = SampleData.conversationSample)
                    // MessageCard(Message("Android","Jetpack Compose"))// to add multiple text
                }
            }
        }
    }


}

data class Message(val author:String,val body:String)
@Composable//define a composable function:
fun MessageCard(msg:com.example.jetpackcompose.Message) { //accept a message instead of string
    Row (modifier = Modifier.padding(all = 8.dp)){                                 //Row:to have a well structred design
        Image(    // To add image element
            painter = painterResource(R.mipmap.ic_launcher_foreground),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .size(40.dp) // To set image size
                .clip(CircleShape)// clip image to be shaped as a circle
                .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)

        )
        Spacer(modifier = Modifier.width(8.dp))  // To Add a horizontal space between the image and the column
        var isExpanded by remember { mutableStateOf(false) }// To keep track if the message is expanded or not
        val surfaceColor by animateColorAsState(   //surfaceColor will be updated from one color to the other
            if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
        )


        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {//toggle the isExpanded variable when we click on this Column

            // column function use to arrange elements vertically
            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall //Material Typography styles are available in the MaterialTheme

            )
            Spacer(
                modifier = Modifier.height(4.dp)) // To Add a vertical space between the author and message texts

            androidx.compose.material3.Surface (
                color = surfaceColor,
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ){

                Text(text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,//If the message is expanded, we display all its content
                    // otherwise we only display the first line
                    style = MaterialTheme.typography.bodyMedium

                )}}}}
@Composable
fun Conversation(messages: List<com.example.jetpackcompose.Message>) {
    LazyColumn {
        messages.map { item { MessageCard(it) } }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    JetPackComposeTheme() {
        Conversation(SampleData.conversationSample)
    }
}


@Preview(
    showBackground = true,
    name = "Light Mode")   // preview function: quick way to test diff state and gesture of your composable
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name="Dark Mode",

    )
@Composable
fun PreviewMessageCard() {
    JetPackComposeTheme() {
        androidx.compose.material3.Surface() {
            MessageCard(msg= com.example.jetpackcompose.Message("Lexi", "hey take a look at jetpack Compose,its great"))
        }}
}
