package com.example.cmpose

import com.example.jetpackcompose.Message

object SampleData {
    // Sample conversation data
    val conversationSample = listOf(
        Message(
            "Msf",
            "Test...Test...Test..."
        ),
        Message(
            "API",
            """List of Android versions:
            |Android KitKat (API 19)
            |Android Lollipop (API 21)
            |Android Marshmallow (API 23)
            |Android Nougat (API 24)
            |Android Oreo (API 26)
            |Android Pie (API 28)
            |Android 10 (API 29)
            |Android 11 (API 30)
            |Android 12 (API 31)""".trimMargin()
        ),
        Message(
            "Nithish",
            """I think Kotlin is my favorite programming language.
            |It's so much fun!""".trimMargin()
        ),
        Message(
            "Jana",
            "Searching for alternatives to XML layouts..."
        ),
        Message(
            "kabilan",
            """Hey, take a look at Jetpack Compose, it's great!
            |It's the Android's modern toolkit for building native UI.
            |It simplifies and accelerates UI development on Android.
            |Less code, powerful tools, and intuitive Kotlin APIs :)""".trimMargin()
        ),
        Message(
            "Mugilan",
            "It's available from API 21+ :)"
        ),
        Message(
            "Santhosh",
            "Writing Kotlin for UI seems so natural, Compose where have you been all my life?"
        ),
        Message(
            "Vinay",
            "Android Studio next version's name is Arctic Fox"
        ),
        Message(
            "kumar",
            "Android Studio Arctic Fox tooling for Compose is top notch ^_^"
        ),
        Message(
            "Syed",
            "I didn't know you can now run the emulator directly from Android Studio"
        ),
        Message(
            "karan",
            "Compose Previews are great to check quickly how a composable layout looks like"
        ),
        Message(
            "sheerash",
            "Previews are also interactive after enabling the experimental setting"
        ),
        Message(
            "Colleague",
            "Have you tried writing build.gradle with KTS?"
        ),
    )
}
