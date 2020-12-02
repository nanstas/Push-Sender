package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream

fun main() {
    val options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
            .setDatabaseUrl(dbUrl)
            .build()

    FirebaseApp.initializeApp(options)

//    val message = Message.builder()
//            .putData("action", "LIKE")
//            .putData("content", """{
//          "userId": 1,
//          "userName": "Vasiliy",
//          "postId": 2,
//          "postAuthor": "Netology"
//        }""".trimIndent())
//            .setToken(token)
//            .build()

//    val message = Message.builder()
//            .putData("action", "OTHER")
//            .putData("content", """{
//            "userId": 1,
//            "userName": "Vasiliy",
//            "postId": 2
//        }""".trimIndent())
//            .setToken(token)
//            .build()

    val message = Message.builder()
            .putData("action", "NEWPOST")
            .putData("content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 2,
          "text": "A basic notification usually includes a title, a line of text, and one or more actions the user can perform in response. To provide even more information, you can also create large, expandable notifications by applying one of several notification templates as described on this page."
        }""".trimIndent())
            .setToken(token)
            .build()

    FirebaseMessaging.getInstance().send(message)
}